package com.younho.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.younho.util.ConsoleLogger;
import me.tongfei.progressbar.ProgressBar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ThreadPoolWrapper {
    private static final Logger LOGGER = LogManager.getLogger(ThreadPoolWrapper.class);
    private final ExecutorService executor;
    private final ConsoleLogger console;

    @Inject
    public ThreadPoolWrapper(ConsoleLogger console) {
        this.console = console;
        this.executor = new ThreadPoolExecutor(
                5,
                5,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                new ThreadFactoryBuilder()
                        .setNameFormat("CoreExecutor-%d")
                        .setUncaughtExceptionHandler(new ThreadExceptionHandler())
                        .build()
        );
    }

    public static void main(String[] args) throws Exception { // Example
        ThreadPoolWrapper threadPoolWrapper = new ThreadPoolWrapper(System.out::println);

        // 100개의 가짜 작업(task)을 생성하고 각 작업의 결과를 받아 처리
        List<Callable<Table>> tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int taskId = i;
            tasks.add(() -> threadPoolWrapper.processTask(taskId));  // 여기 수정 필요
        }

        try (ProgressBar progressBar = new ProgressBar("Task Progress", 100)) {
            Table resultTable = threadPoolWrapper.executeTasks(tasks, progressBar, true, 10);
            System.out.println(resultTable.print()); // 결과 확인
        }
    }

    public Table executeTasks(List<Callable<Table>> tasks, ProgressBar progressBar, boolean isBatchMode, int batchSize) throws Exception {
        if (isBatchMode) {
            return executeTasksInBatches(tasks, batchSize, progressBar);
        } else {
            return executeTasksSequentially(tasks, progressBar);
        }
    }

    public Table executeTasksInBatches(List<Callable<Table>> tasks, int batchSize, ProgressBar progressBar) throws InterruptedException, ExecutionException {
        int totalTasks = tasks.size();
        List<Table> allResults = new ArrayList<>();
        List<CompletableFuture<Table>> batchFutures = new ArrayList<>();

        for (int i = 0; i < totalTasks; i += batchSize) {
            int start = i;
            int end = Math.min(i + batchSize, totalTasks);

            CompletableFuture<Table> batchFuture = CompletableFuture.supplyAsync(() -> {
                Table batchResult = Table.create("Batch Results", StringColumn.create("EXIT_CODE"));
                for (int j = start; j < end; j++) {
                    try {
                        Table result = tasks.get(j).call();
                        batchResult = batchResult.append(result);
                        progressBar.step();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }
                return batchResult;
            }, executor);

            batchFutures.add(batchFuture);
        }

        for (CompletableFuture<Table> batchFuture : batchFutures) {
            allResults.add(batchFuture.get());
        }

        return concatenateTables(allResults);
    }

    public Table executeTasksSequentially(List<Callable<Table>> tasks, ProgressBar progressBar) {
        List<Table> allResults = new ArrayList<>();

        for (Callable<Table> task : tasks) {
            try {
                Table result = task.call();
                allResults.add(result);
                progressBar.step();
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }

        return concatenateTables(allResults);
    }

    private Table concatenateTables(List<Table> tables) {
        Table resultTable = Table.create("Final Results", StringColumn.create("EXIT_CODE"));
        for (Table table : tables) {
            resultTable = resultTable.append(table);
        }
        return resultTable;
    }

    // 개별 작업 처리 함수 (1~2초 랜덤 sleep, 결과 반환)
    private Table processTask(int taskId) {
        // 시작 시각
        LocalDateTime startTime = LocalDateTime.now();
        List<String> results = new ArrayList<>();

        try {
            Random random = new Random();
            int sleepTime = 1000 + random.nextInt(1000); // 1000ms ~ 2000ms
            TimeUnit.MILLISECONDS.sleep(sleepTime);

            // 끝난 시각
            LocalDateTime endTime = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String result = "Task=" + taskId + " start=" + startTime.format(formatter) + " finish=" + endTime.format(formatter);
            results.add(result);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            results.add("Task " + taskId + " interrupted.");
        }

        // 결과를 테이블로 변환하여 반환
        StringColumn exitCode = StringColumn.create("EXIT_CODE", results);
        return Table.create(exitCode);
    }
}

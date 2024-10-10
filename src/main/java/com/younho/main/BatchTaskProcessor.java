package com.younho.main;

import me.tongfei.progressbar.ProgressBar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import me.tongfei.progressbar.ProgressBar;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class BatchTaskProcessor {

    private final Random random = new Random();
    private final ExecutorService executorService;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    // Constructor에서 스레드 풀을 생성
    public BatchTaskProcessor(int threadPoolSize) {
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    public static void main(String[] args) throws Exception {
        // BatchTaskProcessor 생성 시 스레드 풀 크기 전달
        BatchTaskProcessor processor = new BatchTaskProcessor(10);

        // 100개의 가짜 작업(task)을 생성하고 각 작업의 결과를 받아 처리
        List<Callable<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int taskId = i;
            tasks.add(() -> processor.processTask(taskId));  // 각 task가 processTask 결과 반환
        }

        // ProgressBar 생성 (총 100개의 작업을 수행)
        try (ProgressBar progressBar = new ProgressBar("Task Progress", 100)) {
            // 조건에 따라 배치 실행 또는 순차 실행
            boolean isBatchMode = true; // 조건에 따라 true/false 값 설정

            Table resultTable = processor.executeTasks(tasks, isBatchMode, 10, progressBar);

            // 결과 확인
            System.out.println(resultTable.print(500));
        } finally {
            processor.shutdown();
        }
    }

    public Table executeTasks(List<Callable<String>> tasks, boolean isBatchMode, int batchSize, ProgressBar progressBar) throws Exception {
        if (isBatchMode) {
            return executeTasksInBatches(tasks, batchSize, progressBar);
        } else {
            return executeTasksSequentially(tasks, progressBar);
        }
    }

    // 배치로 task를 실행하고 결과를 Table로 반환하는 함수
    public Table executeTasksInBatches(List<Callable<String>> tasks, int batchSize, ProgressBar progressBar) throws InterruptedException, ExecutionException {
        int totalTasks = tasks.size();
        List<String> allResults = new ArrayList<>();
        List<CompletableFuture<List<String>>> batchFutures = new ArrayList<>();

        for (int i = 0; i < totalTasks; i += batchSize) {
            int start = i;
            int end = Math.min(i + batchSize, totalTasks);

            CompletableFuture<List<String>> batchFuture = CompletableFuture.supplyAsync(() -> {
                List<String> batchResults = new ArrayList<>();
                for (int j = start; j < end; j++) {
                    try {
                        String result = tasks.get(j).call();
                        batchResults.add(result);
                        progressBar.step();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }
                return batchResults;
            }, executorService);

            batchFutures.add(batchFuture);
        }

        // 모든 배치가 완료될 때까지 기다리고 결과를 수집
        for (CompletableFuture<List<String>> batchFuture : batchFutures) {
            allResults.addAll(batchFuture.get());
        }

        // 결과를 Table로 변환
        return createResultTable(allResults);
    }

    // 순차적으로 task를 실행하고 결과를 Table로 반환하는 함수
    public Table executeTasksSequentially(List<Callable<String>> tasks, ProgressBar progressBar) {
        List<String> allResults = new ArrayList<>();

        for (Callable<String> task : tasks) {
            try {
                String result = task.call();
                allResults.add(result);
                progressBar.step();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 결과를 Table로 변환
        return createResultTable(allResults);
    }

    // 결과를 Tablesaw Table로 변환하는 함수
    private Table createResultTable(List<String> results) {
        StringColumn resultColumn = StringColumn.create("Results", results);
        Table resultTable = Table.create("Task Results", resultColumn);
        return resultTable;
    }

    // 스레드 풀 종료
    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    // 개별 작업 처리 함수 (1~2초 랜덤 sleep, 결과 반환)
    private String processTask(int taskId) {
        // 시작 시각
        LocalDateTime startTime = LocalDateTime.now();

        try {
            int sleepTime = 1000 + random.nextInt(1000); // 1000ms ~ 2000ms
            TimeUnit.MILLISECONDS.sleep(sleepTime);

            // 끝난 시각
            LocalDateTime endTime = LocalDateTime.now();

            String result = "Task=" + taskId + "start=" + startTime.format(formatter) + " finish=" + endTime.format(formatter);
            return result;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Task " + taskId + " interrupted.";
        }
    }
}

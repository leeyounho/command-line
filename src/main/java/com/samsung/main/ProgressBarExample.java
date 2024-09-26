package com.samsung.main;

import me.tongfei.progressbar.ProgressBar;
import me.tongfei.progressbar.ProgressBarBuilder;
import me.tongfei.progressbar.ProgressBarStyle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ProgressBarExample {
    private static final Logger LOGGER = LogManager.getLogger(ProgressBarExample.class);

    public static void main(String[] args) {
        LOGGER.info("START ProgressBarExample");
        List<String> list = initList();

        ProgressBarBuilder pbb = new ProgressBarBuilder()
                .setStyle(ProgressBarStyle.ASCII)
//                .setStyle(ProgressBarStyle.UNICODE_BLOCK)
                .setMaxRenderedLength(100)
                .setTaskName("TEST"); // TaskName 은 set 하지 않고 이전 줄에서 detail 하게 정보 출력하는 것이 보기 좋을 듯함.
        for (String ignored : ProgressBar.wrap(list, pbb)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        LOGGER.info("END ProgressBarExample");
    }

    private static List<String> initList() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        return list;
    }
}

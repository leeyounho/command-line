package com.samsung.main;

import com.samsung.command.CommandProcessor;
import com.samsung.command.Status;
import com.samsung.di.component.AppComponent;
import com.samsung.di.component.CommandProcessFactory;
import com.samsung.di.component.DaggerAppComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AppMain {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        AppComponent appComponent = DaggerAppComponent.create();

        CommandProcessFactory commandProcessFactory = appComponent.commandComponent().create();
        CommandProcessor commandProcessor = commandProcessFactory.commandProcessor();

        LOGGER.info("AppComponent initialized");

        // Command 를 받으면 실행함.
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            Status unused = commandProcessor.process(scanner.nextLine());
        }

    }
}

package com.samsung.main;

import com.samsung.command.CommandProcessor;
import com.samsung.command.Status;
import com.samsung.component.AppComponentFactory;
import com.samsung.component.DaggerAppComponentFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


class CommandLineAtm {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.debug("Debug message");
        LOGGER.info("Info message");
        LOGGER.warn("Warn message");
        LOGGER.error("Error message");

        Scanner scanner = new Scanner(System.in);
        AppComponentFactory appComponentFactory = DaggerAppComponentFactory.create();
        CommandProcessor commandProcessor = appComponentFactory.commandProcessor();

        while (scanner.hasNextLine()) {
            Status unused = commandProcessor.process(scanner.nextLine());
        }
    }
}

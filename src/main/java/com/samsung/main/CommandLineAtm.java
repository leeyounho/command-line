package com.samsung.main;

import com.samsung.command.CommandProcessor;
import com.samsung.command.Status;
import com.samsung.component.CommandProcessorFactory;
import com.samsung.component.DaggerCommandProcessorFactory;
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
        CommandProcessorFactory commandProcessorFactory = DaggerCommandProcessorFactory.create();
        CommandProcessor commandProcessor = commandProcessorFactory.commandProcessor();

        while (scanner.hasNextLine()) {
            Status unused = commandProcessor.process(scanner.nextLine());
        }
    }
}

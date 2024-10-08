package com.younho.main;

import com.google.common.base.Splitter;
import com.younho.command.CommandFactory;
import com.younho.di.component.AppComponent;
import com.younho.di.component.DaggerAppComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import picocli.CommandLine;

import java.util.List;
import java.util.Scanner;

public class AppMain {
    private static final Logger LOGGER = LogManager.getLogger(AppMain.class);

    public static void main(String[] args) {
        AppComponent appComponent = DaggerAppComponent.create();
        CommandFactory commandFactory = appComponent.getCommandFactory();

        LOGGER.debug("AppMain initialized");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            List<String> parts = Splitter.on(" ").trimResults().splitToList(input);

            String firstPart = parts.get(0);
            String[] secondParts = parts.size() > 1 ? parts.subList(1, parts.size()).toArray(new String[0]) : new String[0];

            int exitCode = new CommandLine(commandFactory.createCommand(firstPart)).execute(secondParts);
            LOGGER.debug("exitCode={}", exitCode);
        }
    }
}

package com.younho.main;

import com.younho.command.CommandRouter;
import com.younho.di.component.AppComponent;
import com.younho.di.component.CommandRouterComponent;
import com.younho.di.component.DaggerAppComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AppMain {
    private static final Logger LOGGER = LogManager.getLogger(AppMain.class);

    public static void main(String[] args) {
        AppComponent appComponent = DaggerAppComponent.create();

        CommandRouterComponent commandRouterComponent = appComponent.getCommandRouterComponent().create();
        CommandRouter commandRouter = commandRouterComponent.router();

        LOGGER.debug("AppMain initialized");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;
            int exitCode = commandRouter.route(input);
            LOGGER.debug("exitCode={}", exitCode);
        }
    }
}

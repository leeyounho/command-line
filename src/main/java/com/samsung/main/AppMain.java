package com.samsung.main;

import com.samsung.command.CommandRouter;
import com.samsung.di.component.AppComponent;
import com.samsung.di.component.CommandRouterComponent;
import com.samsung.di.component.DaggerAppComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AppMain {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        AppComponent appComponent = DaggerAppComponent.create();

        CommandRouterComponent commandRouterComponent = appComponent.commandComponent().create();
        CommandRouter commandRouter = commandRouterComponent.router();

        LOGGER.info("AppComponent initialized");

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            boolean result = commandRouter.route(scanner.nextLine());
            LOGGER.info("result={}", result);
        }
    }
}

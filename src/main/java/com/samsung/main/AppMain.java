package com.samsung.main;

import com.samsung.command.CommandRouter;
import com.samsung.di.component.AppComponent;
import com.samsung.di.component.CommandRouterComponent;
import com.samsung.di.component.DaggerAppComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AppMain {
    private static final Logger LOGGER = LogManager.getLogger(AppMain.class);

    public static void main(String[] args) {
        AppComponent appComponent = DaggerAppComponent.create();

        CommandRouterComponent commandRouterComponent = appComponent.commandComponent().create();
        CommandRouter commandRouter = commandRouterComponent.router();

        LOGGER.debug("AppMain initialized");

        /* Note
            새로운 PicoCommand 추가를 위해서는
            1.picocli package 아래 class 추가, 2.PicoCommandModule class 에 method 추가
        */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int exitCode = commandRouter.route(scanner.nextLine());
            LOGGER.debug("exitCode={}", exitCode);
        }
    }
}

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

        CommandRouterComponent commandRouterComponent = appComponent.commandComponent().create();
        CommandRouter commandRouter = commandRouterComponent.router();

        LOGGER.debug("AppMain initialized");

        /* Note
            새로운 PicoCommand 추가를 위해서는
            1.picocli package 아래 class 추가, 2.PicoCommandModule class 에 method 추가
        */
        Scanner scanner = new Scanner(System.in);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
//            String input = reader.readLine().trim();
            if (input.isEmpty()) continue;
            int exitCode = commandRouter.route(input);
            LOGGER.debug("exitCode={}", exitCode);
        }
    }
}

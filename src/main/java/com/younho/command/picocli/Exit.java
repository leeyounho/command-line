package com.younho.command.picocli;

import com.younho.command.Command;
import com.younho.util.ConsoleLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import picocli.CommandLine;

@CommandLine.Command(name = "exit", version = "exit 1.0", mixinStandardHelpOptions = true)
public class Exit extends Command implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(Exit.class);
    private final ConsoleLogger console;

    public Exit(ConsoleLogger console) {
        LOGGER.debug("Initializing Exit");

        this.console = console;
    }

    @Override
    public void run() {
        console.info("The terminal window exits");
        System.exit(0);
    }
}

package com.younho.command.picocli;

import com.younho.command.PicoCommandHandler;
import com.younho.message.KafkaSender;
import com.younho.message.MessageSender;
import com.younho.message.TibrvSender;
import com.younho.util.ConsoleLogger;
import picocli.CommandLine.Command;

import javax.inject.Inject;

// Example Class
@Command(name = "exit", version = "exit 1.0", mixinStandardHelpOptions = true)
public class Exit extends PicoCommandHandler implements Runnable {
    private final ConsoleLogger console;

    @Inject
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

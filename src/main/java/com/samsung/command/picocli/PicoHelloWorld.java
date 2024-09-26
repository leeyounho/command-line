package com.samsung.command.picocli;

import com.samsung.command.PicoCommandHandler;
import picocli.CommandLine;

import javax.inject.Inject;

@CommandLine.Command(name = "PicoHelloWorld", version = "1.0", mixinStandardHelpOptions = true)
public class PicoHelloWorld extends PicoCommandHandler implements Runnable {
    @Inject
    public PicoHelloWorld() {
        LOGGER.debug("Initializing PicoHelloWorld");
    }

    @CommandLine.Option(names = {"-s", "--font-size"}, description = "Font size")
    int fontSize = 14;

    @CommandLine.Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli", description = "Words to be translated into ASCII art.")
    private String[] words = {"Hello,", "picocli"};

    @Override
    public void run() {
        LOGGER.info("Pico Hello World");
    }
}

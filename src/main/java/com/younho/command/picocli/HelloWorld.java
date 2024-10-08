package com.younho.command.picocli;

import com.younho.cache.Cache;
import com.younho.command.Command;
import picocli.CommandLine;

import static picocli.CommandLine.*;

@CommandLine.Command(name = "PicoHelloWorld", version = "1.0", mixinStandardHelpOptions = true)
public class HelloWorld extends Command implements Runnable {
    private Cache cache;

    public HelloWorld(Cache cache) {
        LOGGER.debug("Initializing PicoHelloWorld");
    }

    @Option(names = {"-s", "--font-size"}, description = "Font size")
    int fontSize = 14;

    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli", description = "Words to be translated into ASCII art.")
    private String[] words = {"Hello,", "picocli"};

    @Override
    public void run() {
        LOGGER.info("Pico Hello World");
        LOGGER.info("fontsize={}", fontSize);
    }
}

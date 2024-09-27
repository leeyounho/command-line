package com.samsung.command.picocli;

import com.samsung.command.PicoCommandHandler;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;

// Example Class
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class ASCIIArt extends PicoCommandHandler implements Runnable {
    @Inject
    public ASCIIArt() {
        LOGGER.debug("Initializing ASCIIArt");
    }

    @Option(names = {"-s", "--font-size"}, description = "Font size")
    int fontSize = 14;

    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli", description = "Words to be translated into ASCII art.")
    private String[] words = {"Hello,", "picocli"};

    @Override
    public void run() {
        BufferedImage image = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setFont(new Font("Dialog", Font.BOLD, fontSize));
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.drawString(String.join(" ", words), 6, 24);

        for (int y = 0; y < 32; y++) {
            StringBuilder builder = new StringBuilder();
            for (int x = 0; x < 144; x++)
                builder.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
            if (builder.toString().trim().isEmpty()) continue;
            System.out.println(builder);
        }
    }
}

package samsung.main;

import com.samsung.command.CommandProcessor;
import com.samsung.command.Status;
import com.samsung.command.component.CommandProcessorFactory;
import com.samsung.command.component.DaggerCommandProcessorFactory;

import java.util.Scanner;


class CommandLineAtm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandProcessorFactory commandProcessorFactory = DaggerCommandProcessorFactory.create();
        CommandProcessor commandProcessor = commandProcessorFactory.commandProcessor();

        while (scanner.hasNextLine()) {
            Status unused = commandProcessor.process(scanner.nextLine());
        }
    }
}

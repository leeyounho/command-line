package samsung.command.strategy;

import com.samsung.command.Command;
import com.samsung.command.Outputter;
import com.samsung.command.Result;

import javax.inject.Inject;
import java.util.List;

public final class HelloWorldCommand implements Command {
    private final Outputter outputter;

    @Inject
    public HelloWorldCommand(Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Result.invalid();
        }
        outputter.output("world!");
        return Result.handled();
    }
}
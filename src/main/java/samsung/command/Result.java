package samsung.command;

import java.util.Optional;

public final class Result {
    private final Status status;
    private final Optional<CommandRouter> nestedCommandRouter;

    private Result(Status status, Optional<CommandRouter> nestedCommandRouter) {
        this.status = status;
        this.nestedCommandRouter = nestedCommandRouter;
    }

    public static Result invalid() {
        return new Result(Status.INVALID, Optional.empty());
    }

    public static Result handled() {
        return new Result(Status.HANDLED, Optional.empty());
    }

    public static Result inputCompleted() {
        return new Result(Status.INPUT_COMPLETED, Optional.empty());
    }

    public Status status() {
        return status;
    }

    public Optional<CommandRouter> nestedCommandRouter() {
        return nestedCommandRouter;
    }

    public static Result enterNestedCommandSet(CommandRouter nestedCommandRouter) {
        return new Result(Status.HANDLED, Optional.of(nestedCommandRouter));
    }
}

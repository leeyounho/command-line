package samsung.command.component;

import com.samsung.command.CommandRouter;
import com.samsung.command.module.UserCommandsModule;
import com.samsung.database.entity.Account;
import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;

@Subcomponent(modules = UserCommandsModule.class)
public interface UserCommandsRouter {
    CommandRouter router();

    @Subcomponent.Factory
    interface Factory {
        UserCommandsRouter create(@BindsInstance Account account);
    }

    @Module(subcomponents = UserCommandsRouter.class)
    interface InstallationModule {
    }
}

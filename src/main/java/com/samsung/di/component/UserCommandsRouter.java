package com.samsung.di.component;

import com.samsung.command.CommandRouter;
import com.samsung.di.module.command.UserCommandsModule;
import com.samsung.cache.entity.Account;
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

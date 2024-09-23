package com.samsung.di.component;

import com.samsung.command.CommandRouter;
import com.samsung.di.annotation.CommandScope;
import com.samsung.di.module.command.HelloWorldModule;
import com.samsung.di.module.command.LoginCommandModule;
import com.samsung.di.module.command.LogoutCommandModule;
import dagger.Subcomponent;


@CommandScope
@Subcomponent(
        modules = {
                LoginCommandModule.class,
                LogoutCommandModule.class,
                HelloWorldModule.class,
        })
public interface CommandRouterComponent {
    CommandRouter router();

    @Subcomponent.Factory
    interface Factory {
        CommandRouterComponent create();
    }
}

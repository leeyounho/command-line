package com.samsung.di.component;

import com.samsung.command.CommandRouter;
import com.samsung.di.annotation.CommandScope;
import com.samsung.di.module.command.PicoCommandModule;
import com.samsung.di.module.command.HelloWorldModule;
import dagger.Subcomponent;


@CommandScope
@Subcomponent(
        modules = {
                PicoCommandModule.class,
                HelloWorldModule.class,
        })
public interface CommandRouterComponent {
    CommandRouter router();

    @Subcomponent.Factory
    interface Factory {
        CommandRouterComponent create();
    }
}

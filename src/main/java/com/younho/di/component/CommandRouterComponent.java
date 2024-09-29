package com.younho.di.component;

import com.younho.command.CommandRouter;
import com.younho.di.annotation.CommandScope;
import com.younho.di.module.command.PicoCommandModule;
import com.younho.di.module.command.HelloWorldModule;
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

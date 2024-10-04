package com.younho.di.component;

import com.younho.command.CommandRouter;
import com.younho.di.annotation.CommandScope;
import com.younho.di.module.PicoCommandModule;
import dagger.Subcomponent;


@CommandScope
@Subcomponent(
        modules = {
                PicoCommandModule.class,
        })
public interface CommandRouterComponent {
    CommandRouter router();

    @Subcomponent.Factory
    interface Factory {
        CommandRouterComponent create();
    }
}

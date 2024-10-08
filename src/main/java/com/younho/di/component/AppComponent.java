package com.younho.di.component;

import com.younho.cache.Cache;
import com.younho.command.CommandFactory;
import com.younho.database.SessionFactoryWrapper;
import com.younho.di.module.ConsoleModule;
import com.younho.message.KafkaSender;
import com.younho.message.TibrvSender;
import com.younho.threadpool.ThreadPoolWrapper;
import com.younho.util.ApplicationPropertyLoader;
import com.younho.util.AppUtils;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ConsoleModule.class})
public interface AppComponent {
    Cache getCache();

    ThreadPoolWrapper getThreadPoolWrapper();

    ApplicationPropertyLoader getApplicationPropertyLoader();

    AppUtils getAppUtils();

    SessionFactoryWrapper getSessionFactoryWrapper();

    KafkaSender getKafkaSender();

    TibrvSender getTibrvSender();

    CommandFactory getCommandFactory();
}

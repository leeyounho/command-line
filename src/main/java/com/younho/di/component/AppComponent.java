package com.younho.di.component;

import com.younho.cache.Cache;
import com.younho.database.SessionFactoryWrapper;
import com.younho.di.module.ConsoleModule;
import com.younho.threadpool.ThreadPoolWrapper;
import com.younho.util.ApplicationPropertyLoader;
import com.younho.util.MyUtil;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ConsoleModule.class})
public interface AppComponent {
    Cache getCache();

    ThreadPoolWrapper getThreadPoolWrapper();

    ApplicationPropertyLoader getApplicationPropertyLoader();

    MyUtil getMyUtil();

    SessionFactoryWrapper getSessionFactoryWrapper();

    // Subcomponent 정의
    CommandRouterComponent.Factory commandComponent();
}

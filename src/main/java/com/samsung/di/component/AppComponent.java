package com.samsung.di.component;

import com.samsung.cache.Cache;
import com.samsung.database.SessionFactoryWrapper;
import com.samsung.di.module.ConsoleModule;
import com.samsung.threadpool.ThreadPoolWrapper;
import com.samsung.util.ApplicationPropertyLoader;
import com.samsung.util.MyUtil;
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

package com.samsung.di.component;

import com.samsung.cache.Cache;
import com.samsung.threadpool.ThreadPoolWrapper;
import com.samsung.util.ApplicationPropertyLoader;
import com.samsung.util.MyUtil;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {})
public interface AppComponent {
    Cache getCache();

    ThreadPoolWrapper getThreadPoolWrapper();

    ApplicationPropertyLoader getPropertyLoader();

    MyUtil getMyUtil();

    // TODO Database 관련 추가.

    // Subcomponent 정의
    CommandRouterComponent.Factory commandComponent();
}

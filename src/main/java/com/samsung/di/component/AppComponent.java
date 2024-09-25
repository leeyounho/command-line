package com.samsung.di.component;

import com.samsung.cache.Cache;
import com.samsung.di.module.CacheModule;
import com.samsung.di.module.PropertyModule;
import com.samsung.di.module.ThreadPoolModule;
import com.samsung.threadpool.ThreadPoolWrapper;
import com.samsung.util.PropertyLoader;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(
        modules = {
                PropertyModule.class,
                CacheModule.class,
                ThreadPoolModule.class,
        })
public interface AppComponent {
    // Provision 메서드 유형 : 매개변수가 없고, Module이 제공하는 객체의 타입을 반환형으로 갖음.
    // 생성된 Component 클래스에서 Provision 메서드를 통해 객체를 얻을 수 있음.
    PropertyLoader getPropertyLoader();
    Cache getCache();
    ThreadPoolWrapper getThreadPoolWrapper();

    // TODO Database 관련 추가.

    // Subcomponent 정의
    CommandRouterComponent.Factory commandComponent();
}

package com.samsung.di.module;

import com.samsung.threadpool.ThreadPoolWrapper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ThreadPoolModule {
    @Provides
    @Singleton
    public ThreadPoolWrapper provideThreadPoolWrapper(){
        return new ThreadPoolWrapper();
    }
}

package com.samsung.di.module;

import com.samsung.cache.Cache;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class CacheModule {
    @Provides
    @Singleton
    public Cache provideCache(){
        return new Cache();
    }
}

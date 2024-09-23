package com.samsung.di.module;

import com.samsung.util.PropertyLoader;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class PropertyModule {
    @Provides
    @Singleton
    public PropertyLoader providePropertiesLoader() {
        return new PropertyLoader("application.properties");
    }
}

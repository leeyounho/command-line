package com.samsung.util.module;

import com.samsung.util.PropertiesLoader;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ConfigModule {
    @Provides
    @Singleton
    public PropertiesLoader providePropertiesLoader() {
        return new PropertiesLoader("application.properties");
    }
}

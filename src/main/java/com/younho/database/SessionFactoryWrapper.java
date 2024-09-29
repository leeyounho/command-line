package com.younho.database;

import com.younho.database.entity.Regions;
import com.younho.util.ApplicationPropertyLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.inject.Inject;

public class SessionFactoryWrapper {
    private static final Logger LOGGER = LogManager.getLogger(SessionFactoryWrapper.class);
    private final SessionFactory sessionFactory;

    @Inject
    public SessionFactoryWrapper(ApplicationPropertyLoader applicationPropertyLoader) {
        LOGGER.debug("Initializing SessionFactoryWrapper");

        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .applySettings(applicationPropertyLoader.getProperties())
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Regions.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

        SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();

        sessionFactory = sessionFactoryBuilder.build();
    }
}

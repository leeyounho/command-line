package com.samsung.main;

import com.samsung.database.entity.Regions;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateExample {
    public static void main(String[] args) {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure( "org/hibernate/example/hibernate.cfg.xml" )
                .build();

        Metadata metadata = new MetadataSources( standardRegistry )
                .addAnnotatedClass( Regions.class )
//                .addAnnotatedClassName( "org.hibernate.example.Customer" )
//                .addResource( "org/hibernate/example/Order.hbm.xml" )
//                .addResource( "org/hibernate/example/Product.orm.xml" )
                .getMetadataBuilder()
                .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
                .build();

        SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();

        // Supply a SessionFactory-level Interceptor
//        sessionFactoryBuilder.applyInterceptor( new CustomSessionFactoryInterceptor() );

        // Add a custom observer
//        sessionFactoryBuilder.addSessionFactoryObservers( new CustomSessionFactoryObserver() );

        // Apply a CDI BeanManager ( for JPA event listeners )
//        sessionFactoryBuilder.applyBeanManager( getBeanManager() );

        SessionFactory sessionFactory = sessionFactoryBuilder.build();
    }
}

package com.samsung.main;

import com.samsung.database.SessionFactoryWrapper;
import com.samsung.util.ApplicationPropertyLoader;

public class HibernateExample {
    public static void main(String[] args) {
        ApplicationPropertyLoader applicationPropertyLoader = new ApplicationPropertyLoader();
        new SessionFactoryWrapper(applicationPropertyLoader);
    }
}

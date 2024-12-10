package org.example.util;

import org.example.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;

public class Util {

    public static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";
    public static final String POSTGRESQL_URL = "jdbc:postgresql://localhost:5432/TaskJDBC_db";
    public static final String POSTGRESQL_USER = "myUser";
    public static final String POSTGRESQL_PASSWORD = "myUser";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(POSTGRESQL_DRIVER);
        return DriverManager.getConnection(POSTGRESQL_URL, POSTGRESQL_USER, POSTGRESQL_PASSWORD);
    }

    public static SessionFactory getHibernateSessionFactory() {
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        Properties properties = getProperties();

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();

        properties.put(Environment.DRIVER, POSTGRESQL_DRIVER);
        properties.put(Environment.URL, POSTGRESQL_URL);
        properties.put(Environment.USER, POSTGRESQL_USER);
        properties.put(Environment.PASS, POSTGRESQL_PASSWORD);

        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        return properties;
    }
}

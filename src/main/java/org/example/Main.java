package org.example;

import org.example.config.AppConfig;
import org.example.model.User;
import org.example.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        UserServiceImpl userServiceJDBC = applicationContext.getBean("userServiceJDBC", UserServiceImpl.class);
        UserServiceImpl userServiceHibernate = applicationContext.getBean("userServiceHibernate", UserServiceImpl.class);

        userServiceJDBC.dropUsersTable();
        userServiceJDBC.createUsersTable();
        userServiceJDBC.saveUser("Vasiliy", "Vasiliev", (byte) 20);
        userServiceJDBC.saveUser("Petr", "Petrov", (byte) 30);
        userServiceJDBC.saveUser("Ivan", "Ivanov", (byte) 40);
        userServiceJDBC.saveUser("Sergey", "Sergeev", (byte) 50);

        userServiceJDBC.removeUserById(4L);

        for (User user : userServiceJDBC.getAllUsers()) {
            System.out.println(user.toString());
        }

        userServiceJDBC.cleanUsersTable();

        userServiceHibernate.dropUsersTable();
        userServiceHibernate.createUsersTable();
        userServiceHibernate.saveUser("Vasiliy", "Vasiliev", (byte) 20);
        userServiceHibernate.saveUser("Petr", "Petrov", (byte) 30);
        userServiceHibernate.saveUser("Ivan", "Ivanov", (byte) 40);
        userServiceHibernate.saveUser("Sergey", "Sergeev", (byte) 50);

        userServiceHibernate.removeUserById(4);

        for (User user : userServiceHibernate.getAllUsers()) {
            System.out.println(user.toString());
        }

        userServiceHibernate.cleanUsersTable();
    }
}

package org.example.config;

import org.example.dao.UserDao;
import org.example.dao.UserDaoHibernateImpl;
import org.example.dao.UserDaoJDBCImpl;
import org.example.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppConfig {

//    @Bean("userJDBCDao")
//    public UserDao getUserDaoJDBCImpl() {
//        return new UserDaoJDBCImpl();
//    }
//
//    @Bean("userHibernateDao")
//    public UserDao getUserDaoHibernateImpl() {
//        return new UserDaoHibernateImpl();
//    }
//
//    @Bean("userServiceJDBC")
//    public UserServiceImpl getUserServiceJDBC() {
//        return new UserServiceImpl(getUserDaoJDBCImpl());
//    }
//
//    @Bean("userServiceHibernate")
//    public UserServiceImpl getUserService() {
//        return new UserServiceImpl(getUserDaoHibernateImpl());
//    }
}



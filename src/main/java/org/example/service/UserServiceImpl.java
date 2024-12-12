package org.example.service;

import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDaoJDBCImpl;
    private final UserDao userDaoHibernateImpl;

    public UserServiceImpl(@Qualifier("userDaoJDBCImpl") UserDao userDaoJDBCImpl,
                           @Qualifier("userDaoHibernateImpl") UserDao userDaoHibernateImpl) {
        this.userDaoJDBCImpl = userDaoJDBCImpl;
        this.userDaoHibernateImpl = userDaoHibernateImpl;
    }

    public void createUsersTable() {
        userDaoJDBCImpl.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoJDBCImpl.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBCImpl.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoJDBCImpl.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoJDBCImpl.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJDBCImpl.cleanUsersTable();
    }
}

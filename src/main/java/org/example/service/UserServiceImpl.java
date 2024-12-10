package org.example.service;

import org.example.dao.UserDao;
import org.example.dao.UserDaoHibernateImpl;
import org.example.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userHibernateDao = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userHibernateDao.createUsersTable();
    }

    public void dropUsersTable() {
        userHibernateDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userHibernateDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userHibernateDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userHibernateDao.getAllUsers();
    }

    public void cleanUsersTable() {
        userHibernateDao.cleanUsersTable();
    }
}

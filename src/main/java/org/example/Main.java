package org.example;

import org.example.dao.UserDao;
import org.example.dao.UserDaoHibernateImpl;
import org.example.model.User;

public class Main {
    public static void main(String[] args) {

        UserDao userHibernateDao = new UserDaoHibernateImpl();

        userHibernateDao.dropUsersTable();
        userHibernateDao.createUsersTable();
        userHibernateDao.saveUser("Vasiliy", "Vasiliev", (byte) 20);
        userHibernateDao.saveUser("Petr", "Petrov", (byte) 30);
        userHibernateDao.saveUser("Ivan", "Ivanov", (byte) 40);
        userHibernateDao.saveUser("Sergey", "Sergeev", (byte) 50);

        userHibernateDao.removeUserById(4);

        for (User user : userHibernateDao.getAllUsers()) {
            System.out.println(user.toString());
        }

        userHibernateDao.cleanUsersTable();
    }
}

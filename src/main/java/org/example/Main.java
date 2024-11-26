package org.example;

import org.example.dao.UserDao;
import org.example.dao.UserDaoJDBCImpl;
import org.example.model.User;

public class Main {
    public static void main(String[] args) {

        UserDao userJDBCDao = new UserDaoJDBCImpl();

        userJDBCDao.dropUsersTable();
        userJDBCDao.createUsersTable();
        userJDBCDao.saveUser("Vasiliy", "Vasiliev", (byte) 20);
        userJDBCDao.saveUser("Petr", "Petrov", (byte) 30);
        userJDBCDao.saveUser("Ivan", "Ivanov", (byte) 40);
        userJDBCDao.saveUser("Sergey", "Sergeev", (byte) 50);

        userJDBCDao.removeUserById(4L);

        for (User user : userJDBCDao.getAllUsers()) {
            System.out.println(user.toString());
        }

        userJDBCDao.cleanUsersTable();

    }
}

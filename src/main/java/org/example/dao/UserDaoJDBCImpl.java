package org.example.dao;

import org.example.model.User;
import org.example.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {


    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String createUsersTableSql = "CREATE TABLE IF NOT EXISTS users"
                + "(id bigserial NOT NULL PRIMARY KEY, name varchar(30) NOT NULL,"
                + "lastname varchar(30) NOT NULL, smallint age)";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(createUsersTableSql);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void dropUsersTable() {
        String dropUsersTableSql = "DROP TABLE IF EXISTS users";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(dropUsersTableSql);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String saveUserSql = "INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)";
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(saveUserSql)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        String deleteUserByIdSql = "DELETE FROM users";
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteUserByIdSql)) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        String getAllUserSql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getAllUserSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                byte age = resultSet.getByte("age");
                users.add(new User(name, lastName, age));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public void cleanUsersTable() {
        String cleanUsersTableSql = "TRUNCATE users";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(cleanUsersTableSql);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
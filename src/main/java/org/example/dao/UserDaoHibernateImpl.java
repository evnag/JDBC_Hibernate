package org.example.dao;

import org.example.model.User;
import org.example.util.Util;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDaoHibernateImpl")
public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        String createUsersTableSql = "CREATE TABLE IF NOT EXISTS users"
                + "(id bigserial NOT NULL PRIMARY KEY, name varchar(30) NOT NULL,"
                + "lastname varchar(30) NOT NULL, age smallint);";
        try (Session session = Util.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.createNativeQuery(createUsersTableSql).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        String dropUsersTableSql = "DROP TABLE IF EXISTS users";
        try (Session session = Util.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.createNativeQuery(dropUsersTableSql).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(new User(name, lastName, age));
            session.getTransaction().commit();
            System.out.println("User с именем — " + name + " добавлен в базу данных");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.remove(user);
                System.out.println("User with id:" + id + " was deleted");
            } else {
                System.out.println("User with id:" + id + " not found");
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            Query<User> query = session.createQuery("FROM User", User.class);
            List<User> users = query.getResultList();
            session.getTransaction().commit();
            return users;
        }
    }

    @Override
    public void cleanUsersTable() {
        String cleanUsersTableSql = "TRUNCATE users";
        try (Session session = Util.getHibernateSessionFactory().openSession()) {
            session.beginTransaction();
            session.createNativeQuery(cleanUsersTableSql).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

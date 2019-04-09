
import Entity.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class UsersRunner {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        UsersRunner usersRunner = new UsersRunner();

        System.out.println("Добавление записей пользователя");

        usersRunner.addUser(1,"Щеглов Александр", "alex123");
        usersRunner.addUser(2,"vasya", "vasya123");
        usersRunner.addUser(3,"petya", "petya123");

        System.out.println("-----------------------");
        usersRunner.listUsers();

        sessionFactory.close();
    }

    public void addUser(int id, String userName, String userPass) {
        Transaction transaction = null ;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        TestTransac.testTransac("сохраняем user", session, transaction);

        User us = new User(id, userName, userPass);
        session.save(us);
        transaction.commit();
        session.close();

        TestTransac.testTransac("сохранил user", session, transaction);
    }

    public void listUsers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null ;
        transaction = session.beginTransaction();

        TestTransac.testTransac("вывод на экран", session, transaction);
    //    List users = session.createQuery("FROM User ").list();
    //    for (User user : users) {
      //      System.out.println(user);
     ///       System.out.println("---------------------");
      //  }

        session.close();
        TestTransac.testTransac("вывел на экран", session, transaction);
    }

    public  void updateUser(int userId, String userName, String userPasw) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null ;
        transaction = session.beginTransaction();
        User user = (User) session.get(User.class, userId);
        user.setUserName(userName);
        user.setUserPasw(userPasw);
        session.update(user);
        transaction.commit();
        session.close();
    }

    public  void removeUser(int userId){
        Session sess = sessionFactory.openSession();
        Transaction trans = null ;
        trans = sess.beginTransaction();
        User user = (User) sess.get(User.class, userId);
        sess.delete(user);
        trans.commit();
        sess.close();
    }
}
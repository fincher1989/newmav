
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

        System.out.println("___________________________");
        System.out.println("Добавление записей 3 записи");
        usersRunner.addUser(1,"vanya", "vanya123");
        usersRunner.addUser(2,"vasya", "vasya123");
        usersRunner.addUser(3,"petya", "petya123");
        usersRunner.listUsers();
        System.out.println("___________________________");
        System.out.println();

        System.out.println("___________________________");
        System.out.println("изменю запись 2");

        usersRunner.updateUser(2," Вася", " Вася123");

        usersRunner.listUsers();
        System.out.println("___________________________");
        System.out.println();

        System.out.println("___________________________");
        System.out.println("удалю первую запись");

        usersRunner.removeUser(1);

        usersRunner.listUsers();
        System.out.println("___________________________");
        System.out.println();

        sessionFactory.close();
    }

    public void addUser(int id, String userName, String userPass) {
        Transaction transaction = null ;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        User us = new User(id, userName, userPass);
        session.save(us);
        transaction.commit();
        session.close();
    }

    public void listUsers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null ;
        transaction = session.beginTransaction();
        List users = session.createQuery("FROM User").list();

        System.out.println("-----------------------");
        System.out.println("| id| name | password |");
        for (int i = 0 ; i < users.size(); i++)
            System.out.println(users.get(i));
        System.out.println("-----------------------");

        session.close();
      //  TestTransac.testTransac("вывел на экран", session, transaction);
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
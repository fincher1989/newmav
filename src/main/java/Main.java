import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        Session session = (new Configuration()).configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        UsersRunner usersRunner = new UsersRunner();

        System.out.println("___________________________");
        System.out.println("Добавление записей 3 записи");
        usersRunner.addUser(session,1,"vanya", "vanya123");
        usersRunner.addUser(session,2,"vasya", "vasya123");
        usersRunner.addUser(session,3,"petya", "petya123");
        usersRunner.listUsers(session);
        System.out.println("___________________________");
        System.out.println();

        System.out.println("___________________________");
        System.out.println("изменю запись 2");
        usersRunner.updateUser(session,2," Вася", " Вася123");
        usersRunner.listUsers(session);
        System.out.println("___________________________");
        System.out.println();

        System.out.println("___________________________");
        System.out.println("удалю первую запись");
        usersRunner.removeUser(session,1);
        usersRunner.listUsers(session);
        System.out.println("___________________________");
        System.out.println();

        System.out.println("___________________________");
        System.out.println("удалю все остальные");
        usersRunner.removeUser(session,2);
        usersRunner.removeUser(session,3);
        usersRunner.listUsers(session);
        System.out.println("___________________________");
        System.out.println();

        transaction.commit();
        session.close();
    }
}

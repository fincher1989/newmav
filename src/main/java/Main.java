import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class Main {

    public static void printListUser(UserService userService){
        List users = userService.listUsers();
        for (int i=0; i < users.size(); i++)
            System.out.println(users.get(i));
    }

    public static void main(String[] args) {
        Session session = (new Configuration()).configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List users ;

        UserService userService = new UserService(session);

        System.out.println("___________________________");
        System.out.println("Добавление записей 3 записи");
        userService.addUser(1,"vanya", "vanya123");
        userService.addUser(2,"vasya", "vasya123");
        userService.addUser(3,"petya", "petya123");
        printListUser(userService);
        System.out.println("___________________________");
        System.out.println();

        System.out.println("___________________________");
        System.out.println("изменю запись 2");
        userService.updateUser(2," Вася", " Вася123");
        printListUser(userService);
        System.out.println("___________________________");
        System.out.println();

        System.out.println("___________________________");
        System.out.println("удалю первую запись");
        userService.removeUser(1);
        printListUser(userService);
        System.out.println("___________________________");
        System.out.println();

        System.out.println("___________________________");
        System.out.println("удалю все остальные");
        userService.removeUser(2);
        userService.removeUser(3);
        printListUser(userService);
        System.out.println("___________________________");
        System.out.println();

        transaction.commit();
        session.close();
    }
}

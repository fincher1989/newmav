import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.Scanner;


import Entity.User;

public class Main {

    public static void printListUser(UserService userService){
        List users = userService.listUsers();
        System.out.println("___________user____________");
        for (int i = 0; i < users.size(); i++)
            System.out.println(users.get(i));
        System.out.println("_________end user__________");
    }

    public static void main(String[] args) {
        List users;
        Scanner scanner;
        Session session = (new Configuration()).configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserService userService = new UserService(session);

        userService.addUser("vanya", "vanya123");
        userService.addUser("vasya", "vasya123");
        userService.addUser("petya", "petya123");
        printListUser(userService);

        System.out.print("изменить:");
        scanner = new Scanner(System.in);
        userService.updateUser(scanner.nextLong()," Вася", " Вася123");
        printListUser(userService);

        System.out.print("удалить:");
        scanner = new Scanner(System.in);
        userService.removeUser(scanner.nextLong());
        printListUser(userService);

        System.out.println("удалю все остальные");
        users = userService.listUsers();
        for (long k = 0; k < users.size(); k++)
            userService.removeUser(k);
        printListUser(userService);


        transaction.commit();
        session.close();
    }
}

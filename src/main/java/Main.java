import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.Scanner;


import Entity.User;
import Entity.Role;

import javax.persistence.criteria.CriteriaBuilder;

public class Main {

    private static boolean printList(UserService userService){
        boolean rez = false ;
        List users = userService.listUsers();
        System.out.println("_________USER__________");
        for (int i = 0; i < users.size(); i++){
            System.out.println(users.get(i));
            rez = true ;
        }
        System.out.println("_______________________");
        return rez ;
    }

    private static boolean printList(RoleService roleService){
        boolean rez = false ;
        List roles = roleService.listRoles();
        System.out.println("_________ROLE__________");
        for (int i = 0; i < roles.size(); i++){
            System.out.println(roles.get(i));
            rez = true ;
        }
        System.out.println("_______________________");
        return rez ;
    }

    private static User getSysUser(){
        boolean tooOk ;
        Scanner scanner;
        User user = new User();

        System.out.println("введите id");
        scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            user.setId(scanner.nextInt());
            tooOk = true ;
        }
        else tooOk = false;

        System.out.println("введите имя");
        scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            user.setUserName(scanner.nextLine());
            tooOk = true ;
        }
        else tooOk = false;

        System.out.println("введите пароль");
        scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            user.setUserPasw(scanner.nextLine());
            tooOk = true ;
        }
        else tooOk = false;

        if (tooOk) return user;
        else{
            System.out.println("корявые данные");
            return null ;
        }
    }

    private static Role getSysRole(){
        boolean tooOk ;
        Scanner scanner;
        Role role = new Role();

        System.out.println("введите id");
        scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            role.setId(scanner.nextInt());
            tooOk = true ;
        }
        else tooOk = false;

        System.out.println("введите наименование");
        scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            role.setRoleName(scanner.nextLine());
            tooOk = true ;
        }
        else tooOk = false;

        System.out.println(role.toString());

        if (tooOk) return role;
        else{
            System.out.println("корявые данные");
            return null ;
        }
    }

    private static void Tests(RoleService inService){
        Scanner scanner;
        boolean toExit = false ;
        while(!toExit) {
            System.out.print("Выберите действие (изменить:1 просмотр:4 удалить:5 добавить:7 <назад:0>): ");
            scanner = new Scanner(System.in);
            if(scanner.hasNextByte()) {
                switch (scanner.nextByte()) {
                    case 1:
                        System.out.println("Редактирование роли");
                        if (printList(inService)) {
                            inService.updateRole(getSysRole());
                        } else System.out.println("В таблице нет записей");
                        break;
                    case 4:
                        System.out.println("Просмотр ролей");
                        printList(inService);
                        break;
                    case 5:
                        System.out.println("Удаление роли");
                        if (printList(inService)) {
                            System.out.print("введите id удаляемого: ");
                            scanner = new Scanner(System.in);
                            if (scanner.hasNextInt()) {
                                inService.removeRole(scanner.nextInt());
                                printList(inService);
                            } else System.out.println("нет записи с таким id");
                        }else System.out.println("В таблице нет записей");
                        break;
                    case 7:
                        System.out.println("Вввод новой роли");
                        System.out.print("Наименование: ");
                        scanner = new Scanner(System.in);
                        if (scanner.hasNextLine()) {
                            String roleName = scanner.nextLine();
                            inService.addRole(roleName);
                            printList(inService);
                        } else System.out.println("неверное имя");
                        break;
                    case 0:
                        toExit = true;
                        break;
                    default:
                        System.out.println("неверный выбор");
                }
            } else System.out.println("абырбалк");
        }
    }

    private static void Tests(UserService inService){
        Scanner scanner;
        boolean toExit = false ;
        while(!toExit) {
            System.out.print("Выберите действие (изменить:1 просмотр:4 удалить:5 добавить:7 <назад:0>): ");
            scanner = new Scanner(System.in);
            if(scanner.hasNextByte()) {
                switch (scanner.nextByte()) {
                    case 1:
                        System.out.println("Редактирование пользователя");
                        if (printList(inService)) {
                            inService.updateUser(getSysUser());
                        } else System.out.println("В таблице нет записей");
                        break;
                    case 4:
                        System.out.println("Просмотр пользователя");
                        printList(inService);
                        break;
                    case 5:
                        System.out.println("Удаление пользователя");
                        if (printList(inService)) {
                            System.out.print("введите id удаляемого: ");
                            scanner = new Scanner(System.in);
                            if (scanner.hasNextInt()) {
                                inService.removeUser(scanner.nextInt());
                                printList(inService);
                            } else System.out.println("нет записи с таким id");
                        }else System.out.println("В таблице нет записей");
                        break;
                    case 7:
                        System.out.println("Вввод нового пользователя");
                        System.out.print("Имя пользователя: ");
                        scanner = new Scanner(System.in);
                        if (scanner.hasNextLine()) {
                            String userName = scanner.nextLine();
                            System.out.print("Пароль: ");
                            scanner = new Scanner(System.in);
                            if (scanner.hasNextLine()) {
                                String userPasw = scanner.nextLine();
                                inService.addUser(userName, userPasw);
                                printList(inService);
                            } else System.out.println("неверный пароль");
                        } else System.out.println("неверное имя");
                        break;
                    case 0:
                        toExit = true;
                        break;
                    default:
                        System.out.println("неверный выбор");
                }
            } else System.out.println("абырбалк");
        }
    }


    public static void main(String[] args) {
        Boolean toExit = false;
        Scanner scanner;

        Session session = (new Configuration()).configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        while (!toExit) {
            System.out.print("Выберите таблицу (пользователи:1 роль:2 <выход:0>): ");
            scanner = new Scanner(System.in);
            switch (scanner.nextByte()) {
                case 1:
                    Tests(new UserService(session));
                    break;
                case 2:
                    Tests(new RoleService(session));
                    break;
                case 0:
                    toExit = true ;
                    break;
                default:
                    System.out.println("неверный выбор");
            }
        }

        transaction.commit();
        session.close();
    }
}

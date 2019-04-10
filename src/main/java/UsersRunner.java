
import Entity.User;

import org.hibernate.Session;

import java.util.List;


public class UsersRunner {


    public void addUser(Session sf, int id, String userName, String userPass) {
        User us = new User(id, userName, userPass);
        sf.save(us);
    }

    public void listUsers(Session sf) {
        List users = sf.createQuery("FROM User").list();
        System.out.println("-----------------------");
        System.out.println("| id| name | password |");
        System.out.println("-----------------------");
        for (int i = 0 ; i < users.size(); i++)
            System.out.println(users.get(i));
        System.out.println("-----------------------");
    }

    public  void updateUser(Session sf, int userId, String userName, String userPasw) {
        User user = (User) sf.get(User.class, userId);
        user.setUserName(userName);
        user.setUserPasw(userPasw);
        sf.update(user);
    }

    public  void removeUser(Session sf, int userId){
        User user = (User) sf.get(User.class, userId);
        sf.delete(user);
    }
}
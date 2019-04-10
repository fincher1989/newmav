
import Entity.User;

import org.hibernate.Session;

import java.util.List;


public class UserService {

    private Session session ;

    public UserService(Session session) {
        this.session = session;
    }

    public void addUser(int id, String userName, String userPass) {
        User us = new User(id, userName, userPass);
        session.save(us);
    }

    public List listUsers() {
        return session.createQuery("FROM User").list();
    }



    public  void updateUser(int userId, String userName, String userPasw) {
        User user = session.get(User.class, userId);
        user.setUserName(userName);
        user.setUserPasw(userPasw);
        session.update(user);
    }

    public  void removeUser(int userId){
        User user = session.get(User.class, userId);
        session.delete(user);
    }
}
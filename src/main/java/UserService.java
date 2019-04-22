
import Entity.User;

import org.hibernate.Session;

import java.util.List;


public class UserService {

    private Session session ;


    public UserService(Session session) {
        this.session = session;
    }


    public void addUser(String userName, String userPass) {
        User user = new User(userName, userPass);
        session.save(user);
    }

    public List listUsers() {
        return session.createQuery("FROM User").list();
    }

    public  void updateUser(long userId, String userName, String userPasw) {
        User user = session.get(User.class, userId);
        user.setUserName(userName);
        user.setUserPasw(userPasw);
        session.update(user);
    }

    public  void removeUser(long userId){
        User user = session.get(User.class, userId);
        session.delete(user);
    }



}
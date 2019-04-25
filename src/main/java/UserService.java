import Entity.User;
import Entity.Role;

import org.hibernate.Session;

import java.util.List;
import java.util.Set;



public class UserService {

    private Session session ;


    public UserService(Session session) {
        this.session = session;
    }

    public User getUser(int userId){
        return session.get(User.class, userId);
    }

    public void addUser(String userName, String userPass) {
        User user = new User(userName, userPass);
        session.save(user);
    }

    public void addUser(String userName, String userPass, Set<Role> roles) {
        User user = new User(userName, userPass, roles);
        session.save(user);
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

    public void updateUser(User user) {

        if (user != null) {
            User user1 = session.get(User.class, user.getId());
            user1.setUserName(user.getUserName());
            user1.setUserPasw(user.getUserPasw());
            session.update(user1);
        }
    }

    public  void removeUser(int userId){
        User user = session.get(User.class, userId);
        session.delete(user);
    }

    public void setRole(User user, Set<Role> roles){
        user.setRoles(roles);
        session.update(user);
    }
}

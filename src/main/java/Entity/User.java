package Entity;

import javax.persistence.*;

@Entity
@Table(name = "USERS", schema = "USERS_DB", catalog = "MYDB")
public class User {
    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Basic
    @Column(name = "USER_NAME", nullable = false, length = 255)
    private String userName;

    @Basic
    @Column(name = "USER_PASW", nullable = false, length = 255)
    private String userPasw;

    public User(){

    }

    public User(int id, String userName, String userPasw) {
        this.id = id ;
        this.userName = userName ;
        this.userPasw = userPasw ;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserPasw() {
        return userPasw;
    }
    public void setUserPasw(String userPasw) {
        this.userPasw = userPasw;
    }

    @Override
    public String toString() {
        return  "Users:" +
                "id: " + id +
                "user name: " + userName +
                "user password: " + userPasw ;
    }
}

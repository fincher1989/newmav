package Entity;


import javax.persistence.*;

// 3.2.3
@Entity
@Table(name = "USERS", schema = "USERS_DB", catalog = "MYDB")
public class User {

    @Id
    @GeneratedValue(generator = "USERS_DB.USER_ID")
    @org.hibernate.annotations.GenericGenerator(
            name = "USERS_DB.USER_ID",
            strategy = "sequence")
    @Column(name = "ID", nullable = false)
    private long id;
    public long getId() {
        return id;
    }

    @Basic
    @Column(name = "USER_NAME", nullable = false, length = 30)
    private String userName;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "USER_PASW", nullable = false, length = 30)
    private String userPasw;
    public String getUserPasw() {
        return userPasw;
    }
    public void setUserPasw(String userPasw) {
        this.userPasw = userPasw;
    }

    public User(){
    }
    public User(String userName, String userPasw) {
        this.userName = userName ;
        this.userPasw = userPasw ;
    }

    @Override
    public String toString() {
        return  "|  " + id + "| " +
                userName + "|  " +
                userPasw + "|" ;
    }
}

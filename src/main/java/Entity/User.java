package Entity;

import javax.persistence.*;
import java.util.Set;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@ToString(exclude = "roles")
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "USERS", schema = "USERS_DB", catalog = "MYDB")
public class User {

    @Id
    @GeneratedValue(generator = "USERS_DB.USER_ID")
    @org.hibernate.annotations.GenericGenerator(name = "USERS_DB.USER_ID", strategy = "sequence")
    @Column(name = "ID", nullable = false)
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "USER_NAME", nullable = false, length = 30)
    private String userName;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "USER_PASW", nullable = false, length = 30)
    private String userPasw;
    public String getUserPasw() {
        return userPasw;
    }
    public void setUserPasw(String userPasw) {
        this.userPasw = userPasw;
    }

    @ManyToMany
    @JoinTable(name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    )
    private Set<Role> roles;

    public User(String userName, String userPass) {
        this.userName = userName ;
        this.userPasw = userPass ;
    }
}

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
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
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
    public Set<Role> getRoles(){
        return roles;
    }
    public void setRoles (Set<Role> roles){
        this.roles = roles;
    }
    public void addRole (Role role){
        roles.add(role);
    }

    public User(){}

    public User(String userName, String userPass) {
        this.userName = userName ;
        this.userPasw = userPass ;
    }

    @Override
    public int hashCode() {
        int result = id ;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPasw != null ? userPasw.hashCode() : 0);
        return result ;
    }

    @Override
    public boolean equals (Object other){
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (!(other instanceof User)) return false;

        final User user = (User) other ;
        if (id != user.id) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (userPasw != null ? !userPasw.equals(user.userPasw) : user.userPasw != null) return false;

        return true;
    }

}

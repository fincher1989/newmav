package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
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

    @ManyToMany
    private List<Role> Roles;

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

    /*

    private Set<Role> roles = new HashSet();
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))


    public Set<Role> getRoles () {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    */

    public User(){
    }
    public User(String userName, String userPasw) {
        this.userName = userName ;
        this.userPasw = userPasw ;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + ((userName != null) ? userName.hashCode() : 0);
        result = 31 * result + ((userPasw != null) ? userPasw.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        User user = (User) o;
        if (id != user.id) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false ;
        if (userPasw != null ? !userPasw.equals(user.userPasw) : user.userPasw != null) return false ;
        return true ;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPasw='" + userPasw + '\'' +
                '}';
    }
}

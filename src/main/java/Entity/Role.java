package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ROLE", schema = "USERS_DB", catalog = "MYDB")
public class Role {

    @Id
    @GeneratedValue(generator = "USERS_DB.ROLE_ID")
    @org.hibernate.annotations.GenericGenerator(name = "USERS_DB.ROLE_ID", strategy = "sequence")
    @Column(name = "ID", nullable = false)
    private long id;
    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany
    private List<User> Users;

    @Basic
    @Column(name = "ROLE_NAME", nullable = false, length = 30)
    private String roleName;
    public String getroleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }







    private Set<User> users = new HashSet();
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Role(){
    }
    public Role(String roleName) {
        this.roleName = roleName ;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + ((roleName != null) ? roleName.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Role role = (Role) o;
        if (id != role.id) return false;
        if (roleName != null ? !roleName.equals(role.roleName) : role.roleName != null) return false ;
        return true ;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + roleName + '\'' +
                '}';
    }
}

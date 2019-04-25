package Entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;


@Data
@ToString(exclude = "users")
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "ROLE", schema = "USERS_DB", catalog = "MYDB")
public class Role {

    @Id
    @GeneratedValue(generator = "USERS_DB.ROLE_ID")
    @org.hibernate.annotations.GenericGenerator(name = "USERS_DB.ROLE_ID", strategy = "sequence")
    @Column(name = "ID", nullable = false)
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "ROLE_NAME", nullable = false, length = 30)
    private String roleName;
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> users;

    public Role (){}
    public Role(String roleName) {
        this.roleName = roleName ;
    }

    @Override
    public int hashCode() {
        int result = id ;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result ;
    }
    @Override
    public boolean equals (Object other){
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (!(other instanceof Role)) return false;

        final Role role = (Role) other ;
        if (id != role.id) return false;
        if (roleName != null ? !roleName.equals(role.roleName) : role.roleName != null) return false;

        return true;
    }
}

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
    private long id;
    public long getId() {
        return id;
    }
    public void setId(Long id) {
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

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<User> users;

    public Role (){}

    public Role(String roleName) {
        this.roleName = roleName ;
    }


}

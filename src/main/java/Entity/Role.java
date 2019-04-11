package Entity;

import javax.persistence.*;

// 3.2.3
@Entity
@Table(name = "ROLE", schema = "USERS_DB", catalog = "MYDB")
public class Role {

    @Id
    @GeneratedValue(generator = "USERS_DB.ROLE_ID")
    @org.hibernate.annotations.GenericGenerator(
            name = "USERS_DB.ROLE_ID",
            strategy = "sequence")
    @Column(name = "ID", nullable = false)
    private long id;
    public long getId() {
        return id;
    }

    @Basic
    @Column(name = "ROLE_NAME", nullable = false, length = 30)
    private String roleName;
    public String getroleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role(){
    }
    public Role(String roleName) {
        this.roleName = roleName ;
    }

    @Override
    public String toString() {
        return  "|  " + id + "| " +
                roleName + "|" ;
    }
}

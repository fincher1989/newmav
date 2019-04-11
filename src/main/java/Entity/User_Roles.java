package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User_Roles {

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


    public User_Roles(){
    }
    public User_Roles(String roleName) {
        this.rolName = roleName ;
    }

}

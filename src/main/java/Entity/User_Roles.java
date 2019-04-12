package Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User_Roles {

    @Id
    @GeneratedValue(generator = "USERS_DB.USER_ROLES_ID")
    @org.hibernate.annotations.GenericGenerator(
            name = "USERS_DB.USER_ROLES_ID",
            strategy = "sequence")
    @Column(name = "ID", nullable = false)
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }




}

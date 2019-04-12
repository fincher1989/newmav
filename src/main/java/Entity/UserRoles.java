package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.io.Serializable;

public class UserRoles {

    @Id
    @GeneratedValue(generator = "USERS_DB.USER_ROLES_ID")
    @org.hibernate.annotations.GenericGenerator(name = "USERS_DB.USER_ROLES_ID", strategy = "sequence")
    @Column(name = "ID", nullable = false)
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    private long userId ;
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "role_id", nullable = false)
    private long roleId ;
    public long getRoleId() {
        return roleId;
    }
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "user_id")
        protected long userId ;

        @Column(name = "role_id")
        protected long roleId ;

        public Id(){
        }
        public Id(long userId, long roleId){
            this.userId = userId ;
            this.roleId = roleId ;
        }

        public boolean equals(Object o) {
            if (o != null && o instanceof Id) {
                Id that = (Id) o;
                boolean b = userId.equals(that.userId) &&
                            roleId.equals(that.roleId);
                return b;
            }
            return false ;
        }

        public int hashCode() {
            return userId.hashCode() + roleId.hashCode();
        }

        @EmbeddedId
        protected Id id = new Id();

        @ManyToOne
        @JoinColumn(name = "user_id", insertable = false, updatable = false)
        protected User user ;

        @ManyToOne
        @JoinColumn(name = "role_id", insertable = false, updatable = false)
        protected Role role ;


     /*   public Id2(User user, Role role ) {
            this.user = user;
            this.role = role;

            this.id.userId = user.getId();
            this.id.roleId = role.getId();

*/


        }
    }


}

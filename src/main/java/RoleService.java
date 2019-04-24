
import Entity.Role;

import org.hibernate.Session;

import java.util.List;


public class RoleService {

    private Session session ;


    public RoleService(Session session) {
        this.session = session;
    }


    public void addRole(String roleName) {
        Role role = new Role(roleName);
        session.save(role);
    }

    public List listRoles() {
        return session.createQuery("FROM Role").list();
    }

    public  void updateRole(int roleId, String roleName) {
        Role role = session.get(Role.class, roleId);
        role.setRoleName(roleName);
        session.update(role);
    }

    public void updateRole(Role role) {
        if (role != null) {
            Role role1 = session.get(Role.class, role.getId());
            role1.setRoleName(role.getRoleName());
            session.update(role1);
        }
    }

    public  void removeRole(int roleId){
        Role role = session.get(Role.class, roleId);
        session.delete(role);
    }
}
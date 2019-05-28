package service;

import java.util.HashMap;
import java.util.Map;
import main.java.entity.Users;
import service.secure.SecurityConfig;

public class DataDao {
    private static final Map<String, Users> mapUsers = new HashMap<String, Users> ();

    static {
        initUsers();
    }

    private static void initUsers() {

        // This user has a role as EMPLOYEE.
        Users master = new Users("master", "master",SecurityConfig.ROLE_MASTER);

        // This user has 2 roles EMPLOYEE and MANAGER.
        Users admin = new Users("admin", "admin",SecurityConfig.ROLE_ADMIN, SecurityConfig.ROLE_MASTER);

        mapUsers.put(master.getLogin (), master);
        mapUsers.put(admin.getLogin (), admin);
    }

    // Find a User by userName and password.
    public static Users findUser(String login, String password) {
        Users u = mapUsers.get(login);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }
}

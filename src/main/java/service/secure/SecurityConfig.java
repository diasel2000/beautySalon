package service.secure;

import java.util.*;

public class SecurityConfig {
    public static final String ROLE_MASTER = "MASTER";
    public static final String ROLE_ADMIN = "ADMIN";
    private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>> ();
    static {
        init();
    }
    private static void init() {

        // Конфигурация для роли "EMPLOYEE".
        List<String> urlPatterns1 = new ArrayList<String>();

        urlPatterns1.add("/userInfoPage");
        urlPatterns1.add("/adminPage");

        mapConfig.put(ROLE_ADMIN, urlPatterns1);

        // Конфигурация для роли "MANAGER".
        List<String> urlPatterns2 = new ArrayList<String> ();

        urlPatterns2.add("/userInfoPage");
        urlPatterns2.add("/masterPage");

        mapConfig.put(ROLE_MASTER, urlPatterns2);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }
}

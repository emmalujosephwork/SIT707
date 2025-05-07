package web.service;

import java.util.HashMap;
import java.util.Map;

public class LoginService {

    private static Map<String, User> userDatabase = new HashMap<>();

    static {
        // Ensure the date format is 'yyyy-mm-dd'
        userDatabase.put("emmalu", new User("emmalu", "emma_pass", "1990-01-01"));
    }

    public static boolean login(String username, String password, String dob) {
        User user = userDatabase.get(username);
        if (user != null && user.getPassword().equals(password) && user.getDob().equals(dob)) {
            return true;
        }
        return false;
    }

    private static class User {
        private String username;
        private String password;
        private String dob;

        public User(String username, String password, String dob) {
            this.username = username;
            this.password = password;
            this.dob = dob;
        }
        

        public String getPassword() {
            return password;
        }

        public String getDob() {
            return dob;
        }
    }
}

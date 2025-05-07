package web.service;

import java.util.HashMap;
import java.util.Map;

public class RegistrationService {

    private static Map<String, User> userDatabase = new HashMap<>();

    public static boolean register(String fname, String lname, String email, String dob) {
        // Check if the email already exists
        if (userDatabase.containsKey(email)) {
            return false;  // Email already exists
        }
        
        // Add the user to the database
        userDatabase.put(email, new User(fname, lname, email, dob));
        return true;  // Successfully registered
    }

    private static class User {
        private String fname;
        private String lname;
        private String email;
        private String dob;

        public User(String fname, String lname, String email, String dob) {
            this.fname = fname;
            this.lname = lname;
            this.email = email;
            this.dob = dob;
        }
    }
}

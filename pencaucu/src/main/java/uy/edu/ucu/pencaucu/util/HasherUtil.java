package uy.edu.ucu.pencaucu.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HasherUtil {

    public static String encode(String password) {

        int strength = 11; // Work factor of bcrypt
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength);

        String encodedPassword = bCryptPasswordEncoder.encode(password);

        return encodedPassword;
    }
    
    public static boolean verify(String password, String encodedPassword) {
    	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    	
    	boolean isPasswordMatch = bCryptPasswordEncoder.matches(password, encodedPassword);
  
        return isPasswordMatch;
    }
}
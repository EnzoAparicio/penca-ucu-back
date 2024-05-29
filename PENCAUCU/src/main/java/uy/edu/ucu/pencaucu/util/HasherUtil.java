package uy.edu.ucu.pencaucu.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jakarta.xml.bind.DatatypeConverter;

public class HasherUtil {
	public static String getSHA256Hash(String input) {
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(input.getBytes());
	        byte[] digest = md.digest();
	        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
	        return myHash;
	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException(e);
	    }
    }
}

/**
 * 
 */
package model.dao.secure;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.*;
import java.util.Base64;

import model.User;


/**
 * @author dumber
 *
 */
public class PasswordHash {
	public static final String HASH_ALGORITHM = "SHA-256"; 
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private static final char[] PASSWORD_CHARS = new char[]{
        '!', '@', '#', '$', '%', '&', '*', '(', ')', 
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}; 
	String plaintext;
	MessageDigest msg_digest;
	private static String hashtext;
			
	public PasswordHash(String txt) throws NoSuchAlgorithmException {		
		plaintext = txt + "54lt";
		msg_digest = MessageDigest.getInstance(HASH_ALGORITHM);
		msg_digest.reset();
		msg_digest.update(plaintext.getBytes());
		byte[] digest = msg_digest.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		hashtext = bigInt.toString(16);
//		// Now we zero pad it to have the full 32 chars.
//		while(hashtext.length() < 32 ){
//		  hashtext = "0"+hashtext;
//		}		
	}
	
    public static byte[] createPasswordHash(final String salt) {
        byte[] result = null;
        String txt = null;
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            digest.update(salt.getBytes(DEFAULT_CHARSET));
            digest.update(hashtext.getBytes(DEFAULT_CHARSET));
            result = digest.digest();
            BigInteger bigInt = new BigInteger(1, result);
            txt = bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            // TODO Logging
        }
//        System.out.println(txt);
        return result;
    }

    public static boolean checkPassword(final User user) {
        boolean result = false;
        String storedPasswordHash = user.getPassword();
        String salt = user.getSalt();
        byte[] checkPasswordHashBytes = createPasswordHash(salt);
        BigInteger bigInt = new BigInteger(1, checkPasswordHashBytes);
        String checkPasswordHash = bigInt.toString(16);
//        String checkPasswordHash = Base64.getEncoder().encodeToString(checkPasswordHashBytes); // for simplicity let's say we use Base64
//        System.out.println(checkPasswordHash);
        
        if (checkPasswordHash != null && storedPasswordHash != null
                && checkPasswordHash.equals(storedPasswordHash)) {
            result = true;
        }

        return result;
    }

//	public String getPlaintext() {
//		return plaintext;
//	}
//
//	public void setPlaintext(String plaintext) {
//		this.plaintext = plaintext;
//	}

	public MessageDigest getMsgDigest() {
		return msg_digest;
	}

	public void setMsgDigest(MessageDigest m) {
		this.msg_digest = m;
	}
	
	public String getFirstHashed() {
		return hashtext;
	}
	
	public void debug() {
		System.out.println(this.hashtext);
	}

    public String getRandomString(final int length) {
        /*
         * Don't try to seed SecureRandom yourself unless you know 
         * what you are doing! 
         * @see Randomly failed! Weaknesses in Java Pseudo Random Number Generators (PRNGs).
         */ 
        SecureRandom secureRandom = new SecureRandom(); 
        StringBuilder sb = new StringBuilder(length);
        int position = 0;
        // create a random string of the requested length from a set of allowed chars
        for (int i = 0; i < length; i++ ) {
            position = secureRandom.nextInt(PASSWORD_CHARS.length);
            sb.append(PASSWORD_CHARS[position]);
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }	
}
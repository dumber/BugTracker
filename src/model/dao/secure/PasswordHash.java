/**
 * 
 */
package model.dao.secure;

import java.math.BigInteger;
import java.security.*;

/**
 * @author dumber
 *
 */
public class PasswordHash {
	String plaintext;
	MessageDigest msg_digest;
	String hashtext;
			
	public PasswordHash(String txt) throws NoSuchAlgorithmException {		
		plaintext = txt;
		msg_digest = MessageDigest.getInstance("MD5");
		msg_digest.reset();
		msg_digest.update(plaintext.getBytes());
		byte[] digest = msg_digest.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		hashtext = bigInt.toString(16);
		// Now we need to zero pad it if you actually want the full 32 chars.
		while(hashtext.length() < 32 ){
		  hashtext = "0"+hashtext;
		}		
	}

	public String getPlaintext() {
		return plaintext;
	}

	public void setPlaintext(String plaintext) {
		this.plaintext = plaintext;
	}

	public MessageDigest getMsgDigest() {
		return msg_digest;
	}

	public void setMsgDigest(MessageDigest m) {
		this.msg_digest = m;
	}	
	
	public void debug() {
		System.out.println(this.hashtext);
	}
}
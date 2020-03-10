package managers;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;

import test.Main;
import cipher.ISecurity;
import entities.UserVO;

public class SecurityManager {

	private static ISecurity security = Main.security;
	
	public static String encode(String text, String salt){
		return security.encode(text, salt);
	}
	
	public static  String createSalt(){
		SecureRandom random = new SecureRandom();
    	byte[] salt = new byte[security.getSaltSize()];
    	random.nextBytes(salt);
    	Encoder encodeBase64 = Base64.getEncoder();
        return new String(encodeBase64.encode(salt));
	}
	
	public static boolean authenticate(UserVO user){
		String  checkString=security.encode(user.getPassword(), user.getSalt());
		return checkString.equals(user.getCipherPassword());
	}
	
}

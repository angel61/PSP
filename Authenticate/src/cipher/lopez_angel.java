package cipher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class lopez_angel implements ISecurity {
	
	public int getSaltSize(){
		return 16;
	}

	public String encode(String  text, String salt){
		String retCode = text+salt;

		MessageDigest md=null;
		try {
			md=MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte bytes[]=retCode.getBytes();
		md.update(bytes);
		retCode=new String(md.digest());
		
		return retCode;
	}
	
}

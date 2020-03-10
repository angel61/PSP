package cipher;

public class MySecurity implements ISecurity {
	
	public int getSaltSize(){
		return 16;
	}

	public String encode(String  text, String salt){
		String retCode = text+salt;
		return retCode;
	}
	
	
	

}

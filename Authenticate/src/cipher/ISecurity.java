package cipher;


public interface ISecurity {

	
	public String encode(String  text, String salt);
	public int getSaltSize();
	
}

package entities;

import java.io.Serializable;

public class UserVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getCipherPassword() {
		return cipherPassword;
	}
	public void setCipherPassword(String cipherPassword) {
		this.cipherPassword = cipherPassword;
	}
	private String login;
	private String password;
	private String salt;
	private String cipherPassword;

	public String toString(){
		return "{\"login\": \""+login +"\", \"password\": \""+cipherPassword +"\", \"salt\": \""+salt+"\"}";
	}
}

package daos;

import entities.UserVO;
/** 
 * ·Este DAO puede guardar en BBDD 
 * (con un datasource, un, pool JDBC.. , usando un driver..., etc.)
 * o en archivos de textos o un webservice o por FTP...etc
 * ...
 * Da igual dónde.
 * SI CAMBIA EL MODELO NO IMPLICA QEU CAMBIE ESTA CLASE
 * SI CAMBIA el LUGAR o el MODO de almacenamiento SÍ
 *
 */
public class UserDAO extends FileBase{

	public UserVO putUser(UserVO user){
		
		Object obj=null;
		try{
			obj =this.writeObjectToFile(user,"user_"+user.getLogin());
		}catch (Exception fno){
			
		}
		user = (obj!=null)?(UserVO) obj:null;
		return user;
	}
	
	public UserVO getUser(UserVO user){
		Object obj=null;
		try{
			obj =this.readObjectFromFile("user_"+user.getLogin());
		}catch (Exception fno){
			
		}
		user = (obj!=null)?(UserVO) obj:null;
		return user;
	}
	
}

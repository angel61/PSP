package managers;

import daos.UserDAO;
import entities.UserVO;

public class UserManager {
	
	public UserVO createUser(UserVO user){
		
		user.setSalt(SecurityManager.createSalt());
		String cypherPass= SecurityManager.encode(user.getPassword(), user.getSalt());
		user.setCipherPassword(cypherPass);
		
		UserDAO userDao= new UserDAO();
		//guarda la entidad....
		user=userDao.putUser(user);
		//@todo: manda correo de bienvenida, o más cosos lo qeu se quiera al crear usuarios...
		return user;
	}
	
	
	
	public UserVO changePassword(UserVO user, String newPassword1){
		/* @todo obtener nueva contraseña cifrada */
		/* llamar al DAO para guardar los cambios de este usuario */
		return user;
	}
	
	public UserVO searchUser(UserVO user){
		UserDAO userDao= new UserDAO();
		user = userDao.getUser(user);
		return user;
	}
	
	public boolean authenticate(UserVO user){
		return SecurityManager.authenticate(user);
	}

}

package test;
import cipher.*;
import entities.UserVO;
import managers.*;


public class Main {
	//AQUI SE DEFINE EL ALGORITMO QUE VAMOS A USAR COMO SEGURIDAD
	public static final ISecurity security = new lopez_angel();

	public static void main(String[] args) {
		
		UserManager userManager = new UserManager();
		System.out.println("---------Creacion de usuarios---------");
		//creamos 2 usuarios
		UserVO user1 = new UserVO();
		user1.setLogin("user1");
		user1.setPassword("contraseña1");
		user1 = userManager.createUser(user1);
		
		System.out.println("user1:" +user1);
		
		UserVO user2 = new UserVO();
		user2.setLogin("user2");
		user2.setPassword("contraseña2");
		user2 = userManager.createUser(user2);
		
		System.out.println("user2:" +user2);
		System.out.println("--------------------------------------");
		
		System.out.println("\n---------Autenticacion-------------");
		
		pruebaLogin("user1","contraseña1");
		pruebaLogin("user2","contraseña1");
		pruebaLogin("user3","contraseña1");
		
		
		


	}

	public static void pruebaLogin(String login , String password){
		UserVO userLogando = new UserVO();
		UserManager userManager = new UserManager();
		
		userLogando.setLogin(login);
		userLogando= userManager.searchUser(userLogando);
		
		if(userLogando==null){
			System.out.println("No encontrado al usuario:"+login);
		}else{
			System.out.println("usuario:"+userLogando);
			userLogando.setPassword(password);
			System.out.println(login + ", " + password +" authenticate:" + userManager.authenticate(userLogando));
		}
	}
}

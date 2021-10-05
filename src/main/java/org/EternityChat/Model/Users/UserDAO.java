package org.EternityChat.Model.Users;

public class UserDAO extends User {
	
	public UserDAO(Integer id, String nickname) {
		//Genera un UserDAO
		super(id,nickname);
	}
	public UserDAO() {
		//Genera un UserDAO por defecto
		super();
	}
}

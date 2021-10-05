package org.EternityChat.Model.Users;

public class User {
	private Integer id;
	private String nickname;
	
	public User() {
		//Genera un User por defecto
		this(-1,"");
	}
	public User(Integer id, String nickname) {
		//Genera un User
		this.id=id;
		this.nickname=nickname;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}

package org.EternityChat.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nickname;
	
	public User() {
		// Genera un User por defecto
		this(-1, "");
	}
	public User(int id, String nickname) {
		// Genera un User
		this.id = id;
		this.nickname = nickname;
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

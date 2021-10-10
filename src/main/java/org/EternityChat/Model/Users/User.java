package org.EternityChat.Model.Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

import org.EternityChat.Model.Message;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nickname;
	private List<Message> ml = new ArrayList<>();
	public User() {
		// Genera un User por defecto
		this(-1, "");
	}

	public User(int id, String nickname) {
		// Genera un User
		this.id = id;
		this.nickname = nickname;
	}

	public User(int id, String nickname, List<Message> ml) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.ml = ml;
	}
	


	



	public void setId(int id) {
		this.id = id;
	}

	public List<Message> getMl() {
		return ml;
	}

	public void setMl(List<Message> ml) {
		this.ml = ml;
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

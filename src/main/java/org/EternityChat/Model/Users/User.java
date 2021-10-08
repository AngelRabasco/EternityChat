package org.EternityChat.Model.Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.EternityChat.Model.Message;

public class User implements Serializable{
	private Integer id;
	private String nickname;
	private List<Message> ml = new ArrayList<>();

	public User() {
		// Genera un User por defecto
		this(-1, "");
	}

	public User(Integer id, String nickname) {
		// Genera un User
		this.id = id;
		this.nickname = nickname;
	}

	public User(Integer id, String nickname, List<Message> ml) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.ml = ml;
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

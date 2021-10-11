package org.EternityChat.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Usuarios")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name = "id")
	private Integer id;
	private String nickname;
	
	public User() {
		// Genera un User por defecto
		this(-1, "");
	}
	public User(Integer id, String nickname) {
		// Genera un User
		this.id = id;
		this.nickname = nickname;
	}
	public User(String nickname) {
		// Genera un User solo con nickname
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + "]";
	}
	
}

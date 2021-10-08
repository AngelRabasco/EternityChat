package org.EternityChat.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.EternityChat.Model.Users.User;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ChatRooms")
public class ChatRooms implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name="id")
	private int id;
	private String name;

	private List<User> usr = new ArrayList<>();

	public ChatRooms() {

	}

	public ChatRooms(int id, String name) {
		super();
		this.id = id;
		this.name = name;

	}

	public ChatRooms(int id, String name, List<User> usr) {
		super();
		this.id = id;
		this.name = name;
		this.usr = usr;
	}

	public List<User> getUsr() {
		return usr;
	}

	public void setUsr(List<User> usr) {
		this.usr = usr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "ChatRooms [id=" + id + ", name=" + name + "]";
	}

}

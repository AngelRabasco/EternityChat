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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ChatRoom")
public class ChatRoom implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name="id")
	private int id;
	private String name;
	@XmlElement (name="mensaje")
	private List<Message> ml = new ArrayList<>();
	@XmlElement (name="ConnectedUsers")
	private List<User> ul = new ArrayList<>();
	public ChatRoom() {

	}

	public ChatRoom(int id, String name) {
		super();
		this.id = id;
		this.name = name;

	}


	
	public ChatRoom(int id, String name,List<Message> ml) {
		super();
		this.id = id;
		this.name = name;
		this.ml = ml;
	}
	
	
	
	public ChatRoom(int id, String name, List<Message> ml, List<User> ul) {
		super();
		this.id = id;
		this.name = name;
		this.ml = ml;
		this.ul = ul;
	}
	
	

	public List<User> getUl() {
		return ul;
	}

	public void setUl(List<User> ul) {
		this.ul = ul;
	}

	public List<Message> getMl() {
		return ml;
	}

	public void setMl(List<Message> ml) {
		this.ml = ml;
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
		return "ChatRoom [id=" + id + ", name=" + name + ", ml=" + ml + ", ul=" + ul + "]";
	}


	
}

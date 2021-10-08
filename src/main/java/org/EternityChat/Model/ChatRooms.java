package org.EternityChat.Model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ChatRooms")
public class ChatRooms implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private List<Message> ml = new ArrayList<>();
	
	
	
	public ChatRooms() {
		
	}
	
	
	public ChatRooms(int id, String name, List<Message> ml) {
		super();
		this.id = id;
		this.name = name;
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


	public List<Message> getMl() {
		return ml;
	}


	public void setMl(List<Message> ml) {
		this.ml = ml;
	}


	@Override
	public String toString() {
		return "ChatRooms [id=" + id + ", name=" + name + "]";
	}
	
	
}

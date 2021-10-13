package org.EternityChat.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ChatRoomsList")
public class ChatRoomsList implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@XmlElement(name="ChatRoom", type=ChatRoom.class)
	private List<ChatRoom> cr = new ArrayList<>();
	@XmlElement(name="AllUsers")
	private List<User> ul = new ArrayList<>();
	public ChatRoomsList(){}
	

	
	public ChatRoomsList(List<ChatRoom> cr, List<User> ul) {
		super();
		this.cr = cr;
		this.ul = ul;
	}



	public List<User> getUl() {
		return ul;
	}


	public void setUl(List<User> ul) {
		this.ul = ul;
	}


	public List<ChatRoom> getCrl() {
		return cr;
	}

	public void setCrl(List<ChatRoom> cr) {
		this.cr = cr;
	}
	
	public void addChatRooms(ChatRoom cr) {
		this.cr.add(cr);
	}
	
	public void deleteChatRooms(ChatRoom cr) {
		this.cr.remove(cr);
	}
	public void setChatRooms(ChatRoom cr,int i) {
		this.cr.set(i, cr);
	}

	@Override
	public String toString() {
		return "ChatRoomsList [cr=" + cr + "]";
	}
	
	public String getName(ChatRoom cr) {
		String name = cr.getName();
		return name;
		
	}
	
	
}
	

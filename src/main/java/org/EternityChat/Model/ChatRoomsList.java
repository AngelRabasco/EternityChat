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
	private List<ChatRoom> crl = new ArrayList<>();
	
	public ChatRoomsList(){}

	public List<ChatRoom> getCrl() {
		return crl;
	}

	public void setCrl(List<ChatRoom> crl) {
		this.crl = crl;
	}
	
	public void addChatRooms(ChatRoom cr) {
		this.crl.add(cr);
	}
	
	public void deleteChatRooms(ChatRoom cr) {
		this.crl.remove(cr);
	}
	public void setChatRooms(ChatRoom cr,int i) {
		this.crl.set(i, cr);
	}

	@Override
	public String toString() {
		return "ChatRoomsList [crl=" + crl + "]";
	}
	
	public String getName(ChatRoom cr) {
		String name = cr.getName();
		return name;
		
	}
	
	
}
	

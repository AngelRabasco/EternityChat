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
	@XmlElement(name="ChatRooms", type=ChatRooms.class)
	private List<ChatRooms> crl = new ArrayList<>();
	
	public ChatRoomsList(){}

	public List<ChatRooms> getCrl() {
		return crl;
	}

	public void setCrl(List<ChatRooms> crl) {
		this.crl = crl;
	}
	
	public void addChatRooms(ChatRooms cr) {
		this.crl.add(cr);
	}

	@Override
	public String toString() {
		return "ChatRoomsList [crl=" + crl + "]";
	}
	
	
}
	
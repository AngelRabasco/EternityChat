package org.EternityChat;


import java.io.File;

import org.EternityChat.Model.ChatRooms;
import org.EternityChat.Model.ChatRoomsList;
import org.EternityChat.Util.JAXBManager;

public class Ejecutable {
	public static void main(String[] args) {
		ChatRooms c1 = new ChatRooms(1,"furbo");
		ChatRoomsList crl=new ChatRoomsList();
		crl.addChatRooms(c1);
		System.out.println(crl.toString());
		try {
			JAXBManager.marshal(crl,new File("Ejemplo.xml"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

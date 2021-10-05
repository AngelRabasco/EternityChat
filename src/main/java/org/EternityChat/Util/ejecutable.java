package org.EternityChat.Util;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.EternityChat.Model.ChatRooms;

public class ejecutable {
	public static void main(String[] args) {
		
		ChatRooms r1=new ChatRooms(1,"furbo");
		
		try {
			JAXBManager.marshal(r1, new File("ejemplo.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

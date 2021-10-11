package org.EternityChat.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


import org.EternityChat.Model.ChatRoom;
import org.EternityChat.Model.ChatRoomsList;
import org.EternityChat.Model.Message;
import org.EternityChat.Model.User;

public class JAXBManager {

	/*
	 * public static void marshal(String url) throws JAXBException, IOException {
	 * ChatRooms r1=new ChatRooms(1,"furbo"); ChatRooms r2=new
	 * ChatRooms(1,"masfurbo");
	 * 
	 * JAXBContext context;
	 * 
	 * context = JAXBContext.newInstance(ChatRoomsList.class);
	 * System.out.println("fufo"); Marshaller m = context.createMarshaller();
	 * m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 * m.setProperty(Marshaller.JAXB_ENCODING, "utf-8"); m.marshal(r1, new
	 * File(url));
	 * 
	 * 
	 * }
	 */

	public static void saveFile(String url) {
		ChatRoomsList cl = new ChatRoomsList();

		List<Message> ml = new ArrayList<>();
		int hora, minutos;
		List<User> ul = new ArrayList<>();

		User u = new User(1, "pakonii");
		User u2 = new User(2, "Angel");

		Message m1 = new Message(1, "holu", u2);

		ml.add(m1);
		Message m2 = new Message(2, "uwu", u);
		ml.add(m2);
		ul.add(u);
		ul.add(u2);
		// solo para pruebas
		ChatRoom c1 = new ChatRoom(1, "furbo", ml, ul);
		cl.addChatRooms(c1);
		
		ChatRoom c2 = new ChatRoom(2,"chill",ml,ul);
		cl.addChatRooms(c2);
		System.out.println(cl);
		// marshaling
		JAXBContext jaxbContext;
		try {
			// jaxbContext = JAXBContext.newInstance(room.class);
			jaxbContext = JAXBContext.newInstance(ChatRoomsList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Marshal the list in console
			// jaxbMarshaller.marshal(_instance, System.out);

			// Marshal the employees list in file
			jaxbMarshaller.marshal(cl, new File(url));

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ChatRoomsList loadFile(String url) throws JAXBException, FileNotFoundException {
		JAXBContext jaxbContext;
		try {
			// jaxbContext = JAXBContext.newInstance(room.class);
			jaxbContext = JAXBContext.newInstance(ChatRoomsList.class);
			Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();

			ChatRoomsList cr = new ChatRoomsList();

			// Marshal the list in console
			// jaxbMarshaller.marshal(_instance, System.out);

			// Marshal the employees list in file
			
			cr = (ChatRoomsList) jaxUnmarshaller.unmarshal(new File(url));
			return cr;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
	   }
	



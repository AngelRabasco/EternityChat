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

/*List<User> ul = new ArrayList<User>();
		ChatRoom cr1 = new ChatRoom(1, "furbo");
		ChatRoom cr2 = new ChatRoom(2, "Chill");
		List<ChatRoom> cr = new ArrayList<ChatRoom>();
		cr.add(cr1);
		cr.add(cr2);
		User u1 = new User(1, "Pakonii");
		ul.add(u1);
		cr1.setUl(ul);
 * */
	
	public static void saveFile(String url) throws FileNotFoundException, JAXBException {
		ChatRoomsList crl = JAXBManager.loadFile("data.xml\\");
		ChatRoom cr = new ChatRoom(3,"Betis");
		crl.addChatRooms(cr);
		JAXBContext jaxbContext;
		try {
			// jaxbContext = JAXBContext.newInstance(room.class);
			jaxbContext = JAXBContext.newInstance(ChatRoomsList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Marshal the list in console
			// jaxbMarshaller.marshal(_instance, System.out);

			// Marshal the employees list in file
			jaxbMarshaller.marshal(crl, new File(url));

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

			ChatRoomsList crl = new ChatRoomsList();

			// Marshal the list in console
			// jaxbMarshaller.marshal(_instance, System.out);

			// Marshal the employees list in file

			crl = (ChatRoomsList) jaxUnmarshaller.unmarshal(new File(url));
			return crl;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

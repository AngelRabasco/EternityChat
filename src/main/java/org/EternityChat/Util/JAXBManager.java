package org.EternityChat.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.EternityChat.Model.ChatRoom;
import org.EternityChat.Model.ChatRoomsList;
import org.EternityChat.Model.User;

public class JAXBManager {

	public static void saveFile(String url, ChatRoomsList crl) throws FileNotFoundException, JAXBException {

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ChatRoomsList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(crl, new File(url));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void saveFile(String url) throws FileNotFoundException, JAXBException {

		JAXBContext jaxbContext;
		try {
			ChatRoomsList crl = new ChatRoomsList();
			List<User> ul = new ArrayList<User>();
			ChatRoom cr1 = new ChatRoom(1, "Futbol");
			ChatRoom cr2 = new ChatRoom(2, "Videojuegos");
			List<ChatRoom> cr = new ArrayList<ChatRoom>();
			crl.addChatRooms(cr1);
			crl.addChatRooms(cr2);
			cr1.setUl(ul);
			jaxbContext = JAXBContext.newInstance(ChatRoomsList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(crl, new File(url));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static ChatRoomsList loadFile(String url) throws JAXBException, FileNotFoundException {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ChatRoomsList.class);
			Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
			ChatRoomsList crl = new ChatRoomsList();
			crl = (ChatRoomsList) jaxUnmarshaller.unmarshal(new File(url));
			return crl;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}

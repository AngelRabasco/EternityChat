package org.EternityChat.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.EternityChat.Model.ChatRooms;
import org.EternityChat.Model.ChatRoomsList;

public class JAXBManager {
	public static void marshal(ChatRoomsList crl) throws JAXBException {
		marshal(crl, "ejemplo.xml");
	}

	public static void marshal(ChatRoomsList crl, String f) throws JAXBException {
		marshal(crl, new File(f));
	}

	public static void marshal(ChatRoomsList crl, File f) throws JAXBException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
			JAXBContext context = JAXBContext.newInstance(ChatRooms.class);
			System.out.println("fufo");
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
			m.marshal(crl, writer);
			// writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static ChatRooms unmarshal(File f) {
		return null;
	}

}

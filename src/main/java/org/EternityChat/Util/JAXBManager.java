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

public class JAXBManager {
	public static void marshal(ChatRooms r) throws JAXBException {
		marshal(r, "ejemplo.xml");
	}

	public static void marshal(ChatRooms r, String f) throws JAXBException {
		marshal(r, new File(f));
	}

	public static void marshal(ChatRooms r, File f) throws JAXBException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
			JAXBContext context = JAXBContext.newInstance(ChatRooms.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
			m.marshal(r, writer);
			// writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static ChatRooms unmarshal(File f) {
		return null;
	}

}

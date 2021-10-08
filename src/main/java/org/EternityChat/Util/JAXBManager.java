package org.EternityChat.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.EternityChat.Model.ChatRooms;
import org.EternityChat.Model.ChatRoomsList;
import org.EternityChat.Model.Message;

public class JAXBManager {
	

	/*public static void marshal(String url) throws JAXBException, IOException {
		ChatRooms r1=new ChatRooms(1,"furbo");
		ChatRooms r2=new ChatRooms(1,"masfurbo");
		
		JAXBContext context;
		
		context = JAXBContext.newInstance(ChatRoomsList.class);
		System.out.println("fufo");
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
		m.marshal(r1, new File(url));
		

	}*/
	
	public static void saveFile(String url) {
		List<Message> ml = new ArrayList<>();
		Message m1 = new Message(1, "holu");
		Message m2 = new Message(2, "uwu");
		ml.add(m1);
		ml.add(m2);
		//solo para pruebas
		ChatRooms c1 = new ChatRooms(1,"furbo",ml);
		ChatRooms c2 = new ChatRooms(2,"masfurbito",ml);
		
	
		
		System.out.println(c1);
		
		//marshaling
		JAXBContext jaxbContext;
		try {
			//jaxbContext = JAXBContext.newInstance(room.class);
			jaxbContext = JAXBContext.newInstance(ChatRooms.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			 
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		     
		    //Marshal the list in console
		    //jaxbMarshaller.marshal(_instance, System.out);
		     
		    //Marshal the employees list in file
		    jaxbMarshaller.marshal(c1, new File(url));
		    
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public static ChatRooms unmarshal(File f) {
		return null;
	}

}

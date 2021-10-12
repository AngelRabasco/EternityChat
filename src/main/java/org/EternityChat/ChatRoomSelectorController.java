package org.EternityChat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBException;

import org.EternityChat.Model.ChatRoom;
import org.EternityChat.Model.ChatRoomsList;
import org.EternityChat.Model.User;
import org.EternityChat.Util.JAXBManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ChatRoomSelectorController {
	
	private User user=new User();
	private String name="";
	private List<ChatRoom> cr = new ArrayList<>();
	private ChatRoomsList crl;
	@FXML
	private ListView<ChatRoom> chatList;
	
	@FXML
	public void initialize() {
	}
	
	@FXML
	public void loadUser(User user) {
		this.user=user;
	}
	
	@FXML
	public void loadChatRooms() throws FileNotFoundException, JAXBException {
	cr = JAXBManager.loadFile("data.xml").getCrl();
	name = cr.get(1).getName();
	for(int i = 0;i<cr.size();i++) {
		chatList.getItems().add(cr.get(i));
	}
	
	}
	
	@FXML
	public void loadMainMenu() throws JAXBException {
		try {
			List<User> ul = new ArrayList<>();
			FXMLLoader loader=new FXMLLoader(getClass().getResource("MainMenu.fxml"));
			Parent parent=loader.load();
			MainMenuController mainMenuController=loader.getController();
			mainMenuController.loadUser(user);
			ul.add(user);
			crl = (ChatRoomsList) JAXBManager.loadFile("data.xml\\");
			JAXBManager.saveFile("data.xml\\", cr.get(1), ul);
			System.out.println(crl);
			
			
			Stage stage=new Stage();
			stage.setScene(new Scene(parent));
			stage.setTitle(chatList.getSelectionModel().getSelectedItem().getName());
			stage.setResizable(false);
			Stage currentStage=(Stage) chatList.getScene().getWindow();
			currentStage.close();
			stage.setOnCloseRequest(e -> mainMenuController.shutdown());
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

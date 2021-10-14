package org.EternityChat;

import javafx.scene.control.TextField;

import org.EternityChat.Model.ChatRoomsList;
import org.EternityChat.Model.User;
import org.EternityChat.Util.JAXBManager;

import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class LoginController {
	@FXML
	private TextField userField;
	@FXML
	private Button loginButton;
	
	private ChatRoomsList crl;
	
	@FXML
	public void initialize() {
		try {
			this.crl = JAXBManager.loadFile("data.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void loadChatRoomList(ChatRoomsList crl) {
		this.crl=crl;
	}
	
	@FXML
	private void loadMainMenu() throws JAXBException {
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("ChatRoomSelector.fxml"));
			Parent parent=loader.load();
			ChatRoomSelectorController chatroomSelectorController=loader.getController();
			chatroomSelectorController.loadUser(new User(userField.getText()));
			chatroomSelectorController.loadChatRoomList(crl);
			chatroomSelectorController.loadChatRooms();
			User us = new User(null,userField.getText());
			//if(us.getNickname()!=crl.getUl().get()..getNickname())
			Stage stage=new Stage();
			stage.setScene(new Scene(parent));
			stage.setTitle("Seleccione un chat");
			stage.setResizable(false);
			Stage currentStage=(Stage) loginButton.getScene().getWindow();
			currentStage.close();
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

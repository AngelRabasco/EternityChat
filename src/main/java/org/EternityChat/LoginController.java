package org.EternityChat;

import javafx.scene.control.TextField;

import org.EternityChat.Model.ChatRoomsList;
import org.EternityChat.Model.User;
import org.EternityChat.Util.JAXBManager;

import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import java.security.cert.CRL;

import javax.xml.bind.JAXBException;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class LoginController {
	@FXML
	private TextField userField;
	@FXML
	private Button loginButton;
	
	@FXML
	public void initialize() { }
	
	@FXML
	private void loadMainMenu() throws JAXBException {
		try {
			ChatRoomsList crl = JAXBManager.loadFile("data.xml\\");
			
			FXMLLoader loader=new FXMLLoader(getClass().getResource("ChatRoomSelector.fxml"));
			Parent parent=loader.load();
			ChatRoomSelectorController chatroomSelectorController=loader.getController();
			chatroomSelectorController.loadUser(new User(userField.getText()));
			User us = new User(null,userField.getText());
			
			//if(us.getNickname()!=crl.getUl().get()..getNickname())
			chatroomSelectorController.loadChatRooms();
			
			
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

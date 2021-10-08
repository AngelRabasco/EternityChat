package org.EternityChat;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField userField;
	@FXML
	private Button loginButton;
	
	@FXML
	public void initialize() { }
	
	@FXML
	private void loadMainMenu() {
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("ChatRoomSelector.fxml"));
			Parent parent=loader.load();
			ChatRoomSelectorController chatroomSelectorController=loader.getController();
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

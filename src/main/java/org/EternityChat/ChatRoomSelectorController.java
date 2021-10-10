package org.EternityChat;

import java.io.IOException;

import org.EternityChat.Model.ChatRoom;
import org.EternityChat.Model.User;

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
	private ObservableList<ChatRoom> obsList=FXCollections.observableArrayList();
	private User user=new User();
	
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
	public void loadChatRooms() {
		obsList.add(new ChatRoom(0,"Dummy"));
		chatList.setItems(obsList);
	}
	
	@FXML
	public void loadMainMenu() {
		try {
			FXMLLoader loader=new FXMLLoader(getClass().getResource("MainMenu.fxml"));
			Parent parent=loader.load();
			MainMenuController mainMenuController=loader.getController();
			mainMenuController.loadUser(user);
			Stage stage=new Stage();
			stage.setScene(new Scene(parent));
			stage.setTitle(chatList.getSelectionModel().getSelectedItem().getName());
			stage.setResizable(false);
			Stage currentStage=(Stage) chatList.getScene().getWindow();
			currentStage.close();
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

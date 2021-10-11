package org.EternityChat;

import org.EternityChat.Model.Message;
import org.EternityChat.Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainMenuController {
	private User user=new User();
	
	@FXML
	private TableView<Message> chat;
	@FXML
	private TableColumn<Message, User> userColumn;
	@FXML
	private TableColumn<Message ,String> textColumn;
	@FXML
	private TextField chatField;
	
	public void initialize() {
		userColumn.setCellValueFactory(new PropertyValueFactory<Message, User>("ur"));
		textColumn.setCellValueFactory(new PropertyValueFactory<Message, String>("text"));
	}
	public void shutdown() {
		System.out.println("Se cierra");
	}
	
	@FXML
	public void pressEnter(KeyEvent keyEvent) {
		if(keyEvent.getCode().equals(KeyCode.ENTER)) {
			sendMessage(chatField.getText());
		}
	}
	public void sendMessage(String message) {
		chat.getItems().add(new Message(message, user));
	}
	
	public void loadUser(User user) {
		this.user=user;
	}
	public void loadChat() {
//		chat.setItems(obsList);
	}
}

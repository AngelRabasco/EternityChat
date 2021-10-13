package org.EternityChat;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

import javax.xml.bind.JAXBException;

import org.EternityChat.Model.ChatRoomsList;
import org.EternityChat.Model.Message;
import org.EternityChat.Model.User;
import org.EternityChat.Util.JAXBManager;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainMenuController {
	private User user = new User();

	@FXML
	private TableView<Message> chat;
	@FXML
	private TableColumn<Message, User> userColumn;
	@FXML
	private TableColumn<Message, String> textColumn;
	@FXML
	private TableColumn<Message, String> timeColumn;
	@FXML
	private TextField chatField;
	@FXML
	private ImageView sendButton;
	ChatRoomsList crl = new ChatRoomsList();

	public void initialize() {
		userColumn.setCellValueFactory(new PropertyValueFactory<Message, User>("ur"));
		textColumn.setCellValueFactory(new PropertyValueFactory<Message, String>("text"));
		timeColumn.setCellValueFactory(new PropertyValueFactory<Message, String>("hora"));
	}

	public void shutdown() throws FileNotFoundException, JAXBException {
		crl = JAXBManager.loadFile("data.xml");

		for (int i = 0; i < crl.getUl().size(); i++) {
			if (user.getNickname().equals(crl.getUl().get(i).getNickname())) {
				crl.getUl().remove(i);

			}
			
		for (int i = 0; i < crl.getcr().get(i)) {
			
		}

		}

		JAXBManager.saveFile("data.xml", crl);
		System.out.println("Se cierra");
	}

	@FXML
	public void pressEnter(KeyEvent keyEvent) {
		if (keyEvent.getCode().equals(KeyCode.ENTER)) {
			sendMessage(chatField.getText());
		}
	}

	@FXML
	public void pressSend() {
		sendMessage(chatField.getText());
	}

	public void sendMessage(String message) {
		if (!message.equals("")) {
			chat.getItems().add(new Message(message, user, LocalDateTime.now()));
			chatField.setText(null);
		}
	}

	public void loadUser(User user) {
		this.user = user;
	}

	public void loadChat() {
//		chat.setItems(obsList);
	}
}

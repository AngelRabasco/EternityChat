package org.EternityChat;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import javax.xml.bind.JAXBException;
import org.EternityChat.Model.ChatRoom;
import org.EternityChat.Model.ChatRoomsList;
import org.EternityChat.Model.Message;
import org.EternityChat.Model.User;
import org.EternityChat.Util.JAXBManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainMenuController {
	private User user;
	private ChatRoomsList crl;
	private ChatRoom currentChatRoom;

	@FXML
	private TableView<Message> chat;
	@FXML
	private TableColumn<Message, User> userColumn;
	@FXML
	private TableColumn<Message, String> textColumn;
	@FXML
	private TableColumn<Message, String> timeColumn;
	@FXML
	private ListView<User> userList;
	@FXML
	private TextField chatField;
	@FXML
	private ImageView sendButton;

	public void initialize() {
		userColumn.setCellValueFactory(new PropertyValueFactory<Message, User>("ur"));
		textColumn.setCellValueFactory(new PropertyValueFactory<Message, String>("text"));
		timeColumn.setCellValueFactory(new PropertyValueFactory<Message, String>("hora"));
	}

	// se ejecuta al cerrar el chat para eliminar al usuario de la lisa de usuarios
	// conectados
	public void shutdown() throws FileNotFoundException, JAXBException {
		crl = JAXBManager.loadFile("data.xml");
		for (int i = 0; i < crl.getUl().size(); i++) {
			if (user.getNickname().equals(crl.getUl().get(i).getNickname())) {
				crl.getUl().remove(i);
			}
		}
		for (int i = 0; i < crl.getcr().get(currentChatRoom.getId() - 1).getUl().size(); i++) {
			if (user.getNickname().equals(crl.getcr().get(currentChatRoom.getId() - 1).getUl().get(i).getNickname())) {
				crl.getcr().get(currentChatRoom.getId() - 1).getUl().remove(i);
			}
		}
		JAXBManager.saveFile("data.xml", crl);
	}

	// carga la ChatRoomList de la pantalla anterior al cargar esta
	public void loadChatRoomList(ChatRoomsList crl) {
		this.crl = crl;
	}

	// compruba la tecla pulsada al escribir y en caso de ser ENTER ejecuta la
	// función sendMessage()
	@FXML
	public void pressEnter(KeyEvent keyEvent) throws FileNotFoundException, JAXBException {
		if (keyEvent.getCode().equals(KeyCode.ENTER)) {
			sendMessage(chatField.getText());
		}
	}

	//se acciona al pulsar el botón de enviar
	@FXML
	public void pressSend() throws FileNotFoundException, JAXBException {
		sendMessage(chatField.getText());
	}

	public void sendMessage(String message) throws FileNotFoundException, JAXBException {
		if (!message.equals("")) {
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formattedDateTime = dateTime.format(formatter);
			Message ms = new Message(message, user, formattedDateTime);
			crl = JAXBManager.loadFile("data.xml");
			chat.getItems().clear();
			for (int i = 0; i < crl.getcr().get(currentChatRoom.getId() - 1).getMl().size(); i++) {
				chat.getItems().add(crl.getcr().get(currentChatRoom.getId() - 1).getMl().get(i));
			}
			chat.getItems().add(ms);
			crl.getcr().get(currentChatRoom.getId() - 1).getMl().add(ms);
			chatField.clear();
			JAXBManager.saveFile("data.xml", crl);
		}
	}

	public void loadUser(User user) {
		this.user = user;
	}

	public void loadChat(ChatRoom chatRoom) throws FileNotFoundException, JAXBException {
		this.currentChatRoom = chatRoom;
		for (int i = 0; i < crl.getcr().get(currentChatRoom.getId() - 1).getUl().size(); i++) {
			userList.getItems().add(crl.getcr().get(currentChatRoom.getId() - 1).getUl().get(i));
		}
		for (int i = 0; i < crl.getcr().get(currentChatRoom.getId() - 1).getMl().size(); i++) {
			chat.getItems().add(crl.getcr().get(currentChatRoom.getId() - 1).getMl().get(i));
		}
		JAXBManager.saveFile("data.xml");
		updateChat();
	}

	public void updateChat() {
		new Timer().schedule(new TimerTask() {
			public void run() {
				Platform.runLater(() -> {
					try {
						chat.getItems().clear();
						userList.getItems().clear();
						crl = JAXBManager.loadFile("data.xml");
						for (int i = 0; i < crl.getcr().get(currentChatRoom.getId() - 1).getUl().size(); i++) {
							userList.getItems().add(crl.getcr().get(currentChatRoom.getId() - 1).getUl().get(i));
						}
						for (int i = 0; i < crl.getcr().get(currentChatRoom.getId() - 1).getMl().size(); i++) {
							chat.getItems().add(crl.getcr().get(currentChatRoom.getId() - 1).getMl().get(i));
						}
					} catch (FileNotFoundException | JAXBException e) {
						e.printStackTrace();
					}
				});

			}
		}, 0, 5000);
	}
}

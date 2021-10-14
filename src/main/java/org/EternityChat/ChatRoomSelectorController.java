package org.EternityChat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.EternityChat.Model.ChatRoom;
import org.EternityChat.Model.ChatRoomsList;
import org.EternityChat.Model.User;
import org.EternityChat.Util.JAXBManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ChatRoomSelectorController {

	private List<ChatRoom> cr = new ArrayList<>();
	private ChatRoomsList crl;
	private User user;

	@FXML
	private ListView<ChatRoom> chatList;

	public void initialize() {
	}

	// carga la ChatRoomList de la pantalla anterior al cargar esta
	public void loadChatRoomList(ChatRoomsList crl) {
		this.crl = crl;
	}

	// carga el usuario con el que se ha accedido
	public void loadUser(User user) {
		this.user = user;
	}

	// carga las salas de la variable clr y las muestra en la lista
	public void loadChatRooms() throws FileNotFoundException, JAXBException {
		cr = crl.getcr();
		for (int i = 0; i < cr.size(); i++) {
			chatList.getItems().add(cr.get(i));
		}
	}

	// cambia de pantalla a MainMenu
	@FXML
	public void loadMainMenu() throws JAXBException {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
			Parent parent = loader.load();
			MainMenuController mainMenuController = loader.getController();
			mainMenuController.loadUser(user);
			mainMenuController.loadChatRoomList(crl);
			crl.getUl().add(user);
			crl.getcr().get(chatList.getSelectionModel().getSelectedIndex()).getUl().add(user);
			mainMenuController.loadChat(chatList.getSelectionModel().getSelectedItem());
			JAXBManager.saveFile("data.xml\\", crl);
			Stage stage = new Stage();
			stage.setScene(new Scene(parent));
			stage.setTitle(chatList.getSelectionModel().getSelectedItem().getName());
			stage.setResizable(false);
			Stage currentStage = (Stage) chatList.getScene().getWindow();
			currentStage.close();
			stage.setOnCloseRequest(e -> {
				try {
					mainMenuController.shutdown();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (JAXBException e1) {
					e1.printStackTrace();
				}
			});
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

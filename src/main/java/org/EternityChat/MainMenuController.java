package org.EternityChat;

import org.EternityChat.Model.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController {
	private User user=new User();
	
	@FXML
	public void initialize() { }
	
	@FXML
	public void loadUser(User user) {
		this.user=user;
	}
}
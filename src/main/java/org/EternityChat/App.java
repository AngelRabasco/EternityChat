package org.EternityChat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.bind.JAXBException;

import org.EternityChat.Util.JAXBManager;

/**
 * JavaFX App
 */
public class App extends Application {
	private static Scene scene;

	@Override
	public void start(Stage stage) throws IOException, JAXBException {
		scene = new Scene(loadFXML("Login"));
		stage.setScene(scene);
		stage.setTitle("Eternity Chat LogIn");
		stage.setResizable(false);
		stage.show();
	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		if(!new File("data.xml").exists()) {
			JAXBManager.saveFile("data.xml\\");
		}
		launch();
	}
}

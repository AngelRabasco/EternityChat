package org.EternityChat.Util;

import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.bind.JAXBException;

import org.EternityChat.Model.ChatRoomsList;

import javafx.application.Platform;



	public class Recargar extends Thread {

		@Override
		public void run() {
			refresqueshion();
		}
		public static void refresqueshion() {
		Timer t = new Timer();
	    t.schedule(new TimerTask() {
	        public void run() {
	            Platform.runLater(() -> {
	                try {
						 JAXBManager.loadFile("data.xml");
					} catch (FileNotFoundException | JAXBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            });
	        }
	    }, 0, 6000);
		}
	}
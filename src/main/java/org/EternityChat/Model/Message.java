package org.EternityChat.Model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

public class Message implements Serializable {
	
	private int id;
	private String text;
	
	public Message(int id, String text) {
		super();
		
		this.id = id;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + "]";
	}

}

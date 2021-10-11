package org.EternityChat.Model;

import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="usuario")
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String text;
	private User ur = new User();
	private Calendar calendario = Calendar.getInstance();
	String hora, minutos, segundos;

	public Message(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public Message(int id, String text, User ur) {
		super();
		this.id = id;
		this.text = text;
		this.ur = ur;
		this.hora = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY) + ":" + calendario.get(Calendar.MINUTE));

	}

	public String getHora() {
		return String.valueOf(hora);
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public User getU() {
		return ur;
	}

	public void setU(User ur) {
		this.ur = ur;
	}

	public Message() {
		super();
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

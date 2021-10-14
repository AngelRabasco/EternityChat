package org.EternityChat.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Mensajes")
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name = "id")
	private int id;
	private String text;
	@XmlElement (name = "Usuario")
	private User ur = new User();
	private String hora;
	
	public Message() {
		this(-1,"",new User(),"");
	}
	public Message(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	public Message(int id, String text, User ur, String hora) {
		super();
		this.id = id;
		this.text = text;
		this.ur = ur;
		this.hora = hora;
	}
	public Message(String text, User user, String hora) {
		this.text=text;
		this.ur=user;
		this.hora=hora;
	}

	public String getHora() {
		return this.hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

	public User getUr() {
		return ur;
	}
	public void setUr(User ur) {
		this.ur = ur;
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

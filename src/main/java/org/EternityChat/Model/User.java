package org.EternityChat.Model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Usuarios")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name = "id")
	private Integer id;
	@XmlElement(name = "nickname")
	private String nickname;

	public User() {
		this(-1, "");
	}

	public User(Integer id, String nickname) {
		this.id = id;
		this.nickname = nickname;
	}

	public User(String nickname) {
		this.nickname = nickname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return nickname;
	}
}

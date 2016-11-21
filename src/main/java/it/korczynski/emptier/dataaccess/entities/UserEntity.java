package it.korczynski.emptier.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import it.korczynski.emptier.dataaccess.enums.Level;


/**
 * User entity.
 * 
 */
@Entity
public class UserEntity {
	
	@Id @GeneratedValue
	private long id;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String password;
	private String name;
	private String surname;
	private String email;
	@Lob
	private String aboutMe;
	@Lob
	private String lifeMotto;
	@Enumerated(EnumType.ORDINAL)
	private Level level;
	private int points;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAboutMe() {
		return aboutMe;
	}
	
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	
	public String getLifeMotto() {
		return lifeMotto;
	}
	
	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}


}

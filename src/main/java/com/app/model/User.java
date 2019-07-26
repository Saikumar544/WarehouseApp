package com.app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="user_tab")
public class User {
	@Id
	@GeneratedValue
	@Column(name="I_D")
private Integer id;
private String userName;
private String userEmail;
private String userPassword;
@ElementCollection(fetch=FetchType.EAGER)
@JoinColumn(name="roles_tab")
private Set<String> roles;
public User() {
	super();
}
public User(Integer id) {
	super();
	this.id = id;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
public Set<String> getRoles() {
	return roles;
}
public void setRoles(Set<String> roles) {
	this.roles = roles;
}
@Override
public String toString() {
	return "User [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword=" + userPassword
			+ ", roles=" + roles + "]";
}

}

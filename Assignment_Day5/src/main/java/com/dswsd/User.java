package com.dswsd;

import java.sql.Date;

public class User {
private String name;
private String password;
private String email;
private Date dob;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String name, String email, String password , Date dob) {
	super();
	this.name = name;
	this.password = password;
	this.email = email;
	this.dob = dob;
}
@Override
public String toString() {
	return "User [name=" + name + ", password=" + password + ", email=" + email + ", dob=" + dob + "]";
}


}


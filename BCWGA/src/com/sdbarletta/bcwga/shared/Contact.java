package com.sdbarletta.bcwga.shared;

import java.io.Serializable;

public class Contact implements Serializable {
	private static final long serialVersionUID = 1283522058892610773L;
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String msg;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String toString() {
		return "Name: "+firstName+" "+lastName+"\nEmail: "+email+"\nPhone: "+(phone == null? "":phone)+"\nMessage: "+msg;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
}

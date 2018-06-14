package com.asha.shopping.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component   //will create instance of User class --- user
@Table       //This User class will map to User Table
@Entity  
public class User {
	
	//@GeneratedValue(generator="system-uuid")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@GenericGenerator(name="emailId", strategy = "emailId")
	
	@Id
	@GeneratedValue
	private String emailId;
	private String name;
	private String password;
	private String mobile;
	private String address;
	private char role;
	private Date added_date;//diff between sql date-show only date where util date show date and time both

	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public char getRole() {
		return role;
	}
	public void setRole(char role) {
		this.role = role;
	}
	public Date getAdded_date() {
		return added_date;
	}
	public void setAdded_date(Date added_date) {
		this.added_date = added_date;
	}
	
}

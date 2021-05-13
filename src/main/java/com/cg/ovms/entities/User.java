package com.cg.ovms.entities;
//
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	@Id
	@Column(name="USER_ID")
	private String userId;
	@Column(name="PWD")
	private String password;
	@Column(name="RLE")
	private String role;
	public User() {
		
	}
	public User(String userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}
	public User(String userId, String password) {
		// TODO Auto-generated constructor stub
		this.userId=userId;
		this.password=password;
	}
	public User(String userId) {
		this.userId=userId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
	
}
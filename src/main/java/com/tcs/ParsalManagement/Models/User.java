package com.tcs.ParsalManagement.Models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class User 
{
	@Id
	@Column(name = "userId")
	private String userId;
	@Column(name = "password")
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "address")
	private String address;
	@Column(name = "role")
	private String role;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public User(String userId, String password, String name, String email, String mobile, String address, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.role = role;
	}
	public User() {
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + ", mobile="
				+ mobile + ", address=" + address + ", role=" + role + "]";
	}
	
	

	
}
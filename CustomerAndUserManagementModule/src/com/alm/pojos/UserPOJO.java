package com.alm.pojos;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserPOJO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uid")
	private int uid;

	private String password;

	private String email;

	private String gender;

	private String username;

	private String role;

	private int gid;

	public UserPOJO() {
	}

	public int getUid() {
		return this.uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/*
	 * public Grouppojo getGrouppojo() { return this.grouppojo; }
	 * 
	 * public void setGrouppojo(Grouppojo grouppojo) { this.grouppojo =
	 * grouppojo; }
	 */
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Userpojo [uid=" + uid + ", password=" + password + ", email="
				+ email + ", gender=" + gender + ", username=" + username
				+ ", role=" + role + ", gid=" + gid + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

}
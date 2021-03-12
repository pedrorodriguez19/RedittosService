package com.redittos.socialmedia.model;

import java.util.List;

public class User {
	private Long id;
	private String name;
	private String password;
	private String email;
	private List<Topic> followed;

	public User() {
	}

	public User(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Topic> getFollowed() {
		return followed;
	}

	public void setFollowed(List<Topic> followed) {
		this.followed = followed;
	}

}

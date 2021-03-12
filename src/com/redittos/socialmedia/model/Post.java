package com.redittos.socialmedia.model;

import java.util.Date;

public class Post {
	private Long id;
	private Long userId;
	private Long topicId;
	private String postTitle;
	private String postTxt;
	private Date published;
	private Long language;
	private char state;

	public Post() {
	}

	public Post(Long userId, Long topicId, String postTitle, String postTxt, Date published, Long language) {
		this.userId = userId;
		this.topicId = topicId;
		this.postTitle = postTitle;
		this.postTxt = postTxt;
		this.published = published;
		this.language = language;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostTxt() {
		return postTxt;
	}

	public void setPostTxt(String postTxt) {
		this.postTxt = postTxt;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public char getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}

	public Long getLanguage() {
		return language;
	}

	public void setLanguage(Long language) {
		this.language = language;
	}
}

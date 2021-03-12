package com.redittos.socialmedia.model;

import java.util.Date;

public class Comment {
	private Long id;
	private Long userId;
	private Long postId;
	private String comTxt;
	private Date published;

	public Comment() {
	}

	public Comment(Long userId, Long postId, String comTxt, Date published) {
		this.userId = userId;
		this.postId = postId;
		this.comTxt = comTxt;
		this.published = published;
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

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getTxt() {
		return comTxt;
	}

	public void setTxt(String comTxt) {
		this.comTxt = comTxt;
	}

	public String getComTxt() {
		return comTxt;
	}

	public void setComTxt(String comTxt) {
		this.comTxt = comTxt;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

}

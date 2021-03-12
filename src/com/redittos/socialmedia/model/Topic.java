package com.redittos.socialmedia.model;

import java.util.List;

public class Topic {
	private Long id;
	private String name;
	private Long creatorId;
	private List<Long> moderators;
	private List<Long> Banned;

	public Topic() {
	}

	public Topic(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public List<Long> getModerators() {
		return moderators;
	}

	public void setModerators(List<Long> moderators) {
		this.moderators = moderators;
	}

	public List<Long> getBanned() {
		return Banned;
	}

	public void setBanned(List<Long> banned) {
		Banned = banned;
	}
}

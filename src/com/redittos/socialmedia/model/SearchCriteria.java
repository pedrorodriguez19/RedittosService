package com.redittos.socialmedia.model;

import java.util.Date;

public class SearchCriteria {
	private String keyWord;
	private String name;
	private Date dateFrom;
	private Date dateTo;
	private Topic topic;
	private Long language;

	public SearchCriteria() {

	}

	public SearchCriteria(String keyWord, String name, Date dateFrom, Date dateTo, Topic topic, Long language) {
		this.keyWord = keyWord;
		this.name = name;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.topic = topic;
		this.language = language;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDate(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Long getLanguage() {
		return language;
	}

	public void setLanguage(Long language) {
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
}

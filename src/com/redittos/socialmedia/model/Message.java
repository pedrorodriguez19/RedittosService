package com.redittos.socialmedia.model;

import java.util.Date;

public class Message {
	private Long msgId;
	private Long issuerId;
	private Long receiverId;
	private String msgTitle;
	private String msgTxt;
	private Date sendDate;

	public Message() {
	}

	public Message(Long issuerId, Long receiverId, String msgTitle, String msgTxt, Date sendDate) {
		this.issuerId = issuerId;
		this.receiverId = receiverId;
		this.msgTitle = msgTitle;
		this.msgTxt = msgTxt;
		this.sendDate = sendDate;
	}

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public long getIssuerId() {
		return issuerId;
	}

	public void setIssuerId(Long issuerId) {
		this.issuerId = issuerId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getMsgTxt() {
		return msgTxt;
	}

	public void setMsgTxt(String msgTxt) {
		this.msgTxt = msgTxt;
	}

	public Date getPublished() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

}

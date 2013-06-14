package com.nandika.hang_out.domain;

import java.util.Date;

public class HangOutDTO {
	
private long id;
	
	private String name;
	
	private Long hangOutTime;
	
	private Long createdTime;
	
	private int status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getHangOutTime() {
		return hangOutTime;
	}

	public void setHangOutTime(Long hangOutTime) {
		this.hangOutTime = hangOutTime;
	}

	public Long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Long createdTime) {
		this.createdTime = createdTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	

}

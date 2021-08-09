package com.project.spring.dto;

import com.sun.jmx.snmp.Timestamp;

public class Board {
	private int bno; 
	private String writer; 
	private String title;
	private String content;
	private Timestamp write_date; 
	private int hit;
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "Board [bno=" + bno + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", write_date=" + write_date + ", hit=" + hit + "]";
	}

	
	
}

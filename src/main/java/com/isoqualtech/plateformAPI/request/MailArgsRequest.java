package com.isoqualtech.plateformAPI.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class MailArgsRequest {
	@NotBlank
	private String to = "";
	private String subject;
	private String text;
	private List<String> filenames = new ArrayList<String>() ;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<String> getFilenames() {
		return filenames;
	}
	public void setFilenames(List<String> filenames) {
		this.filenames = filenames;
	}	
}

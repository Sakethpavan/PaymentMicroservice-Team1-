package com.example.forex_component.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConversionsPK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="currency_from")
	private String from;
	@Column(name="currentcy_to")
	private String to;
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public ConversionsPK(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}
	public ConversionsPK() {}
}

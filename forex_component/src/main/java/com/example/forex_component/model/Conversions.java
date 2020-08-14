package com.example.forex_component.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbl_conversions")
public class Conversions {


	@EmbeddedId
	ConversionsPK conversionPK;
	@Column(name="factor")
	private Double factor;
	
	public Conversions(ConversionsPK conversionPK, Double factor) {
		
		this.conversionPK = conversionPK;
		this.factor = factor;
	}
	public Conversions() {}
	public ConversionsPK getConversionPK() {
		return conversionPK;
	}
	public void setConversionPK(ConversionsPK conversionPK) {
		this.conversionPK = conversionPK;
	}
	public Double getFactor() {
		return factor;
	}
	public void setFactor(Double factor) {
		this.factor = factor;
	}

	
}

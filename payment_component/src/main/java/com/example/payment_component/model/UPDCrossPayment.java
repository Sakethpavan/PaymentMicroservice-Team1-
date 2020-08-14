package com.example.payment_component.model;

public class UPDCrossPayment {
	 public Integer customerId;
	    public String sourceAccNumber;
	    public String targetAccNumber;
	    public Double amount;
	    public String baseCurrency;
	    public String targetCurrency;
	    public String timestamp;
	    public Long transactionReferenceNumber;
	    public String paymentStatus;
	    public Double rates;

	    public UPDCrossPayment() {
	    }

	    public UPDCrossPayment(Integer customerId, String sourceAccNumber, String targetAccNumber, Double amount, String baseCurrency, String targetCurrency, String timestamp, Long transactionReferenceNumber, String paymentStatus, Double rates) {
	        this.customerId = customerId;
	        this.sourceAccNumber = sourceAccNumber;
	        this.targetAccNumber = targetAccNumber;
	        this.amount = amount;
	        this.baseCurrency = baseCurrency;
	        this.targetCurrency = targetCurrency;
	        this.timestamp = timestamp;
	        this.transactionReferenceNumber = transactionReferenceNumber;
	        this.paymentStatus = paymentStatus;
	        this.rates=rates;
	    }

	    public Integer getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(Integer customerId) {
	        this.customerId = customerId;
	    }

	    public String getSourceAccNumber() {
	        return sourceAccNumber;
	    }

	    public void setSourceAccNumber(String sourceAccNumber) {
	        this.sourceAccNumber = sourceAccNumber;
	    }

	    public String getTargetAccNumber() {
	        return targetAccNumber;
	    }

	    public void setTargetAccNumber(String targetAccNumber) {
	        this.targetAccNumber = targetAccNumber;
	    }

	    public Double getAmount() {
	        return amount;
	    }

	    public void setAmount(Double amount) {
	        this.amount = amount;
	    }

	    public String getBaseCurrency() {
	        return baseCurrency;
	    }

	    public void setBaseCurrency(String baseCurrency) {
	        this.baseCurrency = baseCurrency;
	    }

	    public String getTargetCurrency() {
	        return targetCurrency;
	    }

	    public void setTargetCurrency(String targetCurrency) {
	        this.targetCurrency = targetCurrency;
	    }

	    public String getTimestamp() {
	        return timestamp;
	    }

	    public void setTimestamp(String timestamp) {
	        this.timestamp = timestamp;
	    }

	    public Long getTransactionReferenceNumber() {
	        return transactionReferenceNumber;
	    }

	    public void setTransactionReferenceNumber(Long transactionReferenceNumber) {
	        this.transactionReferenceNumber = transactionReferenceNumber;
	    }

	    public String getPaymentStatus() {
	        return paymentStatus;
	    }

	    public void setPaymentStatus(String paymentStatus) {
	        this.paymentStatus = paymentStatus;
	    }

	    public Double getRates() {
	        return rates;
	    }

	    public void setRates(Double rates) {
	        this.rates = rates;
	    }
}

package com.example.corebanking_component.model;

public class LocalPaymentResponse {
	
    public Integer customerId;
    public String paymentStatus;
    public Long transactionReferenceNumber;
    public String timestamp;

    public LocalPaymentResponse(Integer customerId, String paymentStatus, Long transactionReferenceNumber, String timestamp) {
        this.customerId = customerId;
        this.paymentStatus = paymentStatus;
        this.transactionReferenceNumber = transactionReferenceNumber;
        this.timestamp = timestamp;
    }
}

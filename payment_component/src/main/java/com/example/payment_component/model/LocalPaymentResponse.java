package com.example.payment_component.model;

public class LocalPaymentResponse {
    public Integer customerId;
    public String paymentStatus;
    public Long transactionReferenceNumber;
    public String timestamp;

    public LocalPaymentResponse(){

    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getTransactionReferenceNumber() {
        return transactionReferenceNumber;
    }

    public void setTransactionReferenceNumber(Long transactionReferenceNumber) {
        this.transactionReferenceNumber = transactionReferenceNumber;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public LocalPaymentResponse(Integer customerId, String paymentStatus, Long transactionReferenceNumber, String timestamp) {
        this.customerId = customerId;
        this.paymentStatus = paymentStatus;
        this.transactionReferenceNumber = transactionReferenceNumber;
        this.timestamp = timestamp;
    }
}

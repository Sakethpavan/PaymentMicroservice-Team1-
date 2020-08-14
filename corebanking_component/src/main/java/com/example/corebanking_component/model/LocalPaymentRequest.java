package com.example.corebanking_component.model;


public class LocalPaymentRequest {
    public Integer customerId;
    public String sourceAccNumber;
    public String targetAccNumber;
    public Double amount;
    public String baseCurrency;
    public String timestamp;
    public Long transactionReferenceNumber;
    public String paymentStatus;
}

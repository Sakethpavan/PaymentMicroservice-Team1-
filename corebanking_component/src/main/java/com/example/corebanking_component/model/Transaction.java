package com.example.corebanking_component.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long transactionId;
    private Integer customerId;
    private String paymentStatus;
    private String fromAccNumber;
    private String toAccNumber;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
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

    public String getFromAccNumber() {
        return fromAccNumber;
    }

    public void setFromAccNumber(String fromAccNumber) {
        this.fromAccNumber = fromAccNumber;
    }

    public String getToAccNumber() {
        return toAccNumber;
    }

    public void setToAccNumber(String toAccNumber) {
        this.toAccNumber = toAccNumber;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", customerId=" + customerId +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", fromAccNumber='" + fromAccNumber + '\'' +
                ", toAccNumber='" + toAccNumber + '\'' +
//                ", date=" + date +
                '}';
    }

    public Transaction(){

    }
    public Transaction(Long transactionId, Integer customerId, String paymentStatus, String fromAccNumber, String toAccNumber, Date date) {
        this.transactionId = transactionId;
        this.customerId=customerId;
        this.paymentStatus = paymentStatus;
        this.fromAccNumber = fromAccNumber;
        this.toAccNumber = toAccNumber;
//        this.date = date;
    }
}

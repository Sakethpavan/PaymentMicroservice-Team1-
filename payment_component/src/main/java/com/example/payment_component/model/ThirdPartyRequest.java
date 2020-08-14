package com.example.payment_component.model;

public class ThirdPartyRequest {

    private String debitcard_no;
    private String creditcard_no;
    private Double amount;
    private String upiid;
    private String type;
    private String targetCurrency;
    private String requestedBy;


    public ThirdPartyRequest(String debitcard_no, String creditcard_no, Double amount, String upiid, String type, String targetCurrency, String requestedBy) {
        this.debitcard_no = debitcard_no;
        this.creditcard_no = creditcard_no;
        this.amount = amount;
        this.upiid = upiid;
        this.type = type;
        this.targetCurrency = targetCurrency;
        this.requestedBy = requestedBy;
    }

    public ThirdPartyRequest() {


    }

    public String getDebitcard_no() {
        return debitcard_no;
    }

    public void setDebitcard_no(String debitcard_no) {
        this.debitcard_no = debitcard_no;
    }

    public String getCreditcard_no() {
        return creditcard_no;
    }

    public void setCreditcard_no(String creditcard_no) {
        this.creditcard_no = creditcard_no;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUpiid() {
        return upiid;
    }

    public void setUpiid(String upiid) {
        this.upiid = upiid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    @Override
    public String toString() {
        return "ThirdPartyRequest{" +
                "debitcard_no='" + debitcard_no + '\'' +
                ", creditcard_no='" + creditcard_no + '\'' +
                ", amount=" + amount +
                ", upiid='" + upiid + '\'' +
                ", type='" + type + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", requestedBy='" + requestedBy + '\'' +
                '}';
    }
}

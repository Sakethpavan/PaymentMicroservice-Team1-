package com.example.payment_component.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_customer")
public class Customer {


    @Id
    private int custId;

    private String account;
    private String creditcardNo;
    private String debitcardNo;
    private String upi;

    public Customer() {
    }

    public Customer(int custId, String account, String debitcardNo, String creditcardNo, String upi) {
        this.custId = custId;
        this.account = account;
        this.debitcardNo = debitcardNo;
        this.creditcardNo = creditcardNo;
        this.upi = upi;
    }

    public int getcustId() {
        return custId;
    }

    public void setcustId(int custId) {
        this.custId = custId;
    }

    public String getaccount() {
        return account;
    }

    public void setaccount(String account) {
        this.account = account;
    }

    public String getdebitcardNo() {
        return debitcardNo;
    }

    public void setdebitcardNo(String debitcardNo) {
        this.debitcardNo = debitcardNo;
    }

    public String getcreditcardNo() {
        return creditcardNo;
    }

    public void setcreditcardNo(String creditcardNo) {
        this.creditcardNo = creditcardNo;
    }

    public String getupi() {
        return upi;
    }

    public void setupi(String upi) {
        this.upi = upi;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "custId=" + custId +
                ", account='" + account + '\'' +
                ", debitcardNo='" + debitcardNo + '\'' +
                ", creditcardNo='" + creditcardNo + '\'' +
                ", upi='" + upi + '\'' +
                '}';
    }
}

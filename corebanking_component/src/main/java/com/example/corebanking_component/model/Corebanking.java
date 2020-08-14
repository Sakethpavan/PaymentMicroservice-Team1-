package com.example.corebanking_component.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_userdetails")
public class Corebanking {
    @Id
    private int id;

    private String acno;
    private Double balance;
    private Double creditBalance;

    @Override
    public String toString() {
        return "Corebanking{" +
                "id=" + id +
                ", acno='" + acno + '\'' +
                ", balance=" + balance +
                ", creditBalance=" + creditBalance +
                '}';
    }

    public Corebanking(){
 
    }

    public Corebanking(int id, String acno, Double balance, Double creditBalance) {
        this.id = id;
        this.acno = acno;
        this.balance = balance;
        this.creditBalance = creditBalance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcno() {
        return acno;
    }

    public void setAcno(String acno) {
        this.acno = acno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(Double creditBalance) {
        this.creditBalance = creditBalance;
    }
}

package com.example.payment_component.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payment_component.model.Customer;

@Repository
public interface PaymentRepo extends JpaRepository<Customer,Integer> {

    Customer findBycustId(int custId);
    Customer findByDebitcardNo(String debitcardNo);
    Customer findByCreditcardNo(String creditcardNo);
    Customer findByUpi(String upi);

}

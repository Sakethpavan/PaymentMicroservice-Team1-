package com.example.corebanking_component.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.corebanking_component.model.Transaction;


@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {

}

package com.example.corebanking_component.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.corebanking_component.model.Corebanking;



@Repository
public interface BankRepo extends JpaRepository<Corebanking,Integer>  {

    Corebanking findByAcno(String accNo);

}

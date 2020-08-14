package com.example.forex_component.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionsRepository extends JpaRepository<Conversions,ConversionsPK> {
	Conversions findByConversionPK(ConversionsPK c);
}

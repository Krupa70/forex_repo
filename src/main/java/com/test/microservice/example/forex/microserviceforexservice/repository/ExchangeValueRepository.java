package com.test.microservice.example.forex.microserviceforexservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.microservice.example.forex.microserviceforexservice.entity.ExchangeValue;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{

	  ExchangeValue findByFromAndTo(String from, String to);

}

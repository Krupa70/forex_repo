package com.test.microservice.example.forex.microserviceforexservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.microservice.example.forex.microserviceforexservice.entity.ExchangeValue;
import com.test.microservice.example.forex.microserviceforexservice.repository.ExchangeValueRepository;

@RestController
public class ForexController {

	@Autowired
	Environment env;

	@Autowired
	ExchangeValueRepository exchangeRepo;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue
	(@PathVariable String from, @PathVariable String to) throws Exception {

		ExchangeValue exchangeValue = exchangeRepo.findByFromAndTo(from, to);

		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));

		return exchangeValue;

	}

}

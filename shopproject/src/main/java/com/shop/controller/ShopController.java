package com.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.ShopDto;
import com.shop.repository.api.ShopRepository;


@RestController
@SpringBootApplication
@EnableCaching
@ComponentScan("com.shop.*")
public class ShopController {

	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Autowired
	private ShopRepository shopRepository;
	
	@RequestMapping(value = "/shop/details", consumes = "application/json", method = RequestMethod.PUT)
	public ShopDto saveShopDetails(@RequestBody ShopDto shopDto){
		logger.info("Shop name :"+ shopDto.getName());
		return shopRepository.addShops(shopDto);
	}
	
	public static void main(String[] args){
		SpringApplication.run(ShopController.class, args);
	}
}

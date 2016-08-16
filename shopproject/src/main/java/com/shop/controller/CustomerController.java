package com.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.shop.dto.ShopDto;
import com.shop.repository.api.ShopRepository;
import com.shop.response.Response;
import com.shop.response.Result;


@RestController
@SpringBootApplication
@EnableCaching
@ComponentScan("com.shop.*")
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private ShopRepository shopRepository;
	
	@RequestMapping(value = "/customer/{customerLatitude}/{customerLongitude}/", produces = "application/json", method = RequestMethod.GET)
	public ShopDto getShopDetails(@PathVariable("customerLatitude") double latitude,@PathVariable("customerLongitude") double longitude){
		logger.info("latitude :"+ latitude, "longitude :"+longitude);
		ShopDto dto = shopRepository.getShopDetails(latitude,longitude);
		return dto;
	}
	
	//public static void main(String[] args){
		//SpringApplication.run(CustomerController.class, args);
	//}
}

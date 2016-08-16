package com.shop.repository.api.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.shop.controller.ShopController;
import com.shop.dto.ShopDto;
import com.shop.repository.api.ShopRepository;
import com.shop.response.Response;
import com.shop.response.Result;

@Component
public class ShopRepositoryImpl implements ShopRepository {

	private static final Logger logger = LoggerFactory.getLogger(ShopRepositoryImpl.class);
	
	private static Map<String, ShopDto> shopMap = new ConcurrentHashMap<String, ShopDto>();
	
	public ShopDto addShops(ShopDto shopDto) {
		logger.info("Entering addshops");
		//String result = "";
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://maps.googleapis.com/maps/api/geocode/json";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
		        .queryParam("address", shopDto.toString())
		        .queryParam("components","country:IN");
		     
		HttpEntity<Response> entity = new HttpEntity<Response>(headers);

		HttpEntity<Response> response = restTemplate.exchange(
		        builder.build().encode().toUri(), 
		        HttpMethod.GET, 
		        entity, 
		        Response.class);
		
		if (response != null && response.hasBody()){
			Response responseBody = response.getBody();
			if (responseBody.getStatus().equals("OK")){
				//result = "Shop addded Successfully";
				for ( Result result : responseBody.getResults()){
					logger.info("Latitude:"+result.getGeometry().getLocation().getLat());
					logger.info("Latitude:"+result.getGeometry().getLocation().getLng());
					shopDto.setLatitude(result.getGeometry().getLocation().getLat());
					shopDto.setLongitude(result.getGeometry().getLocation().getLng());
				}
				
				shopMap.putIfAbsent(shopDto.getLatitude()+"#"+shopDto.getLongitude(), shopDto);
				
			}
		}
		return shopDto;

	}

	public ShopDto getShopDetails(Double latitude, Double longitude) {
		logger.info("Entering getlist");
		ShopDto dto = new ShopDto();
		for (Map.Entry<String, ShopDto> entry : shopMap.entrySet()) {
			System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
			if (entry.getKey().equals(latitude+"#"+longitude)){
				dto = entry.getValue();
				break;
			}
		}
	    return dto;	     
	}
}

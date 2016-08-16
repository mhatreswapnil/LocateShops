package com.shop.repository.api;

import com.shop.dto.ShopDto;

public interface ShopRepository {
	
	ShopDto addShops(ShopDto shopDto);
	
	ShopDto getShopDetails(Double latitude, Double longitude);
	

}

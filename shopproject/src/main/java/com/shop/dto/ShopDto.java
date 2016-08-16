package com.shop.dto;

import java.util.List;

public class ShopDto {

	private String name;
	private Double longitude;
	private Double latitude;
	private List<ShopAddressDto> addressDto;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public List<ShopAddressDto> getAddressDto() {
		return addressDto;
	}
	public void setAddressDto(List<ShopAddressDto> addressDto) {
		this.addressDto = addressDto;
	}
	@Override
	public String toString() {
		return name + ", " + addressDto;
	}
	
	
	
}

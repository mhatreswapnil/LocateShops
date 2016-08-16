package com.shop.response;

import java.util.List;

public class Result {
	private List<AddressComponent> address_components;
	private String formatted_address;
	private Geometry geometry;
	private String place_id;
	private List<String> types;
	private Boolean partial_match;


	public List<AddressComponent> getAddressComponents() {
		return this.address_components;
	}

	public void setAddressComponents(
		List<AddressComponent> address_components) {
		this.address_components = address_components;
	}

	
	public String getFormattedAddress() {
		return this.formatted_address;
	}

	public void setFormattedAddress(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	
	public Geometry getGeometry() {
		return this.geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	
	public String getPlaceId() {
		return this.place_id;
	}

	public void setPlaceId(String place_id) {
		this.place_id = place_id;
	}

	
	public List<String> getTypes() {
		return this.types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	
	public Boolean getPartialMatch() {
		return this.partial_match;
	}

	public void setPartialMatch(Boolean partial_match) {
		this.partial_match = partial_match;
	}
}

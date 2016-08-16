package com.shop.dto;

public class ShopAddressDto {

		private String number;
		private String postcode;
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getPostcode() {
			return postcode;
		}
		public void setPostcode(String postcode) {
			this.postcode = postcode;
		}
		@Override
		public String toString() {
			return number + ", "+postcode;
		}
		
}

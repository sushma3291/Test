package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
	public class Country {

		private String name;
		private String capital;
		private String alpha2Code;
		private String alpha3Code;
		
		
		
		public String getAlpha2Code() {
			return alpha2Code;
		}
		public void setAlpha2Code(String alpha2Code) {
			this.alpha2Code = alpha2Code;
		}
		public String getAlpha3Code() {
			return alpha3Code;
		}
		public void setAlpha3Code(String alpha3Code) {
			this.alpha3Code = alpha3Code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCapital() {
			return capital;
		}
		public void setCapital(String capital) {
			this.capital = capital;
		}
	}

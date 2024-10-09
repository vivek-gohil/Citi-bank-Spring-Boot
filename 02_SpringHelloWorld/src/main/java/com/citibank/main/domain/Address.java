package com.citibank.main.domain;

import org.springframework.stereotype.Component;

@Component
public class Address {
	private int houseNumber;
	private String buildingNmae;
	private String street;
	private String city;
	private int pin;

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getBuildingNmae() {
		return buildingNmae;
	}

	public void setBuildingNmae(String buildingNmae) {
		this.buildingNmae = buildingNmae;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", buildingNmae=" + buildingNmae + ", street=" + street
				+ ", city=" + city + ", pin=" + pin + "]";
	}

}

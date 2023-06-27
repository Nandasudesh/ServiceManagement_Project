package com.qa.utilities;

import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class FakerUtility {

	Faker faker = new Faker();

	public static String clientName() {
		Faker faker = new Faker();
		String clientname = faker.name().username();
		return clientname;

	}

	public static String location() {
		Faker fake = new Faker();
		String latitude = fake.address().latitude();
		return latitude;

	}

	public static String postalCode() {
		Faker fake = new Faker();
		String postalcode = fake.address().countryCode();
		return postalcode;
	}

	public static String address() {
		Faker fake = new Faker();
		String addresss = fake.address().fullAddress();
		return addresss;

	}

	public static String companyname() {
		Faker fake = new Faker();
		String companyName = fake.company().name();
		return companyName;

	}

	public static String ssN() {
		Faker fake = new Faker();
		String ssn = fake.idNumber().ssnValid();
		return ssn;
	}
	
	

	public static String city() {
		Faker fake = new Faker();
		String cityName = fake.address().city();
		return cityName;

	}

	public static String telephone() {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());																												
		String mobile = fakeValuesService.bothify("##########");
		return mobile;

	}

	public static String email() {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
		String email = fakeValuesService.bothify("????##@gmail.com");
		return email;

	}

	public static void dateFuture() {
		Faker faker = new Faker();
		Date dateFuture = faker.date().future(5, TimeUnit.DAYS);
	}

	public static void datePast() {
		Faker faker = new Faker();
		Date datePast = faker.date().past(20, TimeUnit.DAYS);
	}

}

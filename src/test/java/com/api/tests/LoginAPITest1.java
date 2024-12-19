package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class LoginAPITest1 {

	@Test
	void loginTest() {
		RestAssured.baseURI="http://64.227.160.186:8080/";
		
		Response response= given()
			.header("Content-Type","application/json")
			.body("{ \"username\": \"RanjaniManuel\", \"password\": \"RanjuRanju123!\"}")
			.post("/api/auth/login");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
}

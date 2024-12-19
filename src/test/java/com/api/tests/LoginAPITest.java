package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthServices;
import com.api.models.request.LoginRequest;
import com.api.models.responds.LoginResponse;

import io.restassured.response.Response;

public class LoginAPITest{

	@Test
	void loginTest() {
		LoginRequest loginRequest=new LoginRequest("RanjaniManuel", "RanjuRanju123!");
		AuthServices authServices=new AuthServices();



		Response response= authServices.login(loginRequest);
		LoginResponse loginresponse= response.as(LoginResponse.class);
		
		System.out.println(loginresponse.getToken());
		System.out.println(loginresponse.getEmail());

		
		
	}
	
}

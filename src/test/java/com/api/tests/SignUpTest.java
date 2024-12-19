package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthServices;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class SignUpTest {
	@Test
	public void createAccount() {
	//	SignUpRequest sign=new SignUpRequest("fdf", "dfsd", "dsfddf", "dfsf", "dfs", "sdfdf");
		
	SignUpRequest signUpRequest=	new SignUpRequest.SignupBuilder()
										 .username("SohithSelva14")
										 .password("Sohith123!11")
										 .email("sohith14@gmail.com")
										 .firstName("Sohith")
										 .lastName("Sleva")
										 .mobileNumber("4235118123")
										 .build();
	
	//SignUpRequest signUpRequest2=new SignUpRequest("SohithSelva", "Sohith123!", "sohith1@gmail.com", "Sohith", "Sleva", "4235118123");
		
		AuthServices authServices=new AuthServices();
		Response response = authServices.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		Assert.assertEquals(response.getStatusCode(), 200,"Status code is not 200");
		Assert.assertTrue(response.time()<2000," Time is not less than 700");
		
	}

}

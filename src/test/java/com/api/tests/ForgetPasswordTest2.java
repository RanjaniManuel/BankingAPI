package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthServices;
import com.api.models.request.LoginRequest;
import com.api.models.responds.LoginResponse;

import io.restassured.response.Response;

public class ForgetPasswordTest2 {

	//@Test
	public void forgetpassword() {
		
		
		AuthServices authServices=new AuthServices();
		Response response =authServices.login(new LoginRequest("RanjaniManuel", "RanjuRanju123!"));
		LoginResponse loginresponse = response.as(LoginResponse.class);
		System.out.println(loginresponse.getToken());
				
	response = authServices.forgetPassword("rl@gamil.com",loginresponse.getToken());
		Assert.assertEquals(response.jsonPath().getString("message"), "If your email exists in our system, you will receive reset instructions.");
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.asPrettyString());
		
	}
}

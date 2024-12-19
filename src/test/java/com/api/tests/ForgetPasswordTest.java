package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthServices;
import com.api.models.request.ForgetPasswordRequest;
import com.api.models.responds.ForgetPasswordResponse;

import io.restassured.response.Response;

public class ForgetPasswordTest {
	@Test
	void forgetPassword() {
		ForgetPasswordRequest forgetPasswordRequest=new ForgetPasswordRequest("r@gamil.com");
		AuthServices authServices=new AuthServices();
		Response response = authServices.forgetPassword(forgetPasswordRequest);
		
		ForgetPasswordResponse forgetpasswordResponse = response.as(ForgetPasswordResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(forgetpasswordResponse.getMessage());
		Assert.assertEquals(response.jsonPath().getString("message"), "If your email exists in our system, you will receive reset instructions.");
		
	}
}

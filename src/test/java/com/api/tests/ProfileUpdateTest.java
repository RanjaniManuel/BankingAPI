package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthServices;
import com.api.base.UserManagementServiecs;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileUpdateRequest;
import com.api.models.responds.LoginResponse;

import io.restassured.response.Response;

public class ProfileUpdateTest {
	@Test
	public void profileUdate() {
		
		AuthServices authServices=new AuthServices();
		Response response = authServices.login(new LoginRequest("RanjaniManuel", "RanjuRanju123!"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		System.out.println("__________________________________________");
		
		
		ProfileUpdateRequest profileUpdateRequest=new ProfileUpdateRequest("Sebasti", "manuel", "ranjanimanuel@gamil.com", "7896541526");
		
		
		UserManagementServiecs userManagementServiecs=new UserManagementServiecs();
		response=userManagementServiecs.updateProfile(loginResponse.getToken(), profileUpdateRequest);
		System.out.println(response.asPrettyString());
		
		
	}

}

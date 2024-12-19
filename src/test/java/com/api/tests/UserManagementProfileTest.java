package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthServices;
import com.api.base.UserManagementServiecs;
import com.api.models.request.LoginRequest;
import com.api.models.responds.LoginResponse;
import com.api.models.responds.UserProfileResponse;

import io.restassured.response.Response;

public class UserManagementProfileTest {

	@Test
	public void getProfileTest() {
		AuthServices auth = new AuthServices();
		Response response = auth.login(new LoginRequest("RanjaniManuel", "RanjuRanju123!"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		//System.out.println(loginResponse.getToken());
		
		
		UserManagementServiecs userManagementServiecs=new UserManagementServiecs();
		response= userManagementServiecs.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		
			UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
			Assert.assertEquals(userProfileResponse.getUsername(), "RanjaniManuel","Usernae is not matching................. ");
		
		

	}
}

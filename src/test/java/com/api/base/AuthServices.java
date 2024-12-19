package com.api.base;

import java.util.HashMap;

import com.api.models.request.ForgetPasswordRequest;
import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthServices extends BaseService {
	private static final String BASE_PATH="/api/auth/";
	
	public Response login(LoginRequest payLoad) {
		return postRequest(payLoad, BASE_PATH+"login");
		
	}
	public Response forgetPassword(String email,String token) {
		HashMap<String, String> payload=new HashMap<String, String>();
		payload.put("email", email);
		setAuthToken(token);
		return postRequest(payload, BASE_PATH+"forgot-password");
	}
	public Response signUp(SignUpRequest sighupRequest) {
		return postRequest(sighupRequest, BASE_PATH+"signup");
	}
	
	public Response forgetPassword(ForgetPasswordRequest forgetPasswordRequest) {
		return postRequest(forgetPasswordRequest, BASE_PATH+"forgot-password");
	}
}

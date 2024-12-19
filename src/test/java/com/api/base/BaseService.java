package com.api.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	private static final String BASE_URI = "http://64.227.160.186:8080/";
	protected RequestSpecification requestSpecification;

	public BaseService() {

		this.requestSpecification = RestAssured.given().baseUri(BASE_URI);
	}

	public void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
	}

	public Response postRequest(Object payLoad, String endPoint) {

		Response response = requestSpecification.contentType(ContentType.JSON).body(payLoad).post(endPoint);
		return response;

	}
	public Response putRequest(Object payLoad, String endPoint) {
			 Response response = requestSpecification.contentType(ContentType.JSON)
												.body(payLoad)
												.put(endPoint);
		     return response;

	}

	public Response getRequest(String endPoint) {
		return requestSpecification.get(endPoint);

	}

}

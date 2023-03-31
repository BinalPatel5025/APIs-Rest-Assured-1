package com.qa.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getPractice {

	@Test(priority = 1)
	public void getcall() {
	
		RestAssured.baseURI = "https://reqres.in/";
		
		Response res = RestAssured.get("api/users/2");
		
		System.out.println(res.getStatusCode());
		System.out.println(".........................................");
		System.out.println(res.getBody().asString());
		System.out.println(".........................................");
		System.out.println(res.prettyPrint());
		System.out.println(".........................................");
		System.out.println(res.getTime());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	@Test(priority = 2)
	public void ListGetCall() {
		RestAssured.baseURI = "https://reqres.in/";
		//RestAssured.basePath = "api/users?page=2";
		
		Response res = RestAssured.get("api/users?page=2");
		res.prettyPrint();
	}
	
	
	
	
	
	
}

package com.qa.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;

import io.restassured.response.Response;

public class getPracticeBehaviour {

	
	@Test(priority = 1)
	public void getcall() {
		
		RestAssured.baseURI = "https://reqres.in/";
		Response res =  given()
		.when()
			.get("api/users/2")
		.then()
			.statusCode(200)
			.time(lessThan(2000L))//2000millisecondss
			.assertThat().body("data.first_name", equalTo("Janet"))
			.body("data.id",equalTo(2))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all().extract().response();

		}
	
	@Test(priority = 2)
	public void getListcall() {
		
		RestAssured.baseURI = "https://reqres.in/";
		given()
		.when()
			.get("api/users?page=2")
		.then()
			.statusCode(200)
			.time(lessThan(2000L))//2000millisecondss
			.assertThat().body("data[1].first_name", equalTo("Lindsay"))
			.body("data[1].id",equalTo(8))
			.header("Content-Type","application/json; charset=utf-8")
			.body("data.first_name", hasItems("Michael","Lindsay"));
			

		}
}

package com.qa.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class Get {
  @Test
  public void getP() {
	  
	  RestAssured.baseURI = "https://reqres.in/";
	  Response res =  given()
			 .when()
			 	.get("api/users/2")
			 .then()
			 	.statusCode(200)
			 	.time(lessThan(2000L))
			 	.assertThat().body("data.id",equalTo(2))
			 	.log().all().extract().response();
			 		
			 	
			 
			 	
			 	
			 	
			 	
			 
  }
}

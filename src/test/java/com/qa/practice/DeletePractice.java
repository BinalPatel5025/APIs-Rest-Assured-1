package com.qa.practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

public class DeletePractice {
	Response res;
	@Test
	public void deleteCall() {
		
		RestAssured.baseURI = "https://reqres.in";
		Response res =  given()
		.when()
			.delete("api/users/2")
		.then()
			.statusCode(204)
			.time(lessThan(2000L))
			.log().all().extract().response();
		System.out.println("......" + res.asString());
		}
	
//	ValidatableResponse validatableResponse;
//	 
//    @Test
//    public void deleteUser() {
// 
//         
//    validatableResponse = given()
//                                .baseUri("https://reqres.in")
//                                .contentType(ContentType.JSON)
//                         .when()
//                                .get("api/users/2")
//                         .then()
//                                .assertThat().statusCode(200);
//                                //.body("message", equalTo("Successfully! Record has been deleted"));
// 
//        System.out.println("Response :" + validatableResponse.extract().asPrettyString());
// 
//    }
 
}



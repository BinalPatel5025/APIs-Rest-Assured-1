package com.qa.practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class updatePractice {
	@Test
	public void putCallJObject() {
		JSONObject req = new JSONObject();
		req.put("name","Bins");
		req.put("job","cashier");
		System.out.println(req);
		baseURI = "https://reqres.in"; 
		
		given()
			.header("content-type","appliaction/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(req.toJSONString())
		.when()
			.put("/api/users/2")
		.then()
			.statusCode(200)
			.time(lessThan(2000L))
			.log().all();
	}
}
	

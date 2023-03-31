package com.qa.practice;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Postp {
	
	//@Test
	public void postTest() {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("name","bbb");
		map.put("job","QA");
		
		RestAssured.baseURI = "https://reqres.in/";
		
		given()
			.header("content-type","appliaction/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(map)
		.when()
			.post("/api/users")
		.then()
			.statusCode(201)
			.time(lessThan(2000L))
			.assertThat()
			.body("name",equalTo("bbb"))
			.log().all();
}
	
	@Test(dataProvider = "xpdataprovider")
	public void jsondataTest(String name , String Job) {
		JSONObject js = new JSONObject();
		js.put("name",name);
		js.put("job",Job);
		
		RestAssured.baseURI = "https://reqres.in";
		
		given()
			.header("Content-Type","application/json; charset=utf-8")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(js)
		.when()
			.post("/api/users")
		.then()
			.statusCode(201)
			.time(lessThan(2000L))
			.assertThat()
			//.body("name",equalTo("bbbb"))
			.log().all();
			
				
	}
	
	/*
	 * @DataProvider(name = "empdatagiver") public String[][] empdataprovider() {
	 * String edata[][] = {{"Bin","pat"},{"Goldo","bandu"},{"name","bbbb"}}; return
	 * edata;
	 * 
	 * }
	 */
	 
	@DataProvider(name = "xpdataprovider")
	
	public String[][] datap() throws IOException {
		String path = "C:\\Selenium_WorkSpace\\restapi\\data\\empdata.xlsx";
		int row = XLUtils.getRowCount(path, "Sheet1");
		int col = XLUtils.getCellCount(path, "Sheet1",1);
		String empdata[][] = new String[row][col];
		
		for(int i=1;i<=row;i++) {
			for(int j=0;j<col;j++) {
				empdata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return empdata;
	}
	
}

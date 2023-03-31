package com.qa.practice;
import org.apache.commons.collections4.map.HashedMap;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class postPractice {
	
	

	//@Test
	public void postCall() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name","morpheus");
		map.put("job","leader");
		System.out.println(map);
		baseURI = "https://reqres.in/"; 
		
		given()
			.header("content-type","appliaction/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(map)
		.when()
			.post("api/users")
		.then()
			.statusCode(201)
			.time(lessThan(2000L))
			.log().all();

		}
	
	@Test(dataProvider = "empdataprovider")
	public void postCallJObject(String name,String job ) {
		JSONObject req = new JSONObject();
		req.put("name",name);
		req.put("job",job);
		System.out.println(req);
		baseURI = "https://reqres.in/"; 
		
		given()
			.header("content-type","appliaction/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(req.toJSONString())
		.when()
			.post("api/users")
		.then()
			.statusCode(201)
			.time(lessThan(2000L))
			.log().all();

}
/*
 * @DataProvider(name="empdataprovider") public String[][] dataP() {
 * 
 * String edata[][]= {{"Bin","pat"},{"Goldo","bandu"}}; return edata; }
 */
	
	@DataProvider(name="empdataprovider")
		public String[][] dataP() throws IOException {
		
		String path = "./data/empdata.xlsx";
		//String path = System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\practice\\empdata.xlsx";
		int col = XLUtils.getCellCount(path, "Sheet1",1);
		int row = XLUtils.getRowCount(path, "Sheet1");
		System.out.println(col);
		System.out.println(row);
			
		
		String edata[][] = new String[row][col];
		for(int i=1;i<=row;i++) {
			for(int j=0;j<col;j++) {
				edata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}

			
		//String edata[][]= {{"Bin","pat"},{"Goldo","bandu"}};
		return edata;
		}

}


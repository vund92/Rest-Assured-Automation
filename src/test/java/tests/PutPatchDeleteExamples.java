package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class PutPatchDeleteExamples {

	@Test
	public void testPut() {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject request = new JSONObject();
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void testPatch() {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject request = new JSONObject();
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void testDelete() {

		baseURI = "https://reqres.in/api";

		when().
			delete("/users/2").
		then().
			statusCode(204).
			log().all();
	}

}

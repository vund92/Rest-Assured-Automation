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

public class TestOnLocalAPI {

	//@Test
	public void get() {
		baseURI = "http://localhost:3000";

		given().get("/users").then().statusCode(200).log().all();
	}

	//@Test
	public void post() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Thomas");
		request.put("lastName", "Edison");
		request.put("subjectld", 1);

		baseURI = "http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.post("/users").then().statusCode(201).log().all();

		get();
	}

	//@Test
	public void put() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Albert");
		request.put("lastName", "Einstein");
		request.put("subjectld", 2);
		
		baseURI = "http://localhost:3000";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("/users/4")
		.then()
			.statusCode(200);

		get();
	}
	
	//@Test
	public void patch() {
		JSONObject request = new JSONObject();
		request.put("lastName", "Doe");
		
		baseURI = "http://localhost:3000";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.patch("/users/4")
		.then()
			.statusCode(200);

		get();
	}
	
	@Test
	public void delete() {
		baseURI = "http://localhost:3000";
		when()
			.delete("/users/4")
		.then()
			.statusCode(200);
	}

}

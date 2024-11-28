package RestfulGETBooking;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GETBooking {
//This is GET request

	public static void main(String[] args) {
		//1. Build request
		//2. Hit the request and get response
		//3.Validate the response

		//1. Build request (GET)
		RequestSpecification requestSpecification = RestAssured.given();  //built in class called RestAssured
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/"); //baseURI
		requestSpecification.basePath("booking/{id}");  //  {id} is called place holder
		requestSpecification.pathParam("id",1);

		//2. Hit the request and get Response
		Response response = requestSpecification.get();

		//3. Validate the response
		ValidatableResponse validateResponse = response.then().log().all();  //log is for printing
		validateResponse.statusCode(200);
	}
}
/* we can write the above code in short format like this:
 * 1. Build request
 * RestAssured
 * .given()
 * .log()
 * .all()
 * .baseUri("https://restful - booker .herokuapp.com/")
 * .basePath("booking/{id}")
 * .pathParam("id", 1)
 * 2. Hit the request and get response
 * .when()
 * 		.get()
 * 3. Validate the response
 * .then()
 * 		.log()
 * 		.all()
 * 		.statusCode(200);
 *
 * */

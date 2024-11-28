package RestfulDELETERequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestfulDELETERequest {

	//this delete request has no body/payload

	public static void main(String[] args) {


		//1. Given- Build request
		//2. When - hit request
		//3. Then - validate response

		//1. Build request
		RestAssured  //built in class called RestAssured
			.given()   //these are all Methods
				 .log() //if you don't give log it will not print anything
				 .all()
				 .baseUri("https://restful-booker.herokuapp.com/")
				 .basePath("booking/1")   //booking id 1 is what we want to delete
				 //.pathParam("bookingID", "1")
				 .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
				 .contentType(ContentType.JSON)
			// 2. hit request and get response
			.when()
				.delete()  //this is delete request
			//3. validate the response
			.then()
				.log()
				.all()
				 .assertThat()
				 .statusCode(201);
	}

}

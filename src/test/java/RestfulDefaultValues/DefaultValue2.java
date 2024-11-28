package RestfulDefaultValues;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DefaultValue2 {

	@Test
	public void createBooking1(){

		RestAssured
		.given()
		.log() //for printing
		.all()
		.baseUri("auth")
		.body("{\r\n"
					+ "    \"username\" : \"admin\",\r\n"
					+ "    \"password\" : \"password123\"\r\n"
					+ "}")
			.contentType(ContentType.JSON)
			.post()
			.then()
			.log()
			.all()
			.statusCode(200);
	}
}



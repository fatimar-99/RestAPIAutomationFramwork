package RestfulDefaultValues;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DefaultValuesInRestAssured {

	public static void main(String[] args) {

		//if we comment out baseUri and basePath,run the code, it will default
		//to local host http://localhost:8080

		RestAssured
		.given()
			.log() //for printing
			.all()
			//.baseUri("https://restful-booker.herokuapp.com/")
			//.basePath("booking/1")
			.body("{\r\n"
					+ "    \"firstname\" : \"Nancy1\",\r\n"
					+ "    \"lastname\" : \"Brown\",\r\n"
					+ "    \"totalprice\" : 111,\r\n"
					+ "    \"depositpaid\" : true,\r\n"
					+ "    \"bookingdates\" : {\r\n"
					+ "        \"checkin\" : \"2018-01-01\",\r\n"
					+ "        \"checkout\" : \"2019-01-01\"\r\n"
					+ "    },\r\n"
					+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
					+ "}")
			.contentType(ContentType.JSON)
			.post()
			.then()
			.log()
			.all()
			.statusCode(200);

	}
}

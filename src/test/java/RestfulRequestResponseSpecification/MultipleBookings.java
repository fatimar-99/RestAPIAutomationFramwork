package RestfulRequestResponseSpecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class MultipleBookings {

	RequestSpecification requestSpecification;   //request specification means steps that are common in all


	@BeforeClass
	public void setupRequestSpec()
	{	//these are all common actions
		requestSpecification=RestAssured.given();
		requestSpecification
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
		 	//.basePath("booking")
		 	.contentType(ContentType.JSON);
	}

	@Test
	public void createBooking1()
	{
		RestAssured
		.given()
		.spec(requestSpecification)
		.basePath("booking")
		.body("{\r\n" +
	            "  \"firstname\": \"MaryO\",\r\n" +
	            "  \"lastname\": \"Brown\",\r\n" +
	            "  \"totalprice\": 111,\r\n" +
	            "  \"depositpaid\": true,\r\n" +
	            "  \"bookingdates\": {\r\n" +
	            "    \"checkin\": \"2018-01-01\",\r\n" +
	            "    \"checkout\": \"2019-01-01\"\r\n" +
	            "  },\r\n" +
	            "  \"additionalneeds\": \"Breakfast\"\r\n" +
	            "}")

		.post()
		.then()
			.log()
			.all()
			.assertThat();
	}

	@Test
	public void updateBooking() {

		RestAssured
		.given()
		.spec(requestSpecification)   //body is not common so we keep it
		.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
		.basePath("booking/3")
	 	.body("{\r\n" +
	            "  \"firstname\": \"Mary\",\r\n" +
	            "  \"lastname\": \"Brown\",\r\n" +
	            "  \"totalprice\": 111,\r\n" +
	            "  \"depositpaid\": true,\r\n" +
	            "  \"bookingdates\": {\r\n" +
	            "    \"checkin\": \"2018-01-01\",\r\n" +
	            "    \"checkout\": \"2019-01-01\"\r\n" +
	            "  },\n" +
	            "  \"additionalneeds\": \"Breakfast\"\r\n" +
	            "}")
	 	.when()
	 		.put()
	 	.then()
	 		.log()
	 		.all()
	 		.assertThat()
	 		.statusCode(200);

	}

}

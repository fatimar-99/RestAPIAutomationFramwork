package RestfulDefaultValues;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DefaultValue1 {

	@BeforeTest
	public void setUp()
	{	//these are Static variables/values we are setting up before Class level, that is why I commented out below
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
		RestAssured.basePath = "booking";
		System.out.println("*****In Setup*****"); //to show you it is only running once.
		RestAssured.requestSpecification=RestAssured.given().log().all();
		RestAssured.responseSpecification =RestAssured.expect().statusCode(200);
	}

	@Test
	public void createBooking1(){

		RestAssured
		.given()
			//.log() //for printing
			//.all()
			//.baseUri("https://restful-booker.herokuapp.com/")
			//.basePath("booking")
		.body("{\r\n"
					+ "    \"firstname\" : \"Nancy2\",\r\n"
					+ "    \"lastname\" : \"Browns\",\r\n"
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
			.all();
			//.statusCode(200);
	}

	@Test
	public void createBooking2() {

		RestAssured
		.given()
			//.log() //for printing
			//.all()
			//.baseUri("https://restful-booker.herokuapp.com/")
			//.basePath("booking")
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
			.all();
			//.statusCode(200);
	}
}



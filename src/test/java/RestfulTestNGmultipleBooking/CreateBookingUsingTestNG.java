package RestfulTestNGmultipleBooking;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateBookingUsingTestNG {

	@Test
	public void booking1()  //at first test(here), we are creating booking
	{
		RestAssured  //built in class called RestAssured
		 .given()
		 	.log() //for printing
		 	.all()
		 	.baseUri("https://restful-booker.herokuapp.com/")
		 	.basePath("booking")
		 	.body(("{\n" +
                "  \"firstname\": \"Fatima\",\n" +
                "  \"lastname\": \"Brown\",\n" +
                "  \"totalprice\": 111,\n" +
                "  \"depositpaid\": true,\n" +
                "  \"bookingdates\": {\n" +
                "    \"checkin\": \"2018-01-01\",\n" +
                "    \"checkout\": \"2019-01-01\"\n" +
                "  },\n" +
                "  \"additionalneeds\": \"Breakfast\"\n" +
                "}"))

		 	.contentType(ContentType.JSON)

		 //2. hit the request and get the response
		 .when()
		 	.post()
		 //3. validate the response
		 .then()
		 	.log()
		 	.all()
		 	.statusCode(200);
	}
	@Test
	public void updateBooking()  //here at second test we are updating booking
	{
		RestAssured  //built in class called RestAssured
		 .given()
		 	.log() //for printing
		 	.all()
		 	.baseUri("https://restful-booker.herokuapp.com/")
		 	.basePath("booking/1")
		 	.header("Content-Type" , "application/json")
		 	.header("Authorization" , "Basic YWRtaW46cGFzc3dvcmQxMjM=")
		 	.body(("{\n" +
                "  \"firstname\": \"Fatima\",\n" +
                "  \"lastname\": \"Brown\",\n" +
                "  \"totalprice\": 111,\n" +
                "  \"depositpaid\": true,\n" +
                "  \"bookingdates\": {\n" +
                "    \"checkin\": \"2018-01-01\",\n" +
                "    \"checkout\": \"2019-01-01\"\n" +
                "  },\n" +
                "  \"additionalneeds\": \"Breakfast\"\n" +
                "}"))

		 	//2. hit the request and get the response
		 .when()
		 	.put()
		 //3. validate the response
		 .then()
		 	.log()
		 	.all()//print and log all
		 	.assertThat()
		 	.statusCode(200);

	}

	}


package RestfulRequestResponseSpecification;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class WithoutResponseSpecification {

	@BeforeClass
	public void setUpExpectations() {

		ResponseSpecification responseSpecification = RestAssured.expect();
		responseSpecification.statusCode(200);
		responseSpecification.contentType(ContentType.JSON);
		responseSpecification.time(Matchers.lessThan(5000L));

	}
	@Test
	public void createBooking1() {

	RestAssured  //built in class called RestAssured
	 .given()
	 	.log() //for printing
	 	.all()
	 	.baseUri("https://restful-booker.herokuapp.com/")
	 	.basePath("booking")
	 	.body("{\n" +
            "  \"firstname\": \"Fatima\",\n" +
            "  \"lastname\": \"Brown\",\n" +
            "  \"totalprice\": 111,\n" +
            "  \"depositpaid\": true,\n" +
            "  \"bookingdates\": {\n" +
            "    \"checkin\": \"2018-01-01\",\n" +
            "    \"checkout\": \"2019-01-01\"\n" +
            "  },\n" +
            "  \"additionalneeds\": \"Breakfast\"\n" +
            "}")

	 	.contentType(ContentType.JSON)  //this content type is for request

	 	//2. hit the request and get the response
	 .when()
	 .post()
	 //3. validate the response
	 .then()
	 .log()
	 .all()
	 .statusCode(200)
	 .contentType(ContentType.JSON) //this content type is for response
	 .time(Matchers.lessThan(5000L));  //the response must be less than 5 seconds

	}
	public void updateBooking()
	{
		RestAssured  //built in class called RestAssured
		 .given()
		 	.log() //for printing
		 	.all()
		 	.baseUri("https://restful-booker.herokuapp.com/")
		 	.basePath("booking/1")
		 	.body("{\r\n" +
	            "  \"firstname\": \"Fatima\",\r\n" +
	            "  \"lastname\": \"Brown\",\r\n" +
	            "  \"totalprice\": 111,\r\n" +
	            "  \"depositpaid\": true,\r\n" +
	            "  \"bookingdates\": {\r\n" +
	            "    \"checkin\": \"2018-01-01\",\r\n" +
	            "    \"checkout\": \"2019-01-01\"\r\n" +
	            "  },\n" +
	            "  \"additionalneeds\": \"Breakfast\"\r\n" +
	            "}")

		 	.contentType(ContentType.JSON)  //this content type is for request

		 //2. hit the request and get the response
		 .when()
		 .post()
		 //3. validate the response
		 .then()
		 .log()
		 .all()
		 .statusCode(200);
	}
}

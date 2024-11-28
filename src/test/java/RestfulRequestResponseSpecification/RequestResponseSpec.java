package RestfulRequestResponseSpecification;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestResponseSpec {

	//setting up Request and Response specifications.
	//we are creating booking with request and response specification

	 RequestSpecification requestSpecification;
	 ResponseSpecification responseSpecification;

	@BeforeClass
	public void setupRequestSpec() {
	//setting up request specification
		requestSpecification = RestAssured.given();
			requestSpecification
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.contentType(ContentType.JSON);

	//setting up response specifications
	responseSpecification =RestAssured.expect()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.time(Matchers.lessThan(5000L));
	}
	@Test
	public void createBooking() {

	//using request and response specifications
	RestAssured.given()
		.spec(requestSpecification) //applying request specification
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

	 	.contentType(ContentType.JSON) //this content type if the request

	 	//2. hit the request and get the response
	 	.when()
	 	.post()
	 	//3. validate the response
	 	.then()
	 	.spec(responseSpecification) //applying response sepcification
	 	.log()
	 	.all()
	 	.statusCode(200);

	}
}

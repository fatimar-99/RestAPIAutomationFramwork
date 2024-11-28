package RestfulPOSTBooking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class POSTBookingTheLongway {

	public static void main(String[] args) {
		//for this example you can go to Postman and look up collection called post booking.
		//we posted in Postman, and now are going to do the same in Eclipse
		//the website is called restful-booke.herokuapp.com  then click on getbooking

		//1. build request,
		//2. hit request and get Response,
		//3. validate Response

		RequestSpecification requestSpecification = RestAssured.given();  //built in class called RestAssured

		//1. Build Request
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");   //base uri

		//after running this I want to see something in the counsel here
		requestSpecification= requestSpecification.log().all();

		requestSpecification.basePath("booking");    //base path
		//body
		requestSpecification.body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "} ");
		//type
		requestSpecification.contentType(ContentType.JSON);

		//2. hit request and get Response
		Response response = requestSpecification.post();

		//3. validate Response
		ValidatableResponse validataeableResponse = response.then().log().all();
		validataeableResponse.statusCode(200);  //if you want to see fail, just change the 200 ro 400 status code
	}
}
/*the above code can be written in short:
 * RestAssured
 * .given()
 * .baseUri("https://restful-booker.herokuapp.com/")
 * .basePath("booking"
 * .contentType(ContentType.JSON)
 * .post()
 * .then()
 * .statusCode(200);   go to next page/class*/

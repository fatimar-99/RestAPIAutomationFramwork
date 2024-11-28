package RestfulPOSTBooking;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POSTBookingTheShortway {  //shortway is called Chaining Method.
	//This is POST request

	public static void main(String[] args) {
	//for reference review the longway class.
				//1. Given- Build request
				//2. When - hit request
				//3. Then - validate response

		//1. Build request
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

}

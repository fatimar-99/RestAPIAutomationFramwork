package RestfulBDDFormat;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssuredBDD {

	public static void main(String[] args) {
		//This is POST request
		//we are using BDD(Behavior Data Driven) format without Cucumber

		//1. Given-Build request
		//2. When -
		//3. Then -

		//1. Given -  Build Request
		RestAssured  //built in class called RestAssured
		.given()   //given body
			.log()
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
            .contentType(ContentType.JSON)

        .when()     //2. hit request and get a response
        	.post()  //which Http method will be perform (like GET, POST, UPDATE etc)
        .then()
        	.log()
        	.all()
        	.statusCode(200);  //3. validate response



	}

}

package RestfulPUTBooking;

import io.restassured.RestAssured;

public class PUT_UpdateBooking {

	public static void main(String[] args) {
		//put/update request
		//must have body/payload, header

				//1. Given- Build request
				//2. When - hit request
				//3. Then - validate response

		RestAssured
		.given()
			.log() //for printing
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")  //base uri
			.basePath("booking/1")
			.header("Content-Type" , "application/json")  //from the website
			.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")  //this info is from the website
			.body("{\r\n"
					+ "    \"firstname\" : \"Nancy\",\r\n"
					+ "    \"lastname\" : \"Brown\",\r\n"
					+ "    \"totalprice\" : 111,\r\n"
					+ "    \"depositpaid\" : true,\r\n"
					+ "    \"bookingdates\" : {\r\n"
					+ "        \"checkin\" : \"2018-01-01\",\r\n"
					+ "        \"checkout\" : \"2019-01-01\"\r\n"
					+ "    },\r\n"
					+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
					+ "}")

		.when()
			.put()  //its a put method
		.then()
			.log()
			.all()
			.assertThat()
			.statusCode(200);

	}

}

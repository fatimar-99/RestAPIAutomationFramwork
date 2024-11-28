package RestfulPATCHRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestfulPATCH {

	public static void main(String[] args) {

				//1. Given- Build request
				//2. When - hit request
				//3. Then - validate response

		RestAssured   //RestAssured is a class in library
		.given()
			.log()  //log is for printing
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking/1")
			.body("{\r\n"
					+ "    \"firstname\" : \"James\",\r\n"
					+ "    \"lastname\" : \"Brown\"\r\n"
					+ "}")
			.contentType(ContentType.JSON)
			.header("Authorization" ,"Basic YWRtaW46cGFzc3dvcmQxMjM=")
		.when()
			.patch()  //this is patch request
		.then()
			.log()
			.all()
			.assertThat()
			.statusCode(200);




	}

}

package RestfulRequestResponseSpecification;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateBookingWithRequestAndResponseSpecification {

	public static void main(String[] args) {

		RequestSpecification requestSpecification = RestAssured.given();
			requestSpecification
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking")
			.contentType(ContentType.JSON);

		ResponseSpecification responseSpecification =RestAssured.expect();
			responseSpecification
			.statusCode(200)
			.contentType(ContentType.JSON)
			.time(Matchers.lessThan(5000L));

		RestAssured
			.given(requestSpecification)// interview question, which method are overloaded in RestAssured? ans. 'given method' hover the mosue the given cntrl space you will see
			//.spec(requestSpecification)   //notice here
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
			.post()
			.then()

			.log()
			.all()
			.spec(responseSpecification); // and notice here


	}

}

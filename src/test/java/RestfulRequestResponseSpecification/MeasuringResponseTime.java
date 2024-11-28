package RestfulRequestResponseSpecification;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MeasuringResponseTime {


	//how to measure response time using Hamcrest
	public static void main(String[] args) {

		//ValidatableResponse validatableResponse=RestAssured
		Response response=RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking")
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
		.contentType(ContentType.JSON)
		//hit the request and get the response
		.post();

		long responseTimeInMilliSecond = response.time();
		System.out.println("Response Time in Millie Second : "  + responseTimeInMilliSecond);

		//another Method
		long responseTimeInSecond = response.timeIn(TimeUnit.SECONDS);
		System.out.println("Response time in seconds : " + responseTimeInSecond);

		//another Method
		long responseTimeInMS1 = response.getTime();
		System.out.println("Response time in Milli seconds : " + responseTimeInMS1);

		//another Method
		long responseTimeInSeconds1 = response.getTimeIn(TimeUnit.SECONDS);
		System.out.println("Response time in seconds : " + responseTimeInSeconds1);

		//to put Assertions we use Hamcres
		response.then().time(Matchers.lessThan(5000L));
		response.then().time(Matchers.greaterThan(2000L));

		//response should be between 2 to 5 seconds
		//here we are passing to Assertions
		response.then().time(Matchers.both(Matchers.greaterThan(2000L)).and(Matchers.lessThan(5000L)));



	}

}

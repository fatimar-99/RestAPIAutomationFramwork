package RestfulExtractResponseBodyAsString;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ExtractResponseString {


		public static void main(String[] args) {
			//once we hit the API, we want to extract that response
			// we want to retrieve or extract the response
			//that we POST earlier and print that response

			String responseBody=   //store the response inside a string
			RestAssured
				.given()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking")
				.body(("{\r\n" +
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
				.post()
				//at 'then' we are getting the response
				.then()
				.extract()  //we have a built in method called extract(response), we are calling it here
				.body()
				.asPrettyString(); //print the response in proper jason format.

				System.out.println(responseBody);


		}


	}



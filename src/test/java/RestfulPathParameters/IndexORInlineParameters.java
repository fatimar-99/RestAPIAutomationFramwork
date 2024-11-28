package RestfulPathParameters;

import io.restassured.RestAssured;

public class IndexORInlineParameters {

	public static void main(String[] args) {
		//here we don't give a name to parameters, it should follow the index
		//compare this example to path parameters to know the difference

		RestAssured
		.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")  //base uri
			.basePath("{basePath}/{bookingId}")

		.when()
			.get("https://restful-booker.herokuapp.com/{basePath}/{bookingId}","booking",2)//the base path is booking and the id is 2
		.then()
			.log()
			.all();

	}
// the results should looks like this: https://restful-booker.herokuapp.com/booking/2
}

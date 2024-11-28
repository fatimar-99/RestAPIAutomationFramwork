package RestfulPathParameters;

import io.restassured.RestAssured;

public class PathParameterExample {

	public static void main(String[] args) {
		//example of Name parameters, meaning we give it a name like basePath, booking id etc
		//compare to inline parameters where we don't give names.
		RestAssured
		.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")  //base uri
			.basePath("{basePath}/{bookingId}") //2 base path parameters/keys, you can give any name to parameters
			.pathParam("basePath", "booking")  //values 1
			.pathParam("bookingId", 2) //values 2
		.when()
			.get()
		.then()
			.log()
			.all();




	}

}

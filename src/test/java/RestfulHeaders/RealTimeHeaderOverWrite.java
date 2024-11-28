package RestfulHeaders;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;

public class RealTimeHeaderOverWrite {

	@Test
	public void realTimeHeaderOverwrite()
	{
		RequestSpecification res1=RestAssured.given()
				.header("header1","value1"); //this request has header1

		RequestSpecification res2=RestAssured.given()
				.header("header2","value3")  //this request has header2 and header1
				.header("header1","value2");

		//both specification will be merged
		RestAssured
			.given()
			//we are saying here if you get header1, don't merge,over write it
			.config(RestAssuredConfig.config()
				.headerConfig(HeaderConfig.headerConfig()
						.overwriteHeadersWithName("header1")))
			.spec(res1)
			.spec(res2)
			.log()
			.all()
		.given()
			.get();

		/*header1=value1
		header2=value2*/


	}

}

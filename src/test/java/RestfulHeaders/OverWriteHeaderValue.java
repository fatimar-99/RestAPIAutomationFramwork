package RestfulHeaders;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;

public class OverWriteHeaderValue {
	//important - all headers by default are merged,except
	//the accept and the content-type headers.

	@Test
	public void defaultBehaviour()
	{
		RestAssured
			.given()
			.header("header1", "value1")// the same header with different value
			.header("header1", "value2") //it will merge both values
			.log()
			.all()
		.when()
			.get();

	}
	@Test
	public void defaultBehaviour1()
	{//you can also have it like this and result will be the same
		RestAssured
		.given()
		.header("header1", "value1", "value2")// the same header with different value
		//.header("header1", "value2") //it will merge both values
		.log()
		.all()
	.when()
		.get();
	}

	//do not merger, over write it
	@Test
	public void OverWriteHeader()//we have a config Method inside Restassured class
	{
		RestAssured
			.given()
			//here we are saying if you find header1
			//don't merge it's value but write over it
			.config(RestAssuredConfig.config()
					.headerConfig(HeaderConfig
							.headerConfig()
							.overwriteHeadersWithName("header1")))
			.header("header1", "value1")
			.header("header1", "value2")
			.log()
			.all()
		.when()
		.get();

	}




}

package RestfulHeaders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class HeadersExamples {

	//Headers -in Request and in Response
	//here we are just passing in the header key and value
	//one header can have multiple values

	@Test
	public void passHeader()
	{
		RestAssured
			.given()
			.log()
			.all()
			.header("Header1", "Value1")
			.when()
			.get();
	}

	@Test
	public void HeaderWithMultiValues()
	{
		RestAssured
			.given()
			.log()
			.all()
			//.header("Header1", "Value1")
			//.header("Header2","Value1","Value2","Value3") //or we can use it this way too
			.header("Header1", "Value1")
			.header("Header1", "Value2")
			.when()
			.get();
	}
	@Test
	public void HeaderAsAclass()
	{
		//creating an object of this header
		Header header=new Header("Header1", "Value1");
		RestAssured
			.given()
			.log()
			.all()
			.header(header)
			.when()
			.get();
	}
	@Test
	public void headersMap() //headers with an s
		{
			Map<String,String> headerMap= new HashMap<>(); //we can have Map or List
			List<Header> allHeaders = new ArrayList<>();

			Header header = new Header("Header1", "Value1");
			Header header1 = new Header("Header2", "value2");

			allHeaders.add(header);
			allHeaders.add(header1);

			Headers headers = new Headers(allHeaders);

			headerMap.put("h1", "v1");
			headerMap.put("h2", "v2");
			headerMap.put("h3", "v3");
			headerMap.put("h4", "v4");

			RestAssured
				.given()
				.log()
				.all()
				.headers(headers)
				.when()
				.get();

		}
	}


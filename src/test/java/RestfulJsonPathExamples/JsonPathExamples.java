package RestfulJsonPathExamples;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JsonPathExamples {

	@Test
	public void jsonPathDemo1()
	{
		String json = "{\r\n"
				+ "  \"firstname\": \"Jim\",\r\n"
				+ "  \"lastname\": \"Brown\"\r\n"
				+ "}";
		// get the above from here: https://jsoneditoronline.org/#left=local.lixayu&right=local.fuduqu

		//get JSON path instance of given json document
		JsonPath jsonPath = new JsonPath(json);
		
		//retrieve firstname using json path
		String firstName = jsonPath.getString("firstname");
		
		//print the value of firstname 
		System.out.println(firstName);
		
		//not sure of the datatype then use 'get'
		Object fname = jsonPath.get("firstname");
		System.out.println(fname);


	}
}

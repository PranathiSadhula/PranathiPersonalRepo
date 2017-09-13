package api.controller.response;

import java.util.HashMap;
import java.util.Set;

import org.testng.Assert;

import utils.JsonUtils;
import utils.RequestUrlUtils;



public class ApiResponseValidator {

	private ApiResponse response;
	
	private String requestUrl;

	public ApiResponseValidator(ApiResponse response) {
		this.response = response;
	}

	public ApiResponseValidator expectCode(int expectedCode) {
		Assert.assertEquals( response.getResponseCode(),expectedCode,"Incorrect Response Code");
		return this;
	}

	public ApiResponseValidator expectMessage(String message) {
		Assert.assertEquals("Incorrect Response Message", message, response.getResponseMessage());
		return this;
	}

	public ApiResponseValidator expectHeader(String headerName, String headerValue) {
		try{
			Assert.assertEquals("Incorrect header - " + headerName, headerValue, response.getHeader(headerName));
		}catch(Exception e)
		{
			System.out.println(e);
		}
			return this;
	}

	public ApiResponseValidator expectHeaders(HashMap<String, String> headers) {
		Set<String> keys = headers.keySet();
		for (String key : keys) {
			Assert.assertEquals("Incorrect header - " + key, headers.get(key), response.getHeader(key));
		}
		return this;
	}

	public ApiResponseValidator expectInBody(String content) {
		Assert.assertTrue( response.getResponseBody().toLowerCase().contains(content.toLowerCase()),"Body doesnt contain string : " + content);
		return this;
	}

	public ApiResponseValidator printBody(){
		System.out.println(response.getResponseBody());
		return this;
	}
	
	public ApiResponse getResponse(){
		return response;
	}
	
	public ApiResponseTester getGuid() {
		Assert.assertTrue( response.getResponseBody().toUpperCase().contains("GUID"),"Body doesnt contain string : GUID" );
		return new ApiResponseTester(JsonUtils.returnJsonValue(response.getResponseBody(), "GUID"), "GUID");
	}
	public ApiResponseTester getImeiFromRequest() {
		Assert.assertTrue( this.requestUrl.toUpperCase().contains("IMEI"),"Body doesnt contain string : IMEI" );
		return new ApiResponseTester(RequestUrlUtils.returnReqParamValue(this.requestUrl, "IMEI"), "IMEI");
	}
	
	public ApiResponseTester getGuidFromResponseOrImeiFromRequest()
	{
		ApiResponseTester tester = null;
		if(response.getResponseBody().toUpperCase().contains("GUID"))
		{
			tester = getGuid();
			
		}
		else if(this.requestUrl.toUpperCase().contains("IMEI"))
		{
			tester = getImeiFromRequest();
			
		}
		else
		{
			Assert.assertTrue( (response.getResponseBody().toUpperCase().contains("GUID") || (this.requestUrl.toUpperCase().contains("IMEI")) ),"Body doesnt contain string : GUID or string : IMEI" );
		}
		
		return tester;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

}

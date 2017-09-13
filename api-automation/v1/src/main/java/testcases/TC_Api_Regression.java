package testcases;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import airpush.api.controller.AirpushApiController;

public class TC_Api_Regression extends AirpushApiController {

	

	@BeforeMethod(enabled=false)
	public void setData() {
		testCaseName = "TC_Api_Regression";
		testDescription = "To execute Regression suite for Api Testing";
		expectedResult = "Successful execution of Api Regression test suite";
		authors = "QA_Pranathi";
	}


	@Test(dataProvider = "apiUrlMapping")
	public void testSuccess(String adType, String apiUrl) {
		
		executor.getResponse(adType,apiUrl)
		.expectCode(200)
		.expectInBody("Success")
		.getGuidFromResponseOrImeiFromRequest();
		;
	}
	
	

	

}


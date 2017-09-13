#API QA Automation work.
Pre requisites :
	Java jdk > 7
	Maven
	IDE(eclipse prefered)
pom.xml will give all the dependencies like TestNg, Apache POI(for excel reading and writing), log4

Project Structure :
This project is a maven project with pom.xml defining all the dependencies required.

package api.controller contains the core java classes for exectuing api_request_url, generating response, storing it into a file etc.
	api.controller.ApiQAController.java ==> 
			is an interface which is implemented by api.controller.APiQAExecuter.java
	api.controller.APiQAExecuter.java  ==> 
			its constructor ApiQAExecutor(String apiUrl) builds api request using HttpClientBuilder
			implements getResponse() method of api.controller.ApiQAController.java, where raw response is stored into 				ApiResponse.java and the JSON response is written into response.txt file as an output.
	api.controller.ApiResponse.java  ==> 
			is java pojo class which holds repsonse 
	api.controller.ApiResponseValidator.java ==> 
			is TestNg assertion class which validates response for expected conditions like expectedCode, expectedMessage, 				expectedHeaders, expectedInBody	
package airpush.api.controller contains AirpushApiController.java where all the TestNg annotations being used for executing the testcase
	airpush.api.controller.AirpushApiController.java ==>
			@BeforeSuite - InitialSetUp() ==> loads DB driver, retrives all api urls  from excel sheet, hits DB to get appid 				based adtYpe
			@BeforClass - SetUpApiUrl() ==> generates current Testcase related apiurl with appid, imei
			
package utils contains basic java classes like DBConnection.java and DataInputProvider.java
	DBConnection.java ==>
			is singleton java class which creates only one DB instance through out the execution

	DataInputProvider.java ==>
			Apache POI is implemented here to read excel sheet 
	utils.constants.Constants.java ==>
			holds constants
	utils.constants.PropertyReaderUtil.java ==>
			reads config.properties file

package testcases contains adtypes as sub packages 
			Here testcases are written in TestNg classes instead of java classes.
			All testcases classes should extends AirpushApiController.java 
Mandatory Rules to be followed while writing testcase:
			Class should be TestNg class
			Class Naming convention - TC_AdType_<TC_Name>.java
			@BEforeTest - SetUpTest() with adType = "adType_Name(ex:-inapp)" and dataSheet = "AdRequests"
			@BeforeMethod - SetData() with testCaseName, testDescription, excpected, Author
			@Test - actual testcase

package src/main/resources 
			config.properties
			log4j.properties
folder data :
			AdRequests.xlsx(input file)
			response.txt (output file)
folder log :
			error.log, regression.log


				
	

/*
 * 
 */
package airpush.api.controller;

import java.sql.Connection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.collections4.iterators.EntrySetMapIterator;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import api.controller.ApiQAExecutor;
import utils.DBConnection;
import utils.DataInputProvider;
import utils.constants.PropertyReaderUtil;

public class AirpushApiController extends PropertyReaderUtil {

	/**  Class Level Varaible - log. */
	Logger log = Logger.getLogger(AirpushApiController.class);
	public String dataSheetName = "AdRequests";
	public String testCaseName, testDescription, expectedResult, category, authors;
	public  Connection connection;
	public  HashMap<String, String> inputApiUrls;
	public  HashMap<String, String> appIdAdTypeMap;
	public HashSet<String> inputAdTypeSet;
	//public  String apiUrl = "";
	public  HashMap<String, String> apiUrlMap ;
	public  ApiQAExecutor executor;
	
	static String IOS_App_ID;
	
	static String IOS_Mobile_Web_App_ID; //site id
	
	static String Android_App_ID;
	
	static String Android_Mobile_Web_App_ID;

	@BeforeSuite
	public void InitialSetUp() {
		loadProperties();
		connection = DBConnection.getDBConnection().getConnection();
		appIdAdTypeMap = DataInputProvider.getAppIdForAdType(connection);
		inputAdTypeSet = DataInputProvider.getTestAdType("./data/"+ dataSheetName + ".xlsx");
		inputApiUrls = DataInputProvider.getTestApiUrl("./data/"+ dataSheetName + ".xlsx", appIdAdTypeMap, inputAdTypeSet);
	
		//appIdAdTypeMap = DataInputProvider.getAppIdForAdType();
		
		
	}

	@BeforeClass
	public void setUpApiUrl()
	{
		apiUrlMap = new HashMap<String, String>();
		for (String adType : inputAdTypeSet) {
			if(adType.equalsIgnoreCase("all"))
			{
				apiUrlMap = inputApiUrls;
				break;
			}
			else{
				String apiUrl =  inputApiUrls.get(adType.toLowerCase());
				apiUrlMap.put(adType,apiUrl);
			//executor = new ApiQAExecutor(apiUrl, adType);
			}
				
		}
		executor = new ApiQAExecutor();
	}
	
	@DataProvider(name="apiUrlMapping")
	public String[][] apiUrlMapping(){
		HashMap<String, String> apiUrlMap = this.apiUrlMap;
		String[][] data = new String[apiUrlMap.size()][2];
		Set entries = apiUrlMap.entrySet();
		Iterator entriesIterator = entries.iterator();

		int i = 0;
		while(entriesIterator.hasNext()){

		    Map.Entry mapping = (Map.Entry) entriesIterator.next();

		    data[i][0] = (String) mapping.getKey();
		    data[i][1] = (String) mapping.getValue();
		     i++;
		}
		return data;
		
	}
	
	@AfterSuite
	public void closeDbConnection() {
		DBConnection.closeConnection(connection);
		unloadProperties();
	}

	

	
}

package api.controller.response;

import java.sql.Connection;

public class ApiResponseTester {
	private ApiResponse response;
	private String guid;
	private String imei;

	public ApiResponseTester(ApiResponse response) {
		this.response = response;
	}
	
	public ApiResponseTester(String guidOrImeivalue, String guidOrImei ) {
		if(guidOrImei.equalsIgnoreCase("guid"))
		this.guid = guidOrImeivalue;
		else
		this.imei =  guidOrImeivalue;	
	}
	
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	public ApiResponseTester validateVerticaDetails()
	{
		//using guid, fetch the rcds for vertica and validate the events 
		try {
			Thread.sleep(30000); // 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	public ApiResponseTester validateMyDbr()
	{
		//using guid, fetch the rcds for vertica and validate the events 
		return this;
	}
	
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
	

}

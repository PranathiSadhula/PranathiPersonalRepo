package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class CreationOfLiveEvents extends LearnexaWrappers{
	
	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC011 Create Events";
		testDescription = "Creation of Events";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test(dataProvider="fetchData")
	public  void createcontent(String userName,String password) throws InterruptedException, AWTException {
		String allowdchrs = "123456789";
		String Titledata = "Testing Liveevent Creation" + RandomStringUtils.random(2, allowdchrs);
	new LoginPage (driver,test)
	 .login1()
	 //.closePopup()
	 .clickEvents()
	 .clickCreation()
	 .UploadPresentation()
	 .clickLiveEventTitle(Titledata)
	 .clickSaveButton(Titledata);
	}	
}
	
	

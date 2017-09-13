package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class CreateInPersonFromCatalog extends LearnexaWrappers{
	
	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC016 Create InPerson Events";
		testDescription = "Creation of Events";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test(dataProvider="fetchData")
	public  void createcontent(String UserName,String password) throws InterruptedException, AWTException {
		String allowdchrs = "1234567890";
		String Titledata = "Testing Inperson from Catalog" + RandomStringUtils.random(2, allowdchrs);
	new LoginPage (driver,test)
	 .login1()
	 .clickCatalog1()
	 .clickCreate1()
	 .clickInPerson() 
	 .enterTitle(Titledata)
	 .clickDays() 
	 .clickLocation()
	 .clickSave()
	 .verifyEvent1(Titledata);
	 
	 ;
	}
}

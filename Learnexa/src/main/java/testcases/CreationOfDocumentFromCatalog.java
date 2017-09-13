package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class CreationOfDocumentFromCatalog extends LearnexaWrappers{
	

	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC0014 Create Content And Course By Document Catalog";
		testDescription = "Creation of Content and then course using the content by Document";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test(dataProvider="fetchData")
	public  void createcontent(String userName,String password) throws InterruptedException, AWTException {
	System.out.println(userName + ":::" + password);
	
	String allowdchrs = "1234567890";
	String Titledata = "Testing creation of Document From Catalog" + RandomStringUtils.random(2, allowdchrs);
	String Titledata1 = "Testing creation of course Document From Catalog" + RandomStringUtils.random(1, allowdchrs);
	String Titledata2 = RandomStringUtils.random(1, allowdchrs);
	
	new LoginPage (driver,test)
	 .enterUserName()
	 .enterPassword()
	 .clickSubmit()
	 //.closePopup()
	 .clickContent()
	 .clickCreateContent()
	 .clickContentDocumentation()
	 .clickUpload() 
	 .enterTitle(Titledata)
	 .clickSaveButton()
	 .verifycontentcreated(Titledata)
	 .clickCatalog()
	 .clickCreate() 
	 .clickCourseDocumentation()
	 .searchCreatedContent(Titledata)
	 .clickcheckBox()
	 .clickApply()
	 .clickCourseTitle(Titledata1)
	 .clickDescription()
	 .checkPrice(Titledata2)
	 .clickSave1Button()
	 //.verifycoursecreated(Titledata1)
	 ;
	}

	

}

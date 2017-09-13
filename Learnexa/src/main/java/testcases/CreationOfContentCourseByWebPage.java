package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class CreationOfContentCourseByWebPage extends LearnexaWrappers {
	
	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC007 Create Content And Course By WebPage";
		testDescription = "Creation of Content and then course using the content by WebPage";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test()
	public  void createcontent() throws InterruptedException, AWTException {
	 
		String allowdchrs = "1234567890";
		String Titledata = "Testing content by webpage" + RandomStringUtils.random(2, allowdchrs);
		String Titledata1 = "Testing course by webpage" + RandomStringUtils.random(1, allowdchrs);
	new LoginPage (driver,test)
	 .login1()
	 //.closePopup()
	 .clickContent()
	 .clickCreateContent()
	 .clickWebPage()
	 .switchframe()
	 .clickTitle(Titledata)
	 .clickSaveButton(Titledata)
	 .clickcoursetab()
	 .clickCreateCourse()
	 .clickWebPageButton()
	 .clickcheckBox() 
	 .clickApply()
	 .clickTitle1(Titledata1)
	 .clickDescription()
	 .saveButton1(Titledata1)
	  ;
	}

}

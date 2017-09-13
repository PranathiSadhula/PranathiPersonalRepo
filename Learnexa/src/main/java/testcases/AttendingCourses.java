package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class AttendingCourses extends LearnexaWrappers{
	
	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC015 Attending Courses";
		testDescription = "Creation of Content and then course using the content by Quiz";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test(dataProvider="fetchData")
	public  void createcontent(String userName,String password) throws InterruptedException, AWTException {
		String allowdchrs = "1234567890";
		String Titledata = "Testing Content Created From Catalog " + RandomStringUtils.random(2, allowdchrs);
		String Titledata1 = "Testing Presentation created from Catalog" + RandomStringUtils.random(1, allowdchrs);
		String Title ="Testing Presentation created from Catalog";
		new LoginPage (driver,test)
		 .login1()
		 .clickCatalog()
		 .clickCreate()
		 .clickCreateWebPage(Titledata)
		 //.clickSaveButton1()
		 //.clickApply()
		 .clickCourseTitle1(Titledata1)
		 .clickDescription()
		 .clicksav()
		 .enterText(Title)
		 .clickpopup()
		 .clickpopup2(Titledata1)
		 
		 
		 ;
		
	}
}

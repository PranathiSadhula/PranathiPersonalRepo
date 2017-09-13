package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class CreationOfContentCourseByTinCan extends LearnexaWrappers{
	
	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC007 Create Content And Course By TinCan";
		testDescription = "Creation of Content and then course using the content by TinCan";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test(dataProvider="fetchData")
	public  void createcontent(String userName,String password) throws InterruptedException, AWTException {
		String allowdchrs = "123456789";
		String Titledata = "Testing Content By Tin automation" + RandomStringUtils.random(2, allowdchrs);
		String Titledata1= "Testing Course By Tin automation" + RandomStringUtils.random(1, allowdchrs);
		String Title=RandomStringUtils.random(1, allowdchrs);
		
	new LoginPage (driver,test)
	 .login1()
	 //.closePopup()
	 .clickContent()
	 .clickCreateContent()
	 .clickTinPackage()
	 .clickUpload()
	 .clickTitle(Titledata)
	 .clickSaveButton(Titledata)
	 .clickcoursetab()
	 .clickCreateCourse()
	 .clickTinCan() 
	 .checkBox()
	 .clickApply()
	 .clickCourseTitle(Titledata1)
	 //.clickSave1Button(Title)
	 .clickSave2Button(Titledata1)
	 
	;
	}
}

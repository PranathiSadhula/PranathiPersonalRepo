package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class CreationOfContentCourseByPresentation extends LearnexaWrappers{
	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC001 Course creation By Presentation By My learning";
		testDescription = "Creation of Content and then course By Presentation and Updating the Course";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test()
	public void createcontent() throws InterruptedException, AWTException {
	 
		String allowdchrs = "123456789";
		String UserName="radham@expertus.com";
		String Titledata = "Testing Content By Presentation automation" + RandomStringUtils.random(2, allowdchrs);	
		String Titledata2 = "Testing Course By Presentation automation" + RandomStringUtils.random(1, allowdchrs);	
		String Titledata3 = RandomStringUtils.random(1, allowdchrs);
		String Titledata1 = "Testing Automation Update";
		
	new LoginPage (driver,test)
	 .login1()
	 .clickcoursetab()
	 .clickCreateCourse()
	 .clickContentPresentation()
	 .createContent()
	 .clickUpload() 
	 .enterTitle(Titledata)
	 .clickSaveButton()
	 .clickApply()
	 .clickCourseTitle(Titledata2)
	 .clickDescription()
	 //.checkPrice(Titledata3)
	 .clickSave1Button()
	 .verifycoursecreated1(Titledata2)
	 .clickEdit()
	 .clickCourseTitle1(Titledata1)
	 .clickUpdateSave(Titledata1)
	  ;
	}
}

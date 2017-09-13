package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class CreationOfBundle extends LearnexaWrappers{


	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC0013 Creation of Bundle";
		testDescription = "Creation of Content and then course using the content by Quiz";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test(dataProvider="fetchData")
	public  void createcontent(String UserName,String password) throws InterruptedException, AWTException {
		String allowdchrs = "123456789";
		String Titledata = "Testing Create Bundle Automation" + RandomStringUtils.random(2, allowdchrs);
		String Titledata1 = "Testing Create Bundle Automation" + RandomStringUtils.random(1, allowdchrs);
		
	new LoginPage (driver,test)
	 .login1()
	/* .clickContent()
	 .clickCreateContent()
	 .clickContentQuiz()
	 .clickOnMultipleQuestion()
	 .typeQuestion()
	 .typeAnswers()
	 .courseTitle(Titledata)
	 .saveButton(Titledata)*/
	 .clickBundle()
	 .clickCreateBundle()
	 .clickAddButton()
	 .clickcheckBox() 
	 .clickApply()
	 .clickCourseTitle(Titledata1)
	 .clickDescription() 
	 .clickSave1Button()
	 .verifycoursecreated(Titledata1);

	}
}
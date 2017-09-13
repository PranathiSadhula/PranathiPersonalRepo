package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class CreationOfContentCourseByQuiz extends LearnexaWrappers{
	
	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC004 Create Content And Course By Quiz";
		testDescription = "Creation of Content and then course using the content by Quiz";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test(dataProvider="fetchData")
	public  void createcontent(String userName,String password) throws InterruptedException, AWTException {
		String allowdchrs = "123456789";
		String Titledata = "Testing Content By Quiz automation" + RandomStringUtils.random(2, allowdchrs);
		String Titledata1 = "Testing Course By Quiz automation" + RandomStringUtils.random(1, allowdchrs);
		new LoginPage (driver,test)
		 .login1()
	 //.closePopup()
	 .clickContent()
	 .clickCreateContent()
	 .clickContentQuiz()
	 .clickOnMultipleQuestion()
	 .typeQuestion()
	 .typeAnswers()
	 .courseTitle(Titledata)
	 .saveButton(Titledata)
	 .clickcoursetab()
	 .clickCreateCourse()
	 .clickQuiz()
	 .clickcheckBox()
	 .clickApply()
	 .clickCourseTitle(Titledata1)
	 .clickDescription()
	 .enterMaximumAttempts()
	 .clickPassingScroes()
	 .clickSave1Button()
	 ;
	}

	

}

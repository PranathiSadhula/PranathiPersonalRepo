package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class CreationOfCertificationFromCatalog extends LearnexaWrappers {
	
	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC017 Create Quiz Content And Create a Certitifcation";
		testDescription = "Create Quiz Content And Create a Certitifcation";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test(dataProvider="fetchData")
	public  void createcontent(String userName,String password) throws InterruptedException, AWTException {
		String allowdchrs = "1234567890";
		String Titledata = "Testing certificate creation from catalog" + RandomStringUtils.random(2, allowdchrs);
		String Titledata1 = "Testing certificate creation from catalog" + RandomStringUtils.random(1, allowdchrs);
		String Percentage =RandomStringUtils.random(2, allowdchrs);
		new LoginPage (driver,test)
	  .login1()
	 //.closePopup()
	/* .clickContent()
	 .clickCreateContent()
	 .clickContentQuiz()
	 .clickOnMultipleQuestion()
	 .typeQuestion()
	 .typeAnswers()
	 .courseTitle(Titledata)
	 .saveButton(Titledata)*/
	 .clickCatalog()
	 .clickCreateCeritification()
	 .AddButton()
	 //.searchCreatedContent(Titledata)
	 .checkBox() 
	 .clickApply()
	 .clickCourseTitle(Titledata1)
	 .clickPassingScroes()
	 //.enterMaximumAttempts()
	 .clickSave2Button()
	 ;
	}		

}

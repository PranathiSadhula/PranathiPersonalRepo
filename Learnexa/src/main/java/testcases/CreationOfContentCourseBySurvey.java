package testcases;

	import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

	import pages.LoginPage;
	import wrappers.LearnexaWrappers;

	public class CreationOfContentCourseBySurvey extends LearnexaWrappers{
		
		@Parameters("browser")
		@BeforeClass
		public void setValues(String browser) {
			browserName = browser;
			testCaseName = "TC005 Create Content And Course By Survey";
			testDescription = "Creation of Content and then course using the content by Survey";
			category="Sanity";
			dataSheetName = "TC001";
		}
		
		@Test(dataProvider="fetchData")
		public  void createcontent(String userName,String password) throws InterruptedException, AWTException {
			String allowdchrs = "123456789";
			String Titledata = "Testing Content By Survey automation" + RandomStringUtils.random(2, allowdchrs);
			String Titledata1 = "Testing Course By Survey automation" + RandomStringUtils.random(1, allowdchrs);
		new LoginPage (driver,test)
		 .login1( )
		 //.closePopup()
		 .clickContent()
		 .clickCreateContent()
		 .clickSurvey()
		 .clickOnSingleQuestion()
		 .applyButton()
		 .courseTitle(Titledata)
		 .saveButton(Titledata)
		 .clickcoursetab()
		 .clickCreateCourse()
		 .clickSurveybutton()
		 .clickcheckBox()
		 .clickApply()
		 .clickCourseTitle(Titledata1)
		 .clickDescription()
		 //.checkPrice()
		 .clickSave1Button(Titledata1)
		  ;
		}

		
}

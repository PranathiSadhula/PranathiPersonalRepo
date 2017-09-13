package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class CreationOfBundleFromCatalog extends LearnexaWrappers {
	
	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC0018 Creation of Bundle from Catalog";
		testDescription = "Creation of Content and then course using the content by Quiz";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test(dataProvider="fetchData")
	public  void createcontent(String userName,String password) throws InterruptedException, AWTException {
		String allowdchrs = "1234567890";
		String Titledata = "Testing creation of Bundle" + RandomStringUtils.random(2, allowdchrs);
		String Titledata1 = "Testing creation of Bundle from Catalog" + RandomStringUtils.random(1, allowdchrs);
		
		new LoginPage (driver,test)
	  .login1( )
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
	 .clickCreateBundle() 
	 .clickAddButton()
	 //.clickSearch(Titledata)
	 .clickcheckBox() 
	 .clickApply()
	 .clickCourseTitle(Titledata1)
	 .clickDescription() 
	 .clickSave1Button()
	 ;

	}
}


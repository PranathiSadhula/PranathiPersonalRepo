package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class CreationOfContentCourseByDocument extends LearnexaWrappers{
	
	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC002 Course creation By Document By My learning";
		testDescription = "Creation of Content and then course By Document and Updating the Course";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test()
	public void testcases() throws InterruptedException, AWTException {
	//System.out.println(userName + ":::" + password);
	
	String allowdchrs = "123456789";
	String UserName="radham@expertus.com";
	String Titledata = "Testing Content By Document automation" + RandomStringUtils.random(2, allowdchrs);
	String Titledata1 = "Testing Content By Document automation" + RandomStringUtils.random(1, allowdchrs);
	String Titledata2 = RandomStringUtils.random(1, allowdchrs);
	String Titledata3 = "Testing Content By Document automation";
	
	
	new LoginPage (driver,test)
	 .enterUserName()
	 .enterPassword()
	 .clickSubmit()
	 .clickcoursetab()
	 .clickCreateCourse()
	 .clickCourseDocumentation()
	 .createContent()
	 .clickUpload() 
	 .enterTitle(Titledata)
	 .clickSaveButton()
	 .clickApply()
	 .clickCourseTitle(Titledata1)
	 .clickDescription()
	 //.checkPrice(Titledata2)
	 .clickSave1Button()
	 .verifycoursecreated1(Titledata1)
	 /*.clickCatalogMenu()
	 .enterText(Titledata3)																													
	 .AddToCart()
	 .clickPay()
	 .switchframes()
	 .cardNumber()
	 .MonthYearCVV()
	  .BillingAddress()
	  .country()
	  .NextButton()
	  .emailaddress(sPAYMENTEMAIL)*/
	 	  ;
	}

	


}

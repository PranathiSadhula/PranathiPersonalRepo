package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class Paymentschecking extends LearnexaWrappers {
	
	@Parameters("browser")
	@BeforeClass
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC019 Payments";
		testDescription = "Payments";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test(dataProvider="fetchData")
	public  void createcontent(String userName,String password) throws InterruptedException, AWTException {
		String allowdchrs = "123456789";
		String Titledata = "Testing Payments checking" + RandomStringUtils.random(2, allowdchrs);
		String Titledata1="Testing Payments checking" + RandomStringUtils.random(1, allowdchrs);
		String email="radham@expertus.com";
		
		new LoginPage (driver,test)
		 .enterUserName()
		 .login1()
		 //.closePopup()
		 .clickContent()
		 .clickCreateContent()
		 .clickContentPresentation()
		 .clickUpload()
		 .enterTitle(Titledata)
		 .clickSaveButton()
		 .verifycontentcreated(Titledata)
		 .clickcoursetab()
		 .clickCreateCourse()
		 .clickCoursePresentaion()
		 .searchCreatedContent(Titledata)
		 .clickcheckBox()
		 .clickApply()
		 .clickCourseTitle(Titledata1)
		 .clickDescription()
		 .checkPrice()
		 .clickSave1Button()
		 .verifycoursecreated(Titledata1)
		 .clickCatalogMenu()
		 .enterText(Titledata1)
		 .AddToCart()
		 .clickPay()
		 .switchframes()
		 .cardNumber()
		 .MonthYearCVV()
		  .BillingAddress()
		  .country()
		  .NextButton()
		  .emailaddress(email)
		  //.verifyPaymentMsg()
		  //.goToLearningNow()
		 // .VerifyContent(Titledata1)	
		  /*.mouseovermenu()
		  .viewReceipts()
		  .verifyemail()*/
		 ;
	}
}


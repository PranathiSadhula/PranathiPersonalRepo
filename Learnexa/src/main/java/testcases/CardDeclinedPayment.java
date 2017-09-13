package testcases;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import wrappers.LearnexaWrappers;

public class CardDeclinedPayment extends LearnexaWrappers{
	
	@Parameters("browser")
	@BeforeClass
	
	public void setValues(String browser) {
		browserName = browser;
		testCaseName = "TC026 Card Declined Payment - 6.61";
		testDescription = "Creation of course and checking for Card Declined Payment - 6.61";
		category="Sanity";
		dataSheetName = "TC001";
	}
	
	@Test(dataProvider="fetchData")
	public  void createcontent(String userName,String password) throws InterruptedException, AWTException {
	System.out.println(userName + ":::" + password);
	
	String allowdchrs = "123456789";
	String Titledata = "Testing" + RandomStringUtils.random(2, allowdchrs);
	/*String Titledata1 = "Testing Content By Document automation" + RandomStringUtils.random(1, allowdchrs);
	String Titledata2 = RandomStringUtils.random(1, allowdchrs);*/
    String Titledata3 = "Testing";
	
	
	
	new LoginPage (driver,test)
	 .enterUserName()
	 .login1()
	 .clickCreateCourse1()
	 .clickPresentationContent()
	 .clickselectItem()
     .clickApply()
     .clickCourseTitle()
     .clickDescription()
     .clickPriceButton1(Titledata)
     .clickSave1Button()
     .clickCatalogMenu()
	 .enterText(Titledata3)
	 .AddToCart()
	 .clickPay()
	 .switchframes()
	 .cardNumber()
	 .MonthYearCVV()
	 .BillingAddress()
	 .country()
	 .NextButton()
	 .emailaddress(sPAYMENTEMAIL)
	 ;
}
}
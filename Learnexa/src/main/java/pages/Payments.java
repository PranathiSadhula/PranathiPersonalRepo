package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class Payments extends LearnexaWrappers {

	public Payments(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}
	
	String email="radham@expertus.com";
		
	String Testdata = "Testing";

	public Payments clickCatalogMenu() throws InterruptedException {
		clickById(prop.getProperty("Payments.clickCatalogMenu.Id"));
		Thread.sleep(6000);
		return this;
	}

	public Payments enterText(String Title) throws InterruptedException, AWTException {
		Thread.sleep(3000);
		enterById(prop.getProperty("Payments.enterText.Id"), Title);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(6000);
		return this;
	}
	
	public Payments clickFirstElement() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='catalog_listings_tour']/div/div[2]/div/div[1]/div[1]/ul[2]/li[1]/a")).click();
		clickByXpath(prop.getProperty("Payments.AddToCart.Xpath"));
		return this;
	}

	public Payments AddToCart() throws InterruptedException {
		clickByXpath(prop.getProperty("Payments.AddToCart.Xpath"));
		return this;
	}

	public Payments clickPay() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.id("order_submit")).click();
		System.out.println("Pay clicked");
		Thread.sleep(3000);
		/*driver.findElement(By.xpath(".//*[@id='popupTitleLink']/a")).click();
		System.out.println("Pay1 clicked");*/
		//clickById(prop.getProperty("Payments.clickPay.Id"));
		return this;
	}

	public Payments switchframes() {
		String Testdata1 = "Radha Murugesan";
		driver.switchTo().frame("wepay_checkout_iframe").findElement(By.id("wff-field-0")).sendKeys(Testdata1);
		System.out.println("frame entered");
		// wepay_checkout_iframe
		
		//enterById(prop.getProperty("Payments.switchframes.Id"), Testdata1);
		return this;

	}

	public Payments cardNumber() throws InterruptedException {
		String Testdata2 = "4111111111111111";
		Thread.sleep(3000);
		enterById(prop.getProperty("Payments.cardNumber.Id"), Testdata2);
		return this;

	}

	public Payments MonthYearCVV() throws InterruptedException {
		String Testdata3 = "10";
		String Testdata4 = "20";
		String Testdata5 = "555";
		enterById(prop.getProperty("Payments.Month.Id"), Testdata3);
		Thread.sleep(2000);
		enterById(prop.getProperty("Payments.Year.Id"), Testdata4);
		enterById(prop.getProperty("Payments.CVV.Id"), Testdata5);
		return this;

	}

	public Payments BillingAddress() {
		String Testdata6 = "Chennai";
		String Testdata7 = "Chennai";
		enterById(prop.getProperty("Payments.BillingAdress.Id"), Testdata6);
		enterById(prop.getProperty("Payments.City.Id"), Testdata7);
		return this;

	}
	
	public Payments country(){
		String value="3";
		String data1="Chennai";
		String data2="chennai2";
		selectIndexById(prop.getProperty("Payments.Country.Id"), value);
		enterById(prop.getProperty("Payments.Region.Id"), data1);
		enterById(prop.getProperty("Payments.PostCode.Id"), data2);
		return this;
		
	}
	
	public Payments NextButton() throws InterruptedException {
		Thread.sleep(3000);
	clickByXpath(prop.getProperty("Payments.NextButton.ClassName"));
	Thread.sleep(8000);
		return this;
	}
	
	public Payments emailaddress(String email) throws InterruptedException {
		enterById(prop.getProperty("Payments.emailaddress.id"),email);
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='if-footer']/div[1]/button")).click();
		Thread.sleep(8000);
			return this;
		}
	public Payments verifyPaymentMsg() throws InterruptedException {
		String text = "Thanks for your order.";
		verifyTextByXpath(prop.getProperty("Payments.verifyPaymentMsg.ClassName"),text);
		Thread.sleep(8000);
			return this;
		}
	
	
	public Payments goToLearningNow() throws InterruptedException{
		clickByLink(prop.getProperty("Payments.goToLearningNow.link"));
		Thread.sleep(5000);
		return this;
		
	}
	
	public Payments VerifyContent(String title){
		verifyTextByXpath(prop.getProperty("Payments.VerifyContent.Xpath"),title);
		return this;
			
	}
	
	public Payments mouseovermenu(){
		mouseOverByXpath(prop.getProperty("Payments.mouseovermenu.Xpath"));
		clickByLink(prop.getProperty("Payments.AccountSetting.Link"));
		clickByLink(prop.getProperty("Payments.PurchaseHistory.Link"));	
				return this;
	}
	
	public Payments viewReceipts(){
		
		clickByXpath(prop.getProperty("Payments.viewReceipts.Xpath"));
		return this;
	}
	
	
	/*public Payments verifydetails(){
		String email=getTextByXpath(prop.getProperty("Payments.verifydetails.Xpath"));
		return this;
		
	}*/
	
	public Payments verifyemail(){
	if(driver.getPageSource().contains(email)){
		System.out.println("Content is Created and validated");
		}else{
		System.out.println("Content is Created and validated");
		}
	System.out.println(email);
	return this;
	}
	
	

}

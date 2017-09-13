package pages;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.KeyEvent;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.sikuli.script.Key;
	import org.sikuli.script.Screen;

	import com.relevantcodes.extentreports.ExtentTest;

	import wrappers.LearnexaWrappers;

	public class CardDeclinedPayment extends LearnexaWrappers {
		
		public CardDeclinedPayment(RemoteWebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;

		}
		
		//click on Course button
		public CardDeclinedPayment clickCreateCourseButton()
		{
			clickByXpath(prop.getProperty("CreateCourseByPresentation.clickPresentaion.Xpath"));
			return this;
		}
		
		//Click on Presentation 
		
		public CardDeclinedPayment clickPresentationContent()
		{
			clickByXpath(prop.getProperty("NegativePaymentFlow.clickPresentationContent.Xpath"));
			return this;
		}
		
	    //Select an item from content picker panel
		public CardDeclinedPayment clickselectItem()
		{
			clickByXpath(prop.getProperty("NegativePaymentFlow.clickselectItem.Xpath"));
			return this;
		}
		
		//Click on Apply button
		public CardDeclinedPayment clickApply() throws InterruptedException
		{
			Thread.sleep(4000);
			WebElement element = driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()", element);
			Thread.sleep(4000);
			//clickByXpath(prop.getProperty("NegativePaymentFlow.clickApply.Xpath"));
			return this;
		}
		
		
		
		
		//Click on Course title
		public CardDeclinedPayment clickCourseTitle() throws InterruptedException
		{
			Thread.sleep(4000);
			enterById(prop.getProperty("NegativePaymentFlow.clickApply.Id"), Titledata);
			return this;
		}
		
		//Click on Description
			/*public NegativePaymentFlow clickDescription()
			{
				String Descriptionvalue = "Testing";
				enterById(prop.getProperty("NegativePaymentFlow.clickDescription.Id"), Descriptionvalue);
				return this;
			}*/
			
		public CardDeclinedPayment clickDescription() throws InterruptedException {
			driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys("Testing Automation");
			Thread.sleep(4000);
			driver.switchTo().parentFrame();
			return this;
		}
		
			//Click on Price radio button
			public CardDeclinedPayment clickPriceButton1(String Title) throws InterruptedException
			{
				Thread.sleep(4000);
				String pricevalue="6.61";
				enterById(prop.getProperty("CreateCourseByPresentation.checkPrice1.Id"), pricevalue);
				Thread.sleep(4000);
				clickById(prop.getProperty("CreateCourseByPresentation.checkPrice.Id"));
				
				/*public CreateCourseByDocumentation checkPrice(String Title) {
					clickById(prop.getProperty("CreateCourseByDocumentation.checkPrice.Id"));
					enterById(prop.getProperty("CreateCourseByDocumentation.checkPrice1.Id"), Title);
					return new CreateCourseByDocumentation(driver, test);
				}*/
				
				
				return this;
			}
			
			//Click on Save button
			
			public CardDeclinedPayment clickSave1Button() throws InterruptedException {

				clickByXpath(prop.getProperty("HomePage.clickSave1Button.Xpath"));
				Thread.sleep(5000);
				return new CardDeclinedPayment(driver, test);
			
			
			}		
			
				public CardDeclinedPayment clickCatalogMenu() throws InterruptedException {
					Thread.sleep(3000);
					clickById(prop.getProperty("Payments.clickCatalogMenu.Id"));
					Thread.sleep(6000);
					return this;
				}
				
				public CardDeclinedPayment enterText(String Title) throws InterruptedException, AWTException {
					enterById(prop.getProperty("Payments.enterText.Id"), Title);
					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_ENTER);
					r.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(6000);
					return this;
				}		
				
				public CardDeclinedPayment AddToCart() throws InterruptedException {
					clickByXpath(prop.getProperty("Payments.AddToCart.Xpath"));
					return this;
				}
				
				public CardDeclinedPayment clickPay() throws InterruptedException {
					Thread.sleep(4000);
					driver.findElement(By.id("order_submit")).click();
					System.out.println("Pay clicked");
					Thread.sleep(3000);
					/*driver.findElement(By.xpath(".//*[@id='popupTitleLink']/a")).click();
					System.out.println("Pay1 clicked");*/
					//clickById(prop.getProperty("Payments.clickPay.Id"));
					return this;
				}
				
				public CardDeclinedPayment switchframes() {
					String Testdata1 = "Divya S";
					driver.switchTo().frame("wepay_checkout_iframe").findElement(By.id("wff-field-0")).sendKeys(Testdata1);
					System.out.println("frame entered");
					// wepay_checkout_iframe
					
					//enterById(prop.getProperty("Payments.switchframes.Id"), Testdata1);
					return this;

				}
				
				public CardDeclinedPayment cardNumber() throws InterruptedException {
					String Testdata2 = "4111111111111111";
					Thread.sleep(3000);
					enterById(prop.getProperty("Payments.cardNumber.Id"), Testdata2);
					return this;

				}
				
				public CardDeclinedPayment MonthYearCVV() throws InterruptedException {
					String Testdata3 = "10";
					String Testdata4 = "20";
					String Testdata5 = "555";
					enterById(prop.getProperty("Payments.Month.Id"), Testdata3);
					Thread.sleep(2000);
					enterById(prop.getProperty("Payments.Year.Id"), Testdata4);
					enterById(prop.getProperty("Payments.CVV.Id"), Testdata5);
					return this;

				}

				public CardDeclinedPayment BillingAddress() {
					String Testdata6 = "Chennai";
					String Testdata7 = "Chennai";
					enterById(prop.getProperty("Payments.BillingAdress.Id"), Testdata6);
					enterById(prop.getProperty("Payments.City.Id"), Testdata7);
					return this;

				}
				
				public CardDeclinedPayment country(){
					String value="3";
					String data1="Chennai";
					String data2="chennai2";
					selectIndexById(prop.getProperty("Payments.Country.Id"), value);
					enterById(prop.getProperty("Payments.Region.Id"), data1);
					enterById(prop.getProperty("Payments.PostCode.Id"), data2);
					return this;
					
				}
				
				public CardDeclinedPayment clickPriceButton2(String Title) throws InterruptedException
				{
					Thread.sleep(4000);
					String pricevalue="9.61";
					enterById(prop.getProperty("CreateCourseByPresentation.checkPrice1.Id"), pricevalue);
					Thread.sleep(4000);
					clickById(prop.getProperty("CreateCourseByPresentation.checkPrice.Id"));
					
					/*public CreateCourseByDocumentation checkPrice(String Title) {
						clickById(prop.getProperty("CreateCourseByDocumentation.checkPrice.Id"));
						enterById(prop.getProperty("CreateCourseByDocumentation.checkPrice1.Id"), Title);
						return new CreateCourseByDocumentation(driver, test);
					}*/
								
					return this;
				}
		
				
				public CardDeclinedPayment NextButton() throws InterruptedException {
					Thread.sleep(3000);
				clickByXpath(prop.getProperty("Payments.NextButton.ClassName"));
				Thread.sleep(8000);
					return this;
				}
				
				public CardDeclinedPayment emailaddress(String email) throws InterruptedException {
					enterById(prop.getProperty("Payments.emailaddress.id"),email);
					Thread.sleep(3000);
					driver.findElement(By.xpath(".//*[@id='if-footer']/div[1]/button")).click();
					Thread.sleep(8000);
						return this;
					}

				public CreateCourseByPresentation clickPriceButton(String titledata) {
					// TODO Auto-generated method stub
					return null;
				}

				
	}

package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mongodb.operation.FindAndDeleteOperation;

import utils.Reporter;

public class GenericWrappers extends Reporter implements Wrappers {

	public static RemoteWebDriver driver;
	public static RemoteWebDriver driver1;
	protected static Properties prop;
	
	public static String sUrl;
	public static String sTESTDATA3;
	public String primaryWindowHandle;
	public String sHubUrl;
	public String sPAYMENTEMAIL;
	public String sHubPort;
	public static String sUserName;
	public static String sUserName1;
	public static String sPassword;
	public static String sPassword1;
	public static String sChromiumDriver;
	public String sTESTDATATIN;
	public String sTESTDATA1;
	public  static String sChromiumDriver1;
	public String sTESTDATAAUDIO;
	public String sOBJPRO;
	public String sTESTDATASCORM;
	public String sTESTDATAPRESENTATION;
	public String sTESTDATADESCRIPTION;
	public String sTESTDATAVIDEOEMBEDED;
	public static String sCONFIGPRO;
	WebDriverWait wait;
	
	public WebElement talkbox;
	public WebElement chatlog;
	public WebElement sendbutton;
	
	

	public String allowdchrs1 = "123456789";
	public String Titledata = "TESTING" + RandomStringUtils.random(2, allowdchrs1);
	public String Titledata1= "TESTING" + RandomStringUtils.random(1, allowdchrs1);
	public String Titledata2 = RandomStringUtils.random(1, allowdchrs1);
	
	public GenericWrappers() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("/home/user/workspace/Learnexa/src/main/java/resources/config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sOBJPRO =  prop.getProperty("OBJPRO");
			sUrl = prop.getProperty("URL");
			sTESTDATA3 = prop.getProperty("TESTDATA3");
			sTESTDATADESCRIPTION= prop.getProperty("TESTDATADESCRIPTION");
			sUserName = prop.getProperty("USERNAME");
			sPassword=prop.getProperty("PASSWORD");
			sUserName1 = prop.getProperty("USERNAME1");
			sCONFIGPRO = prop.getProperty("CONFIGPRO");
			sPAYMENTEMAIL=prop.getProperty("PAYMENTEMAIL");
			sPassword1=prop.getProperty("PASSWORD1");
			sChromiumDriver1=sChromiumDriver=prop.getProperty("CHROMIUMDRIVER1");
			sTESTDATA1=prop.getProperty("TESTDATA1");
			sChromiumDriver=prop.getProperty("CHROMIUMDRIVER");
			sTESTDATASCORM=prop.getProperty("TESTDATASCORM");
			sTESTDATATIN=prop.getProperty("TESTDATATIN");
			sTESTDATAAUDIO=prop.getProperty("TESTDATAAUDIO");
			sTESTDATAPRESENTATION=prop.getProperty("TESTDATAPRESENTATION");
			sTESTDATAVIDEOEMBEDED=prop.getProperty("TESTDATAVIDEOEMBEDED");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadObjects() {
		prop = new Properties();
		try {

			// D:\Public\workspace\BDTVVPOM\src\main\resources\object.properties
			prop.load(new FileInputStream(
					new File(sOBJPRO)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void unloadObjects() {
		prop = null;
	}

	/**
	 * This method will launch the browser in local machine and maximise the
	 * browser and set the wait for 30 seconds and load the url
	 *  @param url
	 *            - The url with http or https
	 * 
	 */
	public void invokeApp(String browser) {
		invokeApp(browser, false);
	}

	/**
	 * This method will launch the browser in grid node (if remote) and maximise
	 * the browser and set the wait for 30 seconds and load the url
	 * @param url
	 * - The url with http or https
	 * 
	 */
	public void invokeApp(String browser, boolean bRemote) {
		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.ANY);

			// this is for grid run
			if (bRemote)
				driver = new RemoteWebDriver(new URL("http://" + sHubUrl + ":" + sHubPort + "/wd/hub"), dc);
			else { // this is for local run
				if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", sChromiumDriver);
					ChromeOptions options = new ChromeOptions();
					//options.addArguments("--disable-extensions");
					driver = new ChromeDriver(options);
					//driver1= new ChromeDriver(options);
					/*
					var chromeOptions = new ChromeOptions();
					chromeOptions.AddArgument("--verbose");
					ChromeDriverService chromeDriverService = ChromeDriverService.CreateDefaultService("C:\\chromedriver");
					chromeDriverService.LogPath = "C:\\thelog.log";
					ChromeDriver driver = new ChromeDriver(chromeDriverService, chromeOptions);*/

				} else if (browser.equalsIgnoreCase("ie")) {

					System.setProperty("webdriver.ie.driver",
							"D:\\Public\\workspace\\drivers\\IEDriverServer_Win32_2.53.1\\IEDriverServer.exe");
					/*dc = DesiredCapabilities.internetExplorer();
					dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

					dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);*/
					// WebDriver driver =new FirefoxDriver(dc);

					/*driver = new InternetExplorerDriver(dc);*/

					// options.addArguments("--disable-extensions");
					// driver = new InternetExplorerDriver();

				} else 

				{
					
					System.setProperty("webdriver.gecko.driver", "/home/user/geckodriver");
					FirefoxProfile profile = new FirefoxProfile();
					
					// This will set the true value
					driver = new FirefoxDriver(profile);
									
					
					/*System.setProperty("webdriver.gecko.driver",
							"/home/user/geckodriver (2)");
					FirefoxProfile profile = new FirefoxProfile();
					DesiredCapabilities dc1 = DesiredCapabilities.firefox();
					dc1.setCapability(FirefoxDriver.PROFILE, profile);
					dc1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

					profile.setAcceptUntrustedCertificates(true);

					
									dc = DesiredCapabilities.firefox();
					dc.setCapability("marionette", true);
					//dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					
					//dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
						ProfilesIni prof = new ProfilesIni();				
							FirefoxProfile ffProfile= prof.getProfile ("myProfile");
							ffProfile.setAcceptUntrustedCertificates(true);
							ffProfile.setAssumeUntrustedCertificateIssuer(false);
					driver = new FirefoxDriver(dc);*/
				}

				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get(sUrl);
			/*	driver1.get(sUrl);*/
				wait = new WebDriverWait(driver, 50);
				primaryWindowHandle = driver.getWindowHandle();
				reportStep("The browser:" + browser + " launched successfully", "PASS");
				System.out.println("Sucess");

			}
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("The browser:" + browser + " could not be launched", "FAIL");
		}
	}

	/**
	 * This method will enter the value to the text field using id attribute to
	 * locate
	 * 
	 * @param idValue
	 *            - id of the webelement
	 * @param data
	 *            - The data to be sent to the webelement
	 * @throws IOException
	 * @throws COSVisitorException
	 */
	public void enterById(String idValue, String data) {
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);
			reportStep("The data: " + data + " entered successfully in field :" + idValue, "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data: " + data + " could not be entered in the field :" + idValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering " + data + " in the field :" + idValue, "FAIL");
		}
	}

	/**
	 * This method will enter the value to the text field using name attribute
	 * to locate
	 * 
	 * @param nameValue
	 *            - name of the webelement
	 * @param data
	 *            - The data to be sent to the webelement
	 * @throws IOException
	 * @throws COSVisitorException
	 */
	public void enterByName(String nameValue, String data) {
		try {
			// driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);
			reportStep("The data: " + data + " entered successfully in field :" + nameValue, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: " + data + " could not be entered in the field :" + nameValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering " + data + " in the field :" + nameValue, "FAIL");
		}

	}

	/**
	 * This method will enter the value to the text field using name attribute
	 * to locate
	 * 
	 * @param xpathValue
	 *            - xpathValue of the webelement
	 * @param data
	 *            - The data to be sent to the webelement
	 * @throws IOException
	 * @throws COSVisitorException
	 */
	public void enterByXpath(String xpathValue, String data) {
		try {
			// driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);
			reportStep("The data: " + data + " entered successfully in field :" + xpathValue, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: " + data + " could not be entered in the field :" + xpathValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering " + data + " in the field :" + xpathValue, "FAIL");
		}

	}

	/**
	 * This method will verify the title of the browser
	 * 
	 * @param title
	 *            - The expected title of the browser
	 */
	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		try {
			if (driver.getTitle().equalsIgnoreCase(title)) {
				reportStep("The title of the page matches with the value :" + title, "PASS");
				bReturn = true;
			} else
				reportStep("The title of the page:" + driver.getTitle() + " did not match with the value :" + title,
						"SUCCESS");

		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will verify the given text matches in the element text
	 * 
	 * @param xpath
	 *            - The locator of the object in xpath
	 * @param text
	 *            - The text to be verified
	 */
	public void verifyTextByXpath(String xpath, String text) {
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.equalsIgnoreCase(text)) {
				reportStep("The text: " + sText + " matches with the value :" + text, "PASS");
			} else {
				reportStep("The text: " + sText + " did not match with the value :" + text, "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * 
	 * @param xpath
	 *            - The locator of the object in xpath
	 * @param text
	 *            - The text to be verified
	 */
	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)) {
				reportStep("The text: " + sText + " contains the value :" + text, "PASS");
			} else {
				reportStep("The text: " + sText + " did not contain the value :" + text, "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * 
	 * @param id
	 *            - The locator of the object in id
	 * @param text
	 *            - The text to be verified
	 */
	public void verifyTextById(String id, String text) {
		try {
			String sText = driver.findElementById(id).getText();
			if (sText.equalsIgnoreCase(text)) {
				reportStep("The text: " + sText + " matches with the value :" + text, "PASS");
			} else {
				reportStep("The text: " + sText + " did not match with the value :" + text, "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * 
	 * @param id
	 *            - The locator of the object in id
	 * @param text
	 *            - The text to be verified
	 */
	public void verifyTextContainsById(String id, String text) {
		try {
			String sText = driver.findElementById(id).getText();
			if (sText.contains(text)) {
				reportStep("The text: " + sText + " contains the value :" + text, "PASS");
			} else {
				reportStep("The text: " + sText + " did not contain the value :" + text, "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	/**
	 * This method will close all the browsers
	 */
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			reportStep("The browser:" + driver.getCapabilities().getBrowserName() + " could not be closed.", "FAIL");
		}

	}

	/**
	 * This method will click the element using id as locator
	 * 
	 * @param id
	 *            The id (locator) of the element to be clicked
	 */
	public void clickById(String id) {
		try {
			driver.findElement(By.id(id)).click();
			reportStep("The element with id: " + id + " is clicked.", "PASS");

		} catch (Exception e) {
			reportStep("The element with id: " + id + " could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using id as locator
	 * 
	 * @param id
	 *            The id (locator) of the element to be clicked
	 */
	public void clickByClassName(String classVal) {
		try {
			driver.findElement(By.className(classVal)).click();
			reportStep("The element with class Name: " + classVal + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with class Name: " + classVal + " could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using name as locator
	 * 
	 * @param name
	 *            The name (locator) of the element to be clicked
	 */
	public void clickByName(String name) {
		try {
			driver.findElement(By.name(name)).click();
			reportStep("The element with name: " + name + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with name: " + name + " could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using link name as locator
	 * 
	 * @param name
	 *            The link name (locator) of the element to be clicked
	 * @param data
	 */
	public void clickByLink(String name, String data) {
		try {
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with link name: " + name + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with link name: " + name + " could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using xpath as locator
	 * 
	 * @param xpathVal
	 *            The xpath (locator) of the element to be clicked
	 */
	public void clickByXpath(String xpathVal) {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 3 );
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			reportStep("The element : "+xpathVal+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
	}
	
	
	
	
	//Actions action = new Actions(driver);
    //action.sendKeys(Keys.PAGE_UP);
	public void clickByXpathWithoutSnapshot(String xpathVal){
		
		try {
			driver.findElement(By.xpath(xpathVal)).click();
			System.out.println("The element is clicked");
			} catch (Exception e) {
			System.out.println("The element is not clicked");
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * This method will mouse over on the element using xpath as locator
	 * 
	 * @param xpathVal
	 *            The xpath (locator) of the element to be moused over
	 */
	public void mouseOverByXpath(String xpathVal) {
		try {
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			reportStep("The mouse over by xpath : " + xpathVal + " is performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by xpath : " + xpathVal + " could not be performed.", "FAIL");
		}
	}

	public void ActionClickByXpath(String xpathVal) {
			try {
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).click().build().perform();
			reportStep("The mouse over by xpath : " + xpathVal + " is performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by xpath : " + xpathVal + " could not be performed.", "FAIL");
		}
	}

	/**
	 * This method will mouse over on the element using link name as locator
	 * 
	 * @param xpathVal
	 *            The link name (locator) of the element to be moused over
	 */
	public void mouseOverByLinkText(String linkName) {
		try {
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			reportStep("The mouse over by link : " + linkName + " is performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by link : " + linkName + " could not be performed.", "FAIL");
		}
	}

	/**
	 * This method will return the text of the element using xpath as locator
	 * 
	 * @param xpathVal
	 *            The xpath (locator) of the element
	 */
	public String getTextByXpath(String xpathVal) {
		String bReturn = "";
		try {
			return driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			reportStep("The element with xpath: " + xpathVal + " could not be found.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will return the text of the element using id as locator
	 * 
	 * @param xpathVal
	 *            The id (locator) of the element
	 */
	public String getTextById(String idVal) {
		String bReturn = "";
		try {
			return driver.findElementById(idVal).getText();
		} catch (Exception e) {
			reportStep("The element with id: " + idVal + " could not be found.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will select the drop down value using id as locator
	 * 
	 * @param id
	 *            The id (locator) of the drop down element
	 * @param value
	 *            The value to be selected (visibletext) from the 
	 */
	public void selectVisibileTextById(String id, String value) {
		try {
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);
			;
			reportStep("The element with id: " + id + " is selected with value :" + value, "PASS");
		} catch (Exception e) {
			reportStep("The value: " + value + " could not be selected.", "FAIL");
		}
	}

	public void selectIndexByName(String name, String value) {
		try {
			new Select(driver.findElement(By.name(name))).selectByIndex(Integer.parseInt(value));
			reportStep("The element with name: " + name + " is selected with Index: " + value, "Pass");

		} catch (NumberFormatException e) {
			reportStep("The index: " + value + " could not be selected.", "FAIL");// TODO
																					// Auto-generated
																					// catch
																					// block
		}

	}

	public void selectVisibileTextByXPath(String xpath, String value) {
		try {
			new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(value);
			;
			reportStep("The element with xpath: " + xpath + " is selected with value :" + value, "PASS");
		} catch (Exception e) {
			reportStep("The value: " + value + " could not be selected.", "FAIL");
		}
	}

	public void selectIndexById(String id, String value) {
		try {
			new Select(driver.findElement(By.id(id))).selectByIndex(Integer.parseInt(value));
			reportStep("The element with id: " + id + " is selected with index :" + value, "PASS");
		} catch (Exception e) {
			reportStep("The index: " + value + " could not be selected.", "FAIL");
		}
	}
	
	public void selectIndexByXpath(String xpath, String value) {
		try {
			new Select(driver.findElement(By.xpath(xpath))).selectByIndex(Integer.parseInt(value));
			reportStep("The element with id: " + xpath + " is selected with index :" + value, "PASS");
		} catch (Exception e) {
			reportStep("The index: " + value + " could not be selected.", "FAIL");
		}
	}

	public static String generateRandomAlphaNumeric(int length) {

		String allowdchrs1 = "abcdefghjklmnprstuvwxyz" + "1234567890";
		return RandomStringUtils.random(length, allowdchrs1);

	}

	public void switchtoframebyXpath(String xpathvalue) {

		try {
			System.out.println("value: " + xpathvalue);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//driver.switchTo().frame(1);
			WebElement frameele = driver.findElement(By.xpath(xpathvalue));
			driver.switchTo().frame(frameele);
			reportStep("The frame with xpath: " + xpathvalue + "is selected", "Pass");
		} catch (WebDriverException e) {
			reportStep("The frame with xpath: " + xpathvalue + "is not  selected", "Fail");
			e.printStackTrace();
		}

	}

	public void switchToParentWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
				break;
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the first window.", "FAIL");
		}
	}

	public void switchToLastWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the last window.", "FAIL");
		}
	}

	public void switchToLastWindow(int totalWindowExpected) {
		try {
			// wait.until(ExpectedConditions.numberOfWindowsToBe(totalWindowExpected));
			Set<String> windowhandleSet = driver.getWindowHandles();
			System.out.println("count of opened windows :" + windowhandleSet.size());
			for (String windowhandle : windowhandleSet) {
				// System.out.println("navigating windows :" + windowhandle);
				driver.switchTo().window(windowhandle);
			}
			System.out.println("control is switched to last window");
		} catch (NoSuchWindowException e) {
			System.out.println("Exception occured while switching window  " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.out.println("The Browser could not be found " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.out.println("Unexpected exception in switching to Last Window:" + e.getMessage());
			throw new RuntimeException("FAILED");
		} finally {
			takeSnap();
		}
	}
	
	public boolean isAlertPresent(){
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(driver, 5 /*timeout in seconds*/);
        try {    
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
            driver.switchTo().alert().accept();
        } catch (TimeoutException eTO) {
            foundAlert = false;
        }
        return foundAlert;
    }


	

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}

	}
	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),
					new File("./reports/images/" + number + ".jpg"));
		} catch (WebDriverException e) {
			reportStep("The browser has been closed.", "FAIL");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "WARN");
		}
		return number;
	}

	public void verifyTextByClassName(String ClassName, String text) {
		try {
			String actualText = driver.findElementByClassName(ClassName).getText();
			if (actualText.equals(text)) {
				System.out.println("The verification is Success");
			} else {
				System.out.println("The verification is fail");
			}
		} catch (NoSuchElementException e) {
			System.out.println("The element with className value: " + ClassName + " doesnt exists " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (WebDriverException e) {
			System.out.println("Unfortunately the browser did not open " + e.getMessage());
			throw new RuntimeException("FAILED");
		} catch (Exception e) {
			System.out.println("Unexpected exception occured in verifying Text " + e.getMessage());
			throw new RuntimeException("FAILED");

		} finally {
			takeSnap();
		}

	}
	
	
	

	public void dragAndDropByIdValue(String idval, String xvalue, String yvalue) {
		// Actions builder = new Actions(driver);
		// WebElement Elementbyid = driver.findElementById(idval);
		try {
			new Actions(driver)
					.dragAndDropBy(driver.findElementById(idval), Integer.parseInt(xvalue), Integer.parseInt(yvalue))
					.build().perform();
			reportStep("The dragAndDrop by id values : " + idval + " is performed.", "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportStep("The dragAndDrop by id values : " + idval + " could not be performed.", "FAIL");
			e.printStackTrace();
		}

	}

	public void dragAndDropById(String idvalue1, String idvalue2) {

		try {
			new Actions(driver).dragAndDrop(driver.findElementById(idvalue1), driver.findElementById(idvalue2))
					.perform();
			reportStep("The draAndDrop by id: " + idvalue1 + idvalue2 + "is performed", "PASS");

		} catch (Exception e) {
			reportStep("The draAndDrop by id: " + idvalue1 + idvalue2 + "is performed", "FAIL");
			e.printStackTrace();
		}

	}

	public void moveToElementByXpath(String xpathval) {

		try {
			
			new Actions(driver).moveToElement(driver.findElementByXPath(xpathval)).build().perform();
			
			reportStep("The moveToElement by Xpath:" + xpathval + "is Performed", "PASS");

			;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportStep("The moveToElement by Xpath:" + xpathval + "is performed", "FAIL");
			e.printStackTrace();
		}
	}

	public void KeyPressDown(String xpathval) {

		try {
			new Actions(driver).sendKeys(Keys.DOWN).build().perform();
			reportStep("The KeyPress by ID:" + xpathval + "is Performed", "PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportStep("The KeyPress by ID:" + xpathval + "is not Performed", "FAIL");
			e.printStackTrace();
		}
	}

	public void moveTOElementByXpathval(String xpathval, int xvalue, int yvalue) {

		try {
			new Actions(driver).moveToElement(driver.findElementByXPath(xpathval), xvalue, yvalue).perform();
			reportStep("The moveElement by Xpath with values:" + xpathval + xvalue + yvalue + "is performed:", "PASS");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportStep("The moveElement by Xpath with values:" + xpathval + xvalue + yvalue + "is performed:", "FAIL");
			e.printStackTrace();

		}

	}

	public void rightClickByLinkText(String textval) {

		try {
			new Actions(driver).contextClick(driver.findElementByLinkText(textval)).perform();
			reportStep(" The rightclick by link text:" + textval + "is Performed", "PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportStep("The right click by link text:" + textval + "is Performed", "FAIL");
			e.printStackTrace();
		}
	}

	public boolean verifyImageUsingXpath(String xpath) {
		boolean bReturn = false;
		driver.findElement(By.xpath(xpath)).isDisplayed();
		bReturn = true;
		return bReturn;
	}

	public void clickByPartialLink(String partiallink) {

		try {
			driver.findElementsByPartialLinkText(partiallink);
			reportStep("The element : " + partiallink + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element : " + partiallink + " is not clicked.", "FAIL");
			e.printStackTrace();
		}
	}

	public void clickByLink(String name) {

		try {
			driver.findElementByLinkText(name);
			reportStep("The element : " + name + " is clicked.", "PASS");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportStep("The element : " + name + " is clicked.", "Fail");
			e.printStackTrace();
		}

	}

}

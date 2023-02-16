package pkg1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import pomClasses.LoginOrSignUpPage;
import pomClasses.SignUpPage;

public class TestNgTestClass extends Base {
	WebDriver driver;
	/*@BeforeClass
	public void openBrowser() {
		
		System.out.println("Before Class");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_fileFolder\\chromedriver.exe");//key ,path
	
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}*/
	SoftAssert softAssert;
	@Parameters("browser")
	@BeforeTest
	public void OpenBrowser(String browserName)
	{
		System.out.println("Open Browser before excute the test method..");
		{
			//System.setProperty("webdriver.chrome.driver", "D:\\Automation_fileFolder\\chromedriver.exe");
			//driver= new ChromeDriver();	
			driver= openChromeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
			//System.setProperty("webdriver.gecko.driver","D:\\Automation_fileFolder\\geckodriver-v0.32.0-win64\\geckodriver.exe" );
			//driver= new FirefoxDriver();	
			driver= openFirefoxBrowser();
		}
		if(browserName.equals("Opera"))
		{
			//System.setProperty("webdriver.opera.driver","D:\\Automation_fileFolder\\operadriver_win64\\operadriver_win64\\operadriver.exe");
			//driver= new OperaDriver();
			driver= openOperaBrowser();
		}
	}
	
	@BeforeMethod
	public void openSignUp()
	{
		System.out.println("Before Method");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driver);
		loginOrSignUpPage.clickCreatenewacc("actText");
		 softAssert=new SoftAssert();
		
	}
	
	@Test	(priority=1 )
	public void signupPage() throws InterruptedException {
		System.out.println("Test1");
		//LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driver);
	//String actualText=loginOrSignUpPage.clickCreatenewacc("actText");
	//System.out.println("Actual text of create new account button is "+actualText);
		SignUpPage signUpPage=new SignUpPage(driver);
		String textTerms=signUpPage.clickOntermsCondition("text");
		ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		String actualUrl=driver.getCurrentUrl();
		System.out.println("Actual url is "+actualUrl);
		String actualTitle=driver.getTitle();
		System.out.println("Actual title is "+actualTitle);
		String expUrl="https://www.facebook.com/legal/terms/update";
		String expTitle="Facebook";
		String expText="Terms";
		/*if(actualUrl.equals(expUrl) && actualTitle.equals(expTitle))
		{
			System.out.println("Passed");
		}else
		{
			System.out.println("Failed");
		}*/
	//	softAssert.assertEquals(actualUrl, expUrl);
		softAssert.assertEquals(actualTitle, expTitle);
		softAssert.assertEquals(textTerms, expText);
		softAssert.assertAll();
	}
	
	@Test	(priority = 2 , invocationCount=1)
	public void privacyPolicy() throws InterruptedException
	{
		System.out.println("Test2");
		SignUpPage signUpPage=new SignUpPage(driver);
		String textPrivacyPolicy=signUpPage.clickOnPrivacyPolicy("text");
		
		ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		String actualUrl=driver.getCurrentUrl();
		System.out.println("Actual url is "+actualUrl);
		String actualTitle=driver.getTitle();
		System.out.println("Actual title is "+actualTitle);
		String expUrl  ="https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0";
		String expTitle="Meta Privacy Policy – How Meta collects and uses user data | Privacy Centre | Manage your privacy on Facebook, Instagram and Messenger | Facebook Privacy";
		/*if(actualUrl.equals(expUrl) && actualTitle.equals(expTitle))
		{
			System.out.println("Passed");
		}else
		{
			System.out.println("Failed");
		}*/
		String expText="Privacy Policy";
		//softAssert.assertEquals(actualUrl, expUrl);
		softAssert.assertEquals(actualTitle, expTitle);
		softAssert.assertEquals(textPrivacyPolicy, expText);
		softAssert.assertAll();
	}
	
	@Test	(priority=3)
	public void cookiesPolcy() throws InterruptedException
	{
		System.out.println("Test3");
		SignUpPage signUpPage=new SignUpPage(driver);
		String textCookiesPolicy=signUpPage.clickcookiesPolicy("text");
		ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		String actualUrl=driver.getCurrentUrl();
		System.out.println("Actual url is "+actualUrl);
		String actualTitle=driver.getTitle();
		System.out.println("Actual title is "+actualTitle);
		String expUrl="https://www.facebook.com/privacy/policies/cookies/?entry_point=cookie_policy_redirect&entry=0";
		String expTitle="Meta Cookies Policy | Privacy Centre | Manage your privacy on Facebook, Instagram and Messenger | Facebook Privacy";
	/*	if(actualUrl.equals(expUrl) && actualTitle.equals(expTitle))
		{
			System.out.println("Passed");
		}else
		{
			System.out.println("Failed");
		}*/
		String expText="Cookies Policy";
	//	softAssert.assertEquals(actualUrl, expUrl);
		softAssert.assertEquals(actualTitle, expTitle);
		softAssert.assertEquals(textCookiesPolicy, expText);
		softAssert.assertAll();
	}
	@AfterMethod
	public void closeCurrentTab()
	{
		System.out.println("After Method");
		driver.close();
		ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(0));
	}
	
	/*@AfterClass
	public void closeAllTab()
	{
		System.out.println("After Class");
		driver.quit();
	}*/
	
	@AfterTest
	public void closeallTab()
	{
		System.out.println("After Test");
		driver.quit();
		//driver.quit();
	}
}

package pkg1;

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

//import com.beust.jcommander.Parameters;

import pomClasses.LoginOrSignUpPage;

public class LoginPageTestClass {
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
	if(browserName.equals("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_fileFolder\\chromedriver.exe");
		driver= new ChromeDriver();	
	}
	if(browserName.equals("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver","D:\\Automation_fileFolder\\geckodriver-v0.32.0-win64\\geckodriver.exe" );
		driver= new FirefoxDriver();	
	}
	if(browserName.equals("Opera"))
	{
		System.setProperty("webdriver.opera.driver","D:\\Automation_fileFolder\\operadriver_win64\\operadriver_win64\\operadriver.exe");
		driver= new OperaDriver();
	}
}
	@BeforeMethod
	public void openCreateNewAccount()
	{
		System.out.println("Before Method");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driver);
	//	loginOrSignUpPage.clickCreatenewacc("actText");
		 softAssert=new SoftAssert();
	}
	@Test
	public void test1()
	{
		LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driver);
		String actualText=loginOrSignUpPage.clickCreatenewacc("actText");
		System.out.println("Actual text is "+actualText);
		String expText="Create new account";
	/*	if(actualText.equals(expText))
		{
			System.out.println("Actual text and expected text is same Passed");
		}
		else
		{
			System.out.println("Failed");
		}*/
		String actUrl=driver.getCurrentUrl();
		System.out.println("Actual url is "+actUrl);
		String expUrl="https://www.facebook.com/";
		softAssert.assertEquals(actUrl, expUrl);
		softAssert.assertEquals(actualText, expText);
		
		softAssert.assertAll();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("after method...");
		driver.close();
	}
	/*@AfterClass
	public void afterClass()
	{
		System.out.println("After class");
	}*/
	@AfterTest
	public void aftercloseallTab()
	{
		System.out.println("After test...");
	}
}

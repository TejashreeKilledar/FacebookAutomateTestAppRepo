package pkg1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomClasses.LoginOrSignUpPage;
import pomClasses.SignUpPage;

public class SignupTestNg {

	WebDriver driver;
	@BeforeClass
	public void launchSignup()
	{
		System.out.println("Before Class");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_fileFolder\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void openSignUpPage() {
		System.out.println(" Before Method");
		driver.get("https://www.facebook.com/");
		
		LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driver);
		loginOrSignUpPage.clickCreatenewacc("actText");
	}
	
	@Test
	public void verifyDetailsInfo() {
		System.out.println("Test-1");
	  
		SignUpPage signUpForm = new SignUpPage(driver);
		signUpForm.sendfirstName();
		signUpForm.sendSurName();
		signUpForm.sendMobNumOrEmailAddress();
		signUpForm.sendNewPassword();
		signUpForm.selectFemaleButton();
		signUpForm.selectdate();
		signUpForm.selectmonth();
		signUpForm.selectYear();
		
		String actText=signUpForm.clickOnSignUpButton("text");
		
		String expText="Sign Up";
		if(expText.equals(actText))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("Failed");
		}
			
		}

	/*	@Test
		public void verifsignupButton() {
			System.out.println("Test-9");
			SignUpPage signUpForm=new SignUpPage(driver);
			String expText="Sign Up";
			String actText=signUpForm.clickOnSignUpButton("text");
		
			if(expText.equals(actText))
			{
				System.out.println("passed");
			}
			else
			{
				System.out.println("Failed");
			}
			
		
			
		}*/

		
		@AfterMethod
		public void closedCurrentTab(){
			System.out.println("After method");
			 driver.close();
		}
		
	   @AfterClass
		public void afterClass() {
			System.out.println("After Class");
			// driver.close();
		}
	
	
	
}

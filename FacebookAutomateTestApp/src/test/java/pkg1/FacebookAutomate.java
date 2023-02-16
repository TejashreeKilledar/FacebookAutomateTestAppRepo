package pkg1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.LoginOrSignUpPage;
import pomClasses.SignUpPage;
public class FacebookAutomate 
{

	public static void main(String[] args) throws InterruptedException 
	{
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_fileFolder\\chromedriver.exe");//key ,path
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");

		//Thread.sleep(3000);
		LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driver);
		loginOrSignUpPage.sendUserName();
		loginOrSignUpPage.sendPassword();
		loginOrSignUpPage.clickCreatenewacc("actText");
		Thread.sleep(2000);
		
		SignUpPage signUpPage=new SignUpPage(driver);
		
		signUpPage.sendfirstName();
		signUpPage.sendSurName();
		
		signUpPage.sendMobNumOrEmailAddress();
		
		signUpPage.sendNewPassword();
		
		signUpPage.selectdate();
		signUpPage.selectmonth();
		signUpPage.selectYear();
		signUpPage.selectFemaleButton();
		signUpPage.clickOnSignUpButton("text");
}
}
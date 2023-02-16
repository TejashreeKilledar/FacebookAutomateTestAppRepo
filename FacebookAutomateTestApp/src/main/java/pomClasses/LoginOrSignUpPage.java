package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUpPage {

	//all variables are private and variables means WebElelemnt //variable-->WebElement-->Private
	
	@FindBy (xpath="//input[@type='text']") 
	private WebElement userName;
	
	@FindBy (xpath="//input[@type='password']") 
	private WebElement password;
	
	@FindBy (xpath="//button[@name='login']") 
	private WebElement loinButton;
	
	
	@FindBy (xpath="//a[text()='Create new account']") 
	private WebElement createNewAccount;
	
	
		public  LoginOrSignUpPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Methods-> public ->WebElement Action
		
		public void sendUserName() 
		{
			userName.sendKeys("Tejashree");
		}
		
		public void sendPassword() 
		{
			password.sendKeys("0714");
		}
		
		public String clickCreatenewacc(String actText) 
		{
			createNewAccount.click();
			String text=createNewAccount.getText();
			return text;
		}
		
	
	
}

package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static void captureScreenShot(WebDriver driver,String fileName) throws IOException 
	{
		
		 //Random random=new Random();
			Date d=new Date();
			String date = d.toString().replace(":", ";").replace(" ;", "-") ;
			TakesScreenshot t=(TakesScreenshot)driver;
			
			 
		
				File src=t.getScreenshotAs(OutputType.FILE);
			//	File dest=new File("C:\\Users\\Admin\\Desktop\\capturedScrrenshotPages"+random.nextInt()+".png"+"  "+FileName);
				//FileUtils.copyFile(src,new File("./Screenshot/"+fileName+ "" ));
				FileHandler.copy(src,new File("./Screenshot/"+fileName+ ""+ date));
				//File dest=new File("C:\\Users\\Admin\\Desktop\\soapuiDoc");
				//return dest;
				
				
	}
}

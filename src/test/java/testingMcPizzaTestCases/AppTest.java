package testingMcPizzaTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import testPages.LoginPage;
import utilities.BrowserFactory;

public class AppTest {

	
	WebDriver driver;
	WebDriverWait wait;
	LoginPage loginpage;

	@Test
	public void loginToApplication() throws InterruptedException, IOException 
	{
        BrowserFactory bro=new BrowserFactory(driver);
        
		driver=BrowserFactory.startApplication(driver,"Chrome", "https://c6.avaamo.com/web_channels/c767654d-6709-43f6-bb0c-ce1d2c559f6a/demo.html?banner=true&demo=true&banner_text=%20&banner_title=This%20is%20how%20the%20chat%20agent%20shows%20up");

		loginpage=new LoginPage(driver);

		loginpage.clickonBot();

		loginpage.logintoMcPizza("darshan", "dpg.93@gmail.com");

		String response=loginpage.orderScreen("I want to order Pizza","veg","cheese and tomato");
		
		Assert.assertEquals(response,"CONGRATS ! ORDER PLACED .");
		
		
		bro.screenShotCapture(driver);

        driver.quit();


	}


}

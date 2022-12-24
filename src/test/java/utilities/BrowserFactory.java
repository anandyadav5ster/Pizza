package utilities;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class BrowserFactory 
{
	WebDriverWait lwait;
	WebDriver ldriver;
	//Takes care of Browser and driver Initialization

	public BrowserFactory(WebDriver driver)
	{
		this.ldriver=driver;
	}

	public static WebDriver startApplication(WebDriver ldriver,String browsername,String appURL)
	{
		if(browsername.equals("Chrome"))
		{
			ldriver=new ChromeDriver();
			System.out.println("Chrome driver initialized");

		}
		else if(browsername.equals("Firefox"))
		{
			ldriver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Sorry this browser is not supported");
		}

		ldriver.manage().window().maximize();

		ldriver.get(appURL);

		return ldriver;
	}


	//Takes care of browser termination
	public static void tearDown(WebDriver driver)
	{
		driver.quit();
	}

	//Explicit wait mechanism
	public void waitExplicitclickable(WebDriver ldriver,WebElement locator)
	{
		lwait = new WebDriverWait(ldriver,java.time.Duration.ofSeconds(10));
		lwait.until(ExpectedConditions.elementToBeClickable(locator));

	}	

	public void waitExplicitvisible(WebDriver ldriver,WebElement locator)
	{
		lwait = new WebDriverWait(ldriver,java.time.Duration.ofSeconds(10));
		lwait.until(ExpectedConditions.visibilityOf(locator));

	}	
	public void switchingFrame(WebElement frameelement)
	{
		ldriver.switchTo().frame(frameelement);
	}
  
    public void screenShotCapture(WebDriver ldriver) throws IOException
    {
    	//Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)ldriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(System.getProperty("user.dir")+"/src/test/java/Screeshot.png");

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);
    }

}



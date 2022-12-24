package testPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserFactory;

public class LoginPage extends BrowserFactory
{

	WebDriver driver;




	//Constructor to initialize the driver

	public LoginPage(WebDriver ldriver)
	{   
		super(ldriver);
		this.driver=ldriver;
		PageFactory.initElements(driver,this);


	}



	//locators list in the webpage

	@FindBy(xpath="//div[@class='avm-bot-welcome-notification animated fadeInUp']") private WebElement welcomeBot;

	@FindBy(xpath="//a[contains(text(),'Get Started')]")private WebElement getStarted;

	@FindBy(xpath="//input[@id='first_name']") private WebElement firstName;

	@FindBy(id= "email")private WebElement emailId;

	@FindBy(xpath="//button[@type='submit']") private WebElement submitButton;

	@FindBy(id= "queryTextbox") private WebElement queryBox;

	@FindBy(xpath="//button[contains(text(),'Send')]") private WebElement sendButton;

	@FindBy(name="avaamoIframe") private WebElement frameName;

	@FindBy(xpath="//a[@aria-label='veg']") private WebElement vegpizza;

	@FindBy(xpath="//a[@aria-label='non-veg']") private WebElement nvegpizza;

	//@FindBy(xpath="//input[@value='cheese_id']") private WebElement cheese;

	@FindBy(xpath="//div[@class='default_card_input']//input[@value='cheese_id']") private WebElement cheese; 

	@FindBy(xpath="//input[@value='tomato_id']") private WebElement tomato;

	@FindBy(xpath="//button[@aria-label='Submit']") private WebElement subbtn;

	@FindBy(xpath="//a[@aria-label='Thick Crust']") private WebElement thinCrust;

	@FindBy(xpath="//a[@aria-label='Small']") private WebElement size;

	@FindBy(xpath="//a[@aria-label='Yes']") private WebElement yes;

	@FindBy(xpath="//button[@aria-label='Thumbs up']") private WebElement thumbsup;

	@FindBy(id= "picklist-undefined_d1135584-6a33-4962-bad1-0607ccc44955") private WebElement ratingdropbox;

	@FindBy(xpath="//li[@id='option0']") private WebElement option;
	
	@FindBy(xpath="//button[@class='btn default_card_submit']") private WebElement sub;
	
	@FindBy(xpath="//p[contains(text(),'CONGRATS ! ORDER PLACED .')]") private WebElement finalmessage;


	//Click on welcomeBot and Getstarted
	public void clickonBot()
	{   

		waitExplicitclickable(driver,welcomeBot);
		welcomeBot.click();
		waitExplicitclickable(driver,getStarted);
		getStarted.click();

	}

	//Welcome Screen
	public void logintoMcPizza(String fname,String mail)
	{   
		waitExplicitvisible(driver,frameName);
		switchingFrame(frameName);
		firstName.sendKeys(fname);
		emailId.sendKeys(mail);
		submitButton.click();

	}


	//Post login order screen
	public String orderScreen(String query,String type,String topping) throws InterruptedException
	{
		queryBox.sendKeys("I want to order Pizza");
		sendButton.click();
		waitExplicitvisible(driver,vegpizza);
		if(type.equalsIgnoreCase("veg"))
			vegpizza.click();
		else
			nvegpizza.click();
		/*  waitExplicitvisible(driver,frameName);
	    switchingFrame(frameName);
	  /  JavascriptExecutor j = (JavascriptExecutor) driver;

	      // identify element and set value
	      j.executeScript
	      ("document.getElementByValue('cheese_id').click();");*/
		// waitExplicitclickable(driver,cheese);
		Thread.sleep(3000);
		if(topping.contains("cheese"))
			cheese.click();
		if(topping.contains("tomato"))
			tomato.click();

		subbtn.click();


		waitExplicitclickable(driver,thinCrust);
		thinCrust.click();

		waitExplicitclickable(driver,size);
		size.click();

		waitExplicitclickable(driver,yes);
		yes.click();

		waitExplicitclickable(driver,thumbsup);
		thumbsup.click();

		waitExplicitvisible(driver, ratingdropbox);
		ratingdropbox.click();

		waitExplicitvisible(driver, option);
		option.click();

        sub.click();
        
        //waitExplicitvisible(driver,finalmessage);
        Thread.sleep(3000);
        
        String strResponse=finalmessage.getText();
        return strResponse ;
        



	}



}












package com.qa.stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.log4testng.Logger;

//import org.junit.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps_01 extends TestBase{
	
	LoginPage loginpage1;
	HomePage homePage;
	TestUtil testUtil;

	// Logger is defined here for logs.
	Logger log = Logger.getLogger(HomePageSteps_01.class);
	
	
	
	@Before   //@Before and @After are concept of hooks.
	public void setUp()
	{
	 log.info("Launching the Browser and the Application URL displays");
	 
	   System.out.println("Launch the browser and enter url");
		TestBase.initialization();
	}
	
	

	@Given("^user is on Login Page of TMR D365$")
	public void user_is_on_Login_Page()  {
	    
		loginpage1 = new LoginPage();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Sign in to your account", title);
	   
	}

	// ************** HASHMAP Implementation - Especially Useful for Role Based or
	// Permission based Testing in D365 CRM.***********************

	public static HashMap<String, String> getCredentialsMap() {
		HashMap<String, String> userMap = new HashMap<String, String>(); // Created HashMap Object
		userMap.put("IPU_Operator", "pdsuser@tmr.qld.gov.au:Hub(2022)"); // Here "customer" is the Key and
																				// "naveenautomation:Test@123" is the
																				// value
		userMap.put("IPU_TeamLead", "pdslead@tmr.qld.gov.au:Hub(2022)"); // Here "admin" is the Key and "anuraag:Waheguru@01" is the value
		userMap.put("IPU_SysAdmin", "pdssuper@tmr.qld.gov.au:Hub(2022)");
		
		return userMap;

	}

	public static String getUserName(String role) {
		String credentails = getCredentialsMap().get(role);

		return credentails.split(":")[0]; // This split will split by : That is Example: anuraag:Waheguru@01 will be
											// split by and [0] will return anuraag as its 0

	}

	public static String getPassword(String role) {
		String credentails = getCredentialsMap().get(role);

		return credentails.split(":")[1]; // This split will split by : That is Example: anuraag:Waheguru@01 will be
											// split by and [1] will return Waheguru@01 as its 1

	}

	// ************** HASHMAP Implementation - Especially Useful for Role Based or
	// Permission based Testing in D365 CRM.***********************






	@When("^user types \"([^\"]*)\" & clicks Next button$")
	public void user_types_and_clicks_Next_button(String username) throws InterruptedException 
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(100);

		// driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);

		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(getUserName(username)); // Code-This will call
																								// the above HashMap.

		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	
	@And("^user types \"([^\"]*)\" & clicks SignIn button$")
	public void user_types_and_clicks_SignIn_button(String password) throws Throwable {

		Thread.sleep(200);
		// driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(getPassword(password)); // Code-This will call
																									// the above HashMap

		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement SignIn_Button = driver.findElement(By.xpath("//input[@value='Sign in' and @id='idSIButton9']"));
		je.executeScript("arguments[0].scrollIntoView(true);", SignIn_Button);
		SignIn_Button.click();

	}
	
	@And("^user clicks on the Yes$")
	public void user_clicks_on_the_Yes_option() throws Throwable {
		Thread.sleep(100);
		driver.findElement(By.xpath("//input[@value='Yes' and @type='submit']")).click();

	}
		
		@Then("^user clicks on Sales Hub option$")
		public void user_clicks_on_the_Sales_Hub_option() throws InterruptedException
		{
			Thread.sleep(100);
			driver.findElement(By.xpath("//bdi[contains(text(),'Sales Hub')]"));
			
		}
		

	@Then("^user validates Dynamics CRM home page title Page of TMR$")
	public void dynamics_CRM_home_page_is_displayed() throws InterruptedException, IOException  
	{
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		String title1 = driver.getTitle();
		System.out.println("Home Page Title is :: "+title1);
		
		log.info("The Page Title is" +title1 );
		Assert.assertEquals("Microsoft Dynamics 365", title1);
		//TestUtil.takeScreenshotAtEndofTest();
		log.info("************************ Validate D365 Home Page Availability***********************");
		log.info("The Page Title is" +title1 );
	    //Microsoft Dynamics 365
	    //log.fatal("This is a Test Error message");
	}

	


	
	@When("^on Home Page user clicks on the Contacts Menu$")
	public void on_Home_Page_user_clicks_on_the_Contacts_Menu() throws Throwable {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 20000);
		WebElement ContactsMenu = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@role='presentation' and  @title='Contacts']")));

		ContactsMenu.click();

	}

@Then("^user clicks on New button$")
public void user_clicks_on_New_button()
{
	WebDriverWait wait = new WebDriverWait(driver, 100);
	WebElement NewOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='New']")));
	
	NewOption.click();
    
}

@Then("^user enters Contact details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and clicks Save$")
//@Then("^user enters Contact details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and clicks Save$")
public void user_enters_Contact_details_and_clicks_Save(String firstname, String lastName, String JobTitle, String Email) throws InterruptedException 
{
	Thread.sleep(500);
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver, 5000);
	WebElement Firstname_Text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='First Name']")));
	Firstname_Text.click();
	Firstname_Text.sendKeys(firstname);
	
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	// Date and time format
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	Date date = new Date();
	String date1 = dateFormat.format(date);
	WebDriverWait wait1 = new WebDriverWait(driver, 5000);
	WebElement Lastname_Text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Last Name']")));
	
	Lastname_Text.click();
	Lastname_Text.sendKeys(lastName +date1);
	
	
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@aria-label='Job Title']")).click();
	driver.findElement(By.xpath("//input[@aria-label='Job Title']")).sendKeys(JobTitle);
	
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@aria-label='Email']")).click();
	driver.findElement(By.xpath("//input[@aria-label='Email']")).sendKeys(Email);
	
	Thread.sleep(1000);
	WebDriverWait wait2 = new WebDriverWait(driver, 2000);
	WebElement clickSave = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Save' and @data-id='contact|NoRelationship|Form|Mscrm.Form.contact.Save']")));
	
	clickSave.click();
	
	
}


@Then("^user verifies Contact Creation$")
public void user_verifies_Contact_Creation() throws InterruptedException
{
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
    WebDriverWait wait = new WebDriverWait(driver, 10000);
	WebElement confirmed_ContactCreated = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Assign']")));
	Assert.assertEquals(true, confirmed_ContactCreated.isDisplayed());
	Thread.sleep(1000);
}



@Then("^user verifies Duplicate Contact detection$")
public void user_verifies_Duplicate_Contact_detection() throws InterruptedException
{
	Thread.sleep(500);
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
    WebDriverWait wait = new WebDriverWait(driver, 10000);
    WebElement verify_DuplicateContactDetected = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@aria-label='Duplicate records found']")));
	//WebElement confirmed_ContactCreated = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Assign']")));
	Assert.assertEquals(true, verify_DuplicateContactDetected.isDisplayed());
	Thread.sleep(1000);
	/*
	 * driver.findElement(By.xpath("//span[contains(text(),'Ignore and save')]")).
	 * click(); Thread.sleep(500);
	 */
	
}


@When("^user enters the \"([^\"]*)\" in the search box and clicks Enter$")
public void user_enters_the_in_the_search_box_and_clicks_Enter(String firstname) throws Throwable {
	Thread.sleep(500);
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@aria-label='Search this view']")).click();
	driver.findElement(By.xpath("//input[@aria-label='Search this view']")).sendKeys(firstname);
	driver.findElement(By.xpath("//input[@aria-label='Search this view']")).sendKeys(Keys.ENTER);

}


@Then("^user verifies the Contact Search functionality is pass or fail$")
public void user_verifies_the_Contact_Search_functionality_is_pass_or_fail() throws Throwable 
{
	
	Thread.sleep(1000);
	//driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

	/*
	 * //Assert.assertEquals(true,
	 * driver.findElement(By.xpath("//a[contains(@title,'Neil')]")).isDisplayed());
	 * try {
	 * Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@title,'Neil')]")
	 * ).isDisplayed()); } catch (org.openqa.selenium.NoSuchElementException e) { //
	 * Try to apply If and Else here. }
	 */
	
	while(true) 
	{
		if (driver.findElement(By.xpath("//a[contains(@title,'Neil')]")).isDisplayed()==false) 
		{

			System.out.println("Search Element Not Found");
		    break;
		}   
		else if (driver.findElement(By.xpath("//a[contains(@title,'Neil')]")).isDisplayed()==true)
		{
			 System.out.println("TEST CASE PASSED");
		     break;
		}
	}
     
/*	  if (driver.findElement(By.xpath("//a[contains(@title,'Neil')]")).isDisplayed()==true)
	  { 
	    System.out.println("TEST CASE PASSED");
	    
	   
	  }
	  else
	  {
	    System.out.println("Search Element Not Found");
	  
	  }*/
	}


/*
 * public boolean isElementPresent(By locatorKey) { try {
 * driver.findElement(locatorKey); return true; } catch
 * (org.openqa.selenium.NoSuchElementException e) { return false; } }
 * 
 * public boolean isElementVisible(String cssLocator){ return
 * driver.findElement(By.cssSelector(cssLocator)).isDisplayed(); }
 */

@And("^user click on the Existing Contact to Update$")
public void user_click_on_the_Existing_Contact_to_Update() throws InterruptedException
{
	Thread.sleep(10000);
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[contains(@title,'Steve Wagh')]")).click();
	
}



@Then("^user updates the \"([^\"]*)\" and saves the record$")
public void user_updates_the_and_saves_the_record(String UpdateJobTitle) throws InterruptedException
{
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    WebDriverWait wait = new WebDriverWait(driver, 10000);
    WebElement updateContact = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Job Title']")));
	driver.findElement(By.xpath("//input[@aria-label='Job Title']")).clear();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@aria-label='Job Title']")).click();
	driver.findElement(By.xpath("//input[@aria-label='Job Title']")).sendKeys(UpdateJobTitle);
	
	Thread.sleep(10000);
	WebDriverWait wait2 = new WebDriverWait(driver, 20000);
	WebElement clickSave = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Save' and @data-id='contact|NoRelationship|Form|Mscrm.Form.contact.Save']")));
	
	clickSave.click();
	
   
}


@After
public void tearDown(Scenario scenario)
{
	if(scenario.isFailed())
	{
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		//embed it in the report.
		scenario.embed(screenshot,"image/png");
		
	}
}


@Then("^finally user closes the Browser$")
public void finally_user_closes_the_Browser() throws Throwable
{
	System.out.println("Exit from the browser");
    driver.close();
}
	



}

package TestRunner.loginSteps;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.LoginObject;
import ObjectRepository.SignupObject;
import TestRunner.SetupClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import webApp.PerformAction;

public class CO_checkout extends SetupClass{
	
	WebDriverWait wait = new WebDriverWait(driver,30);
        JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Given("^user is already on Website Home Page (\\d+)CO$")
	public void user_is_already_on_Website_Home_Page_CO(int arg1) throws Throwable {
		
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
	    Thread.sleep(2000);
	    try {
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
			if (logout.isEnabled()) {
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}
	    Thread.sleep(1000);
		try {
			WebElement iframe = driver.findElement(By.id("livechat-full-view"));
			if(iframe.isDisplayed()) {
				driver.switchTo().frame(iframe);   
				 Actions act = new Actions(driver);
				 act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
				 Thread.sleep(2000);
					WebElement chat1=driver.findElement(By.cssSelector("#title .icon-minimize"));
					 Thread.sleep(1000);
						chat1.click();
						 Thread.sleep(1000);
						 driver.switchTo().defaultContent();
						 Thread.sleep(1000);
						 driver.switchTo().parentFrame();
					 Thread.sleep(1000);
			}
			else {
				

			System.out.println("chat window does not open");
			}
		}
				catch(NoSuchElementException NCP) {
					
				}
		Thread.sleep(1000);
	    
	    
	}

	@Then("^user navigates to sign up page (\\d+)CO$")
	public void user_navigates_to_sign_up_page_CO(int arg1) throws Throwable {
		Thread.sleep(3000);
		try {
			driver.findElement(By.cssSelector("ul.header > li:nth-child(1) > a:nth-child(1)")).click();
			Thread.sleep(2000);
			log.info("It's opening the website URL and redirect user to sign up page");
		} 
		catch (NoSuchElementException popup) {
		}
	}

	@Then("^user create a new ac count (\\d+)CO$")
	public void user_create_a_new_ac_count_CO(int arg1) throws Throwable {
		// create new email for sign up
		
				int leftLimit = 97; // letter 'a'
			    int rightLimit = 122; // letter 'z'
			    int targetStringLength = 10;
			    Random random = new Random();
			    StringBuilder buffer = new StringBuilder(targetStringLength);
			    for (int i = 0; i < targetStringLength; i++) {
			        int randomLimitedInt = leftLimit + (int) 
			          (random.nextFloat() * (rightLimit - leftLimit + 1));
			        buffer.append((char) randomLimitedInt);
			    }
			    String generatedString = buffer.toString();
			 
			    System.out.println(generatedString);
			    
			    String signup_email=generatedString;
			    String full_email="selenium.testing."+generatedString+"@gmail.com";
			    System.out.println(full_email);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
				//driver.findElement(By.id("email_address")).sendKeys(full_email);
				

				Thread.sleep(2000);
			    WebElement new_email_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("email_address")));
				Thread.sleep(2000);
			    new_email_signup.sendKeys(full_email);
				Thread.sleep(2000);
				
				// enter name

			    WebElement new_fname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("firstname")));
				Thread.sleep(2000);
			    new_fname_signup.sendKeys("Selenium");
				Thread.sleep(2000);

			    WebElement new_lname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("lastname")));
				Thread.sleep(2000);
			    new_lname_signup.sendKeys("Testing");
				Thread.sleep(2000);
				
				//enter password
				 WebElement new_pwd_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
					Thread.sleep(2000);
				    new_pwd_signup.sendKeys("selenium@123");
					Thread.sleep(2000);

				    WebElement new_pwd1_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("password-confirmation")));
					Thread.sleep(2000);
				    new_pwd1_signup.sendKeys("selenium@123");
					Thread.sleep(2000);
					
					// enter captcha
					WebElement new_captcha_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("captcha_user_create")));
					Thread.sleep(2000);
				    new_captcha_signup.sendKeys("Aj7W2mtf9namwf55");
					Thread.sleep(2000);
				    
				    // sign  up button
				    WebElement new_btn_signup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".submit")));
					Thread.sleep(2000);
				    new_btn_signup.click();
					Thread.sleep(2000);
	}

	@Then("^Redirected to pricing page and Check all the subscriptions are present$")
	public void Redirected_to_pricing_page_and_Check_all_the_subscriptions_are_present(int arg1) throws Throwable {
		WebElement Pricing= driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div[2]/div/nav/div/div/ul/li[2]/a"));
		//WebElement Monthly =driver.findElement(By.xpath("//div[text()='Monthly']"));
		getPageSource = "https://www.slideteam.net/pricing";
		String pageSource = driver.getPageSource();
		{
			Thread.sleep(2000);
		if(driver.getPageSource().contains("Monthly")) {
			
                System.out.println("Monthly is present");
                 
		} else {
                 
			System.out.println("Monthly is absent");
		}
			Thread.sleep(2000);
			//String pageSource = driver.getPageSource();
		if (driver.getPageSource().contains("Semi Annual")) {
               
			System.out.println("Semi Annual is present");
                 } else {
                 
			System.out.println("Semi Annual is absent");
		}
			Thread.sleep(2000);
			//String pageSource = driver.getPageSource();
		if(driver.getPageSource().contains("Annual")){
                System.out.println("Annual is present");
                 } else {
                 System.out.println("Annual is absent");
		}
			Thread.sleep(2000);
			//String pageSource = driver.getPageSource();
		if(driver.getPageSource().contains("Annual Custom Design")){
                System.out.println("Annual Custom Design is present");
                 } else {
                 System.out.println("Annual Custom Design is absent");
		}
			Thread.sleep(2000);
			if(driver.getPageSource().contains("Team License")){
                System.out.println("Team License is present");
                 } else {
                 System.out.println("Team License is absent");
			}
		}
	}
		
	@Then("^user is redirected to pricing page and choose a plan to pay (\\d+)CO$")
	public void user_is_redirected_to_pricing_page_and_choose_a_plan_to_pay_CO(int arg1) throws Throwable {
		//Thread.sleep(3000);
		
		// choose a plan
		js.executeScript("window.scrollBy(0,1000)");
		 WebElement join_now_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(.,'Join now')])[8]")));
		js.executeScript("arguments[0].scrollIntoView();",join_now_btn);		
		Thread.sleep(2000);
		    join_now_btn.click();
			Thread.sleep(6000);

	}

	@Then("^user is redirected to checkout page (\\d+)CO$")
	public void user_is_redirected_to_checkout_page_CO(int arg1) throws Throwable {
		Thread.sleep(6000);
	}

	@Then("^user proceed to pay with (\\d+)CO (\\d+)CO$")
	public void user_proceed_to_pay_with_CO_CO(int arg1, int arg2) throws InterruptedException {
	     try {
		Thread.sleep(1400);
		// select 2co option
		WebElement co_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tco_checkout")));
		Thread.sleep(2000);
	         co_btn.click();
		Thread.sleep(5000);
	     } catch( NoSuchElementException popup) { 
	     }
		
		// place order button 
		try {
			
		 WebElement place_order_btn  =  driver.findElement(By.cssSelector("#place-order-trigger > span"));
			Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView();",place_order_btn);	
			//js.executeScript("arguments[0].click();", place_order_btn);
			Thread.sleep(2000);
		    place_order_btn.click();
			Thread.sleep(5000);
		} catch (NoSuchElementException popup) {
		}
		
		
	}

	@Then("^paypal popup appears and user navigates back to my account (\\d+)CO$")
	public void paypal_popup_appears_and_user_navigates_back_to_my_account_CO(int arg1) throws Throwable {
	    String co_page_title=driver.getTitle();
		Thread.sleep(3000);
	    System.out.println("Title of the Page is --> "+co_page_title);
	    
	    String page_title="2Checkout";
	    
	    if(page_title.equalsIgnoreCase(co_page_title))
	    {
	    	System.out.println(" user is on the 2checkout page");
	    	log.info("USER IS ON THE 2CHECKOUT PAGE");
	    }
	    else
	    {
	    	System.out.println("user is on the wrong page");
	    	log.info("USER IS ON THE WRONG PAGE");
	    }
		Thread.sleep(3000);
	}

	@Then("^user deleted the account (\\d+)CO$")
	public void user_deleted_the_account_CO(int arg1) throws Throwable {
		Thread.sleep(3000);
	    driver.get("https://www.slideteam.net/");
		Thread.sleep(2000);
		

		 driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		 Thread.sleep(3000);
		 
		


try {
			WebElement iframe = driver.findElement(By.id("livechat-full-view"));
			if(iframe.isDisplayed()) {
				driver.switchTo().frame(iframe);   
				 Actions act = new Actions(driver);
				 act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
				 Thread.sleep(2000);
					WebElement chat1=driver.findElement(By.cssSelector("#title .icon-minimize"));
					 Thread.sleep(1000);
						chat1.click();
						 Thread.sleep(1000);
						 driver.switchTo().defaultContent();
						 Thread.sleep(1000);
						 driver.switchTo().parentFrame();
					 Thread.sleep(1000);
			}
			else {
				

			System.out.println("chat window does not open");
			}
		}
				catch(NoSuchElementException NCP) {
					
				}


      
		 WebElement delete_account = driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]"));
		js.executeScript("arguments[0].scrollIntoView();",delete_account);
		 delete_account.click();
		 Thread.sleep(3000);
		 WebElement continue_delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit'][contains(.,'Continue')]")));
		js.executeScript("arguments[0].scrollIntoView();",continue_delete);
		continue_delete.click();
		 Thread.sleep(3000);
	}


	
}

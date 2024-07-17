package gentilmenproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login1 {
	ChromeDriver driver;
	SoftAssert 	SoftAssert;
	public Login1(ChromeDriver mdriver) {
		this.driver=mdriver;
	}
  @Test(priority=1)
  public void verifytitle() {
	  System.out.println("to verify the page title");
	  try {
	  String expected="Gentleman | Welcome";
	  String actual=driver.getTitle();
	  Assert.assertEquals(actual, expected);
	  }
	  catch (AssertionError e) {
		  System.out.println("DEFECT:The user is  not able to access the URL");
		  }
	  }
	 
	  
	 
  
  @Test(priority=2)
  public void validlogin() {
	  System.out.println("to verify whether login functionality is working with valid inputs");
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys("admin");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("admin@gentleman");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div/form/button"));
	  btn.click();
	  System.out.println(driver.getTitle());
	 try {
	  String expected="GENTLEMAN";
	  String actual=driver.getTitle();
	  Assert.assertEquals(actual, expected);
	 }

		catch (AssertionError e)
	 {
			System.out.println("DEFECT:The user is  able to login with valid inputs");
	 }
	 
	 
	 finally  {
	  WebElement button=driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li[1]/a"));
	  button.click();
	  WebElement signout=driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li[1]/ul/li[2]/div[2]/a"));
	  signout.click();
	  
	 }
	 
  }
  @Test(priority=3)
	public void invalidnamelogin()
	{
		System.out.println("Verifying the login function with invalid name field");
		driver.findElement(By.name("username")).sendKeys("admin123");
		driver.findElement(By.name("password")).sendKeys("admin@gentleman");
		driver.findElement(By.xpath("/html/body/div[1]/div/form/button")).click();
		try
		{
			String Expectedresult1="Gentleman | Welcome";
			String actualresult1=driver.getTitle();
			SoftAssert=new SoftAssert();
			SoftAssert.assertEquals(actualresult1, Expectedresult1, "DEFECT : The user is able to login with invalid name field");
			SoftAssert.assertAll();

			WebElement error=driver.findElement(By.name("invalid-name;error_message"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("invalid-name;error_message")));
			SoftAssert.assertTrue(error.isDisplayed(), "DEFECT : The error message showing incorrectness in the name field is not displayed");
			SoftAssert.assertAll();
			
		}
		catch(AssertionError  | TimeoutException | NoSuchElementException  e) {
			System.out.println("DEFECT : The error message showing incorrectness in the name field is not displayed.");
		}
		finally
		{
			driver.navigate().refresh();
		}
	}
  @Test(priority=4)
  public void invalidpasswordfiledlogin() {
	  System.out.println("to verify whether login functionality is working with invalid password field");
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys("admin");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("student@gentleman");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div/form/button"));
	  btn.click();
	  try {
	  System.out.println(driver.getTitle());
	  String expected="Gentleman | Welcome";
	  String actual=driver.getTitle();
	  SoftAssert=new SoftAssert();
		SoftAssert.assertEquals(actual, expected, "DEFECT : The user is able to login with invalid password field");
		SoftAssert.assertAll();
		
		WebElement error=driver.findElement(By.name("invalid-password;error_message"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("invalid-paasowrd;error_message")));
		SoftAssert.assertTrue(error.isDisplayed(), "DEFECT : The error message showing incorrectness in the name field is not displayed");
		SoftAssert.assertAll();

	  }
	  catch(AssertionError  | TimeoutException | NoSuchElementException  e) {
			System.out.println("DEFECT : The error message showing incorrectness in the password field is not displayed.");
		}
		 
		 
	  finally
		{
			driver.navigate().refresh();
		}
	}
  @Test(priority=5)
  public void invalidfieldslogin() {
	  System.out.println("to verify whether login functionality is working with invalid  field");
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys("student");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("student@gentleman");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div/form/button"));
	  btn.click();
	  try {
	  System.out.println(driver.getTitle());
	  String expected="Gentleman | Welcome";
	  String actual=driver.getTitle();
	  Assert.assertEquals(actual, expected);SoftAssert=new SoftAssert();
		SoftAssert.assertEquals(actual, expected, "DEFECT : The user is able to login with invalid input fields");
		SoftAssert.assertAll();
		
		WebElement error=driver.findElement(By.name("invalid-input_fields;error_message"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("invalid-input_fields;error_message")));
		SoftAssert.assertTrue(error.isDisplayed(), "DEFECT : The error message showing incorrectness in the input fields is not displayed");
		SoftAssert.assertAll();

	  }
	  catch(AssertionError  | TimeoutException | NoSuchElementException  e) {
			System.out.println("DEFECT : The error message showing incorrectness in the input  fields is not displayed.");
		}
		 
	  finally
		{
			driver.navigate().refresh();
		}
	}
  @Test(priority=6)
  public void blanknamefieldlogin() {
	  System.out.println("to verify whether login functionality is working with blank name field");
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys("");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("admin@gentleman");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div/form/button"));
	  btn.click();
	  try {
	  System.out.println(driver.getTitle());
	  String expected="Gentleman | Welcome";
	  String actual=driver.getTitle();
	  Assert.assertEquals(actual, expected);
	  }
	  catch (AssertionError e)
		 {
				System.out.println("DEFECT:The user is  not able to login with blank name field");
		 }
		 
		 
	  finally
		{
			driver.navigate().refresh();
		}
	}
  @Test(priority=7)
  public void blankpasswordfieldlogin() {
	  System.out.println("to verify whether login functionality is working with blank password field");
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys("admin");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div/form/button"));
	  btn.click();
	  try {
	  System.out.println(driver.getTitle());
	  String expected="Gentleman | Welcome";
	  String actual=driver.getTitle();
	  Assert.assertEquals(actual, expected);
	  }
	  
		 catch (AssertionError e)
		 {
				System.out.println("DEFECT:The user is  not able to login with blank password field");
		 }
		 
	  finally
		{
			driver.navigate().refresh();
		}
	}
  @Test(priority=8)
  public void blankinputfieldlogin() {
	  System.out.println("to verify whether login functionality is working with blank input field");
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys("");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div/form/button"));
	  btn.click();
	  try {
	  System.out.println(driver.getTitle());
	  String expected="Gentleman | Welcome";
	  String actual=driver.getTitle();
	  Assert.assertEquals(actual, expected);
	  }
	  catch (AssertionError e)
		 {
				System.out.println("DEFECT:The user is  not able to login with blank input field");
		 }
		 
		 
	  finally
		{
			driver.navigate().refresh();
		}
	}
  @Test(priority=9)
  public void forgotemailid() {
	  System.out.println("to verify navigate to forgotpassword page");
	  WebElement forgot=driver.findElement(By.xpath("/html/body/div/div/a/span"));
	  forgot.click();
	  
	  
	  try {
		  System.out.println(driver.getTitle());
		  String expected="https://www.wahylab.com/gendemo/login/forgot_pass";
		  String actual=driver.getCurrentUrl();
		  Assert.assertEquals(actual, expected);SoftAssert=new SoftAssert();
			SoftAssert.assertEquals(actual, expected, "DEFECT : The link is not present");
			SoftAssert.assertAll();
			
			WebElement error=driver.findElement(By.name("invalid-link;error_message"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("invalid-link;error_message")));
			SoftAssert.assertTrue(error.isDisplayed(), "DEFECT : The link is not present");
			SoftAssert.assertAll();

		  }
	  catch (NoSuchElementException e)
		 {
			 System.out.println("link is not present");
		 }
			 
		  finally
			{
				driver.navigate().refresh();
			}
  }
}
  

 

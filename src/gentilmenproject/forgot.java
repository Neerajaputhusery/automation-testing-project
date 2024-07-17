package gentilmenproject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class forgot {
	ChromeDriver driver;
	SoftAssert 	SoftAssert;
	public forgot(ChromeDriver mdriver) {
		this.driver=mdriver;
	}
	
 @Test(priority=1)
  public void vaildemailid() throws IOException {
	  System.out.println("to verify whether Enter registered email:");
	  WebElement email=driver.findElement(By.id("name"));
	  email.sendKeys("gentleman@gmail.com");
	  WebElement sumbit=driver.findElement(By.xpath("/html/body/div/div[1]/form/center/input"));
	  sumbit.click();
	  
		 try {
		  String expected="Please check your email!";
		  WebElement check=driver.findElement(By.xpath("/html/body/div/div[2]/h2"));
		  String actual=check.getText();
		  Assert.assertTrue(actual.contentEquals(expected));
		 }
		 catch (AssertionError e)
		 {
			 TakesScreenshot screenshot=((TakesScreenshot)driver);
			 File scrnsht=screenshot.getScreenshotAs(OutputType.FILE);
			 Files.copy(scrnsht, new File("‪‪C:\\automationdefect1\\vaildemailid.jpg"));
				System.out.println("DEFECT:wrong message display for valid input");
		 }
		 
		 
		 finally  {
			 driver.navigate().refresh();
		 
		   }
		 
	  }
  
  @Test(priority=2)
  public void invaildemailid() throws IOException {
	  System.out.println("to verify whether Enter not registered email:");
	  WebElement email=driver.findElement(By.id("name"));
	  email.sendKeys("neerajaputhusery@gmail.com");
	  WebElement sumbit=driver.findElement(By.xpath("/html/body/div/div[1]/form/center/input"));
	  sumbit.click();
	  try {
		  String expected="Invalid Email ID !";
		  WebElement check=driver.findElement(By.xpath("/html/body/div/div[3]/h2"));
		  String actual=check.getText();
		  Assert.assertTrue(actual.contentEquals(expected));
		 }
	  catch (AssertionError e)
		 {
		  try {
		  TakesScreenshot screenshot=((TakesScreenshot)driver);
			 File scrnsht=screenshot.getScreenshotAs(OutputType.FILE);
			 Files.copy(scrnsht, new File("‪‪C:\\automationdefect1\\invaildemailid.jpg"));
				System.out.println("DEFECT: wrong message is display for invaild input");
		  }
		  catch ( FileNotFoundException f) {
			  System.out.println("file not found");
		  }
		 }
		 
		 finally  {
			 driver.navigate().refresh();
		 
		   }
		 
	  }
  
  @Test(priority=3)
  public void blankemailid() {
	  System.out.println("to verify whether blank  email field:");
	  WebElement email=driver.findElement(By.id("name"));
	  email.sendKeys("");
	  WebElement sumbit=driver.findElement(By.xpath("/html/body/div/div[1]/form/center/input"));
	  sumbit.click();
	  
	}
  @Test(priority=4)
  public void login() {
	  System.out.println("precondition:Login");
	  driver.get("https://www.wahylab.com/gendemo/login");
	  WebElement username=driver.findElement(By.name("username"));
	  username.sendKeys("admin");
	  WebElement password=driver.findElement(By.name("password"));
	  password.sendKeys("admin@gentleman");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div/form/button"));
	  btn.click();
	  
	}

  
}

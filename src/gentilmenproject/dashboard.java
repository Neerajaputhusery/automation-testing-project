package gentilmenproject;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.opentelemetry.sdk.logs.data.Body;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class dashboard {
	ChromeDriver driver;
	public dashboard(ChromeDriver mdriver) {
		this.driver=mdriver;
	}
  @Test(priority=1)
  public void headerpart() throws IOException {
	  System.out.println("to verify whether clickable and minimize");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/header/nav/a"));
	  btn.click();
	  WebElement header=driver.findElement(By.tagName("body"));
	  String dashboard=header.getAttribute("class");
	  try {
		  String expected="skin-blue sidebar-mini sidebar-collapse";
		  WebElement body=driver.findElement(By.tagName("body"));
		  String actual=dashboard;
		  Assert.assertTrue(actual.contentEquals(expected));
		 }
		 catch (AssertionError e)
		 {
			 /*TakesScreenshot screenshot=((TakesScreenshot)driver);
			 File scrnsht=screenshot.getScreenshotAs(OutputType.FILE);
			 Files.copy(scrnsht, new File("‪‪C:\\automationdefect1\\headerpart.jpg"));*/
				System.out.println("DEFECT:hamburger_button is not working");
		 }
		 
		 
		 finally  {
			 driver.navigate().refresh();
		 
		   }
		 
	  
}
  @Test(priority=2)
  public void welcome() throws IOException {
	  System.out.println("to verify whether clickable welcome admin");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li[1]"));
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/header/nav/div/ul/li[1]")));
	  Actions button=new Actions(driver);
	  button.moveToElement(btn).click().perform();
	  
	  try {
		  WebElement box=driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li[1]/ul"));
		 
		    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			box = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/header/nav/div/ul/li[1]/ul")));
			Assert.assertTrue(box.isDisplayed());
		 }
		 catch (AssertionError  | TimeoutException | NoSuchElementException  e)
		 {
			 /*TakesScreenshot screenshot=((TakesScreenshot)driver);
			 File scrnsht=screenshot.getScreenshotAs(OutputType.FILE);
			 Files.copy(scrnsht, new File("‪‪C:\\automationdefect1\\headerpart.jpg"));*/
				System.out.println("DEFECT:welcome_admin button is not working");
		 }
		 
		 
		 finally  {
			 driver.navigate().refresh();
			 btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/header/nav/div/ul/li[1]")));
			  button.moveToElement(btn).click().perform();
			  
			
		 
		   }
		 
	  
}
  @Test(priority=3)
  public void signout() throws IOException {
	  System.out.println("to verify whether clickable welcome admin");
	  WebElement signout=driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li[1]/ul/li[2]/div[2]/a"));
	  signout.click();
	  System.out.println(driver.getTitle());
		 try {
		  String expected="Gentleman | Welcome";
		  String actual=driver.getTitle();
		  Assert.assertEquals(actual, expected);
		 }

			catch (AssertionError e)
		 {
				System.out.println("DEFECT: signout is not working ");
		 }
		 
		 
		 finally  {
		 
			 driver.navigate().refresh();
		 }
		 
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

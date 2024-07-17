package gentilmenproject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class dashboardtitle {
	ChromeDriver driver;
	public dashboardtitle(ChromeDriver mdriver) {
		this.driver=mdriver;
	}
  @Test(priority=1)
	  public void dashboard() throws IOException {
		  System.out.println("to verify whether clickable e");
		  WebElement btn=driver.findElement(By.xpath("//*[@id=\"navi\"]/li[1]"));
		  btn.click();
		  try {
			  System.out.println(driver.getTitle());
			  String expected="https://www.wahylab.com/gendemo/Dashboard";
			  String actual=driver.getCurrentUrl();
				Assert.assertEquals(actual, expected);
			  }
		  catch (NoSuchElementException e)
			 {
				 System.out.println("\"DEFECT : The link is not present");
			 }
				 
			  finally
				{
					driver.navigate().refresh();
				}
			}
	  
  @Test(priority=2)
  public void designtion () throws IOException {
	  System.out.println("to verify whether click and naviage to designation");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[2]/div/a"));
	  btn.click();
	  try {
		  System.out.println(driver.getTitle());
		  String expected="https://www.wahylab.com/gendemo/NewMaster/showDesignation";
		  String actual=driver.getCurrentUrl();
			Assert.assertEquals(actual, expected);
		  }
	  catch (NoSuchElementException e)
		 {
			 System.out.println("\"DEFECT : The link is not present");
		 }
			 
		  finally
			{
			  driver.navigate().back();
			}
		}
  
@Test(priority=3)
public void Items () throws IOException {
  System.out.println("to verify whether click and naviage to Items");
  WebElement btn=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[3]/div/a"));
  btn.click();
  try {
	  System.out.println(driver.getTitle());
	  String expected="https://www.wahylab.com/gendemo/NewMaster/showMasterOpeningStock";
	  String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
	  }
  catch (NoSuchElementException e)
	 {
		 System.out.println("\"DEFECT : The link is not present");
	 }
		 
	  finally
		{
			driver.navigate().back();
		}
	}
  @Test(priority=4)
  public void Mutualbranchtransferrequest () throws IOException {
	  System.out.println("to verify whether click and naviage to Mutualbranchtransferrequest");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[4]/div/a"));
	  btn.click();
	  try {
		  System.out.println(driver.getTitle());
		  String expected="https://www.wahylab.com/gendemo/newMaster/showB2bRequest";
		  String actual=driver.getCurrentUrl();
			Assert.assertEquals(actual, expected);
		  }
	  catch (NoSuchElementException e)
		 {
			 System.out.println("\"DEFECT : The link is not present");
		 }
			 
		  finally
			{
			  driver.navigate().back();
			}
		}
  @Test(priority=5)
  public void BranchestockRequestApproval () throws IOException {
	  System.out.println("to verify whether click and naviage to Branche stock Request Approval");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[5]/div/a"));
	  btn.click();
	  try {
		  System.out.println(driver.getTitle());
		  String expected="https://www.wahylab.com/gendemo/NewMaster/showBranchItemRequestsPage";
		  String actual=driver.getCurrentUrl();
			Assert.assertEquals(actual, expected);
		  }
	  catch (NoSuchElementException e)
		 {
			 System.out.println("\"DEFECT : The link is not present");
		 }
			 
		  finally
			{
			  driver.navigate().back();
			}
		}
  @Test(priority=6)
  public void Branches() throws IOException {
	  System.out.println("to verify whether click and naviage to Branches");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[6]/div/a"));
	  btn.click();
	  try {
		  System.out.println(driver.getTitle());
		  String expected="https://www.wahylab.com/gendemo/NewMaster/showBranchLists";
		  String actual=driver.getCurrentUrl();
			Assert.assertEquals(actual, expected);
		  }
	  catch (NoSuchElementException e)
		 {
			 System.out.println("\"DEFECT : The link is not present");
		 }
			 
		  finally
			{
			  driver.navigate().back();
			}
		}
  @Test(priority=7,enabled=false)
  public void Stock () throws IOException, InterruptedException {
	  System.out.println("to verify whether click and naviage to Categorys ");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[7]/div/a"));
	 btn.click();
	  try {
		  System.out.println(driver.getTitle());
		  
		  String expected="https://www.wahylab.com/gendemo/NewMaster/showMasterStock";
		  String actual=driver.getCurrentUrl();
			Assert.assertEquals(actual, expected);
		  }
	  catch (NoSuchElementException e)
		 {
			 System.out.println("\"DEFECT : The link is not present");
		 }
			 
		  finally
			{
			  driver.navigate().back();
			  driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
			  driver.get("https://www.wahylab.com/gendemo/NewMaster/showMasterStock");
			  try 
		      {
				  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		          wait.until(ExpectedConditions.alertIsPresent());
		          Alert alert = driver.switchTo().alert();
		          System.out.println(alert.getText());
		          alert.accept(); 
		      } 
		  catch (TimeoutException e) 
		  {
		          System.out.println("Alert not displayed within timeout");
		      } 

			  
			}
		}
  @Test(priority=8)
  public void Categorys () throws IOException {
	  System.out.println("to verify whether click and naviage to Category Details ");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[8]/div/a"));
	  btn.click();
	  try {
		  System.out.println(driver.getTitle());
		  String expected="https://www.wahylab.com/gendemo/NewMaster/showCategory";
		  String actual=driver.getCurrentUrl();
			Assert.assertEquals(actual, expected);
		  }
	  catch (NoSuchElementException e)
		 {
			 System.out.println("\"DEFECT : The link is not present");
		 }
			 
		  finally
			{
			  driver.navigate().back();
			}
		}
  @Test(priority=9)
  public void TotalEmployees () throws IOException {
	  System.out.println("to verify whether click and naviage to Total Employees ");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[9]/div/a"));
	  btn.click();
	  try {
		  System.out.println(driver.getTitle());
		  String expected="https://www.wahylab.com/gendemo/NewMaster/ShowEmployeeList";
		  String actual=driver.getCurrentUrl();
			Assert.assertEquals(actual, expected);
		  }
	  catch (NoSuchElementException e)
		 {
			 System.out.println("\"DEFECT : The link is not present");
		 }
			 
		  finally
			{
			  driver.navigate().back();
			}
		}
  @Test(priority=10)
  public void BranchReturns () throws IOException {
	  System.out.println("to verify whether click and naviage to Stock Return Details ");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[10]/div/a"));
	  btn.click();
	  try {
		  System.out.println(driver.getTitle());
		  String expected="https://www.wahylab.com/gendemo/newMaster/showBranchReturn";
		  String actual=driver.getCurrentUrl();
			Assert.assertEquals(actual, expected);
		  }
	  catch (NoSuchElementException e)
		 {
			 System.out.println("\"DEFECT : The link is not present");
		 }
			 
		  finally
			{
			  driver.navigate().back();
			}
		}
  @Test(priority=11)
  public void Vendors () throws IOException {
	  System.out.println("to verify whether click and naviage to Vendor Details");
	  WebElement btn=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[11]/div/a"));
	  btn.click();
	  try {
		  System.out.println(driver.getTitle());
		  String expected="https://www.wahylab.com/gendemo/NewMaster/showVendor";
		  String actual=driver.getCurrentUrl();
			Assert.assertEquals(actual, expected);
		  }
	  catch (NoSuchElementException e)
		 {
			 System.out.println("\"DEFECT : The link is not present");
		 }
			 
		  finally
			{
			  driver.navigate().back();
			}
		}

@Test(priority=12)
public void ReorderNotificationMaster () throws IOException {
System.out.println("to verify whether click and naviage to Master ROP Details");
WebElement btn=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[12]/div/a"));
btn.click();
try {
  System.out.println(driver.getTitle());
  String expected="https://www.wahylab.com/gendemo/NewMaster/showMasterReorder";
  String actual=driver.getCurrentUrl();
	Assert.assertEquals(actual, expected);
  }
catch (NoSuchElementException e)
 {
	 System.out.println("\"DEFECT : The link is not present");
 }
	 
  finally
	{
	  driver.navigate().back();
	}
}

}
  
  
  
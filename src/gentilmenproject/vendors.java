package gentilmenproject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class vendors {
	ChromeDriver driver;
	public vendors(ChromeDriver mdriver) {
		this.driver=mdriver;
	}
  @Test(priority=1)
  public void vendors() {
	  System.out.println("to verify check whether vendors button clickable");
		WebElement btn=driver.findElement(By.xpath("//body/div[1]/aside[1]/section[1]/ul[1]/li[3]/a[1]"));
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
  }
  @Test(priority=2)
	public void Home() {
		System.out.println("to verify check whether home button clickable");
		WebElement btn=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/ol/li[1]/a"));
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

		finally {
			WebElement btn1=driver.findElement(By.xpath("//*[@id=\"navi\"]/li[3]/a"));
			btn1.click();
		}
	}
  @Test(priority=3)
	public void back() {
		System.out.println("to verify check whether naviagte back button");
		WebElement btn=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/ol/li[2]/a"));
		btn.click();
		try {
			WebElement back=driver.findElement(By.xpath("//body/div[1]/aside[1]/section[1]/ul[1]/li[1]/a[1]"));
			String expected="";
			String actual=back.getText();
			Assert.assertEquals(actual,expected);
		}
		catch (AssertionError e)
		{
			System.out.println("DEFECT:back button is not working");
		}

		finally {
		}
	}
  
  @Test(priority=4)
	public void search() throws InterruptedException {
		System.out.println("to verify check whether search vendors Name");
		WebElement btn=driver.findElement(By.xpath("//*[@id=\"designation_table_filter\"]/label/input"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		btn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table_filter\"]/label/input")));
		Actions button=new Actions(driver);
		button.moveToElement(btn).click().sendKeys("Nidhin").perform();
		btn.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		try {
			String expected="Nidhin";
			WebElement search=driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr/td[2]"));
			search= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table\"]/tbody/tr/td[2]")));
			button.moveToElement(search).build().perform();


			String actual=search.getText();
			Assert.assertTrue(actual.contentEquals(expected));
		}
		catch (AssertionError e)
		{
			System.out.println("DEFECT:wrong vendors name display for search button");
		}

		finally {
		}
	}
  
  @Test(priority=5)
	public void dropdown() throws InterruptedException {
		System.out.println("to verify check whether clickable dropdown");
		WebElement clk=driver.findElement(By.xpath("//*[@id=\"designation_table_length\"]/label/select"));
		clk.click();
		WebElement dd=driver.findElement(By.name("designation_table_length"));
		Select select=new Select(dd);
		select.selectByValue("100");
		/* select.selectByVisibleText("100"); 
select.selectByIndex(0);*/
		driver.navigate().refresh();
		Thread.sleep(1000);
	}
  @Test(priority=7)
  public void excel() throws InterruptedException {
      System.out.println("to verify check whether check download excel sheet");
      WebElement excel = driver.findElement(By.xpath("//span[contains(text(),'Excel')]"));
  long startTime = System.currentTimeMillis();
      excel.click();

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1)); 
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Excel')]"))); 

      String excelLocation = System.getProperty("user.dir") + "/Downloads/GENTLEMAN.xlsx";
      File file = new File(excelLocation);
      int waitTime = 0;
      while(!file.exists() || (file.exists() && file.lastModified() <= startTime)) {
          Thread.sleep(1000); 
          waitTime++;
          if (waitTime > 10) { 
              break;
          }
      }

      if (file.exists() && file.length() > 0) {
          System.out.println("Excel Download : " + excelLocation + " is downloaded");
          file.delete(); 
      } else {
          System.out.println("DEFECT: Excel is not downloaded or failed to verify within timeout.");
      }

  }
	@Test(priority=6,enabled=false)
	public void pdf() throws InterruptedException {
		System.out.println("to verify check whether check download pdf file");
		WebElement pdf = driver.findElement(By.xpath("//*[@id=\"designation_table_wrapper\"]/div[2]/a[3]/span"));
		pdf.click();
		Thread.sleep(3000);
		try 
		{
			String pdfLocation =System.getProperty("user.dir") + "/Downloads/GENTLEMAN.pdf";
			File file = new File(pdfLocation);
			Assert.assertTrue(file.exists());
			System.out.println("Excel Download : "+ pdfLocation + " is downloaded");
			file.delete();
		}
		catch ( AssertionError e) 
		{
			System.out.println("DEFECT:pdf is not downloaded: "+e);
		}
		finally 
		{
			driver.navigate().refresh();
		}

	}
	
	@Test(priority=7)
	public void print() {
		System.out.println("to verify check whether working print button");
		WebElement print = driver.findElement(By.xpath("//*[@id=\"designation_table_wrapper\"]/div[2]/a[4]"));
		print.click();
		Set<String>totalwindow=driver.getWindowHandles();
		Iterator<String>window=totalwindow.iterator();
		window.hasNext();
		String firstwindow=window.next();
		String secondwindow=window.next();
		driver.switchTo().window(secondwindow);
		System.out.println("Print : Navigates to print page");
		try
		{
			String expected = "about:blank";
			String actual = driver.getCurrentUrl();
			Assert.assertEquals(actual,expected);
		}
		catch(AssertionError e)
		{
			System.out.println("DEFECT : Print button is not working");
		}
		finally
		{
			driver.close();
			driver.switchTo().window(firstwindow);
		}
	}
	@Test(priority=8,enabled=false)
	public void csv() throws InterruptedException {
		System.out.println("to verify check whether check download pdf file");
		WebElement csv = driver.findElement(By.xpath("//*[@id=\"designation_table_wrapper\"]/div[2]/a[5]"));
		csv.click();
		Thread.sleep(3000);
		try 
		{
			String csvLocation =System.getProperty("user.dir") + "/Downloads/GENTLEMAN.csv";
			File file = new File(csvLocation);
			Assert.assertTrue(file.exists());
			System.out.println("Excel Download : "+ csvLocation + " is downloaded");
			file.delete();
		}
		catch ( AssertionError e) 
		{
			System.out.println("DEFECT:csv is not downloaded: "+e);
		}
		finally 
		{
			driver.navigate().refresh();
		}

	}
	  @Test(priority=9)
		public void slno() throws InterruptedException {
			System.out.println("to verify check slno working ascending descending order");
			WebElement btn=driver.findElement(By.xpath("//th[contains(text(),'Slno')]"));
			btn.click();
			try {
				String expectedText = "10";
				WebElement targetElement = driver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[1]")));
				String actualText = targetElement.getText().trim();
				Assert.assertEquals(actualText,expectedText);
			}
			catch (AssertionError |NotFoundException e)
			{
				System.out.println("DEFECT:slno is not working ascending descending order " +e);
			}

			finally {
			}
		}
	  
	  @Test(priority=10)
		public void addvendor() 
		{
			System.out.println("to verify check whether click add user button");
			WebElement addbtn=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div[1]/div[2]/a"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			addbtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/section[2]/div/div/div[1]/div[2]/a")));
			//		Actions button=new Actions(driver);
			//		button.moveToElement(addbtn1).click().perform();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div[1]/div[2]/a")));
			try 
			{
				WebElement add=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[2]"));
				add= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[2]")));
				Assert.assertTrue(add.isDisplayed());
			}
			catch (AssertionError  | TimeoutException | NoSuchElementException  e)
			{
				System.out.println("DEFECT:add vendor  button is not working");
			}
		}
	  @Test(priority=14)
		public void vaildusername() throws InterruptedException 
		{
			System.out.println("to verify whether  functionality is working with valid inputs");
			String VendorName="Neerajap";
			String address="Neerajahome670702";
			String Email="neerajaputhusery@gmail.com";
			String phonenumber="8075474902";
			String GST="0ABCU690R1S2";
			String PAN="BASR2323OP";
			WebElement Vendorname=driver.findElement(By.cssSelector("#designation"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			Vendorname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#designation")));
			Actions button=new Actions(driver);
			Thread.sleep(1000);
			button.moveToElement(Vendorname).click().sendKeys(VendorName).perform();
			WebElement adress=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/textarea[1]"));
			adress= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/textarea[1]")));
			button.moveToElement(adress).click().sendKeys(address).perform();
			Thread.sleep(1000);
			WebElement email=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[3]/div[1]/input[1]"));
			email= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[3]/div[1]/input[1]")));
			button.moveToElement(email).click().sendKeys(Email).perform();
			Thread.sleep(1000);
			WebElement phonenumber1=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[4]/div[1]/input[1]"));
			phonenumber1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[4]/div[1]/input[1]")));
			button.moveToElement(phonenumber1).click().sendKeys(phonenumber).perform();
			Thread.sleep(1000);
			WebElement gst=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[5]/div[1]/input[1]"));
			gst= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[5]/div[1]/input[1]")));
			button.moveToElement(gst).click().sendKeys(GST).perform();
			Thread.sleep(1000);
			WebElement pan=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[6]/div[1]/input[1]"));
			pan= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[6]/div[1]/input[1]")));
			button.moveToElement(pan).click().sendKeys(PAN).perform();
			Thread.sleep(1000);
			WebElement addbtn=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[2]/div[7]/div/input"));
			addbtn.click();
			Thread.sleep(2000);
			try
			{
				WebElement vendorname=driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[2]"));
				vendorname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[2]")));
				button.moveToElement(vendorname).build().perform();
				String emptext=vendorname.getText();
				Assert.assertTrue(emptext.contentEquals(VendorName));
			}
			catch (AssertionError e)
			{
				System.out.println("DEFECT:  vendor name is not added ");
			}
			finally  
			{
				driver.navigate().refresh();
				Thread.sleep(1000);
			}
		}
	  
	  @Test(priority=15)
		public void invaildusername() throws InterruptedException {
			System.out.println("to verify check whether navigate click add user button");
			WebElement addbtn=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div[1]/div[2]/a"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			addbtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/section[2]/div/div/div[1]/div[2]/a")));
			//		Actions button=new Actions(driver);
			//		button.moveToElement(addbtn).click().perform();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div[1]/div[2]/a")));
			System.out.println("to verify whether functionality is working with invalid inputs");
			String data=String.valueOf(1234);
			// String name = NumberToTextConverter.toText(data);
			String address="@#$%";
			String Email="neerajaputhusery@gmailCOM";
			String phonenumber="807547490212345";
			String GST="avcbd";
			String PAN="xyz";
			
			WebElement vendorname=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]"));
			
			vendorname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]")));
			Actions button=new Actions(driver);
			button.moveToElement(vendorname).build().perform();
			js.executeScript("arguments[0].setAttribute('value', arguments[1])", vendorname, data);
			WebElement adress=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/textarea[1]"));
			adress= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/textarea[1]")));
			button.moveToElement(adress).click().sendKeys(address).perform();
			Thread.sleep(1000);
			WebElement email=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[3]/div[1]/input[1]"));
			email= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[3]/div[1]/input[1]")));
			button.moveToElement(email).click().sendKeys(Email).perform();
			Thread.sleep(1000);
			WebElement phonenumber1=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[4]/div[1]/input[1]"));
			phonenumber1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[4]/div[1]/input[1]")));
			button.moveToElement(phonenumber1).click().sendKeys(phonenumber).perform();
			Thread.sleep(1000);
			WebElement gst=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[5]/div[1]/input[1]"));
			gst= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[5]/div[1]/input[1]")));
			button.moveToElement(gst).click().sendKeys(GST).perform();
			Thread.sleep(1000);
			WebElement pan=driver.findElement(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[6]/div[1]/input[1]"));
			pan= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[6]/div[1]/input[1]")));
			button.moveToElement(pan).click().sendKeys(PAN).perform();
			Thread.sleep(1000);
			WebElement addbtn1=driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[2]/div[7]/div/input"));
			addbtn1.click();
			Thread.sleep(2000);
			try
			{
				WebElement vendorname1=driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[2]"));
				vendorname1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[2]")));
				button.moveToElement(vendorname1).build().perform();
				String emptext=vendorname1.getText();
				Assert.assertTrue(emptext.contentEquals(data));
			}
			catch (AssertionError e)
			{
				System.out.println("DEFECT:  vendor name is not added ");
			}
			finally  
			{
				driver.navigate().refresh();
				Thread.sleep(1000);
			}
		}
	  @Test(priority = 16)
	  public void testDeleteButton() {
	      System.out.println("Navigate to the page with delete button");
	      WebElement deleteButton = driver.findElement(By.xpath("//tbody/tr[3]/td[8]/center[1]/a[2]/i[1]"));
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
	      deleteButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[3]/td[8]/center[1]/a[2]/i[1]")));
	      Actions actions = new Actions(driver);
	      actions.moveToElement(deleteButton).click().perform();
	      try 
	      {
	          wait.until(ExpectedConditions.alertIsPresent());
	          Alert alert = driver.switchTo().alert();
	          System.out.println(alert.getText());
	          alert.accept(); 
	      } 
	  catch (TimeoutException e) 
	  {
	          System.out.println("Alert not displayed within timeout");
	      } 
	  catch (NoSuchElementException e) 
	  {
	          System.out.println("Defect: Delete button not found or is not clickable");
	      }
	  }
	 
	  	
			
  
 
}

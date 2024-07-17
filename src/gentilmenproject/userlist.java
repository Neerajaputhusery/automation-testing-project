package gentilmenproject;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class userlist {
	ChromeDriver driver;
	public userlist(ChromeDriver mdriver) {
		this.driver=mdriver;
	}
	@Test(priority=1)
	public void userlist() {
		System.out.println("to verify check whether userlist button clickable");
		WebElement btn=driver.findElement(By.xpath("//*[@id=\"navi\"]/li[2]/a"));
		btn.click();
		try {
			System.out.println(driver.getTitle());
			String expected="https://www.wahylab.com/gendemo/NewMaster/showLoginUsersList";
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
			WebElement btn1=driver.findElement(By.xpath("//*[@id=\"navi\"]/li[2]/a"));
			btn1.click();
		}
	}
	@Test(priority=3)
	public void search() throws InterruptedException {
		System.out.println("to verify check whether search Employee Name");
		WebElement btn=driver.findElement(By.xpath("//*[@id=\"designation_table_filter\"]/label/input"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		btn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table_filter\"]/label/input")));
		Actions button=new Actions(driver);
		button.moveToElement(btn).click().sendKeys("Akhilasa").perform();
		btn.sendKeys(Keys.ENTER);
		Thread.sleep(1000);          //*[@id="designation_table"]/tbody/tr/td[2]"}
		try {
			String expected="Akhilasa";
			WebElement search=driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr/td[2]"));
			search= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table\"]/tbody/tr/td[2]")));
			button.moveToElement(search).build().perform();


			String actual=search.getText();
			Assert.assertTrue(actual.contentEquals(expected));
		}
		catch (AssertionError e)
		{
			System.out.println("DEFECT:wrong employee name display for search button");
		}

		finally {
		}
	}
	@Test(priority=4)
	public void back() {
		System.out.println("to verify check whether naviagte back button");
		WebElement btn=driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/ol/li[2]/a"));
		btn.click();
		try {
			WebElement search=driver.findElement(By.xpath("//*[@id=\"designation_table_filter\"]/label/input"));
			String expected="";
			String actual=search.getText();
			Assert.assertEquals(actual,expected);
		}
		catch (AssertionError e)
		{
			System.out.println("DEFECT:wrong employee name display for search button");
		}

		finally {          
		}
	}
	@Test(priority=6)
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
		WebElement excel = driver.findElement(By.xpath("//*[@id=\"designation_table_wrapper\"]/div[2]/a[2]"));
		excel.click();

		/*	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"designation_table_wrapper\"]/div[2]/a[2]"))); 

	    String excelLocation = System.getProperty("user.dir") + "/Downloads/GENTLEMAN.xlsx";
	    File file = new File(excelLocation);
	    int waitTime = 0;
	    while (!file.exists() || file.length() == 0) {
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
	    }*/
		
		Thread.sleep(3000);
		try 
		{
			String ExcelLocation =System.getProperty("user.dir") + "/Downloads/GENTLEMAN.xlsx";
			File file = new File(ExcelLocation);
			Assert.assertTrue(file.exists());
			System.out.println("Excel Download : "+ ExcelLocation + " is downloaded");
			file.delete();
		}
		catch ( AssertionError e) 
		{
			System.out.println("DEFECT:Excel is not downloaded: "+e);
		}
		finally 
		{
			driver.navigate().refresh();
		}

	}

	@Test(priority=8,enabled=false)
	public void pdf() throws InterruptedException {
		System.out.println("to verify check whether check download pdf file");
		WebElement pdf = driver.findElement(By.xpath("//*[@id=\"designation_table_wrapper\"]/div[2]/a[3]"));
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
	@Test(priority=9)
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
	@Test(priority=10,enabled=false)
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

	@Test(priority=11)
	public void slno() throws InterruptedException, IOException {
		System.out.println("to verify check slno working ascending descending order");
		WebElement btn=driver.findElement(By.xpath("//th[contains(text(),'Slno')]"));
		btn.click();
		try {
			String expectedText = "100";
			WebElement targetElement = driver.findElement(By.cssSelector("body.skin-blue.sidebar-mini:nth-child(2) div.wrapper div.content-wrapper:nth-child(3) section.content div.row div.box div.box-body.table-responsive div.dataTables_wrapper.form-inline.dt-bootstrap.no-footer div.dataTables_scroll div.dataTables_scrollHead div.dataTables_scrollHeadInner table.table.table-bordered.table-striped.dataTable.no-footer thead:nth-child(1) tr:nth-child(1) > th.sorting_desc:nth-child(1)"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body.skin-blue.sidebar-mini:nth-child(2) div.wrapper div.content-wrapper:nth-child(3) section.content div.row div.box div.box-body.table-responsive div.dataTables_wrapper.form-inline.dt-bootstrap.no-footer div.dataTables_scroll div.dataTables_scrollHead div.dataTables_scrollHeadInner table.table.table-bordered.table-striped.dataTable.no-footer thead:nth-child(1) tr:nth-child(1) > th.sorting_desc:nth-child(1)")));
			String actualText = targetElement.getText().trim();
			Assert.assertEquals(actualText,expectedText);
		}
		catch (AssertionError |NotFoundException e)
		{
			System.out.println("DEFECT:slno is not working ascending descending order " +e);
			
		}

		finally {
			driver.navigate().refresh();
			Thread.sleep(1000);
		}
	}
	@Test(priority=12)
	public void nextpage() throws InterruptedException {
		System.out.println("to verify check whether naviage to next page");
		WebElement text=driver.findElement(By.xpath("//*[@id=\"designation_table_info\"]"));
		String firstPageDataRange = text.getText();
		int totalEntries = Integer.parseInt(firstPageDataRange.split("of ")[1].split(" ")[0]);
		Thread.sleep(1000);
		Actions mouse=new Actions(driver);
		WebElement next=driver.findElement(By.xpath("//*[@id=\"designation_table_next\"]/a"));
		mouse.moveToElement(next).click().perform();
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		try {
			String secondPageDataRange = text.getText();
			String[] firstPageData = firstPageDataRange.split(" ");
			int firstPageStartIndex = Integer.parseInt(firstPageData[1]);
			int firstPageEndIndex = Integer.parseInt(firstPageData[3]);
			String[] secondPageData = secondPageDataRange.split(" ");
			int secondPageStartIndex = Integer.parseInt(secondPageData[1]);

			Assert.assertTrue(totalEntries == Integer.parseInt(secondPageData[5]) && 
					secondPageStartIndex == firstPageEndIndex + 1) ;
		}
		catch(AssertionError e) {
			System.out.println("Next button functionality might be broken!");
		}
		finally
		{
			js.executeScript("window.scrollTo(0,0)");
			driver.navigate().refresh();
		}
	}

	@Test(priority=13)
	public void adduser() 
	{
		System.out.println("to verify check whether click add user button");
		WebElement addbtn=driver.findElement(By.xpath("//option[contains(text(),'ADMIN')]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		addbtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add user')]")));
		//		Actions button=new Actions(driver);
		//		button.moveToElement(addbtn).click().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[contains(text(),'Add user')]")));
		try 
		{
			WebElement add=driver.findElement(By.xpath("//button[contains(text(),'ADD USER')]"));
			add= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'ADD USER')]")));
			Assert.assertTrue(add.isDisplayed());
		}
		catch (AssertionError  | TimeoutException | NoSuchElementException  e)
		{
			System.out.println("DEFECT:add user button is not working");
		}
	}
	@Test(priority=14)
	public void vaildusername() throws InterruptedException 
	{
		System.out.println("to verify whether  functionality is working with valid inputs");
		String name="Aryas";
		String employeepassword="Arya@1234";
		String employeemail="aryasuresh@gmail.com";
		WebElement username=driver.findElement(By.cssSelector("#username1"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username1")));
		Actions button=new Actions(driver);
		Thread.sleep(1000);
		button.moveToElement(username).click().sendKeys(name).perform();
		WebElement password=driver.findElement(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]"));
		password= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]")));
		button.moveToElement(password).click().sendKeys(employeepassword).perform();
		WebElement email=driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]"));
		email= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]")));
		button.moveToElement(email).click().sendKeys(employeemail).perform();
		System.out.println("to verify check whether clickable dropdown");
		WebElement clk=driver.findElement(By.xpath("//*[@id=\"user_type\"]"));
		clk.click();
		System.out.println("to verify check whether clickable dropdown");
		WebElement type=driver.findElement(By.xpath("//*[@id=\"user_type\"]"));
		type.click();
		WebElement dd=driver.findElement(By.name("user_type"));
		Select select=new Select(dd);
		select.selectByValue("A");
		WebElement branch=driver.findElement(By.xpath("//*[@id=\"branchSelect\"]"));
		branch.click();
		WebElement bname=driver.findElement(By.name("branch_id"));
		Select select1=new Select(bname);
		select1.selectByValue("Harippad");
		WebElement addbtn=driver.findElement(By.xpath("//*[@id=\"addUserForm\"]/div[2]/button[2]"));
		addbtn.click();
		WebElement okbtn=driver.findElement(By.xpath("/html/body/div[2]/div/div[10]/button[1]"));
		okbtn.click();
		Thread.sleep(2000);
		try
		{
			WebElement empname=driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[2]"));
			empname= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[2]")));
			button.moveToElement(empname).build().perform();
			String emptext=empname.getText();
			Assert.assertTrue(emptext.contentEquals(name));
		}
		catch (AssertionError e)
		{
			System.out.println("DEFECT:wrong employee name  display for search button");
		}
		finally  
		{
			driver.navigate().refresh();
			Thread.sleep(1000);
		}
	}
	@Test(priority=15)
	public void vaildedit() throws InterruptedException {
		System.out.println("to verify check whether working edit  button");
		WebElement editbtn=driver.findElement(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		editbtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[1]")));
		Actions button=new Actions(driver);
		button.moveToElement(editbtn).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[1]")));
		System.out.println("to verify whether  functionality is working with valid inputs");
		String name="Jasna1";
		String employeepassword="Jasna1234";
		String employeemail="jasnaraju81@gmail.com";
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
		button.moveToElement(username).click().sendKeys(name).perform();


		WebElement password=driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]"));
		password= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]")));

		button.moveToElement(password).click().sendKeys(employeepassword).perform();

		WebElement email=driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]"));
		email= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]")));
		button.moveToElement(email).click().sendKeys(employeemail).perform();
		WebElement addbtn=driver.findElement(By.xpath("//button[contains(text(),'Modify')]"));
		addbtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Modify')]")));
		button.moveToElement(addbtn).click().perform();


		try {
			WebElement okbtn=driver.findElement(By.xpath("/html/body/div[2]/div"));

			Assert.assertTrue(okbtn.isDisplayed());
		}
		catch (AssertionError |NoSuchElementException e)
		{

			System.out.println("DEFECT:details not editable edit function is not working");
		}

		finally  
		{
			WebElement modifybtn=driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
			modifybtn.click();
			driver.navigate().refresh();
			Thread.sleep(1000);
			WebElement dlt=driver.findElement(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[2]"));
			dlt= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[2]")));
			button.moveToElement(dlt).build().perform();
			js.executeScript("arguments[0].click();", dlt);
			WebElement confirm=driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
			confirm= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Confirm')]")));
			button.moveToElement(confirm).click().perform();
			WebElement dltok=driver.findElement(By.xpath("/html/body/div[2]/div/div[10]/button[1]"));
			dltok.click();
			driver.navigate().refresh();
		}
	}

	@Test(priority=16)
	public void invaildusername() throws InterruptedException {
		System.out.println("to verify check whether navigate click add user button");
		WebElement addbtn=driver.findElement(By.xpath("//button[contains(text(),'Add user')]"));     
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		addbtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add user')]")));
		//		Actions button=new Actions(driver);
		//		button.moveToElement(addbtn).click().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[contains(text(),'Add user')]")));
		System.out.println("to verify whether functionality is working with invalid inputs");
		String data=String.valueOf(1234);
		// String name = NumberToTextConverter.toText(data);
		String employeepassword="#$%@";
		String employeemail="neerajaputhusery@COM";
		WebElement username=driver.findElement(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"));

		username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]")));
		Actions button=new Actions(driver);
		button.moveToElement(username).build().perform();
		js.executeScript("arguments[0].setAttribute('value', arguments[1])", username, data);
		WebElement password=driver.findElement(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]"));
		password= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]")));
		button.moveToElement(password).click().sendKeys(employeepassword).perform();
		WebElement email=driver.findElement(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]"));
		username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]")));
		button.moveToElement(email).click().sendKeys(employeemail).perform();
		System.out.println("to verify check whether clickable dropdown");
		WebElement clk=driver.findElement(By.xpath("//*[@id=\"user_type\"]"));
		clk.click();
		System.out.println("to verify check whether clickable dropdown");
		WebElement type=driver.findElement(By.xpath("//*[@id=\"user_type\"]"));
		type.click();
		WebElement dd=driver.findElement(By.name("user_type"));
		Select select=new Select(dd);
		select.selectByValue("S");
		WebElement branch=driver.findElement(By.xpath("//*[@id=\"branchSelect\"]"));
		branch.click();
		WebElement bname=driver.findElement(By.name("branch_id"));
		Select select1=new Select(bname);
		select1.selectByValue("Thalayolaparambu");
		WebElement addbtn1=driver.findElement(By.xpath("//*[@id=\"addUserForm\"]/div[2]/button[2]"));
		addbtn1.click();
		WebElement okbtn=driver.findElement(By.xpath("/html/body/div[2]/div/div[10]/button[1]"));
		okbtn.click();
		try {
			WebElement error=driver.findElement(By.name("invalid-name;error_message"));
			error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("invalid-name;error_message")));
			Assert.assertTrue(error.isDisplayed());
		}
		catch(AssertionError | TimeoutException | NoSuchElementException e) {
			System.out.println("DEFECT : The error message showing incorrectness in the name field is not displayed.");
		}

		finally {
			WebElement dlt=driver.findElement(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[2]"));
			dlt= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[2]")));  
			button.moveToElement(dlt).build().perform();
			js.executeScript("arguments[0].click();", dlt);
			WebElement confirm=driver.findElement(By.xpath("//*[@id=\"deleteModal\"]/div/div/form/div[2]/button[2]"));
			confirm= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"deleteModal\"]/div/div/form/div[2]/button[2]")));
			button.moveToElement(confirm).click().perform();
			WebElement dltok=driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
			dltok= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
			button.moveToElement(dltok).click().perform();
			driver.navigate().refresh();
			Thread.sleep(1000);


		}
	}

	@Test(priority=17)
	public void invaildedit() throws InterruptedException {
		System.out.println("to verify check whether working edit  button");   
		WebElement editbtn=driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[4]/center/button[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		editbtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[4]/center/button[1]")));
		Actions button=new Actions(driver);
		button.moveToElement(editbtn).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"designation_table\"]/tbody/tr[1]/td[4]/center/button[1]")));
		System.out.println("to verify whether  functionality is working with invalid inputs");
		String name="12345";
		String employeepassword="#$%@";
		String employeemail="neerajaputhusery@COM@";
		WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		username= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
		button.moveToElement(username).click().sendKeys(name).perform();


		WebElement password=driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]"));
		password= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]")));

		button.moveToElement(password).click().sendKeys(employeepassword).perform();

		WebElement email=driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]"));
		email= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]")));
		button.moveToElement(email).click().sendKeys(employeemail).perform();
		WebElement addbtn=driver.findElement(By.xpath("//button[contains(text(),'Modify')]"));
		addbtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Modify')]")));
		button.moveToElement(addbtn).click().perform();

		try {

			WebElement error=driver.findElement(By.name("invalid-name;error_message"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			error = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("invalid-name;error_message")));
			Assert.assertTrue(error.isDisplayed());

		}
		catch(AssertionError  | TimeoutException | NoSuchElementException  e) {
			System.out.println("DEFECT : The error message showing incorrectness in the name field is not displayed.");
		}
		finally
		{
			driver.navigate().refresh();
			Thread.sleep(1000);
		}
	}
	@Test(priority=18)
	public void testDeleteButton() {
		System.out.println("Navigate to the page with delete button");  
		WebElement delete=driver.findElement(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[2]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		delete= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[2]")));
		Actions button=new Actions(driver);
		button.moveToElement(delete).click().perform();
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//tbody/tr[1]/td[4]/center[1]/button[2]")));
		WebElement confirm=driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
		confirm= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Confirm')]")));
		button.moveToElement(confirm).click().perform();
		try {
			WebElement dltok=driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
			dltok= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
			Assert.assertTrue(dltok.isDisplayed());
		}
		catch(AssertionError  | TimeoutException | NoSuchElementException  e) {
			System.out.println("DEFECT : Delete operation was not successful.");
		}
		finally
		{
			driver.navigate().refresh();
		}
	}
	
	  


	
}


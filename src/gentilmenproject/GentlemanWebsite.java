package gentilmenproject;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class GentlemanWebsite {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver mdriver=new ChromeDriver ();
		mdriver.navigate().to("https://www.wahylab.com/gendemo/");
		mdriver.manage().window().maximize();
		Thread.sleep(2000);
		Login1 pom1=new Login1(mdriver);
		pom1.verifytitle();
		pom1.validlogin();
		pom1.invalidnamelogin();
		pom1.invalidpasswordfiledlogin();
		pom1.invalidfieldslogin();
		pom1.blanknamefieldlogin();
		pom1.blankpasswordfieldlogin();
		pom1.blankinputfieldlogin();
		
		pom1.forgotemailid();
		forgot pom2= new forgot(mdriver);
		pom2.vaildemailid();
		pom2.invaildemailid();
		pom2.blankemailid();
		pom2.login();
		
		
		dashboard pom3=new dashboard(mdriver);
		pom3.headerpart();
		pom3.welcome();
		pom3.signout(); 
		pom3.login();
		
		dashboardtitle pom4=new dashboardtitle(mdriver);
		pom4.dashboard();
		pom4.designtion();
		pom4.Items();
		pom4.Mutualbranchtransferrequest();pom4.BranchestockRequestApproval();
		pom4.Branches();
//		pom4.Stock();
		pom4.Categorys();
		pom4.TotalEmployees();
		pom4.BranchReturns();
		pom4.Vendors();
		
		
    	userlist pom5=new userlist(mdriver);
		pom5.userlist();
		pom5.Home();
		pom5.search();
		pom5.back();
		pom5.dropdown();
		pom5.excel();
		pom5.pdf();
		pom5.print();
		pom5.csv();
		pom5.slno();
		pom5.nextpage();
		pom5.adduser();
		pom5.vaildusername();
		pom5.vaildedit();
		pom5.invaildusername();
		pom5.invaildedit();
		pom5.testDeleteButton();
		
		vendors pom6=new vendors(mdriver);
		pom6.vendors();
		pom6.Home();
		pom6.back();
		pom6.search();
		pom6.dropdown();
		pom6.excel();
		pom6.pdf();
		pom6.print();
		pom6.csv();
		pom6.slno();
		pom6.addvendor();
		pom6.vaildusername();
		pom6.invaildusername();
		pom6.testDeleteButton();
		
		
	

	}

}


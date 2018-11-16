package com.laa;

import com.util.Constants;
import com.util.TestUtil;
import com.util.Xls_Reader;

import java.util.Hashtable;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.pages.DobDashboardPage;
import com.pages.DobDocumentsPage;
import com.pages.DobPW1Page;
import com.pages.DobPW3Page;
import com.pages.DobSOWPage;
import com.pages.DobDS1Page;
import com.relevantcodes.extentreports.LogStatus;
import com.pages.DobSignaturesPage;
import com.pages.DobTR1Page;
import com.pages.DobTR8Page;
import com.pages.LaaPage;
import com.base.TestBase;

public class Paa150 extends TestBase {
	
	Xls_Reader xlsx = new Xls_Reader(Constants.testCasesesLaa);
	String testname = "PaaOnPermitted";
	
	@BeforeSuite
	public void BeforeSuite() {
		initConfigurations();
	}

	@BeforeMethod
	public void init() {
		initDriver();
		getEnvironmentDetails();
	}

	@AfterMethod
	public void quit() {
		quitDriver();
	}
//	JG: Changing to Chrome needs to happen when the preferred config is Chrome, but some prior function needed IE.
//	@AfterClass
//	public void setChrome() {
//		setConfigBrowser("Chrome");
//	}

	@AfterSuite(alwaysRun=true)
	public void killDrivers() {
		killDriver();
	}

	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData(testname, xlsx);
	}
	
	LaaPage laa = new LaaPage();
	
	DobDashboardPage dash = new  DobDashboardPage();
	DobPW1Page pw1 = new  DobPW1Page();
	DobDS1Page ds1 = new DobDS1Page();
	DobSOWPage asw = new DobSOWPage();
	DobPW3Page pw3 = new DobPW3Page();
	DobTR1Page tr1 = new DobTR1Page();
	DobTR8Page tr8 = new DobTR8Page();
	DobSignaturesPage signature = new DobSignaturesPage();
	DobDocumentsPage docs = new DobDocumentsPage();
	
	@Test(priority = 0, dataProvider = "getTestData")
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable(testname, xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		String laaJobNumber = "M00022777";
		if(!CONFIG.getProperty("env").contains("8085")) {
			laaJobNumber = "M00355575";
		}
		for(int i=1;i<150;i++) {			
			loginToPortal(user);
			type("//span[text()='Job Number']/following::input[@ng-model='colFilter.term']", laaJobNumber);
			wait(1);
			type("//span[text()='Filing Number']/following::input[@ng-model='colFilter.term']", "i");
			wait(1);
			select("//select[@id='FilingAction']", "PAA");
			wait(1);
			click(Constants.yes_button);
			
			if(text(Constants.notification).contains("PAA already in progress")) {
				click(Constants.ok_button);	
//				waitInvisible(Constants.yes_button);
//				waitUntilISpinnersInvisible();
//				waitForPageToLoad();
				type("//span[text()='Job Number']/following::input[@ng-model='colFilter.term']", laaJobNumber);
				wait(1);
				type("//span[text()='Filing Number']/following::input[@ng-model='colFilter.term']", " ");
				type("//span[text()='Filing Type']/following::input[@ng-model='colFilter.term']", "paa");
				type("//span[text()='Filing Status']/following::input[@ng-model='colFilter.term']", "pre-filing");
				wait(1);
				select("//select[@id='FilingAction']", "Delete");
				click(Constants.yes_button);	
				waitInvisible(Constants.yes_button);
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
			}
			else {
//				click(Constants.yes_button);	
				waitInvisible(Constants.yes_button);
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
				scrollUp();
				wait(1);
				laa.saveGI("Y");			
				System.out.println( text(Constants.el_job_label));
//				addToProps("job_number", text(Constants.el_job_label).substring(0, 10).trim());
				laa.uploadDocuments(data.get("documents"));
				laa.signatures(data.get("signature"));
				refreshPage();
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
				laa.previewToFile(data.get("file"));
			}			
		}
/*		laa.filterAndAction(data.get("action"));
		laa.pAa(data.get("paa"));	
		laa.uploadDocuments(data.get("documents"));
		laa.signatures(data.get("signature"));
		laa.previewToFile(data.get("file"));
		successMessage(data.get("description"));*/
	}
	

	
}
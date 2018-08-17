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
import org.openqa.selenium.support.PageFactory;
import com.pages.DobDashboardPage;
import com.pages.DobDocumentsPage;
import com.pages.DobPW1Page;
import com.pages.DobPW3Page;
import com.pages.DobSOWPage;
import com.pages.CrmTaskFormPage;
import com.pages.DobDS1Page;
import com.relevantcodes.extentreports.LogStatus;
import com.pages.DobSignaturesPage;
import com.pages.DobTR1Page;
import com.pages.DobTR8Page;
import com.pages.LaaPage;
import com.base.TestBase;
import com.pages.CityPayPage;

public class Subs150 extends TestBase {
	
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
	
	@AfterClass
	public void setChrome() {
		setConfigBrowser("Chrome");
	}

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
	
	@Test(priority = 0, dataProvider = "getTestData", invocationCount = 1)
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable(testname, xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());		
		for(int i=1;i<150;i++) {			
			loginToPortal(user);
			type("//span[text()='Job Number']/following::input[@ng-model='colFilter.term']", "M00022809"); //M00022800
			wait(1);
			type("//span[text()='Filing Number']/following::input[@ng-model='colFilter.term']", "i");
			wait(1);
			select("//select[@id='FilingAction']", "Subsequent Filing");
			wait(1);


			
/*			if(text(Constants.notification).contains("PAA already in progress")) {
				click(Constants.yes_button);	
				waitInvisible(Constants.yes_button);
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
				type("//span[text()='Job Number']/following::input[@ng-model='colFilter.term']", "M00022777");
				wait(1);
				type("//span[text()='Filing Type']/following::input[@ng-model='colFilter.term']", "Subsequent Filing");
				wait(1);
				select("//select[@id='FilingAction']", "Delete");
				click(Constants.yes_button);	
				waitInvisible(Constants.yes_button);
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
			}*/
//			else {
				click(Constants.yes_button);	
				waitInvisible(Constants.yes_button);
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
				wait(1);
//				waitVisible("//h4[text()='Job filing includes:']");
//				waitVisible("//button[text()='Create Subsequent']");
	/*			System.out.println(count("//input[@ng-model='" + data[0] + "FilingWorktype']"));
				System.out.println(count("//input[@ng-model='LaaFilingWorktype']"));
				System.out.println(count("//input[@ng-model='" +data[0]+"FilingWorktype']"));*/
				check("//input[@ng-model='rowData.LaaFilingWorktype']");
				wait(1);
				click("//button[text()='Create Subsequent']");
				waitInvisible("//button[text()='Create Subsequent']");
				type(Constants.proposed_work_summary, convertedTimestamp());
				laa.applicantInfo(data.get("user_info"));
				laa.feeAssessment(data.get("fee_assessment"));
				laa.saveGI("Y");			
				System.out.println( text(Constants.el_job_label));
//				addToProps("job_number", text(Constants.el_job_label).substring(0, 10).trim());
/*				laa.uploadDocuments(data.get("documents"));
				laa.signatures(data.get("signature"));
				refreshPage();
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
				laa.previewToFile(data.get("file"));*/
//			}			
		}
/*		laa.filterAndAction(data.get("action"));
		laa.pAa(data.get("paa"));	
		laa.uploadDocuments(data.get("documents"));
		laa.signatures(data.get("signature"));
		laa.previewToFile(data.get("file"));
		successMessage(data.get("description"));*/
	}
	

	
}
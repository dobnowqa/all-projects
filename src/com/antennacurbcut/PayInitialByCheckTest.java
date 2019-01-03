package com.antennacurbcut;

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
import com.pages.DobPW3Page;
import com.base.TestBase;
import com.pages.CityPayPage;
import com.pages.DobSOWPage;
import com.relevantcodes.extentreports.LogStatus;

public class PayInitialByCheckTest extends TestBase {
	// This test case uses DOBNOW to pay the amount due for a job in Pre-Filing Status. It filters for a job based on the value in the 'filter' column of the data (xls) file.
	// Be sure to set the config.properties environment = to the appropriate group based on the filter value.
	String testname = this.getClass().getSimpleName();	
	Xls_Reader xlsx = new Xls_Reader(Constants.testCases);
	
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

	@AfterSuite
	public void killDrivers() {
		killDriver();
	}

	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData("PayInitialByCheckTest", xlsx);
	}

	@Test(priority = 0, dataProvider = "getTestData")
	public void Base(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("PayInitialByCheckTest", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + testname + ": " + data.get("description") + " " + env);
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		DobSOWPage asw = PageFactory.initElements(driver, DobSOWPage.class);
		DobPW3Page pw3 = PageFactory.initElements(driver, DobPW3Page.class);
		
		dash.filterToPay(data.get("filter"));
		if (CONFIG.getProperty("env").contains("8085")) { //JG 201-01-02 
			addToProps("job_number", text(Constants.el_job_label).substring(0, 9).trim());
		} else {
			addToProps("job_number", text(Constants.job_label).trim().substring(6, 15).trim());
			asw.scopeOfWork(data.get("asw"));
			pw3.costAffidavit(data.get("pw3"));
			setConfigBrowser("IE");
		}
	}
	
	// PAY NOW / CITY PAY
	@Test(priority = 4, dataProvider = "getTestData", dependsOnMethods = {"Base"})
	public void CityPay(Hashtable<String, String> data) {
		CityPayPage pay = PageFactory.initElements(driver, CityPayPage.class);
		pay.cityPay(data.get("pay_now"));
		successMessage(data.get("description"));
	}

}
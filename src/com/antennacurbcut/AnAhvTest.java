package com.antennacurbcut;

import com.util.Constants;
import com.util.TestUtil;
import com.util.Xls_Reader;

import java.util.Hashtable;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.support.PageFactory;
import com.pages.DobDashboardPage;
import com.base.TestBase;
import com.pages.DobAHVPage;
import com.relevantcodes.extentreports.LogStatus;

public class AnAhvTest extends TestBase {
	
	Xls_Reader xlsx = new Xls_Reader(Constants.testCases);
	String testname = "AnAhvTest";
	
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

	@AfterSuite
	public void killDrivers() {
		killDriver();
	}

	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData(testname, xlsx);
	}

	@Test(priority = 0, dataProvider = "getTestData", invocationCount = 1)
	public void Base(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable(testname, xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		DobAHVPage ahv = PageFactory.initElements(driver, DobAHVPage.class);
		
//		loginToPortal(user);		
/*		loginToPortal("mrctest003@GMAIL.COM"); // mrctest003@gmail.com DOBSIGNHANGER@GMAIL.COM

		click(Constants.my_work_permits_tab);
		waitUntilISpinnersInvisible();
		waitVisible(Constants.global_first_filter_field);
		type(Constants.job_number_filter, JOB_NUMBER.getProperty("job_number"));
		wait(1);
		wait(1);
		select(Constants.filing_action_label, "Create AHV");
 		clickButton("Yes");
 		waitInvisible(Constants.yes_button);
 		waitUntilISpinnersInvisible();
 		
 		
		ahv.antennaAHV(data.get("ahv"));*/
		
		
		
		
		

		dash.ahv(data.get("ahv"), data.get("filter"));
		ahv.antennaAHV(data.get("ahv"));
	}

	
}
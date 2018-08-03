package com.electrical;

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
import com.pages.ElectricalPage;
import com.pages.ElectricalSOWPage;
import com.relevantcodes.extentreports.LogStatus;
import com.base.TestBase;
import com.pages.ElectricalDashboardPage;

public class ElOnOtherSubsTest extends TestBase {
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
		quitDriver();
		killDriver();
	}
	
	@AfterClass
	public void setChrome() {
		setConfigBrowser("Chrome");
	}
	
	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData("ElOnOtherSubsTest", xlsx);
	}

	Xls_Reader xlsx = new Xls_Reader(Constants.testCasesesEctrical);

	@Test(priority = 1, dataProvider = "getTestData")
	public void PlanWorkTest(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable("ElOnOtherSubsTest", xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping the test");
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Data");
		test.log(LogStatus.INFO, data.toString());
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		ElectricalDashboardPage dash = PageFactory.initElements(driver, ElectricalDashboardPage.class);
		ElectricalSOWPage sow = PageFactory.initElements(driver, ElectricalSOWPage.class);
		ElectricalPage el = PageFactory.initElements(driver, ElectricalPage.class);
		
		
		dash.subsFilingAction(OR_PROPERTIES.getProperty("user_email"), data.get("filter"));
		dash.selectWorkTypeSubs(data.get("work_type_subs"));
		el.subsFiling(data.get("owner_info_subs"));
		filterJob(user);		
		sow.workDescription(data.get("sow"));
		el.uploadDocumentsEl(data.get("documents_subs"));
		el.signaturesEl(data.get("sign"));
		el.previewToFile(data.get("preview_to_file_subs"));
		successMessage(data.get("description"));
	}

}
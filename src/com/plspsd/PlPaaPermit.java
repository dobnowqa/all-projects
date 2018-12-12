package com.plspsd;

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
import com.base.TestBase;
import com.pages.CityPayPage;
import com.pages.CrmDocs;
import com.pages.CrmTaskFormPage;
import com.pages.DobDS1Page;
import com.pages.DobDashboardPage;
import com.pages.DobDocumentsPage;
import com.pages.DobPW1Page;
import com.pages.DobPW2Page;
import com.pages.DobSOWPage;
import com.pages.DobPW3Page;
import com.pages.DobTR1Page;
import com.pages.DobTR8Page;
import com.pages.PlumbingPage;
import com.pages.DobSignaturesPage;
import com.relevantcodes.extentreports.LogStatus;

public class PlPaaPermit extends TestBase {
	String testname = this.getClass().getSimpleName();
	Xls_Reader xlsx = new Xls_Reader(Constants.testCasesPlm);
	
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

	@DataProvider(parallel = true)
	public Object[][] getTestData() {
		return TestUtil.getData(testname, xlsx);
	}
	
	PlumbingPage pl = new PlumbingPage();
	DobDashboardPage dash = new  DobDashboardPage();
	DobPW1Page pw1 = new  DobPW1Page();
	DobDS1Page ds1 = new DobDS1Page();
	DobSOWPage asw = new DobSOWPage();
	DobPW3Page pw3 = new DobPW3Page();
	DobTR1Page tr1 = new DobTR1Page();
	DobTR8Page tr8 = new DobTR8Page();
	DobPW2Page pw2 = new DobPW2Page();
	DobSignaturesPage signature = new DobSignaturesPage();
	DobDocumentsPage docs = new DobDocumentsPage();
	CrmTaskFormPage task_form = new CrmTaskFormPage();
	CrmDocs crmdocs = new CrmDocs();
	CityPayPage pay = new CityPayPage();

	@Test(priority = 1, dataProvider = "getTestData", invocationCount = 1)
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable(testname, xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());


		
		dash.paa(data.get("filter"));
		pw1.pAa(data.get("paa"));	
		pl.applicantignaturePaa(data.get("signatures"));
		docs.uploadDocuments(data.get("documents"));
		signature.ownerSignature(data.get("owner_signature"));
		setConfigBrowser("IE");
	}
	
	// PAY NOW CITY PAY
	@Test(priority = 2, dataProvider = "getTestData", dependsOnMethods = {"Portal"})//
	public void PayNowCityPayTest(Hashtable<String, String> data) {
		pay.cityPay(data.get("pay_now_paa"));
	}
	
	// PREVIEW TO FILE
	@Test(priority = 3, dataProvider = "getTestData", dependsOnMethods = {"PayNowCityPayTest"})//
	public void PreviewToFilePaaTest(Hashtable<String, String> data) {
		pw1.previewToFile(data.get("preview_to_file"));
		successMessage(data.get("description"));
	}

}
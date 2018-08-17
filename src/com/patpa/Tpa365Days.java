package com.patpa;

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
import com.pages.CrmTaskFormPage;
import com.pages.PaPage;
import com.relevantcodes.extentreports.LogStatus;

public class Tpa365Days extends TestBase {

	Xls_Reader xlsx = new Xls_Reader(Constants.testCasesesPaTpa);
	String testname = "Tpa365Days";

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
		return TestUtil.getData(testname, xlsx);
	}
	
	PaPage pa = new PaPage();
	CrmTaskFormPage task_form = new CrmTaskFormPage();

	@Test(priority = 0, dataProvider = "getTestData", invocationCount = 1)
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable(testname, xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping the test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());


		
		
		pa.selectWorkTypePa(data.get("work_type"));
		pa.locationImfo(data.get("address"));
		pa.workOnFloors(data.get("work_on_floors"));
		pa.applicantInfo(data.get("user_info"));
		pa.reviewtype(data.get("filing_review_type"));
		pa.ownerinfo(data.get("owner_info"));
//		pa.party(data.get("party"));	
		pa.saveGI("Y");
		pa.scopeOfWorkTpa(data.get("sow"));
		pa.techReport(data.get("tech_report"));
		pa.progressInspector(data.get("tech_report"));
		pa.uploadDocuments(data.get("documents"));
		pa.signatures(data.get("signature"));
		pa.owner(data.get("owner"));
		pa.previewToFile(data.get("file"));
		task_form.centralAssigner(data.get("cpe_acpe"));
	}
	
	// CPE
	@Test(priority = 1, dataProvider = "getTestData", dependsOnMethods = {"Portal"})
	public void CPEAction(Hashtable<String, String> data) {
		task_form.cpeActions(data.get("cpe"));
		task_form.viewAcceptDocuments(data.get("cpe"));
		task_form.crmTr(data.get("tr"));
	}

	// PRIMARY
	@Test(priority = 2, dataProvider = "getTestData", dependsOnMethods = {"CPEAction"})
	public void PrimaryPA(Hashtable<String, String> data) {
		task_form.peActions(data.get("primary_pe"));				
	}
	
	// CPE
	@Test(priority = 3, dataProvider = "getTestData", dependsOnMethods = {"PrimaryPA"})
	public void CPEAction2(Hashtable<String, String> data) {
		task_form.cpeActions(data.get("cpe_2"));
		successMessage(data.get("description"));
	}

/*	// CPE ACTIONS
	@Test(priority = 1, dataProvider = "getTestData", dependsOnMethods = { "Portal" })
	public void CPEActiona(Hashtable<String, String> data) {
		task_form.cpeActions(data.get("cpe"));
		task_form.viewAcceptDocuments(data.get("cpe"));
		task_form.crmTr(data.get("tr"));
		
		task_form.primaryPeAction(data.get("primary_pe"));
		successMessage(data.get("description"));
		
	}*/

}
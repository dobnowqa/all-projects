package com.plspsd;

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

import com.base.TestBase;
import com.pages.DobDashboardPage;
import com.pages.DobDocumentsPage;
import com.pages.DobPW1Page;
import com.pages.DobSOWPage;
import com.pages.DobPW3Page;
import com.pages.DobTR1Page;
import com.pages.DobTR8Page;
import com.pages.DobSignaturesPage;
import com.relevantcodes.extentreports.LogStatus;

public class BeNew extends TestBase {
	// This test case uses DOBNOW to create an application/job/filing for new-work for Boiler Equipment (BE).
	// This test case needs to run with config.properties environment = "plumbing"
	String testname = "BeNew";
	// The following file is used for PL, SP, SD, ST, MS and BE work types:
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

	@AfterSuite
	public void killDrivers() {
		killDriver();
	}

	@DataProvider(parallel = true)
	public Object[][] getTestData() {
		return TestUtil.getData(testname, xlsx);
	}

	// Execute the Base test, using the data defined above, to create the number of jobs equal to invocationCount.
	@Test(dataProvider = "getTestData",invocationCount = 1)
	public void Base(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable(testname, xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		DobPW1Page pw1 = PageFactory.initElements(driver, DobPW1Page.class);
		DobSOWPage asw = PageFactory.initElements(driver, DobSOWPage.class);
		DobPW3Page pw3 = PageFactory.initElements(driver, DobPW3Page.class);
		DobTR1Page tr1 = PageFactory.initElements(driver, DobTR1Page.class);
		DobTR8Page tr8 = PageFactory.initElements(driver, DobTR8Page.class);
		DobSignaturesPage signature = PageFactory.initElements(driver, DobSignaturesPage.class);
		DobDocumentsPage docs = PageFactory.initElements(driver, DobDocumentsPage.class);
		
		dash.selectWorkTypeBoilerEquipment(data.get("work_type"));
		pw1.locationImfo(data.get("address"));
		type(Constants.pw1_1_apt_suite_number, testname); // Used for tracking which test created the job.
		pw1.workOnFloors(data.get("work_on_floors"));
		pw1.applicantInfo(data.get("user_info"));
		pw1.workTypesBoilerEquipment(data.get("new_existing_both"));
		pw1.additionalInfo(data.get("additional_info"));
		pw1.additionalConciderations(data.get("additional_conciderations"));
		pw1.complianceNYCECC(data.get("nycecc"));
		pw1.buildingCharacteristics(data.get("building_charcteristics")); // Zoning Info
		pw1.siteCharacteristics(data.get("site_characteristics"));
		pw1.savePW1(data.get("save_pw1"));
		asw.scopeOfWorkBoilerEquipment(data.get("asw"));
		pw3.costAffidavit(data.get("pw3"));
		tr1.specialInspectionBoilerEquipment(data.get("tr1"));
		tr1.specialInspectorSignatureBoilerEquipment(data.get("tr1"));
		tr8.energyCodeProgressInspectionBoilerEquipment(data.get("tr8"));
		tr8.energyCodeSignatureMechanicalSystems(data.get("tr8"));
		signature.applicantStatementsSignature(data.get("signatures"));
		docs.uploadDocuments(data.get("documents"));
		signature.ownerSignature(data.get("owner_signature"));
//		pw1.previewToFile(data.get("preview_to_file")); // comment-out for Filing Status to remain Pre-Filing
		successMessage(data.get("description"));
	}

}

package com.bemsst;

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

public class BeNewPro extends TestBase {
	// This test simulates a registered e-Filing account holder using DOBNOW to create a filing (aka job) for Boiler Equipment (BE); New-install; Prof-cert.; Non-legalization
	// This test case needs to run with config.properties environment = "bemsst"
	String testname = this.getClass().getSimpleName();
	// The following file is used for BE, MS and ST work types:
	Xls_Reader xlsx = new Xls_Reader(Constants.testCasesBEMSST); 
		
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
		System.out.println(convertedTimestamp() + " ******BEGIN***** " + testname + ": " + data.get("description") + " " + env);
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		DobDashboardPage 	dash = PageFactory.initElements(driver, DobDashboardPage.class);
		DobPW1Page 			pw1  = PageFactory.initElements(driver, DobPW1Page.class);
		DobSOWPage 			asw  = PageFactory.initElements(driver, DobSOWPage.class);
		DobPW3Page 			pw3  = PageFactory.initElements(driver, DobPW3Page.class);
		DobTR1Page 			tr1  = PageFactory.initElements(driver, DobTR1Page.class);
		DobTR8Page 			tr8  = PageFactory.initElements(driver, DobTR8Page.class); // JG 2018-12-19 comment out due to TR8 not used
		DobSignaturesPage 	signature = PageFactory.initElements(driver, DobSignaturesPage.class);
		DobDocumentsPage 	docs = PageFactory.initElements(driver, DobDocumentsPage.class);
		
		dash.selectJobFilingWorkType(data.get("work_type"));	
		pw1.enterFilingInformation(data.get("description"));
		pw1.enterLocationInformation(data.get("address"));
		pw1.addWorkOnFloors(data.get("work_on_floors"));
		pw1.enterApplicantInformation(data.get("user_info"));
		pw1.enterWorkTypes(data.get("new_existing_both"));
		pw1.enterAdditionalInformation(data.get("additional_info"));
		pw1.enterNYCECCCompliance(data.get("nycecc"));
		pw1.enterJobDescription();
		pw1.enterSiteCharacteristics(data.get("site_characteristics"));
		pw1.enterAsbestosAbatementCompliance(data.get("site_characteristics"));
		pw1.constructionEquipment(data.get("equipment"));
		pw1.enterPw1Comments(data.get("site_characteristics"));	
		pw1.saveJob("get_number");
		pw1.enterAdditionalConsiderations(data.get("additional_conciderations"));
		pw1.enterBuildingCharacteristics(data.get("building_charcteristics")); // Zoning Info
		pw1.saveJob("skip_number");
		asw.enterScopeOfWorkBoilerEquipment(data.get("asw"));
		pw1.addBoilerEquipmentDevice(data.get("new_existing_both"));
		pw3.addCostAffidavit(data.get("pw3"));
		tr1.addSpecialInspectionBoilerEquipment(data.get("tr1"));
		tr1.addProgressInspectionBoilerEquipment(data.get("tr1"));
		tr8.energyCodeProgressInspectionBoilerEquipment(data.get("tr8"));
		tr8.enterProgressSignatureMechanicalSystems(data.get("tr8"));
		signature.applicantStatementsSignature(data.get("signatures"));
		docs.uploadDocuments(data.get("documents"));
		signature.ownerSignature(data.get("owner_signature"));
//		pw1.previewToFile(data.get("preview_to_file")); // comment-out for Filing Status to remain Pre-Filing
		successMessage(data.get("description"));
	}

}

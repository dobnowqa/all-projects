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
import com.pages.DobDocumentsPage;
import com.pages.DobPW1Page;
import com.base.TestBase;
import com.pages.DobSignaturesPage;
import com.relevantcodes.extentreports.LogStatus;

public class CcQaFailed extends TestBase {
	
	Xls_Reader xlsx = new Xls_Reader(Constants.testCases);
	String testname = "CcQaFailed";
	
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
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable(testname, xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description"));
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());
		DobDashboardPage dash = PageFactory.initElements(driver, DobDashboardPage.class);
		DobPW1Page pw1 = PageFactory.initElements(driver, DobPW1Page.class);
		DobSignaturesPage signature = PageFactory.initElements(driver, DobSignaturesPage.class);
		DobDocumentsPage docs = PageFactory.initElements(driver, DobDocumentsPage.class);
		
		
		dash.selectWorkType(data.get("work_type"));
		pw1.locationImfo(data.get("address"));
		type(Constants.pw1_1_apt_suite_number, testname);
		pw1.applicantInfo(data.get("user_info"));
		pw1.reviewtype(data.get("filing_review_type"));
		pw1.directive14acceptanceRequested(data.get("job_project_type"));
		pw1.additionalInfo(data.get("cost_floor_area_build_type"));
		pw1.additionalConciderationsCurb(data.get("additional_conciderations"));
		pw1.zonningCharacteristics(data.get("dist_overlay_spec_dist_map"));
		pw1.buildingCharacteristics(data.get("building_charcteristics"));
		pw1.curbCutDescription(data.get("curb_cut_description"));
		pw1.fireProtectionEquipment(data.get("fire_equipment"));
		pw1.siteCharacteristics(data.get("site_characteristics"));
		pw1.savePW1(data.get("save_pw1"));
		signature.applicantStatementsSignature(data.get("signatures"));
		signature.ownerSignature(data.get("owner_signature"));
		docs.uploadDocuments(data.get("documents"));
		pw1.previewToFile(data.get("preview_to_file"));
	}
 	
/*	// CPE VIEW-ACCEPT DOCS
 	@Test(priority=5, dataProvider="getTestData", dependsOnMethods={"Portal"})
 	public void CPEAcceptDocsTest(Hashtable<String,String> data) {
 		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
 		task_form.viewAcceptDocuments(data.get("chief_plan_examiner"));
 	}
  // CPE ASSIGN
 	@Test(priority=12, dataProvider="getTestData", dependsOnMethods={"CPEAcceptDocsTest"})
	public void ChiefPlanExaminerTest(Hashtable<String,String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.cpeAction(data.get("chief_plan_examiner"));
	}
// PE 	
	@Test(priority=13, dataProvider="getTestData", dependsOnMethods={"ChiefPlanExaminerTest"})
	public void PlanExaminerTest(Hashtable<String,String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.peAction(data.get("plan_examiner"));
	}	
	// PW2-2
	@Test(priority = 14, dataProvider = "getTestData", dependsOnMethods={ "PlanExaminerTest"})
	public void WorkPermit2Test(Hashtable<String, String> data) {
		DobPW2Page pw2 = PageFactory.initElements(driver, DobPW2Page.class);
		pw2.workPermit(data.get("pw2_2"));
//		pw2.uploadDocuments(data.get("pw2_2_documents"));
	}

	// CRM QA SUPERVISER
	@Test(priority = 15, dataProvider = "getTestData", dependsOnMethods={ "WorkPermit2Test"})
	public void QaSuperviserTest(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.assignTo(data.get("qa_superviser"));
	}

	// QA FAILED
	@Test(priority = 16, dataProvider = "getTestData", dependsOnMethods={ "QaSuperviserTest"})
	public void QaFailedTest(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.qaFailed(data.get("qa_administrator"));
		successMessage(data.get("description"));
	}*/

}
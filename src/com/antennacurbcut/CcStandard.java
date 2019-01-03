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
import com.pages.CrmDocs;
import com.pages.CrmTaskFormPage;
import com.pages.DobDS1Page;
import com.pages.DobDashboardPage;
import com.pages.DobDocumentsPage;
import com.pages.DobPW1Page;
import com.pages.DobPW2Page;
import com.pages.DobPW3Page;
import com.pages.DobSOWPage;
import com.pages.DobSignaturesPage;
import com.pages.DobTR1Page;
import com.pages.DobTR8Page;
import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class CcStandard extends TestBase {
	// This test case uses DOBNOW to create an application/job/filing for new-work for CurbCut (CC).
	// This test case needs to run with config.properties environment = "curbcut"
	String testname = this.getClass().getSimpleName();
	// The following file is used for AN & CC work types:
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

	@AfterSuite
	public void killDrivers() {
		killDriver();
	}

	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData(testname, xlsx);
	}

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
	// Execute the Portal test, using the data defined above, to create the number of jobs equal to invocationCount.
	@Test(priority = 0, dataProvider = "getTestData", invocationCount = 1)
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable(testname, xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + testname + ": " + data.get("description") + " " + env);
		String filing_review_type_variable = "filing_review_type"; //JG 2018-11-21 
		if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-21
			filing_review_type_variable = "filing_review_type_8085";
		}
		test = rep.startTest(data.get("description"));
		test.log(LogStatus.INFO, data.get("description"));
		test = rep.startTest("Test Case Data");
		test.log(LogStatus.INFO, data.toString());



		
		if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-10-30 TEST-ENV new PW UI
			dash.selectWorkType("Curb Cut");
		} else {
			dash.selectWorkType(data.get("work_type"));
		}
		pw1.locationImfo(data.get("address"));
		
		if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-21
			pw1.workOnFloors(data.get("work_on_floors")); // JG 2018-11-20 new per Data Dictionary	
		}
		
		pw1.applicantInfo(data.get("user_info"));		
		
		if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-30 this is now selected when adding the job
			pw1.reviewtype(data.get(filing_review_type_variable));	
			pw1.directive14acceptanceRequested(data.get("job_project_type"));  //JG 2018-11-21
		} else {
			click(Constants.pw1_6_work_types_accordion);
			radio(Constants.pw1_6_cc_new_installation); // JG 2018-11-21
		}
		pw1.additionalInfo(data.get("cost_floor_area_build_type"));
		pw1.additionalConciderationsCurb(data.get("additional_conciderations"));
		if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-21
			pw1.complianceNYCECC(data.get("nycecc"));
			pw1.savePW1(data.get("save_pw1"));
		} else {
			pw1.fireProtectionEquipment(data.get("fire_equipment"));
			pw1.siteCharacteristics(data.get("site_characteristics"));
		}
		pw1.curbCutDescription(data.get("curb_cut_description"));
		pw1.zonningCharacteristics(data.get("dist_overlay_spec_dist_map"));
		pw1.buildingCharacteristics(data.get("building_charcteristics"));
		if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-21
			click(Constants.global_save_form_button_8085);
		} else {
			pw1.savePW1(data.get("save_pw1"));
		}
		signature.applicantStatementsSignature(data.get("signatures"));
		docs.uploadDocuments(data.get("documents"));
		signature.ownerSignature(data.get("owner_signature"));
		pw1.previewToFile(data.get("preview_to_file"));
	}
 	
/*	// CPE VIEW-ACCEPT DOCS
 	@Test(priority=5, dataProvider="getTestData", dependsOnMethods={"Portal"})
 	public void CPEAcceptDocsTest(Hashtable<String,String> data) {
 		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
 		task_form.viewAcceptDocuments(data.get("chief_plan_examiner"));
 	}
  // CPE ASSIGN
 	@Test(priority=6, dataProvider="getTestData", dependsOnMethods={"CPEAcceptDocsTest"})
	public void ChiefPlanExaminerTest(Hashtable<String,String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.cpeAction(data.get("chief_plan_examiner"));
	}
// PE 	
	@Test(priority=7, dataProvider="getTestData", dependsOnMethods={"ChiefPlanExaminerTest"})
	public void PlanExaminerTest(Hashtable<String,String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.peAction(data.get("plan_examiner"));
	}	
	// PW2-2
	@Test(priority = 8, dataProvider = "getTestData", dependsOnMethods = {"PlanExaminerTest"})
	public void WorkPermit2Test(Hashtable<String, String> data) {
		DobPW2Page pw2 = PageFactory.initElements(driver, DobPW2Page.class);
		pw2.workPermit(data.get("pw2_2"));
//		pw2.uploadDocuments(data.get("pw2_2_documents"));
	}

	// CRM QA SUPERVISER
	@Test(priority = 9, dataProvider = "getTestData", dependsOnMethods = {"WorkPermit2Test"})
	public void QaSuperviserTest(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.viewAcceptDocuments(data.get("qa_superviser"));
		task_form.assignTo(data.get("qa_superviser"));
	}

	// QA ADMIN
	@Test(priority = 10, dataProvider = "getTestData", dependsOnMethods = {"QaSuperviserTest"})
	public void QaAdministratorTest(Hashtable<String, String> data) {
		CrmPW2Page pw2 = PageFactory.initElements(driver, CrmPW2Page.class);
		pw2.viewAcceptPW2Docs(data.get("qa_administrator"), data.get("accept_pw2_docs"));
	}

	// ISSUE PERMIT
	@Test(priority = 11, dataProvider = "getTestData", dependsOnMethods = {"QaAdministratorTest"})
	public void IssuePermitTest(Hashtable<String, String> data) {
		CrmTaskFormPage task_form = PageFactory.initElements(driver, CrmTaskFormPage.class);
		task_form.isuePermit(data.get("qa_administrator"));
		successMessage(data.get("description"));
	}*/

}
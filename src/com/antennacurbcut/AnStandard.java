package com.antennacurbcut;

import com.util.Constants;
import com.util.TestUtil;
import com.util.Xls_Reader;
import java.util.Hashtable;

import org.junit.AfterClass;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.pages.DobDashboardPage;
import com.pages.DobDocumentsPage;
import com.pages.DobPW1Page;
import com.pages.DobPW2Page;
import com.pages.CrmTaskFormPage;
import com.pages.DobSOWPage;
import com.pages.DobPW3Page;
import com.pages.DobDS1Page;
import com.pages.DobTR1Page;
import com.pages.DobTR8Page;
import com.pages.DobSignaturesPage;
import com.base.TestBase;
import com.pages.CrmDocs;
import com.relevantcodes.extentreports.LogStatus;

public class AnStandard extends TestBase {
	// This test case uses DOBNOW to create an application/job/filing for new-work for Antenna (AN).
	// This test case needs to run with config.properties environment = "antenna"	
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
		System.out.println(convertedTimestamp() + " ******BEGIN***** " + testname + ": " + data.get("description") + " " + env);
		String filing_review_type_variable = "filing_review_type"; //JG 2018-10-31 original field in the Excel (data) sheet
		if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-10-30 TEST-ENV new PW UI
			filing_review_type_variable = "filing_review_type_8085"; //JG 2018-10-30 new field in the Excel (data) sheet
		}
		if (!data.get(filing_review_type_variable).equals("")) {
			test = rep.startTest(data.get("description"));
			test.log(LogStatus.INFO, data.get("description"));
			test = rep.startTest("Test Case Data");
			test.log(LogStatus.INFO, data.toString());
//			filterJob(user);
						
			dash.selectWorkType(data.get("work_type")); // JG 2018-11-30 TODO: pass the filing_review_type value to indicate 'standard' or 'pro'
			pw1.locationImfo(data.get("address"));
			pw1.workOnFloors(data.get("work_on_floors"));
			pw1.applicantInfo(data.get("user_info"));
//			pw1.reviewtype(data.get("filing_review_type")); // JG 2018-10-31 use the following instead:
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-30 this is now selected when adding the job
				pw1.reviewtype(data.get(filing_review_type_variable));
			} 
			pw1.directive14acceptanceRequested(data.get("job_project_type"));
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-10-30 TEST-ENV new PW UI
				pw1.workTypesAntenna(data.get("new_existing_both")); //JG 2018-10-30 TEST-ENV new PW UI
			} else {
				pw1.workTypes(data.get("new_existing_both"));
			}
			pw1.additionalInfo(data.get("cost_floor_area_build_type"));
			pw1.additionalConciderations(data.get("additional_conciderations"));
			pw1.complianceNYCECC(data.get("nycecc"));
			pw1.zonningCharacteristics(data.get("dist_overlay_spec_dist_map"));
			pw1.buildingCharacteristics(data.get("building_charcteristics"));
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-01 TEST-ENV doesn't have 'Fire' section yet!?
				pw1.fireProtectionEquipment(data.get("fire_equipment"));
			}
			pw1.siteCharacteristics(data.get("site_characteristics"));
			pw1.savePW1(data.get("save_pw1"));
			ds1.demolitionSubmittal(data.get("ds1"));
			asw.scopeOfWork(data.get("asw"));
			pw3.costAffidavit(data.get("pw3"));
			tr1.specialInspection(data.get("tr1"));
			tr1.specialInspectorSignature(data.get("tr1"));
			tr1.progressInspecSign(data.get("tr1"));
			tr8.energyCodeProgressInspection(data.get("tr8"));
			tr8.energyCodeSignature(data.get("tr8"));
			signature.applicantStatementsSignature(data.get("signatures"));
			docs.uploadDocuments(data.get("documents"));
			signature.ownerSignature(data.get("owner_signature"));
//			pw1.previewToFile(data.get("preview_to_file"));
			successMessage(data.get("description"));
//			// ASSIGN TO TEAM
//			task_form.centralAssigner(data.get("cpe_acpe"));
		}
	}
	
//	// CPE
//	@Test(priority = 1, dataProvider = "getTestData", dependsOnMethods = {"Portal"})
//	public void CPEAction(Hashtable<String, String> data) {
//		task_form.cpeActions(data.get("cpe"));
//		task_form.viewAcceptDocuments(data.get("cpe"));
//	}
//
//	// PRIMARY
//	@Test(priority = 2, dataProvider = "getTestData", dependsOnMethods = {"CPEAction"})
//	public void PrimaryPA(Hashtable<String, String> data) {
//		task_form.peActions(data.get("primary_pe"));				
//	}
//	
//	// CPE / PW2
//	@Test(priority = 3, dataProvider = "getTestData", dependsOnMethods = {"PrimaryPA"})
//	public void CPEAction2(Hashtable<String, String> data) {
//		task_form.cpeActions(data.get("cpe_2"));
//		pw2.workPermit(data.get("pw2_2"));
//	}
//	
//	// DOCS
//	@Test(priority = 3, dataProvider = "getTestData", dependsOnMethods = {"CPEAction2"})
//	public void QaSuper(Hashtable<String, String> data) {
//		task_form.qaSuper(data.get("qa_super"));
//		crmdocs.viewAcceptTR1Fuel(data.get("qa_super"), data.get("accept_tr"));
//		crmdocs.viewAcceptTR1Fina(data.get("qa_super"), data.get("accept_tr"));
//		crmdocs.viewAcceptTR8PDocs(data.get("qa_super"), data.get("accept_tr"));
//		crmdocs.viewAcceptPW2Docs(data.get("qa_super"), data.get("accept_pw2_docs"));
//	}
//	
//	// CPERMIT
//	@Test(priority = 4, dataProvider = "getTestData", dependsOnMethods = {"QaSuper"})
//	public void Permit(Hashtable<String, String> data) {
//		task_form.isuePermit(data.get("qa_admin"));
//		successMessage(data.get("description"));
//	}
//	
}
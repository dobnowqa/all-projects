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

public class Crm extends TestBase {
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
	
	@Test(priority = 0, dataProvider = "getTestData", invocationCount = 1)
	public void Portal(Hashtable<String, String> data) {
		if (!TestUtil.isExecutable(testname, xlsx) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping test");
		System.out.println("BEGIN " + convertedTimestamp() + " **************** " + data.get("description")+ " " +env);
		if (!data.get("filing_review_type").equals("")) {
			test = rep.startTest(data.get("description"));
			test.log(LogStatus.INFO, data.get("description"));
			test = rep.startTest("Test Case Data");
			test.log(LogStatus.INFO, data.toString());
			

			loginToCrm("BUILD001");
//			task_form.assignTo("BUILD001 :: BUILD005");
			task_form.viewAcceptDocuments("BUILD001 :: BUILD001");
			
			task_form.assignTo("BUILD001 :: BUILD001");
			loginToCrm("BUILD017");
			searchForJobCrm();

			
			
			
			

			
			
			
			
			
			task_form.cpeAction("BUILD001 :: Yes :: BUILD005");
			task_form.cpeAction("BUILD005 :: Yes :: QA Failed");
			
			task_form.assignTo("BUILD001 :: BUILD005");
			task_form.qaDecision("BUILD001 :: QA Failed :: Yes");
			
			task_form.viewAcceptDocuments("BUILD001 :: BUILD005");

//			task_form.assignTo("BUILD023 :: BUILD023");
			task_form.assignTo("BUILD001 :: BUILD005");
			task_form.viewAcceptDocuments("BUILD001 :: BUILD005");
			crmdocs.viewAcceptTR1Fuel("BUILD023", "BUILD023");
			crmdocs.viewAcceptTR1Fina("BUILD023", "Y");
			crmdocs.viewAcceptTR8PDocs("BUILD023", "BUILD023");
			crmdocs.viewAcceptPW2Docs("BUILD012", "Y");
			task_form.viewAcceptDocuments("BUILD017 :: BUILD012");
//			task_form.assignTo("BUILD017 :: BUILD023");
//			loginToCrm("BUILD012"); //                         BUILD013             BUILD017          BUILD023 
			


			
/*			task_form.assignTo("BUILD013 :: BUILD013");*/ 

		}
	}
	
		// CPE VIEW-ACCEPT DOCS
	@Test(priority = 2, dataProvider = "getTestData", dependsOnMethods = {"Portal"})
	public void CPEAcceptDocsTest(Hashtable<String, String> data) {		
		task_form.qaDecision("BUILD013 :: Approved :: Yes"); 
//		task_form.cpeActions("BUILD012 :: BUILD013");
		task_form.viewAcceptDocuments("BUILD012 :: BUILD012");
		crmdocs.viewAcceptPW2Docs("BUILD012", "BUILD013");
	}

	// CPE ASSIGN
	@Test(priority = 3, dataProvider = "getTestData", dependsOnMethods = {"Portal"})
	public void ChiefPlanExaminerTest(Hashtable<String, String> data) {		
		task_form.cpeAction(data.get("chief_plan_examiner"));
	}

	// PE ACTION
	@Test(priority = 4, dataProvider = "getTestData", dependsOnMethods = {"Portal"})
	public void PlanExaminerTest(Hashtable<String, String> data) {		
		task_form.peAction(data.get("plan_examiner"));
	}

	// PW2-2
	@Test(priority = 5, dataProvider = "getTestData", dependsOnMethods = {"Portal"})
	public void WorkPermit2Test(Hashtable<String, String> data) {
		pw2.workPermit(data.get("pw2_2"));
//		pw2.uploadDocuments(data.get("pw2_2_documents"));
	}

	// CRM QA SUPERVISER
	@Test(priority = 6, dataProvider = "getTestData", dependsOnMethods={ "Portal"})
	public void QaSuperviserTest(Hashtable<String, String> data) {		
		task_form.assignTo(data.get("qa_superviser"));
	}

	// QA FAILED
	@Test(priority = 7, dataProvider = "getTestData", dependsOnMethods={ "Portal"})
	public void QaFailedTest(Hashtable<String, String> data) {		
		task_form.qaFailed(data.get("qa_administrator"));
		successMessage(data.get("description"));
	}
}
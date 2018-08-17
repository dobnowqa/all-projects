/*package com.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.util.Constants;
import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class CrmPW2Page extends TestBase {
	WebDriver driver;

	public CrmPW2Page(WebDriver dr) {
		driver = dr;
	}

	@FindBy(xpath = Constants.cpe_search_job_button)
	public WebElement cpe_search_job_button;
	@FindBy(xpath = Constants.pe_search_job_button)
	public WebElement pe_search_job_button;
	@FindBy(xpath = Constants.crm_top_nav_search_button)
	public WebElement crm_top_nav_search_button;
	@FindBy(xpath = Constants.submit_work_type_button)
	public WebElement submit_work_type_button;
	@FindBy(xpath = Constants.filtered_job)
	public WebElement filtered_job;
	@FindBy(xpath = Constants.job_number_search)
	public WebElement job_number_search;
	@FindBy(xpath = Constants.search_for_records_one)
	public WebElement search_for_records_one;
	@FindBy(xpath = Constants.search_for_records_one_field)
	public WebElement search_for_records_one_field;
	@FindBy(xpath = Constants.search_for_records_one_image)
	public WebElement search_for_records_one_image;
	@FindBy(xpath = Constants.cpe_tasks_search_job)
	public WebElement cpe_tasks_search_job;
	@FindBy(xpath = Constants.cpe_tasks_search_job_field)
	public WebElement cpe_tasks_search_job_field;
	@FindBy(xpath = Constants.pe_tasks_search_job)
	public WebElement pe_tasks_search_job;
	@FindBy(xpath = Constants.pe_tasks_search_job_field)
	public WebElement pe_tasks_search_job_field;
	@FindBy(xpath = Constants.qa_super_tasks_search_job)
	public WebElement qa_super_tasks_search_job;
	@FindBy(xpath = Constants.qa_super_tasks_search_job_field)
	public WebElement qa_super_tasks_search_job_field;
	@FindBy(xpath = Constants.qa_super_search_job_button)
	public WebElement qa_super_search_job_button;
	@FindBy(xpath = Constants.qa_admin_tasks_search_job)
	public WebElement qa_admin_tasks_search_job;
	@FindBy(xpath = Constants.qa_admin_tasks_search_job_field)
	public WebElement qa_admin_tasks_search_job_field;
	@FindBy(xpath = Constants.qa_admin_search_job_button)
	public WebElement qa_admin_search_job_button;

	@FindBy(xpath = Constants.qa_super_job_subject)
	public WebElement qa_super_job_subject;
	@FindBy(xpath = Constants.prof_sert_qa_super_job_subject)
	public WebElement prof_sert_qa_super_job_subject;

	@FindBy(xpath = Constants.search_results_job_subject)
	public WebElement search_results_job_subject;
	@FindBy(xpath = Constants.qa_admin_job_subject)
	public WebElement qa_admin_job_subject;
	@FindBy(xpath = Constants.qa_administrator_search_button)
	public WebElement qa_administrator_search_button;
	@FindBy(xpath = Constants.permit_not_issued_link)
	public WebElement permit_not_issued_link;
	

	@FindBy(xpath = Constants.job_search_input_box)
	public WebElement job_search_input_box;
	@FindBy(xpath = Constants.search_button)
	public WebElement search_button;
	@FindBy(xpath = Constants.actions_dropdown)
	public WebElement actions_dropdown;
	@FindBy(xpath = Constants.appoitment_required)
	public WebElement appoitment_required;
	@FindBy(xpath = Constants.option_yes)
	public WebElement option_yes;
	@FindBy(xpath = Constants.option_no)
	public WebElement option_no;
	@FindBy(xpath = Constants.qa_action)
	public WebElement qa_action;
	@FindBy(xpath = Constants.option_permit_issued)
	public WebElement option_permit_issued;
	@FindBy(xpath = Constants.label_job_filing)
	public WebElement label_job_filing;
	@FindBy(xpath = Constants.qa_admin_tr1_tab)
	public WebElement qa_admin_tr1_tab;
	@FindBy(xpath = Constants.qa_admin_tr8_tab)
	public WebElement qa_admin_tr8_tab;
	@FindBy(xpath = Constants.qa_admin_antenna_pw2_tab)
	public WebElement qa_admin_antenna_pw2_tab;
	@FindBy(xpath = Constants.qa_admin_curbcut_pw2_tab)
	public WebElement qa_admin_curbcut_pw2_tab;

	@FindBy(xpath = Constants.qa_admin_documents_tab)
	public WebElement qa_admin_documents_tab;


	@FindBy(xpath = Constants.qa_admin_fuel_oil_document)
	public WebElement qa_admin_fuel_oil_document;
	@FindBy(xpath = Constants.qa_admin_electrical_energy_document)
	public WebElement qa_admin_electrical_energy_document;
	@FindBy(xpath = Constants.qa_admin_final_document)
	public WebElement qa_admin_final_document;
	@FindBy(xpath = Constants.qa_admin_permit_not_yet_issued)
	public WebElement qa_admin_permit_not_yet_issued;
	@FindBy(xpath = Constants.qa_admin_certificate_of_insurance_document)
	public WebElement qa_admin_certificate_of_insurance_document;

	

	 
	@FindBy(xpath = Constants.seal_and_signature)
	public WebElement seal_and_signature;

	@FindBy(xpath = Constants.qa_admin_special_inspector_seal_signature)
	public WebElement qa_admin_special_inspector_seal_signature;
	@FindBy(xpath = Constants.qa_admin_progress_inspector_seal_signature)
	public WebElement qa_admin_progress_inspector_seal_signature;

	@FindBy(xpath = Constants.pe_action)
	public WebElement pe_action;
	@FindBy(xpath = Constants.pe_action_approved)
	public WebElement pe_action_approved;
	@FindBy(xpath = Constants.approved_plan_uploaded)
	public WebElement approved_plan_uploaded;
	@FindBy(xpath = Constants.approved_plan_uploaded_yes)
	public WebElement approved_plan_uploaded_yes;

	@FindBy(xpath = Constants.total_number_of_documents)
	public WebElement total_number_of_documents;
	@FindBy(xpath = Constants.load_next_page_image)
	public WebElement load_next_page_image;
	@FindBy(xpath = Constants.view_document_button)
	public WebElement view_document_button;
	@FindBy(xpath = Constants.accept_document_button)
	public WebElement accept_document_button;
	@FindBy(xpath = Constants.assign_to_plan_examiner)
	public WebElement assign_to_plan_examiner;
	@FindBy(xpath = Constants.assign_to_qa_administrator)
	public WebElement assign_to_qa_administrator;
	@FindBy(xpath = Constants.assign_to_qa_administrator_field)
	public WebElement assign_to_qa_administrator_field;
	@FindBy(xpath = Constants.select_qa_administrator)
	public WebElement select_qa_administrator;
	@FindBy(xpath = Constants.crm_permit_not_yet_issued_link)
	public WebElement crm_permit_not_yet_issued_link;

	@FindBy(xpath = Constants.plan_examiner_text_field)
	public WebElement plan_examiner_text_field;
	@FindBy(xpath = Constants.plan_examiner_search_button)
	public WebElement plan_examiner_search_button;
	@FindBy(xpath = Constants.select_examiner)
	public WebElement select_examiner;
	@FindBy(xpath = Constants.comments_textbox)
	public WebElement comments_textbox;
	@FindBy(xpath = Constants.submit_button)
	public WebElement submit_button;

	@FindBy(xpath = Constants.global_save_step_button)
	public WebElement global_save_step_button;
	@FindBy(xpath = Constants.global_notification_ok_button)
	public WebElement global_notification_ok_button;
	@FindBy(xpath = Constants.global_loading_spinner)
	public WebElement global_loading_spinner;

	public static int number_of_documents;


	public void viewAcceptPW2Docs(String user_name, String accept_pw2_docs) {
		if (!accept_pw2_docs.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** PW2 Accept cert of ins/Site Safety " +data[0]);
			loginToCrm(data[0]);
			searchForJobCrm();
			waitDocStatus();
			waitVisible(Constants.label_job_filing);
			if (user_name.contains("BUILD02")) {
				waitUntilElementVisible(Constants.crm_permit_not_yet_issued_link, 30);
				new Actions(driver).contextClick(driver.findElement(By.xpath(Constants.crm_permit_not_yet_issued_link))).build().perform();
			}
			if (user_name.contains("BUILD01")) {
				waitUntilElementVisible(Constants.permit_not_issued_link, 30);
				new Actions(driver).contextClick(driver.findElement(By.xpath(Constants.permit_not_issued_link))).build().perform();
//				new Actions(driver).contextClick(permit_not_issued_link).build().perform();
			}
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			ifAlertExistAccept();
			waitForPageToLoad();
			waitVisible(Constants.crm_documents_first_document_link);
			waitClickableOr("//nobr[text()='Accepted']", "//nobr[text()='Submitted']");
			if (count(Constants.crm_document_status_submitted) > 0) {
				for (int i = 1; i <= 20; i++) {
					doubleclick(Constants.crm_document_status_submitted);
					waitForPageToLoad();
					wait(2);
					driver.switchTo().defaultContent();
					click(Constants.view_document_button);
					wait(3);
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					while (tabs.size() > 1) {
						driver.switchTo().window(tabs.get(1));
						driver.close();
						wait(2);
						tabs = new ArrayList<String>(driver.getWindowHandles());
					}
					driver.switchTo().window(tabs.get(0));
					doubleclick(Constants.accept_document_button);
					ifAlertExistAccept();
					waitForPageToLoad();
					wait(2);
					driver.switchTo().frame("contentIFrame0");
					waitVisible(Constants.crm_document_accepted);
					driver.switchTo().defaultContent();
					driver.navigate().back();
					waitForPageToLoad();
					wait(2);
					driver.switchTo().frame("contentIFrame0");
//					waitVisible(Constants.label_job_filing);
					waitClickableOr("//nobr[text()='Accepted']", "//nobr[text()='Submitted']");
					if (count(Constants.crm_document_status_submitted) == 0) {
						reportPass("viewAcceptDocuments");
						break;
					}
				}
			}
		}
	}

	public void viewAcceptPW2DocsAhv(String accept_pw2_docs_ahv) {
		if (!accept_pw2_docs_ahv.equals("")) {
			String[] data = accept_pw2_docs_ahv.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** viewAcceptPW2DocsAhv");
			loginToCrm(data[0]);
			setWindowfocus();
			waitForPageToLoad();
			waitUntilElementVisible(Constants.crm_top_nav_search_button, 30);
			driver.switchTo().frame("contentIFrame0").switchTo().frame("dashboardFrame");
			scrollAllWayDown();scrollAllWayDown();scrollAllWayDown();scrollAllWayDown();scrollAllWayDown();scrollAllWayDown();
			
			click(Constants.bod_ahv_permits_label + "/following::label[text()='Search for records']");
			type(Constants.bod_ahv_permits_label + "/following::input[@class='ms-crm-Dialog-Lookup-QuickFind']","*"+JOB_NUMBER.getProperty("ahv_number").substring(2));
			click(Constants.bod_ahv_permits_label + "/following::img[@class='ms-crm-ImageStrip-search']");
			click("//span[contains(text(),'Search Results')]/following::a[@title='"+JOB_NUMBER.getProperty("ahv_number")+"']");
			ifAlertExistAccept();
			wait(5);
			driver.switchTo().frame("contentIFrame0");
			addToProps("job_number", text("//span[text()='Click here to go to Work Permit']/following::span[@class='ms-crm-Lookup-Item']").substring(0, 9).trim());
			
			
			ifAlertExistAccept();
			waitForPageToLoad();
			waitVisible(Constants.crm_documents_first_document_link);
			waitClickableOr("//nobr[text()='Accepted']", "//nobr[text()='Submitted']");
			if (count(Constants.crm_document_status_submitted) > 0) {
				for (int i = 1; i <= 20; i++) {
					doubleclick(Constants.crm_document_status_submitted);
					waitForPageToLoad();
					wait(2);
					driver.switchTo().defaultContent();
					click(Constants.view_document_button);
					wait(5);
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					while (tabs.size() > 1) {
						driver.switchTo().window(tabs.get(1));
						driver.close();
						wait(2);
						tabs = new ArrayList<String>(driver.getWindowHandles());
					}
					driver.switchTo().window(tabs.get(0));
					click(Constants.accept_document_button);
					ifAlertExistAccept();
					ifAlertExistAccept();
					waitForPageToLoad();
					wait(2);
					driver.switchTo().frame("contentIFrame0");
					waitVisible(Constants.crm_document_accepted);
					driver.switchTo().defaultContent();
					driver.navigate().back();
					waitForPageToLoad();
					wait(2);
					driver.switchTo().frame("contentIFrame0");
//					waitVisible(Constants.label_job_filing);
					waitClickableOr("//nobr[text()='Accepted']", "//nobr[text()='Submitted']");
					if (count(Constants.crm_document_status_submitted) == 0) {
						reportPass("viewAcceptPW2DocsAhv");
						break;
					}
				}
			}

			
//			viewAcceptDoc(2);
		}
	}

}*/
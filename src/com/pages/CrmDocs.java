package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.base.TestBase;
import com.util.Constants;

public class CrmDocs extends TestBase {
	
	public void crmTechnicalReport(String user_name, String accept_tr) {
		if (!accept_tr.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** " + data[0] + " crmTechnicalReport");
			loginToCrm(data[0]);
			searchForJobCrm();
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			driver.switchTo().frame("contentIFrame0");
//			waitUntilElementVisible(Constants.label_job_filing, 30);
			for (int i=1; i < 20; i++) {
				click(Constants.job_filing_link);
				waitInvisible(Constants.job_filing_link);
				if (count(Constants.job_filing_link) < 1) 
					break;
			}	
			ifAlertExistAccept();
			waitVisible(Constants.qa_admin_application_highlights_label);
			waitVisible(Constants.qa_admin_tr1_tab);
			for (int i = 1; i <= 20; i++) {
				click(Constants.qa_admin_tr1_tab);
				wait(5);
/*				if (count(Constants.public_assembly_emergency_lighting) > 0)
					break;*/				
				if (driver.findElement(By.xpath(Constants.public_assembly_emergency_lighting)).isDisplayed() == true)
					break;
				refreshPage();
				driver.switchTo().frame("contentIFrame0");
			}
			waitVisible(Constants.public_assembly_emergency_lighting);
//			actionClick(Constants.public_assembly_emergency_lighting);
			WebElement public_assembly_emergency_lighting = driver.findElement(By.xpath(Constants.public_assembly_emergency_lighting));
			new Actions(driver).contextClick(public_assembly_emergency_lighting).build().perform();
			wait(1);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			waitUntilElementVisible(Constants.qa_admin_progress_inspector_seal_signature, 30);
			viewAcceptDocs();
		}
		navigate(crm_url);
	}

	public void viewAcceptTR1Fuel(String user_name,	String accept_tr) {
		if (!accept_tr.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** " + data[0] + " View accept FUEL OIL");
//			loginToCrm(data[0]);
			searchForJobCrm();
			driver.switchTo().frame("contentIFrame0");
//			waitUntilElementVisible(Constants.label_job_filing, 30);
			waitVisible(Constants.label_job_filing);
			for (int i=1; i < 20; i++) {
				click(Constants.job_filing_link);
				waitInvisible(Constants.job_filing_link);
				if (count(Constants.job_filing_link) < 1) 
					break;
			}	
			ifAlertExistAccept();
			waitVisible(Constants.qa_admin_application_highlights_label);
			waitVisible(Constants.qa_admin_tr1_tab);
			for (int i = 1; i <= 20; i++) {
				click(Constants.qa_admin_tr1_tab);
				wait(5);
				if (driver.findElement(By.xpath(Constants.qa_admin_fuel_oil_document)).isDisplayed() == true)
					break;
				refreshPage();
				driver.switchTo().frame("contentIFrame0");
			}
			waitVisible(Constants.qa_admin_fuel_oil_document);
			rightClick(Constants.qa_admin_fuel_oil_document);
			wait(1);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			waitUntilElementVisible(Constants.qa_admin_special_inspector_seal_signature, 30);
			viewAcceptDocs();
		}
		navigate(crm_url);
	}
	
	public void viewAcceptTR1Fina(String user_name, String accept_tr) {
		if (!accept_tr.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** " + data[0] + " View accept Final");
//			loginToCrm(data[0]);
			searchForJobCrm();
			driver.switchTo().frame("contentIFrame0");
			waitVisible(Constants.label_job_filing);
			for (int i=1; i < 20; i++) {
				click(Constants.job_filing_link);
				waitInvisible(Constants.job_filing_link);
				if (count(Constants.job_filing_link) < 1) 
					break;
			}			
			ifAlertExistAccept();
			waitVisible(Constants.qa_admin_tr1_tab);
			for (int i = 1; i <= 20; i++) {
				click(Constants.qa_admin_tr1_tab);
				wait(5);
				if (driver.findElement(By.xpath(Constants.qa_admin_final_document)).isDisplayed() == true)
					break;
				refreshPage();
				driver.switchTo().frame("contentIFrame0");
			}
			waitVisible(Constants.qa_admin_final_document);
			rightClick(Constants.qa_admin_final_document);
			wait(1);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			waitVisible(Constants.qa_admin_progress_inspector_seal_signature);
			viewAcceptDocs();
		}
		navigate(crm_url);
	}
	public void viewAcceptTR1Plumbing(String tr_docs) {
		if (!tr_docs.equals("")) {
			String[] data = tr_docs.split(" :: ");
			int num_of_docs = Integer.valueOf(data[3]); // Number of documents to upload
			System.out.println(convertedTimestamp() + " **************** " + data[0] + " viewAcceptTR1Plumbing");
			loginToCrm(data[0]);
			searchForJobCrm();
			driver.switchTo().frame("contentIFrame0");
			waitVisible(Constants.label_job_filing);
			for (int i=1; i < 5; i++) {
				if(i > num_of_docs)
					break;
				while(count(Constants.label_job_filing) > 0) {
					clickAndWait(Constants.label_job_filing, Constants.qa_admin_application_highlights_label);
				}
			ifAlertExistAccept();
			waitVisible(Constants.qa_admin_application_highlights_label);
			waitVisible(Constants.qa_admin_tr1_tab);
			//waitUntilElementVisible(Constants.qa_admin_work_on_floors_document, 30);
			click(Constants.qa_admin_tr1_tab);
			waitVisible("//span[text()='" +data[i]+ "']");
			new Actions(driver).contextClick(getElement("//span[text()='" +data[i]+ "']")).build().perform();
			wait(1);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			waitForPageToLoad();
			wait(2);
			waitVisible(Constants.required_documents_label_tr1);
			viewAcceptDocs();
			driver.switchTo().frame("contentIFrame0");
			}
		}
		navigate(crm_url);
	}

	public void viewAcceptTR8PDocs(String user_name, String accept_tr) {
		if (!accept_tr.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** " + data[0] + " viewAcceptTR8PDocs");
//			loginToCrm(data[0]);
			searchForJobCrm();
			driver.switchTo().frame("contentIFrame0");
			waitUntilElementVisible(Constants.label_job_filing, 30);
			waitVisible(Constants.label_job_filing);
			for (int i=1; i < 20; i++) {
				click(Constants.job_filing_link);
				waitInvisible(Constants.job_filing_link);
				if (count(Constants.job_filing_link) < 1) 
					break;
			}				
			ifAlertExistAccept();
			waitVisible(Constants.qa_admin_application_highlights_label);
			waitVisible(Constants.qa_admin_tr8_tab);
			for (int i = 1; i <= 20; i++) {
				click(Constants.qa_admin_tr8_tab);
				wait(5);
				if (count(Constants.qa_admin_electrical_energy_document) > 0)
					break;
				refreshPage();
				driver.switchTo().frame("contentIFrame0");
			}
			waitVisible(Constants.qa_admin_electrical_energy_document);
			rightClick(Constants.qa_admin_electrical_energy_document);
			wait(1);
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			waitForPageToLoad();
			wait(2);
			waitVisible(Constants.required_documents_label_tr8);
			viewAcceptDocs();
		}
		navigate(crm_url);
	}
	
	public void viewAcceptPW2Docs(String user_name, String accept_pw2_docs) {
		if (!accept_pw2_docs.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** PW2 Accept cert of ins/Site Safety " +data[0]);
//			loginToCrm(data[0]);
			searchForJobCrm();
			waitDocStatus();
			waitVisible(Constants.label_job_filing);
			waitUntilElementVisible(Constants.crm_permit_not_yet_issued_link, 30);
			rightClick(Constants.crm_permit_not_yet_issued_link);
//			new Actions(driver).contextClick(driver.findElement(By.xpath(Constants.crm_permit_not_yet_issued_link))).build().perform();
			new Actions(driver).sendKeys(Keys.ENTER).build().perform();
			ifAlertExistAccept();
			waitForPageToLoad();
			waitVisible(Constants.crm_documents_first_document_link);
			waitClickableOr("//nobr[text()='Accepted']", "//nobr[text()='Submitted']");
			viewAcceptDocs();
			
			/*if (count(Constants.crm_document_status_submitted) > 0) {
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
			}*/
		}
		navigate(crm_url);
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
		}
	}
	
}
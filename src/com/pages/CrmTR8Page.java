/*package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.base.TestBase;
import com.util.Constants;

public class CrmTR8Page extends TestBase {
	
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
				if (count(Constants.public_assembly_emergency_lighting) > 0)
					break;				
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
	}

	public void viewAcceptTR8PDocs(String user_name, String accept_tr) {
		if (!accept_tr.equals("")) {
			String[] data = user_name.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** " + data[0] + " View accept Energy");
			loginToCrm(data[0]);
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
	}
}*/
package com.pages;

import com.base.TestBase;
import com.util.Constants;
import org.openqa.selenium.By;

public class DobDocumentsPage extends TestBase {

	public void uploadDocuments(String upload_file) {
		if (!upload_file.equals("")) {
			System.out.println(convertedTimestamp() + " **************** Documents uploadDocuments");
//			filterJob(user);
			test = rep.startTest("Upload Documents");
			click(Constants.docs_documents_tab);
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-15 
				if (driver.findElement(By.xpath(Constants.documents_loading_spinner)).isDisplayed()) {
					refreshPage();
					waitForPageToLoad();
					wait(3);
				}
			} else {
				if (driver.findElement(By.xpath(Constants.documents_loading_spinner_8085)).isDisplayed()) {
					refreshPage();
					waitForPageToLoad();
					wait(3);
				}
				scrollAllWayUp(); // JG 2018-11-30 
			}
			while (count(Constants.upload_document_icon) < 1) {
				refreshPage();
				waitForPageToLoad();
				wait(3);
			}
			while (count(Constants.document_status_required) > 0) { 
				if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-15
					type(Constants.document_status_filter, "required");
				} else {
					type(Constants.document_status_filter_8085, "required");
				}
				wait(1);
				click(Constants.upload_document_icon);
				send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
				click(Constants.doc_upload_button);
				waitInvisible(Constants.doc_please_wait_message);
				waitVisible(Constants.doc_upload_succesfull_message);				
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
				if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-15 
					if (driver.findElement(By.xpath(Constants.documents_loading_spinner)).isDisplayed()) {
						refreshPage();
						waitForPageToLoad();
						wait(5);
					}
				} else {
					if (driver.findElement(By.xpath(Constants.documents_loading_spinner_8085)).isDisplayed()) {
						refreshPage();
						waitForPageToLoad();
						wait(5);
					}
				}
				if (count(Constants.document_status_required) == 0) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
//					assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved");
					wait(2);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					wait(2);
					clickButton("OK");// JG 2018-12-13 clickButton is supposed to click the OK button for all pop-ups whenever multiple pop-ups happen, but it doesn't always work in the new UI.
					waitInvisible(Constants.ok_button);
				}
			}
			reportPass("uploadDocuments");
		} else {
			System.out.println(convertedTimestamp() + " **************** Documents no uploadDocuments");
		}
	}
	
	public void addSupportingDocuments(String upload_file) {
		if (!upload_file.equals("")) {
			System.out.println(convertedTimestamp() + " **************** Documents addSupportingDocuments");
			test = rep.startTest("addSupportingDocuments");
			click(Constants.docs_documents_tab);			
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			if (driver.findElement(By.xpath(Constants.documents_loading_spinner_8085)).isDisplayed()) {
				refreshPage();
				waitForPageToLoad();
				wait(3);
			}
			scrollAllWayUp();
			click(Constants.docs_additional_supporting_documents_accordion); // open
			click(Constants.docs_add_new_document_button);
			type(Constants.docs_search_documents_textbox, "Landmark Approval");
			wait(1);
			send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
			click(Constants.doc_upload_button);
			waitInvisible(Constants.doc_please_wait_message);
			waitVisible(Constants.doc_upload_succesfull_message);				
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			waitUntilISpinnersInvisible();
			waitForPageToLoad();
			if (driver.findElement(By.xpath(Constants.documents_loading_spinner_8085)).isDisplayed()) {
				refreshPage();
				waitForPageToLoad();
				wait(5);
			}
			reportPass("addSupportingDocuments");
		} else {
			System.out.println(convertedTimestamp() + " **************** Documents no addSupportingDocuments");
		}
	}

} // end of class
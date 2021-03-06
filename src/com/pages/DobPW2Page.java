package com.pages;

import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import com.util.Constants;

public class DobPW2Page extends TestBase {
/*	WebDriver driver;
	public DobPW2Page(WebDriver dr) {
		driver = dr;
	}*/

	public void workPermit(String pw2) {	
		if(!pw2.equals("")){
			String[] data = pw2.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** PW2 workPermit");
			filterJob(user);
			test = rep.startTest("PW2");
			test.log(LogStatus.INFO, "workPermit PW2");
			click(Constants.pw2_work_permit_step);
			wait(2);
			waitVisible("//div[@class='ui-grid-viewport']");
			while(count(Constants.global_add_button) <= 0) {
				refreshPage();
				click(Constants.pw2_work_permit_step);
				wait(1);
			}
			if (count(Constants.trash_can_icon) > 0) {
				click(Constants.trash_can_icon);
				waitVisible(Constants.yes_button);
				clickButton("Yes");
				waitInvisible(Constants.yes_button);
			}
			clickAndWait(Constants.global_add_button, Constants.pw2_calendar_icon);
			wait(2);
				click(Constants.pw2_calendar_icon);
				click(Constants.pw2_calendar_active_day);
				email(data[0]);
				select(Constants.license_type_list, data[1]);
				select(Constants.license_type_list, OR_PROPERTIES.getProperty("user_licence_type"));
				radio(Constants.pw2_different_from_applicant_no);
		 		type(Constants.pw2_liability, "liability");
				click(Constants.pw2_liability_expiration_calendar);
				click(Constants.pw2_calendar_next_month_arrow);
				click(Constants.pw2_calendar_active_day);
		 		type(Constants.pw2_workers_compensation, "workers");
		 		click(Constants.pw2_workers_compensation_expiration_calendar);
				click(Constants.pw2_calendar_next_month_arrow);
				click(Constants.pw2_calendar_active_day);
				type(Constants.pw2_disability, "disability");
				click(Constants.pw2_disability_expiration_calendar);
				click(Constants.pw2_calendar_next_month_arrow);
				click(Constants.pw2_calendar_active_day);
				waitTime(1000);
		 		check(Constants.pw2_information_correct_and_complete);
		 		click(Constants.pw2_save_button);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_saved"));
				clickButton("OK");
				waitInvisible(Constants.ok_button);
			test = rep.startTest("PW2 upload docs");
			System.out.println(convertedTimestamp() + " **************** uploadDocuments PW2");
			scrollAllWayUp();
			for (int i = 1; i < 10; i++) {
				doubleclick(Constants.pw2_documents_tab);
				waitVisible("//span[text()='Document Status']");
				if (count(Constants.document_status_required) == 0)
					break;
				click(Constants.upload_document_icon);
				send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
				click(Constants.doc_upload_button);
				waitInvisible(Constants.doc_please_wait_message);
				waitVisible(Constants.doc_upload_succesfull_message);				
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				waitUntilISpinnersInvisible();
				waitForPageToLoad();	
		 		click(Constants.pw2_save_button);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_saved"));
				clickButton("OK");
				waitInvisible(Constants.ok_button);
			}			
			if(getElement(Constants.pw2_file_button).isDisplayed() == true) {				
				if (count("//button[@disabled='disabled'][text()='File']") == 0) {
					click(Constants.pw2_file_button);
					// clickButton("File");
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_submitted_for_review"));
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}
				if (count(Constants.pw2_cancel_button) > 0)
					clickButton(Constants.pw2_cancel_button);
			}
		}
		reportPass("workPermit");
	}
	
	// Add PW2 Work Permit
	public void addWorkPermit(String pw2) {	
		if(!pw2.equals("")){
			String[] data = pw2.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** PW2 addWorkPermit");
			if (!data[6].equals("AJOETEST@GMAIL.COM")) { // ajoetest is used for speeding up job creation
				filterJob(user);
			}
			test = rep.startTest("PW2");
			test.log(LogStatus.INFO, "workPermit PW2");
			wait(1);
			click(Constants.pw2_work_permit_step);
			wait(2);
			scrollAllWayUp();
			click(Constants.pw2_add_work_permit);
			wait(2);
			
			wait(1);
			
			click(Constants.pw2_reason_for_filing_accordion); // open
			click(Constants.pw2_calendar_icon);
			click(Constants.pw2_calendar_active_day);
			click(Constants.pw2_reason_for_filing_accordion); // close
			
			click(Constants.pw2_type_of_permit_accordion); // open
//			select(Constants.pw2_select_type_of_permit, "Boilers");
//			type(Constants.pw2_type_of_permit_job_description, "Job description - type of permit.");
			click(Constants.pw2_type_of_permit_accordion); // close
			
			click(Constants.pw2_applicant_information_accordion); // open			
			email(data[0]);
			select(Constants.license_type_list, data[1]);
			wait(1);
			select(Constants.pw2_select_business_name, data[2]);
			type(Constants.pw2_applicant_taxpayer_id, data[3]);
			type(Constants.pw2_registration_tracking_number, data[4]);
			if (count(Constants.pw2_applicant_responsible_for_all_work_no) > 0) {
				radio(Constants.pw2_applicant_responsible_for_all_work_no);
			}
			scrollAllWayUp();
			click(Constants.pw2_applicant_information_accordion); // close
			
			click(Constants.pw2_filing_representative_accordion); // open
			email(data[5]);
			scrollAllWayUp();
			click(Constants.pw2_filing_representative_accordion); // close
			
			if (!data[7].equals("skip insurance")) {
				click(Constants.pw2_insurance_accordion); // open
				type(Constants.pw2_liability_name, data[7]);
				click(Constants.pw2_liability_expiration_calendar);
				click(Constants.pw2_calendar_next_month_arrow);
				click(Constants.pw2_calendar_active_day);
		 		type(Constants.pw2_workers_compensation_name, data[8]);
		 		click(Constants.pw2_workers_compensation_expiration_calendar);
				click(Constants.pw2_calendar_next_month_arrow);
				click(Constants.pw2_calendar_active_day);
				type(Constants.pw2_disability_name, data[9]);
				click(Constants.pw2_disability_expiration_calendar);
				click(Constants.pw2_calendar_next_month_arrow);
				click(Constants.pw2_calendar_active_day);
				scrollAllWayUp();
				click(Constants.pw2_insurance_accordion); // close
			}
			
			click(Constants.pw2_statements_signatures_tab);
			radio(Constants.pw2_work_require_adjacent_property_insurance_no);
			check(Constants.pw2_information_correct_and_complete);
	 		click(Constants.pw2_work_permit_save);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			wait(1);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_saved"));
			wait(1);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		
			// Move the following to a separate method, run with PW2 Applicant user.
//			click(Constants.pw2_documents_tab2);
//			waitVisible("//span[text()='Document Status']");
//			click(Constants.upload_document_icon);
//			send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
//			click(Constants.doc_upload_button);
//			waitInvisible(Constants.doc_please_wait_message);
//			waitVisible(Constants.doc_upload_succesfull_message);				
//			clickButton("OK");
//			waitInvisible(Constants.ok_button);
//			waitUntilISpinnersInvisible();
//			waitForPageToLoad();
			
	 		click(Constants.pw2_work_permit_save);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			wait(1);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_saved"));
			wait(1);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			click(Constants.pw2_back_to_filing);
		} else {
			System.out.println(convertedTimestamp() + " **************** PW2 no addWorkPermit");
		}
		reportPass("addWorkPermit");
	}
	
	public void workPermitPlumbing(String pw2) {	
		if(!pw2.equals("")){
//			String[] data = pw2.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** workPermitPlumbing");
			filterJob(user);
			click(Constants.pw2_work_permit_step);
			while(count(Constants.pw2_save_button) <= 0) {
				refreshPage();
				click(Constants.global_add_button);
				wait(2);
			}
			test = rep.startTest("PW2");
			test.log(LogStatus.INFO, "PW2 workPermit");
			click(Constants.pw2_calendar_icon);
			click(Constants.pw2_calendar_active_day);
			select("//select[@id='txtWPPermitType']", "Plumbing");
			email(OR_PROPERTIES.getProperty("mrctest003"));
			select(Constants.license_type_list, pw2_lic);
			select("//select[@id='txtPWAppbusiness']", "JCG INDUSTRIES INC");
			radio(Constants.pw2_different_from_applicant_no);
			radio("//input[@id='chkWPNotRequiredInsuranceTerms2']");
//			check(Constants.pw2_information_correct_and_complete);
			click(Constants.pw2_save_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			
			filterJob(OR_PROPERTIES.getProperty("mrctest003"));
			scrollAllWayUp();
			click(Constants.pw2_work_permit_step);
			doubleclick("//div[text()='Permit is not yet issued']");
			check(Constants.pw2_information_correct_and_complete);
			click(Constants.pw2_save_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			doubleclick(Constants.pw2_documents_tab);
			// Preparation for upload documents	
			reportPass("workPermitPlumbing");
		}
	}
	public void XuploadDocuments(String upload_file) {	
		if(!upload_file.equals("")){
			test = rep.startTest("PW2 upload docs");
			System.out.println(convertedTimestamp() + " **************** " + "PW2 uploadDocuments");
			scrollAllWayUp();
/*			if(CONFIG.getProperty("env").contains("443") || CONFIG.getProperty("env").contains("8085")) {
			doubleclick(Constants.pw2_documents_tab);
			}*/
			for (int i = 1; i < 10; i++) {
				waitVisible("//span[text()='Document Status']");
				if (count(Constants.document_status_required) == 0)
					break;
				click(Constants.upload_document_icon);
				send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
				click(Constants.doc_upload_button);
				waitInvisible(Constants.doc_please_wait_message);
				waitVisible(Constants.doc_upload_succesfull_message);				
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				waitUntilISpinnersInvisible();
				waitForPageToLoad();
				
			}
/*			doubleclick(Constants.pw2_documents_tab);
			while (count(Constants.document_status_required) > 0) { 
//				type(Constants.document_status_filter, "required");
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
			}	*/
/*			for (int i=0; count(Constants.document_status_required) > 0; i++) {
				test.log(LogStatus.INFO, "Upload documents " +i);
//				if(CONFIG.getProperty("env").contains("8085"))
				doubleclick(Constants.pw2_documents_tab);
				doubleclick("(//i[@class='fa fa-upload'])[" +i+ "]");
				waitVisible(Constants.doc_browse_button);
				send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
				click(Constants.doc_upload_button);
				waitInvisible(Constants.doc_please_wait_message);
				waitVisible(Constants.doc_upload_succesfull_message);
				click(Constants.doc_document_uploaded_ok_button);
				waitInvisible(Constants.doc_document_uploaded_ok_button);
				waitInvisible(Constants.global_loading_spinner);
				waitUntilISpinnersInvisible();

			}*/
	 		click(Constants.pw2_save_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			if (upload_file.contains("File")) {
				click(Constants.pw2_file_button);
//				clickButton("File");
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("work_permit_submitted_for_review"));
				clickButton("OK");
				waitInvisible(Constants.ok_button);
			}
			else
				click(Constants.cancel_button);
		}
		reportPass("uploadDocuments");
	}

}
package com.pages;

import com.base.TestBase;
import com.util.Constants;

public class DobSignaturesPage extends TestBase {

	public void applicantStatementsSignature(String signatures) {
		if(!signatures.equals("")){
			System.out.println(convertedTimestamp() + " **************** Applicant Sign");
			filterJob(user);	
			test = rep.startTest("applicantStatementsSignature");
			refreshPage(); //JG 2018-11-28: need to refresh for elements to be clickable
			click(Constants.ss_statement_signatures_step);
			waitUntilISpinnersInvisible();
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-14: new PW1 UI
				waitVisible(Constants.ss_save_button);
				if(count(Constants.project_not_require_commissioning) > 0) {
					radio(Constants.project_not_require_commissioning); // JG 2018-11-19 in new UI, user can't click this.
				}
			} else {
				if(count(Constants.project_not_require_commissioning) > 0) {
					scrollTo(Constants.project_not_require_commissioning); // JG 2018-11-19
				} else {
					scrollTo(Constants.ss_technical_report_text); // JG 2018-11-21
				}
			}
			if(count(Constants.ss_i_havepersonally_reviewed_all_information_8085) > 0) { // JG 2018-11-14
				check(Constants.ss_i_havepersonally_reviewed_all_information_8085);
			}			
			wait(2); // JG 2018-11-14
//			scrollTo("//h3[contains(text(),'Owner - Statements & Signatures')]"); // JG 2018-11-14 //rblPWFeeExceptReqNonPro
			if(signatures.contains("profit"))
				radio(Constants.ss_fee_exemption_reques_non_profit_yes+ "[@value='false']");
			else
				radio(Constants.ss_fee_exemption_reques_non_profit_yes+ "[@value='true']");
//			radio(Constants.ss_fee_exemption_reques_non_profit_yes);
			radio(Constants.ss_owners_certifications_yes);
			radio(Constants.ss_building_to_be_altered_demolished_no);
			radio(Constants.ss_building_to_be_altered_demolished_no);
//			radio(Constants.ss_owner_is_not_required_to_notify_yes);
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-15
				radio(Constants.ss_owner_is_not_required_to_notify_no);
				radio(Constants.ss_owner_notified_new_york);
			}
			scrollTo(Constants.ss_owner_type); // JG 2018-11-14 need to get the email field clickable
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-15
				select(Constants.ss_owner_type, "Partnership");
			} else {
				select(Constants.ss_owner_type, "NYCHA/HHC"); //JG 2018-11-15 new UI uses this to indicate Pay Exempt
			}
			email(OR_PROPERTIES.getProperty("owner_email"));
			wait(1); // JG 2018-11-30
			click(Constants.save_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			wait(1); // JG 2018-11-30
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved ss");
			wait(1); // JG 2018-11-30
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
	}
	public void signatures(String signatures) {	
		if(!signatures.equals("")){
			System.out.println(convertedTimestamp() + " **************** StatementsSignaturesTest");
			filterJob(user);	
			test = rep.startTest("signatures");
			waitUntilElementVisible(Constants.ss_statement_signatures_step, 30);
			click(Constants.ss_statement_signatures_step);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ss_save_button);
			if(count(Constants.project_not_require_commissioning) > 0)
				radio(Constants.project_not_require_commissioning);
			check(Constants.ss_i_havepersonally_reviewed_all_information);
			scrollTo("//h3[contains(text(),'Owner - Statements & Signatures')]"); // JG 2018-11-14
			radio(Constants.ss_fee_exemption_reques_non_profit_yes);
			scrollToElement(Constants.ss_owners_certifications_yes);
			radio(Constants.ss_owners_certifications_yes);
			radio(Constants.ss_building_to_be_altered_demolished_no);
			radio(Constants.ss_building_to_be_altered_demolished_no);
//			radio(Constants.ss_owner_is_not_required_to_notify_yes);
			
			radio(Constants.ss_owner_is_not_required_to_notify_no);
			
			radio(Constants.ss_owner_notified_new_york);
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-15
				select(Constants.ss_owner_type, "Partnership");
			} else {
				select(Constants.ss_owner_type, "NYCHA/HHC"); //JG 2018-11-15 new UI uses this to indicate Pay Exempt
			}
	 		emailpreview = Constants.email_xpath_part1 + OR_PROPERTIES.getProperty("owner_email") + Constants.email_xpath_part2;
			waitUntilElementVisible(Constants.ss_partner_email, 30);
	 		for(int i=1; i < 100; i++) {
	 			clear(Constants.ss_partner_email);
	 			type(Constants.ss_partner_email, OR_PROPERTIES.getProperty("owner_email"));
	 			wait(1);
	 			if(count(emailpreview) > 0)
	 				break;
	 		}
/*			
//			if(!description.contains("Correction") ) {
				type(Constants.ss_partner_email, OR_PROPERTIES.getProperty("owner_email"));
		 		wait(2);
				while(count(emailpreview) < 0) {
					clear(Constants.ss_partner_email);
					type(Constants.ss_partner_email, OR_PROPERTIES.getProperty("owner_email"));
					wait(1);
				}*/
				clickElement(emailpreview);
//			}
			click(Constants.ss_save_button);
//			waitUntilElementVisible(Constants.global_loading_spinner, 10);
			waitUntilISpinnersInvisible();
			waitUntilElementVisible(Constants.global_notification_ok_button, 30);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved ss");
			clickButton("OK");
			waitInvisible(Constants.global_notification_ok_button);
		}
	}

	public void applicantSignature(String statements_signatures) {	
		if(!statements_signatures.equals("")){
			System.out.println(convertedTimestamp() + " **************** " + "applicantSignature");
			filterJob(user);	
			test = rep.startTest("Applicant Sign");
			click(Constants.ss_statement_signatures_step);
			wait(2);
			scrollToElement(Constants.ss_i_havepersonally_reviewed_all_information);
/*			if(!ss_i_havepersonally_reviewed_all_information.isSelected())
				ss_i_havepersonally_reviewed_all_information.click();*/
			check(Constants.ss_i_havepersonally_reviewed_all_information);
			wait(2);
			scrollToElement(Constants.ss_save_button);
			click(Constants.ss_save_button);
//			waitUntilElementVisible(Constants.global_loading_spinner, 10);
			waitUntilISpinnersInvisible();
			waitUntilElementVisible(Constants.global_notification_ok_button, 30);
			wait(1); // JG 2018-11-30
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved ss");
			clickButton("OK");
			waitInvisible(Constants.global_notification_ok_button);
		}
	}
	public void ownerSignature(String owner_signature) {	
		if(!owner_signature.equals("")){
			System.out.println(convertedTimestamp() + " **************** Owner Sign");
			filterJob(OR_PROPERTIES.getProperty("owner_email"));
			test = rep.startTest("Owner Sign");
			click(Constants.ss_statement_signatures_step);
			wait(2);
			scrollToElement(Constants.ss_i_understand_and_agrree);
			check(Constants.ss_i_understand_and_agrree);
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-14: new PW1 UI
				scrollToElement(Constants.ss_save_button);
				click(Constants.ss_save_button);
			} else {
				click(Constants.save_button);
			}
			waitInvisible(Constants.global_loading_spinner);
			waitVisible(Constants.ok_button);
			wait(1); // JG 2018-11-30
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved owner sign");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			filterJob(user);
		}
	}


}
package com.pages;

import com.util.Constants;
import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class DobTR8Page extends TestBase {
/*	WebDriver driver;
	public DobTR8Page(WebDriver dr) {
		driver = dr;
	}*/
	String add_button;

	public void energyCodeProgressInspection(String tr8) {
		if (!tr8.equals("")) {
			System.out.println(convertedTimestamp() + " **************** TR8 energyCodeProgressInspection");
//			filterJob(OR_PROPERTIES.getProperty("user_email"));
			test = rep.startTest("TR8 Energy progress");
			click(Constants.tr8_technical_report_energy_step);
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-14: new PW1 UI
				check(Constants.tr8_are_you_progress_inspector);
			}
			for (int i = 1; i < 100; i++) {
				waitVisible("//span[text()='Requirement']");
				multiClick(Constants.add);
				click(Constants.tr8_select_requirement_code);
				type(Constants.tr8_select_requirement_code_field, tr8);
				click(Constants.tr8_select_requirement_code_filter);
				click(Constants.inspection_label);
				email(OR_PROPERTIES.getProperty("progress_inspector_email"));
				if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-14: new PW1 UI
					select(Constants.tr1_license_type, OR_PROPERTIES.getProperty("progress_inspector_lisence"));
					if (text(Constants.tr1_license_type).contains(OR_PROPERTIES.getProperty("progress_inspector_lisence"))) {
						click(Constants.tr8_save_progress_inspection_button);
					} else {
						click(Constants.global_cancel_button);
					}

				} else {
					click(Constants.tr8_save_progress_inspection_button_8085);
					}
				waitUntilElementVisible(Constants.ok_button, 30);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
				click(Constants.ok_button);
				waitInvisible(Constants.ok_button);
				if (count(Constants.identified_no_label) > 0) {
					break;
				}
			}
			reportPass("Success");
		}
	}

	public void energyCodeProgressInspectionBoilerEquipment(String tr8) {
		if (!tr8.equals("")) {
			String[] data = tr8.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR8 energyCodeProgressInspectionBoilerEquipment");
			filterJob(OR_PROPERTIES.getProperty("user_email"));
			test = rep.startTest("TR8 Energy progressInspectionBoilerEquipment");
			click(Constants.tr8_technical_report_energy_step);
			for (int i = 1; i < 100; i++) {
				waitVisible("//span[text()='Requirement']");
				multiClick(Constants.add);
				click(Constants.tr8_select_requirement_code);
//				type(Constants.tr8_select_requirement_code_field, data[1]); // JG filtering this way is making the requirement_code_filter not visible
				wait(1);
				click(Constants.tr8_select_requirement_code_filter);
				click(Constants.inspection_label);
				email(OR_PROPERTIES.getProperty("progress_inspector_email"));
				click(Constants.tr8_save_progress_inspection_button_8085);
				waitUntilElementVisible(Constants.ok_button, 30);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
				click(Constants.ok_button);
				waitInvisible(Constants.ok_button);
				if (count(Constants.identified_no_label) > 0) {
					break;
				}
			}
			reportPass("Success");
		}
	}
	
	public void energyCodeSignature(String tr8) {
		if (!tr8.equals("")) {
			System.out.println(convertedTimestamp() + " **************** TR8 energyCodeSignature");
			for (int i = 1; i < 100; i++) {
				filterJob(OR_PROPERTIES.getProperty("energy_code_inspector_email"));
				test = rep.startTest("TR8 Energy Sign");
				click(Constants.tr8_technical_report_energy_step);
				check(Constants.tr8_are_you_progress_inspector);
				wait(2);
				click("(//i[@class='fa fa-edit'])[last()]");
				wait(2);
				check(Constants.tr8_i_take_responcibility);
				check(Constants.tr8_i_understand_and_agree);
				if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-14: new PW1 UI
					select(Constants.tr1_license_type, OR_PROPERTIES.getProperty("progress_inspector_lisence"));
					click(Constants.tr8_save_progress_inspection_button_8085);
					waitInvisible(Constants.tr8_save_progress_inspection_button_8085);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_saved_success"));
				} else {
					click(Constants.global_save_form_button);
					waitInvisible(Constants.global_save_form_button);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_updated"));
				}				
				click(Constants.ok_button);
				waitInvisible(Constants.ok_button);
				if (count(Constants.identified_yes_label) > 0)
					break;
			}
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-14: new PW1 UI
				click(Constants.upload_document_icon);
			} else {
				click(Constants.upload_document_icon_8085);
			}
			send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
			wait(1);
			click(Constants.tr1_upload_button);
			waitInvisible(Constants.tr1_please_wait_message);
			waitVisible(Constants.tr1_upload_succesfull_message);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
			reportPass("Success");
			filterJob(user);
		}
	}

	public void energyCodeSignatureMechanicalSystems(String tr8) { // JG 2018-12-10 new method to add signature info for ajoetest@gmail.com
		if (!tr8.equals("")) {
			String[] data = tr8.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR8 energyCodeSignatureMechanicalSystems");
			filterJob(data[2]);
			test = rep.startTest("TR8 Energy Sign");
			click(Constants.tr8_technical_report_energy_step);
			wait(2);
			check(Constants.tr8_are_you_progress_inspector);
			wait(2);
			click("(//i[@class='fa fa-edit'])[last()]");
			wait(2);
			email(data[2]);
			select(Constants.tr1_license_type, data[3]);
			check(Constants.tr8_i_take_responcibility);
			check(Constants.tr8_i_understand_and_agree);
			click(Constants.tr8_save_progress_inspection_button_8085);
			waitInvisible(Constants.tr8_save_progress_inspection_button_8085);				
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_saved_success"));
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
//			click(Constants.upload_document_icon_8085);
			click("(//i[@class='fa fa-upload ng-scope'])[last()]");
			send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
			wait(1);
			click(Constants.tr1_upload_button);
			waitInvisible(Constants.tr1_please_wait_message);
			waitVisible(Constants.tr1_upload_succesfull_message);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
			reportPass("Success");
			filterJob(user);
		}
	}
	
	public void energyCodeProgressPlumbing(String tr8) {
		if (!tr8.equals("")) {
			String[] data = tr8.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR8 energyCodeProgressPlumbing");
			filterJob(user);
			test = rep.startTest("energyCodeProgressPlumbing");
			click(Constants.tr8_technical_report_energy_step);
			check(Constants.tr8_are_you_progress_inspector);
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-12-12: new UI, just add 1 new TR8
				click(Constants.tr8_add_energy_code_progress_inspection);
				click(Constants.tr8_select_requirement_code);
				type(Constants.tr8_select_requirement_code_field, data[1]);
				click(Constants.tr8_select_requirement_code_filter);
				click(Constants.inspection_label);
				email(data[2]);
				select(Constants.tr1_license_type, data[3]);
				click(Constants.tr8_save_progress_inspection_button_8085);
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification,
						TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
				click(Constants.ok_button);
				waitInvisible(Constants.ok_button);
				wait(2);
			} else {
				if(count("//span[contains(text(),'Legalization')]") > 0)
					add_button = "(//*[text()='Add'])[last()]";			
				if(count("//span[contains(text(),'New Work')]") > 0)
					add_button = "//*[text()='Add']";
				for (int i = 1; i < 20; i++) {
					waitVisible("//span[text()='Requirement']");
					multiClick(add_button);
					click(Constants.tr8_select_requirement_code);
					type(Constants.tr8_select_requirement_code_field, data[1]);
					click(Constants.tr8_select_requirement_code_filter);
					click(Constants.inspection_label);
					email(data[2]);
					select(Constants.tr1_license_type, data[3]);
					if (text(Constants.tr1_license_type).contains(data[3])) {
						click(Constants.tr8_save_progress_inspection_button);
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification,
								TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
					}
					wait(2);
					if (count("//div[text()='" + data[1] + "']") >= 1)
						break;
				}
				if (Integer.valueOf(data[0]) > 1) {
					for (int i = 1; i < 20; i++) {
						add_button = "(//*[text()='Add'])[last()]";	
						waitVisible("//span[text()='Requirement']");
						multiClick(add_button);
						click(Constants.tr8_select_requirement_code);
						type(Constants.tr8_select_requirement_code_field, data[1]);
						click(Constants.tr8_select_requirement_code_filter);
						click(Constants.inspection_label);
						email(data[2]);
						select(Constants.tr1_license_type, data[3]);
						if (text(Constants.tr1_license_type).contains(data[3])) {
							click(Constants.tr8_save_progress_inspection_button);
							waitVisible(Constants.ok_button);
							verifyNotification(Constants.notification,
									TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
							clickButton("OK");
							waitInvisible(Constants.ok_button);
						}
						if (count("//div[text()='" + data[1] + "']") >= Integer.valueOf(data[0]))
							break;
					}
				}
			}
			reportPass("energyCodeProgressPlumbing");
		}
	}
	public void energyCodeProgress2(String tr8) {
		if (!tr8.equals("")) {
			String[] data = tr8.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR8 energyCodeProgress2");
			filterJob(user);
			test = rep.startTest("TR8 Energy Code progress");
			click(Constants.tr8_technical_report_energy_step);
			check(Constants.tr8_are_you_progress_inspector);
			for (int i = 1; i < 100; i++) {
				waitVisible("//span[text()='Requirement']");
				multiClick(Constants.add);
				click(Constants.tr8_select_requirement_code);
				type(Constants.tr8_select_requirement_code_field, data[0]);
				click(Constants.tr8_select_requirement_code_filter);
				click(Constants.inspection_label);
				


				
				
				
				select(Constants.tr1_license_type, data[2]);
				if (text(Constants.tr1_license_type).contains(data[2]))
					break;
				else
					click(Constants.global_cancel_button);
			}
			click(Constants.tr8_save_progress_inspection_button);
			waitUntilElementVisible(Constants.ok_button, 30);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
			reportPass("Success");
		}
	}

	public void energyCodeSignaturePlumbing(String tr8) {
		if (!tr8.equals("")) {
			String[] data = tr8.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR8 energyCodeSignaturePlumbing");
			filterJob(data[2]);
			test = rep.startTest("TR8 Energy Code Signature");
			click(Constants.tr8_technical_report_energy_step);
			wait(2);
			check(Constants.tr8_are_you_progress_inspector);
			wait(3);
			for (int i = 1; i <= 20; i++) {
				test.log(LogStatus.INFO, " energyCodeSignaturePlumbing");
				if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-27
					click("(//i[@class='fa fa-edit'])[last()]");
				} else {
					click("(//i[@class='fa fa-edit'])[" + i + "]");
				}
				wait(2);
				check(Constants.tr8_i_take_responcibility);
				check(Constants.tr8_i_understand_and_agree);
				if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-27
					click(Constants.tr1_save_progress_inspection_button_8085);
					waitInvisible(Constants.tr1_save_progress_inspection_button_8085);
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification,TEXT_PROPERTIES.getProperty("tr_saved_success"));
				} else {
					click(Constants.tr1_save_progress_inspection_button);
					waitInvisible(Constants.tr1_save_progress_inspection_button);
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification,TEXT_PROPERTIES.getProperty("tr_updated"));
				}
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				
				wait(2);
/*					if(count("//span[text()='Required']") > 0) {
					click("//span[text()='Required']");
					waitVisible(Constants.tr1_browse_button);
					send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
					click(Constants.tr1_upload_button);
					waitInvisible(Constants.tr1_please_wait_message);
					waitVisible(Constants.tr1_upload_succesfull_message);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				} */
					if (count(Constants.identified_yes_label) >= Integer.valueOf(data[0]))
						break;
			}
			for (int i = 1; i <= 10; i++) {
				if (count("//span[text()='Required']") > 0) {
					click("//span[text()='Required']");
					waitVisible(Constants.tr1_browse_button);
					send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
					click(Constants.tr1_upload_button);
					waitInvisible(Constants.tr1_please_wait_message);
					waitVisible(Constants.tr1_upload_succesfull_message);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					clickButton("OK");
					waitInvisible(Constants.ok_button);
					if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-28 need to exit loop for new UI
						break;
					}
				}
			}
		}
//		filterJob(user);
		reportPass("energyCodeSignaturePlumbing");
	}

}
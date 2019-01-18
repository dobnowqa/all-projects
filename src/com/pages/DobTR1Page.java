package com.pages;

import com.util.Constants;
import org.openqa.selenium.By;
import com.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class DobTR1Page extends TestBase {

	String add_button;

	public void specialInspection(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspection");
			filterJob(user);
			test = rep.startTest("TR1 Inspection");
			click(Constants.tr1_technical_report_step);
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-13: new PW1 UI
				if (count(Constants.tr1_are_you_special_inspector) > 0) {
					check(Constants.tr1_are_you_special_inspector);
				}
				check(Constants.tr1_are_you_progress_inspector);
			}
			for (int i = 1; i < 100; i++) {
				multiClick(Constants.add);
//				click(Constants.global_add_button);
				click(Constants.tr1_select_requirement_code);
				type(Constants.tr1_select_requirement_code_field, data[0]);
				click(Constants.tr1_select_requirement_code_filter);
				click(Constants.inspection_label);
				email(OR_PROPERTIES.getProperty("special_inspector_email"));
				select(Constants.tr1_license_type, OR_PROPERTIES.getProperty("special_inspector_lisence"));
				type(Constants.tr1_agency_number, data[3]);
				//keyPressTab(Constants.tr1_agency_number);
				wait(2);
				if (count(Constants.green_valid_label) > 0) {
					break;
				} else {
					click(Constants.global_cancel_button);
				}
			}
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-02: new PW1 UI
				click(Constants.tr1_save_progress_inspection_button_8085);
				waitInvisible(Constants.tr1_save_progress_inspection_button_8085);
			} else {
				click(Constants.tr1_save_progress_inspection_button);
				waitInvisible(Constants.tr1_save_progress_inspection_button);
			}
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			reportPass("Success");
		}
	}
	
	public void specialInspectionMechanicalSystems(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectionMechanicalSystems");
			if (!data[1].equals("AJOETEST@GMAIL.COM")) { // ajoetest is used for speeding up job creation
				filterJob(user);
			}
			test = rep.startTest("TR1 Inspection");
			click(Constants.tr1_technical_report_step);
			scrollAllWayUp();
			if (count(Constants.tr1_are_you_special_inspector) > 0) {
				check(Constants.tr1_are_you_special_inspector);
			}
			if (count(Constants.tr1_are_you_progress_inspector) > 0) {
				check(Constants.tr1_are_you_progress_inspector); // JG 2018-12-07 as of now, only the special inspector needs to be entered.
			}
			// Edit the Special Inspection row to enter the inspector email:
			click("(//i[@class='fa fa-edit'])[last()-1]");
			email(data[1]);
			select(Constants.tr1_license_type, data[2]);
			type(Constants.tr1_agency_number, data[3]);
			//keyPressTab(Constants.tr1_agency_number);
			wait(2);
			click(Constants.tr1_save_progress_inspection_button_8085);
			waitInvisible(Constants.tr1_save_progress_inspection_button_8085);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			reportPass("Success");
		}
	}

	public void specialInspectionStructural(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectionStructural");
			if (!data[1].equals("AJOETEST@GMAIL.COM")) { // ajoetest is used for speeding up job creation
				filterJob(user);
			}
			test = rep.startTest("TR1 Inspection");
			click(Constants.tr1_technical_report_step);
			scrollAllWayUp();
			if (count(Constants.tr1_are_you_special_inspector) > 0) { // JG 2019-01-04 no more check boxes asking if you're an inspector? Just check them if they're present.
				check(Constants.tr1_are_you_special_inspector);				
			}
			if (count(Constants.tr1_are_you_progress_inspector) > 0) {
				check(Constants.tr1_are_you_progress_inspector); // JG 2018-12-07 as of now, only the special inspector needs to be entered.
			}			
			// Edit the Special Inspection row to enter the inspector email:
			click("(//i[@class='fa fa-edit'])[last()-1]");
			email(data[1]);
			select(Constants.tr1_license_type, data[2]);
			type(Constants.tr1_agency_number, data[3]);
			wait(2);
			click(Constants.tr1_save_progress_inspection_button_8085);
			waitInvisible(Constants.tr1_save_progress_inspection_button_8085);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			reportPass("Success");
		}
	}

	
	public void specialInspectionBoilerEquipment(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectionBoilerEquipment");
			if (!data[1].equals("AJOETEST@GMAIL.COM")) { // ajoetest is used for speeding up job creation
				filterJob(user);
			}
			test = rep.startTest("TR1 Inspection");
			click(Constants.tr1_technical_report_step);
			wait(1);
			if (count(Constants.tr1_are_you_special_inspector) > 0) { // JG 2019-01-04 no more check boxes asking if you're an inspector? Just check them if they're present.
				check(Constants.tr1_are_you_special_inspector);
			}			
			// Edit the Special Inspection row to enter the inspector email:
			click("(//i[@class='fa fa-edit'])[last()]");
			email(data[1]);
			select(Constants.tr1_license_type, data[2]);
			type(Constants.tr1_agency_number, data[3]);
			//keyPressTab(Constants.tr1_agency_number);
			wait(2);
			click(Constants.tr1_save_progress_inspection_button_8085);
			waitInvisible(Constants.tr1_save_progress_inspection_button_8085);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			wait(1);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			reportPass("Success");
		}
	}

	public void addSpecialInspection(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 addSpecialInspection");
			if (!data[1].equals("AJOETEST@GMAIL.COM")) { // ajoetest is used for speeding up job creation
				filterJob(user);
			}
			test = rep.startTest("TR1 Inspection");
			click(Constants.tr1_technical_report_step);
			wait(1);
			// Add a new Special Inspection row:
			click("(//div/span[contains(text(),'Add')])[last()-3]");
			click(Constants.tr1_select_requirement_code);
			type(Constants.tr1_select_requirement_code_field, data[4]);
			click(Constants.tr1_select_requirement_code_filter);
			click(Constants.inspection_label);
			
			email(data[1]);
			select(Constants.tr1_license_type, data[2]);
			type(Constants.tr1_agency_number, data[3]);
			wait(2);
			
			check(Constants.tr1_i_take_responcibility);
			check(Constants.tr1_i_understand_my_failure_to_file);
			check(Constants.tr1_i_understand_and_agree);
			
			click(Constants.tr1_save_progress_inspection_button_8085);
			waitInvisible(Constants.tr1_save_progress_inspection_button_8085);
			waitUntilISpinnersInvisible();
			
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_saved_success"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			waitInvisible(Constants.tr1_save_progress_inspection_button_8085);	
			
			if(count(Constants.upload_document_icon_8085) > 0) {
				click(Constants.upload_document_icon_8085); // DO NOT CAHNGE TO LAST()
				waitVisible(Constants.tr1_browse_button);
				send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
				wait(1);
				click(Constants.tr1_upload_button);
				waitInvisible(Constants.tr1_please_wait_message);
				waitVisible(Constants.tr1_upload_succesfull_message);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				clickButton("OK");
				waitInvisible(Constants.ok_button);
			}
			
			reportPass("Success");
		}
	}


	public void enterProgressInspectionSignature(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 enterProgressInspectionSignature");
			if (!data[1].equals("AJOETEST@GMAIL.COM")) { // ajoetest is used for speeding up job creation
				filterJob(user);
			}
			test = rep.startTest("TR1 Inspection");
			click(Constants.tr1_technical_report_step);
			wait(1);
			// Enter the signature for an existing Progress Inspection row:
	
			click("(//i[@class='fa fa-edit'])[last()]");
			waitVisible("//h4[text()='Progress Inspection Category']");
			email(data[1]);
			select(Constants.tr1_license_type, data[2]);
			check(Constants.tr1_i_take_responcibility);
			check(Constants.tr1_i_understand_my_failure_to_file);
			check(Constants.tr1_i_understand_and_agree);

			click(Constants.tr1_save_progress_inspection_button_8085);
			waitInvisible(Constants.tr1_save_progress_inspection_button_8085);
			waitUntilISpinnersInvisible();			
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_saved_success"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			waitInvisible(Constants.tr1_save_progress_inspection_button_8085);	
			
			if(count(Constants.upload_document_icon_progress_inspection) > 0) {
				click(Constants.upload_document_icon_progress_inspection);
				waitVisible(Constants.tr1_browse_button);
				send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
				wait(1);
				click(Constants.tr1_upload_button);
				waitInvisible(Constants.tr1_please_wait_message);
				waitVisible(Constants.tr1_upload_succesfull_message);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				clickButton("OK");
				waitInvisible(Constants.ok_button);
			}
		} else {
			System.out.println(convertedTimestamp() + " **************** TR1 no enterProgressInspectionSignature");
		}
	}

	public void specialInspectorSignature(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectorSignature");
			filterJob(data[1]);
			test = rep.startTest("TR1 specialInspectorSignature");
			for (int i = 1; i < 100; i++) {
				click(Constants.tr1_technical_report_step);
				if (count(Constants.tr1_are_you_special_inspector) > 0) {
					check(Constants.tr1_are_you_special_inspector);
				}
				check(Constants.tr1_are_you_progress_inspector);
				if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-13: new PW1 UI
					click("//i[@class='fa fa-edit']"); // DO NOT CAHNGE TO LAST()
				} else {
					click("(//i[@class='fa fa-edit'])[3]"); // JG 2018-11-13: new PW1 UI
				}
				waitVisible("//h4[text()='Special Inspection Category']");
				waitVisible(Constants.tr1_agency_number);
				wait(3);
				if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-13: new PW1 UI
					if (count(Constants.green_valid_label) > 0) {
						check(Constants.tr1_i_take_responcibility);
						check(Constants.tr1_i_understand_my_failure_to_file);
						check(Constants.tr1_i_understand_and_agree);
						click(Constants.tr1_save_progress_inspection_button);
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_updated"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
						waitInvisible(Constants.tr1_save_progress_inspection_button);
					}
				} else {
					if (count(Constants.green_valid_label_8085) > 0) {
						check(Constants.tr1_i_take_responcibility);
						check(Constants.tr1_i_understand_my_failure_to_file);
						check(Constants.tr1_i_understand_and_agree);
						click(Constants.tr1_save_progress_inspection_button_8085);
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_saved_success"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
						waitInvisible(Constants.tr1_save_progress_inspection_button_8085);
					}
				}
				wait(2);
				if (count(Constants.identified_yes_label) > 0)
					break;
				if (!text(Constants.license_type_list).contains(data[2]));
					select(Constants.license_type_list, data[2]); // DO NOT CAHNGE TO LAST()
				if ((count(Constants.tr1_agency_number) > 0))
					type(Constants.tr1_agency_number, "005551");
				wait(2);
				check(Constants.tr1_i_take_responcibility);
				check(Constants.tr1_i_understand_my_failure_to_file);
				check(Constants.tr1_i_understand_and_agree);
				if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-13: new PW1 UI
					click(Constants.tr1_save_progress_inspection_button);
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_updated"));
					clickButton("OK");
					waitInvisible(Constants.ok_button);
					waitInvisible(Constants.tr1_save_progress_inspection_button);
				} else {
					click(Constants.tr1_save_progress_inspection_button_8085);
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_saved_success"));
					clickButton("OK");
					waitInvisible(Constants.ok_button);
					waitInvisible(Constants.tr1_save_progress_inspection_button_8085);
				}
				if (count(Constants.identified_yes_label) > 0)
					break;
/*				else
					click(Constants.cancel_button);*/
			}
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-13: new PW1 UI
				if(count(Constants.upload_document_icon) > 0) {
					click(Constants.upload_document_icon); // DO NOT CAHNGE TO LAST()
					waitVisible(Constants.tr1_browse_button);
					send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
					wait(1);
					click(Constants.tr1_upload_button);
					waitInvisible(Constants.tr1_please_wait_message);
					waitVisible(Constants.tr1_upload_succesfull_message);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}
			} else {
				click(Constants.tr8_technical_report_step); // JG 2018-11-13 click TR8 then TR1 tab to refresh the grid because grid is empty after save.
				waitInvisible(Constants.tr1_please_wait_message);
				click(Constants.tr1_technical_report_step);
				waitInvisible(Constants.tr1_please_wait_message);
				if(count(Constants.upload_document_icon_8085) > 0) {
					click(Constants.upload_document_icon_8085); // DO NOT CAHNGE TO LAST()
					waitVisible(Constants.tr1_browse_button);
					send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
					wait(1);
					click(Constants.tr1_upload_button);
					waitInvisible(Constants.tr1_please_wait_message);
					waitVisible(Constants.tr1_upload_succesfull_message);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}				
			}
			reportPass("Success");
		}
	}

	public void specialInspectionSignNew(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectionPlumbingNew");
//			filterJob(user);
			test = rep.startTest("TR1 specialInspectionPlumbingNew");
			test.log(LogStatus.INFO, " specialInspectionPlumbingNew");
			clickAndWait(Constants.tr1_technical_report_step, Constants.tr1_are_you_special_inspector);
			if (count(Constants.tr1_are_you_special_inspector) > 0) {
				check(Constants.tr1_are_you_special_inspector);
			}
//			if (count(Constants.edit_icon) > 0) {
				for (int i = 1; i < 5; i++) {
					waitVisible("//span[text()='Requirement']");
					multiClick("//span[contains(text(),'Special Inspection Categories for New Work')]/following::span[text()='Add']");
					click(Constants.tr1_select_requirement_code);
					type(Constants.tr1_select_requirement_code_field, data[4]);
					click(Constants.tr1_select_requirement_code_filter);
					click(Constants.inspection_label);
					email(data[1]);
					select(Constants.tr1_license_type, data[2]);
					type(Constants.tr1_agency_number, data[3]);
					//keyPressTab(Constants.tr1_agency_number);
					wait(2);
					if (count(Constants.green_valid_label) > 0) {
						click(Constants.tr1_save_progress_inspection_button);
						waitInvisible(Constants.tr1_save_progress_inspection_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification,
								TEXT_PROPERTIES.getProperty("inspection_requirements_updated"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
						break;
					} else {
						i--;
						click(Constants.global_cancel_button);
					}
				}
//			}
//				filterJob(user);
		}
	}
	public void specialInspectionPlumbingNew(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectionPlumbingNew");
//			filterJob(user);
			test = rep.startTest("TR1 specialInspectionPlumbingNew");
			test.log(LogStatus.INFO, " specialInspectionPlumbingNew");
			clickAndWait(Constants.tr1_technical_report_step, Constants.tr1_are_you_special_inspector);
			if (count(Constants.tr1_are_you_special_inspector) > 0) { // JG 2019-01-04 no more check boxes asking if you're an inspector? Just check them if they're present.
				check(Constants.tr1_are_you_special_inspector);
			}
//			if (count(Constants.edit_icon) > 0) {
				for (int i = 1; i < 5; i++) {
					waitVisible("//span[text()='Requirement']");
//					multiClick("//span[contains(text(),'Special Inspection Categories For New Work')]/following::span[text()='Add']"); 
					multiClick("//span[contains(text(),'Special Inspection Categories')]/following::span[text()='Add']"); // JG 2018-11-28 shorter bc "F" changed to "f"
					click(Constants.tr1_select_requirement_code);
					type(Constants.tr1_select_requirement_code_field, data[4]);
					click(Constants.tr1_select_requirement_code_filter);
					click(Constants.inspection_label);
					email(data[1]);
					select(Constants.tr1_license_type, data[2]);
					type(Constants.tr1_agency_number, data[3]);
					//keyPressTab(Constants.tr1_agency_number);
					wait(2);
					if (count(Constants.green_valid_label) > 0) {
						if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-28
							click(Constants.tr1_save_progress_inspection_button);
							waitInvisible(Constants.tr1_save_progress_inspection_button);
						} else {
							click(Constants.tr1_save_progress_inspection_button_8085);
							waitInvisible(Constants.tr1_save_progress_inspection_button_8085);
						}						
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification,
								TEXT_PROPERTIES.getProperty("inspection_requirements_updated"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
						break;
					} else {
						i--;
						click(Constants.global_cancel_button);
					}
				}
//			}
//				filterJob(user);
		}
	}
	public void specialInspectionPlumbingLegalization(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectionPlumbingLegalization");
//			filterJob(user);
			test = rep.startTest("TR1 specialInspectionPlumbingLegalization");
			test.log(LogStatus.INFO, " specialInspectionPlumbingLegalization");
			clickAndWait(Constants.tr1_technical_report_step, Constants.tr1_are_you_special_inspector);
			if (count(Constants.tr1_are_you_special_inspector) > 0) {
				check(Constants.tr1_are_you_special_inspector);
			}
//			if (count(Constants.edit_icon) > 0) {
				for (int i = 1; i < 5; i++) {
					waitVisible("//span[text()='Requirement']");
					multiClick("//span[contains(text(),'Special Inspection Categories For Legalization')]/following::span[text()='Add']");
					click(Constants.tr1_select_requirement_code);
					type(Constants.tr1_select_requirement_code_field, data[4]);
					click(Constants.tr1_select_requirement_code_filter);
					click(Constants.inspection_label);
					email(data[1]);
					select(Constants.tr1_license_type, data[2]);
					type(Constants.tr1_agency_number, data[3]);
					//keyPressTab(Constants.tr1_agency_number);
					wait(2);
					if (count(Constants.green_valid_label) > 0) {
						click(Constants.tr1_save_progress_inspection_button);
						waitInvisible(Constants.tr1_save_progress_inspection_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification,
								TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
						break;
					} else {
						i--;
						click(Constants.global_cancel_button);
					}
				}
//			}
//				filterJob(user);
		}
	}
	public void specialInspectionPlumbing(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectionPlumbing");
//			filterJob(user);
			test = rep.startTest("TR1 Inspection");
			test.log(LogStatus.INFO, " specialInspectionPlumbing");
			wait(2);
			clickAndWait(Constants.tr1_technical_report_step, Constants.tr1_are_you_special_inspector);
			if (count(Constants.tr1_are_you_special_inspector) > 0) {
				check(Constants.tr1_are_you_special_inspector);
			}
			if (count(Constants.edit_icon) > 0) {
				// wait(22);
				for (int i = 1; i <= count(Constants.edit_icon); i++) {
					test.log(LogStatus.INFO, " specialInspectionPlumbing");
					if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-12-03
						i = count(Constants.edit_icon);
					}
					click("(//i[@class='fa fa-edit'])[" + i + "]");
					click(Constants.inspection_label);
					email(data[1]);
					select(Constants.tr1_license_type, data[2]);
					type(Constants.tr1_agency_number, data[3]);
					//keyPressTab(Constants.tr1_agency_number);
					wait(2);
					if (count(Constants.green_valid_label) > 0) {
						if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-12-03
							click(Constants.tr1_save_progress_inspection_button_8085);
							waitInvisible(Constants.tr1_save_progress_inspection_button_8085);
							waitUntilISpinnersInvisible();
							waitVisible(Constants.ok_button);
							verifyNotification(Constants.notification,
								TEXT_PROPERTIES.getProperty("tr_saved_success"));
						} else {
							click(Constants.tr1_save_progress_inspection_button);
							waitInvisible(Constants.tr1_save_progress_inspection_button);
							waitUntilISpinnersInvisible();
							waitVisible(Constants.ok_button);
							verifyNotification(Constants.notification,
								TEXT_PROPERTIES.getProperty("inspection_requirements_updated"));
						}
						clickButton("OK");
						waitInvisible(Constants.ok_button);
					} else {
						i--;
						click(Constants.global_cancel_button);
					}
				}
			} else {
				if (count("//span[contains(text(),'Legalization')]") > 0)
					add_button = "(//*[text()='Add'])[last()]";
				if (count("//span[contains(text(),'New Work')]") > 0)
					add_button = "//*[text()='Add']";
				for (int i = 1; i < 5; i++) {
					waitVisible("//span[text()='Requirement']");
					multiClick(add_button);
					click(Constants.tr1_select_requirement_code);
					type(Constants.tr1_select_requirement_code_field, data[4]);
					click(Constants.tr1_select_requirement_code_filter);
					click(Constants.inspection_label);
					email(data[1]);
					select(Constants.tr1_license_type, data[2]);
					type(Constants.tr1_agency_number, data[3]);
					//keyPressTab(Constants.tr1_agency_number);
					wait(2);
					if (count(Constants.green_valid_label) > 0) {
						click(Constants.tr1_save_progress_inspection_button);
						waitInvisible(Constants.tr1_save_progress_inspection_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification,
								TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
						break;
					} else {
						i--;
						click(Constants.global_cancel_button);
					}
				}
				if (Integer.valueOf(data[0]) > 1) {
					for (int a = 1; a < 5; a++) {
						add_button = "(//*[text()='Add'])[2]";
						waitVisible("//span[text()='Requirement']");
						multiClick(add_button);
						click(Constants.tr1_select_requirement_code);
						send(Constants.tr1_select_requirement_code_field, data[4]);
						click(Constants.tr1_select_requirement_code_filter);
						click(Constants.inspection_label);
						email(data[1]);
						select(Constants.tr1_license_type, data[2]);
						type(Constants.tr1_agency_number, data[3]);
						//keyPressTab(Constants.tr1_agency_number);
						wait(2);
						if (count(Constants.green_valid_label) > 0) {
							click(Constants.tr1_save_progress_inspection_button);
							waitInvisible(Constants.tr1_save_progress_inspection_button);
							waitUntilISpinnersInvisible();
							waitVisible(Constants.ok_button);
							verifyNotification(Constants.notification,
									TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
							clickButton("OK");
							waitInvisible(Constants.ok_button);
							break;
						} else {
							a--;
							click(Constants.global_cancel_button);
						}
					}

				}
			}
//			filterJob(user);
			reportPass("Success");
		}
	}

	public void progressInspecSign(String tr1) {
		if (!tr1.equals("")) {
			
			System.out.println(convertedTimestamp() + " **************** TR1 progressInspecSign");
			for (int i = 1; i < 100; i++) {
				String[] data = tr1.split(" :: ");
				filterJob(data[1]);
				test = rep.startTest("TR1 progressInspecSign");
				click(Constants.tr1_technical_report_step);
//				check(Constants.tr1_are_you_special_inspector);
				check(Constants.tr1_are_you_progress_inspector);
				for (int a = 1; a <= 5; a++) {
					wait(2);					
					if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-13: new PW1 UI
						click("(//i[@class='fa fa-edit'])[last()]");
					} else {
						scrollTo("(//i[@class='fa fa-edit'])[last()]"); // JG 2018-11-14 scroll to edit button.
						click("(//i[@class='fa fa-edit'])[last()]"); 
					}
					waitVisible("//h4[text()='Progress Inspection Category']");
					email(data[1]);
					select(Constants.tr1_license_type, data[2]);
					check(Constants.tr1_i_take_responcibility);
					check(Constants.tr1_i_understand_my_failure_to_file);
					check(Constants.tr1_i_understand_and_agree);
					if (getElement(Constants.tr1_i_take_responcibility).isSelected()) {
						if (getElement(Constants.tr1_i_understand_my_failure_to_file).isSelected()) {
							if (getElement(Constants.tr1_i_understand_and_agree).isSelected()) {
								break;
							}
						}
					} else
						click(Constants.global_cancel_button);
				}
				if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-14: new PW1 UI
					click(Constants.global_save_form_button);
					waitInvisible(Constants.global_save_form_button);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_updated"));
				} else {
					click(Constants.tr1_save_progress_inspection_button_8085);
					waitInvisible(Constants.tr1_save_progress_inspection_button_8085);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_saved_success"));
				}
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				if (count(Constants.identified_yes_label) > 1)
					break;
			}
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-14: new PW1 UI
				if(count(Constants.upload_document_icon) > 0) {
					click(Constants.upload_document_icon);
					send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
					click(Constants.tr1_upload_button);
					waitInvisible(Constants.tr1_please_wait_message);
					waitVisible(Constants.tr1_upload_succesfull_message);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}
			} else {
				click(Constants.tr8_technical_report_step); // JG 2018-11-14 click TR8 then TR1 tab to refresh the grid because grid is empty after save.
				waitInvisible(Constants.tr1_please_wait_message);
				click(Constants.tr1_technical_report_step);
				waitInvisible(Constants.tr1_please_wait_message);
				if(count(Constants.upload_document_icon_8085) > 0) {
					click(Constants.upload_document_icon_8085);
					send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
					click(Constants.tr1_upload_button);
					waitInvisible(Constants.tr1_please_wait_message);
					waitVisible(Constants.tr1_upload_succesfull_message);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}
			}

			filterJob(user);
			reportPass("Success");
		}
	}

			
			
	public void progressInspection(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 progressInspection");
			filterJob(user);
			test = rep.startTest("TR1 progressInspection");
			click(Constants.tr1_technical_report_step);
/*			check(Constants.tr1_are_you_special_inspector);
			check(Constants.tr1_are_you_progress_inspector);*/
//			for (int i = 1; i < 5; i++) {
				click("(//*[text()='Add'])[last()]");
				click(Constants.select_dropdown);
				type(Constants.tr1_select_requirement_code_field, data[0]);
				click(Constants.tr1_select_requirement_code_filter);
				click(Constants.inspection_label);
//				multiClick("//input[@id='txtInspecterEmail']");
				waitClickableOr("//input[@id='txtInspecterEmail']", "(//input[@id='txtInspecterEmail'])[last()]");
				try {
					driver.findElement(By.xpath("//input[@id='txtInspecterEmail']")).sendKeys(data[1]);
					wait(2);
					if (count("//strong[text()='" + data[1] + "']") > 0)
						doubleclick("//strong[text()='" + data[1] + "']");
				} catch (Exception e) {
					driver.findElement(By.xpath("(//input[@id='txtInspecterEmail'])[last()]")).sendKeys(data[1]);
					wait(2);
					if (count("//strong[text()='" + data[1] + "']") > 0)
						doubleclick("//strong[text()='" + data[1] + "']");
				}
/*				wait(2);
//				System.out.println(text("(//input[@id='txtInspecterEmail'])[last()]"));
				System.out.println(text("//input[@id='txtInspecterEmail']"));
				if (text("//input[@id='txtInspecterEmail']").contains(user))
					break;
				else
					click(Constants.global_cancel_button);*/
//			}
			click(Constants.tr1_save_progress_inspection_button);
			waitInvisible(Constants.tr1_save_progress_inspection_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("inspection_requirements_added"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			check(Constants.tr1_are_you_progress_inspector);
			for (int a = 1; a <= 5; a++) {
				click("(//i[@class='fa fa-edit'])[last()]");
				waitVisible("//h4[text()='Progress Inspection Category']");
				email(tr1_user);
				select(Constants.tr1_license_type, tr1_lic);
				check(Constants.tr1_i_take_responcibility);
				check(Constants.tr1_i_understand_my_failure_to_file);
				check(Constants.tr1_i_understand_and_agree);
				if (getElement(Constants.tr1_i_take_responcibility).isSelected()) {
					if (getElement(Constants.tr1_i_understand_my_failure_to_file).isSelected()) {
						if (getElement(Constants.tr1_i_understand_and_agree).isSelected()) {
							break;
						}
					}
				} else
					click(Constants.global_cancel_button);
			}
			
			reportPass("Success");
		}
	}	
	
	public void progressInspectionSign(String progress_inspector_sign_upload) {
		if (!progress_inspector_sign_upload.equals("")) {
			System.out.println(convertedTimestamp() + " **************** TR1 progressInspectionSign");
			for (int i = 1; i < 100; i++) {
				filterJob(tr1_user);
				test = rep.startTest("TR1 progressInspectionSign");
				click(Constants.tr1_technical_report_step);
				if (count(Constants.tr1_are_you_special_inspector) > 0) {
					check(Constants.tr1_are_you_special_inspector);
				}
				check(Constants.tr1_are_you_progress_inspector);
				for (int a = 1; a <= 5; a++) {
					click("(//i[@class='fa fa-edit'])[last()]");
					waitVisible("//h4[text()='Progress Inspection Category']");
					email(OR_PROPERTIES.getProperty("progress_inspector_email"));
					select(Constants.tr1_license_type, OR_PROPERTIES.getProperty("progress_inspector_lisence"));
					check(Constants.tr1_i_take_responcibility);
					check(Constants.tr1_i_understand_my_failure_to_file);
					check(Constants.tr1_i_understand_and_agree);
					if (getElement(Constants.tr1_i_take_responcibility).isSelected()) {
						if (getElement(Constants.tr1_i_understand_my_failure_to_file).isSelected()) {
							if (getElement(Constants.tr1_i_understand_and_agree).isSelected()) {
								break;
							}
						}
					} else
						click(Constants.global_cancel_button);
				}
				click(Constants.global_save_form_button);
				waitInvisible(Constants.global_save_form_button);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_updated"));
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				if (count(Constants.identified_yes_label) > 1)
					break;
			}
			click(Constants.upload_document_icon);
			send(Constants.tr1_browse_button, Constants.uploadFolder + progress_inspector_sign_upload);
			click(Constants.tr1_upload_button);
			waitInvisible(Constants.tr1_please_wait_message);
			waitVisible(Constants.tr1_upload_succesfull_message);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			clickButton("OK");
			waitInvisible(Constants.ok_button);

		}
		filterJob(user);
		reportPass("Success");
	}
	
	public void specialInspectorSignaturePlumbing(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectorSignaturePlumbing");
			if (!data[1].equals("AJOETEST@GMAIL.COM")) { // ajoetest is used for speeding up job creation
				filterJob(data[1]);
			}	
			test = rep.startTest("TR1 specialInspectorSignaturePlumbing");
			click(Constants.tr1_technical_report_step);
			if (count(Constants.tr1_are_you_special_inspector) > 0) {
				check(Constants.tr1_are_you_special_inspector);
			}
			if (count(Constants.tr1_are_you_progress_inspector) > 0) {
				check(Constants.tr1_are_you_progress_inspector);
			}
			wait(3);
			int number_of_boxes = count(Constants.edit_icon);
			for (int i = 1; i <= number_of_boxes; i++) {
				test.log(LogStatus.INFO, " specialInspectorSignaturePlumbing");
				if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-28
					click("(//i[@class='fa fa-edit'])[" + i + "]");
					wait(2);
					waitVisible(Constants.tr1_valid_label);
					check(Constants.tr1_i_take_responcibility);
					check(Constants.tr1_i_understand_my_failure_to_file);
					check(Constants.tr1_i_understand_and_agree);
					click(Constants.tr1_save_progress_inspection_button);
					waitInvisible(Constants.tr1_save_progress_inspection_button);
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_updated"));
				} else {
					click("(//i[@class='fa fa-edit'])[last()]");
					wait(2);
					waitVisible(Constants.tr1_valid_label);
					scrollAllWayUp();
					check(Constants.tr1_i_take_responcibility);
					check(Constants.tr1_i_understand_my_failure_to_file);
					check(Constants.tr1_i_understand_and_agree);
					click(Constants.tr1_save_progress_inspection_button_8085);
					waitInvisible(Constants.tr1_save_progress_inspection_button_8085);
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_saved_success"));
				}
				wait(1);
				clickButton("OK");
				waitInvisible(Constants.ok_button);
				wait(2);
				if (count(Constants.identified_yes_label) == number_of_boxes)//Integer.valueOf(data[0]))
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
		reportPass("specialInspectorSignaturePlumbing");
	}

	public void specialInspectorSignatureStructural(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectorSignatureStructural");
			if (!data[1].equals("AJOETEST@GMAIL.COM")) { // ajoetest is used for speeding up job creation
				filterJob(data[1]);
			}
			test = rep.startTest("TR1 specialInspectorSignatureStructural");
			click(Constants.tr1_technical_report_step);
			if (count(Constants.tr1_are_you_special_inspector) > 0) {
				check(Constants.tr1_are_you_special_inspector);
			}
			if (count(Constants.tr1_are_you_progress_inspector) > 0) {
				check(Constants.tr1_are_you_progress_inspector);
			}
			wait(3);
			test.log(LogStatus.INFO, " specialInspectorSignatureStructural");
			
			// JG 2018-12-05 Edit the 'Special Inspection...' record.
			click("(//i[@class='fa fa-edit'])[last()-1]");
			wait(2);
			select(Constants.tr1_license_type, data[2]);
			type(Constants.tr1_agency_number, data[3]);
			wait(2);
			waitVisible(Constants.tr1_valid_label);
			check(Constants.tr1_i_take_responcibility);
			check(Constants.tr1_i_understand_my_failure_to_file);
			check(Constants.tr1_i_understand_and_agree);
			click(Constants.tr1_save_progress_inspection_button_8085);
			waitInvisible(Constants.tr1_save_progress_inspection_button_8085);					
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_saved_success"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			wait(1);
			click("(//span[text()='Required'])[1]");
			waitVisible(Constants.tr1_browse_button);
			send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
			click(Constants.tr1_upload_button);
			waitInvisible(Constants.tr1_please_wait_message);
			waitVisible(Constants.tr1_upload_succesfull_message);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			
			// JG 2018-12-05 Edit the 'Progress Inspection...' record.
			scrollAllWayDown();
			click("(//i[@class='fa fa-edit'])[last()]");
			wait(2);
			email(data[1]);
			select(Constants.tr1_license_type, data[2]);
			wait(1);
			check(Constants.tr1_i_take_responcibility);
			check(Constants.tr1_i_understand_my_failure_to_file);
			check(Constants.tr1_i_understand_and_agree);
			click(Constants.tr1_save_progress_inspection_button_8085);
			waitInvisible(Constants.tr1_save_progress_inspection_button_8085);					
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_saved_success"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			wait(1);
			click("(//span[text()='Required'])[1]");
			waitVisible(Constants.tr1_browse_button);
			send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
			click(Constants.tr1_upload_button);
			waitInvisible(Constants.tr1_please_wait_message);
			waitVisible(Constants.tr1_upload_succesfull_message);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
		reportPass("specialInspectorSignatureStructural");
	}

	public void specialInspectorSignatureMechanicalSystems(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectorSignatureMechanicalSystems");
			if (!data[1].equals("AJOETEST@GMAIL.COM")) { // ajoetest is used for speeding up job creation
				filterJob(data[1]);
			}
			test = rep.startTest("TR1 specialInspectorSignatureMechanicalSystems");
			click(Constants.tr1_technical_report_step);
			if (count(Constants.tr1_are_you_special_inspector) > 0) {
				check(Constants.tr1_are_you_special_inspector);
			}
			if (count(Constants.tr1_are_you_progress_inspector) > 0) {
				check(Constants.tr1_are_you_progress_inspector);
			}
			wait(3);
			test.log(LogStatus.INFO, " specialInspectorSignatureMechanicalSystems");
			
			// JG 2018-12-05 Edit the 'Special Inspection...' record.
			click("(//i[@class='fa fa-edit'])[last()-1]");
			wait(2);
			check(Constants.tr1_i_take_responcibility);
			check(Constants.tr1_i_understand_my_failure_to_file);
			check(Constants.tr1_i_understand_and_agree);
			click(Constants.tr1_save_progress_inspection_button_8085);
			waitInvisible(Constants.tr1_save_progress_inspection_button_8085);					
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_saved_success"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			wait(1);
			click("(//span[text()='Required'])[1]");
			waitVisible(Constants.tr1_browse_button);
			send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
			click(Constants.tr1_upload_button);
			waitInvisible(Constants.tr1_please_wait_message);
			waitVisible(Constants.tr1_upload_succesfull_message);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			
			// JG 2018-12-05 Edit the 'Progress Inspection...' record.
			scrollAllWayDown();
			click("(//i[@class='fa fa-edit'])[last()]");
			wait(2);
			email(data[1]);
			wait(1);
			select(Constants.tr1_license_type, data[2]);
			wait(1);
			check(Constants.tr1_i_take_responcibility);
			check(Constants.tr1_i_understand_my_failure_to_file);
			check(Constants.tr1_i_understand_and_agree);
			click(Constants.tr1_save_progress_inspection_button_8085);
			waitInvisible(Constants.tr1_save_progress_inspection_button_8085);					
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_saved_success"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			wait(1);
			click("(//span[text()='Required'])[1]");
			waitVisible(Constants.tr1_browse_button);
			send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
			click(Constants.tr1_upload_button);
			waitInvisible(Constants.tr1_please_wait_message);
			waitVisible(Constants.tr1_upload_succesfull_message);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
		reportPass("specialInspectorSignatureMechanicalSystems");
	}

	public void specialInspectorSignatureBoilerEquipment(String tr1) {
		if (!tr1.equals("")) {
			String[] data = tr1.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** TR1 specialInspectorSignatureBoilerEquipment");
			if (!data[1].equals("AJOETEST@GMAIL.COM")) { // ajoetest is used for speeding up job creation
				filterJob(data[1]); // stay logged in to speed up data entry
			}
			test = rep.startTest("TR1 specialInspectorSignatureBoilerEquipment");
			click(Constants.tr1_technical_report_step);
//			waitVisible(Constants.tr1_are_you_special_inspector);
//			waitVisible(Constants.tr1_are_you_progress_inspector);
			waitUntilISpinnersInvisible();
			scrollAllWayUp();
			if (count(Constants.tr1_are_you_special_inspector) > 0) {
				check(Constants.tr1_are_you_special_inspector);
			}
//			check(Constants.tr1_are_you_progress_inspector);
			wait(3);
			test.log(LogStatus.INFO, " specialInspectorSignatureBoilerEquipment");		
			// JG 2018-12-10 Edit the 'Special Inspection...' record.
			click("(//i[@class='fa fa-edit'])[last()]");
			waitUntilISpinnersInvisible();
			wait(2);
			check(Constants.tr1_i_take_responcibility);
			check(Constants.tr1_i_understand_my_failure_to_file);
			check(Constants.tr1_i_understand_and_agree);
			click(Constants.tr1_save_progress_inspection_button_8085);
			waitInvisible(Constants.tr1_save_progress_inspection_button_8085);					
			waitVisible(Constants.ok_button);
			wait(1);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("tr_saved_success"));
			wait(1);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			wait(1);
			click("(//span[text()='Required'])[1]");
			waitVisible(Constants.tr1_browse_button);
			send(Constants.tr1_browse_button, Constants.uploadFolder + "upload.png");
			click(Constants.tr1_upload_button);
			waitInvisible(Constants.tr1_please_wait_message);
			waitVisible(Constants.tr1_upload_succesfull_message);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
		reportPass("specialInspectorSignatureBoilerEquipment");
	}
	
}
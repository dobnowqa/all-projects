package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.base.TestBase;
import com.util.Constants;
//import com.util.Hour;

public class DobPW1Page extends TestBase {
/*	WebDriver driver;
	public DobPW1Page(WebDriver dr) {
		driver = dr;
	}*/

	@FindBy(xpath=Constants.pw1_16_size_of_cutout)
	public WebElement pw1_16_size_of_cutout;	
	@FindBy(xpath=Constants.pw1_16_distance_to_nearest_corner)
	public WebElement pw1_16_distance_to_nearest_corner;
	@FindBy(xpath=Constants.pw1_16_distance_from_nearest_property)
	public WebElement pw1_16_distance_from_nearest_property;	
	@FindBy(xpath=Constants.pw1_16_which_side_nearest_to_property)
	public WebElement pw1_16_which_side_nearest_to_property;
	@FindBy(xpath=Constants.pw1_16_to_streat)
	public WebElement pw1_16_to_streat;	
	@FindBy(xpath=Constants.pw1_16_this_curb_will_provide_access_to)
	public WebElement pw1_16_this_curb_will_provide_access_to;
	@FindBy(xpath=Constants.pw1_16_which_side_of_street_curb_on)
	public WebElement pw1_16_which_side_of_street_curb_on;	
	@FindBy(xpath=Constants.pw1_16_on_grade_yes)
	public WebElement pw1_16_on_grade_yes;
	@FindBy(xpath=Constants.pw1_16_on_grade_no)
	public WebElement pw1_16_on_grade_no;	
	@FindBy(xpath=Constants.pw1_16_over_vault_yes)
	public WebElement pw1_16_over_vault_yes;
	@FindBy(xpath=Constants.pw1_16_over_vault_no)
	public WebElement pw1_16_over_vault_no;
	@FindBy(xpath=Constants.pw1_16_other_structure_yes)
	public WebElement pw1_16_other_structure_yes;
	@FindBy(xpath=Constants.pw1_16_other_structure_no)
	public WebElement pw1_16_other_structure_no;
	@FindBy(xpath=Constants.pw1_16_sidewalk_within_8ft_yes)
	public WebElement pw1_16_sidewalk_within_8ft_yes;
	@FindBy(xpath=Constants.pw1_16_sidewalk_within_8ft_no)
	public WebElement pw1_16_sidewalk_within_8ft_no;
	@FindBy(xpath=Constants.pw1_16_sidewalk_to_destroy_yes)
	public WebElement pw1_16_sidewalk_to_destroy_yes;
	@FindBy(xpath=Constants.pw1_16_sidewalk_to_destroy_no)
	public WebElement pw1_16_sidewalk_to_destroy_no;
	@FindBy(xpath=Constants.pw1_16_infront_of_ajoining_yes)
	public WebElement pw1_16_infront_of_ajoining_yes;
	@FindBy(xpath=Constants.pw1_16_infront_of_ajoining_no)
	public WebElement pw1_16_infront_of_ajoining_no;
	@FindBy(xpath=Constants.pw1_16_agencies_required_documents)
	public WebElement pw1_16_agencies_required_documents;

	// 0. Enter Filing Information	
	public void enterFilingInformation(String description) {	
		if (description.contains("Boiler")) {
			System.out.println(convertedTimestamp() + " **************** PW1 enterFilingInformation");
			test = rep.startTest("enterFilingInformation");
			select(Constants.pw1_filing_info_select_scope_includes, "Boiler");
			select(Constants.pw1_filing_info_select_boiler_energy_source, "Oil & Gas(Dual)");
			if (count(Constants.pw1_filing_info_associated_job_number) > 0) {
			 	type(Constants.pw1_filing_info_associated_job_number,"M00029074");
			}
			click(Constants.pw1_filing_info_accordion); // close
		} else {
			System.out.println(convertedTimestamp() + " **************** PW1 no enterFilingInformation");
		}
	}

	// Select Device	
	public void selectDevice(String device) {
		if (!device.equals("")) {
			System.out.println(convertedTimestamp() + " **************** PW1 enterDevice");
			test = rep.startTest("enterDevice");
			String[] data = device.split(" :: ");
			click(Constants.pw1_list_boiler_equipment_accordion); // open List of Devices
			if (data[0].equals("1")) {
				radio(Constants.pw1_list_boiler_search_by_bin);
				type(Constants.pw1_list_boiler_search_bin, data[1]);
			}
			if (data[0].equals("2")) {
				radio(Constants.pw1_list_boiler_search_by_address);
			}
			if (data[0].equals("3")) {
				radio(Constants.pw1_list_boiler_search_by_id);
				type(Constants.pw1_list_boiler_search_id, data[1]);
			}
			click(Constants.pw1_list_boiler_search_and_add_button);
			check(Constants.pw1_list_boiler_device_list_checkbox);
			click(Constants.pw1_list_boiler_device_list_add_button);
			click(Constants.pw1_list_boiler_equipment_accordion); // close List of Devices
		} else {
			System.out.println(convertedTimestamp() + " **************** PW1 no enterDevice");
		}
	}
			
	// 1. Location Imfo	
	public void locationImfo(String address) {	
		if(!address.equals("")){
			System.out.println(convertedTimestamp() + " **************** " + "PW1");
			test = rep.startTest("PW1");
			String[] data = address.split(" :: ");
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-29
				click(Constants.pw1_1_location_information_accordion);
			}
			type(Constants.pw1_1_house_number, data[0]);
			type(Constants.pw1_1_street_name,data[1]);
			select(Constants.pw1_1_borough, data[2]);
			type(Constants.pw1_1_block, data[3]);
			type(Constants.pw1_1_lot, data[4]);
		}
	}
	// 1. Enter Location Information	
	public void enterLocationInformation(String address) {	
		if(!address.equals("")){
			System.out.println(convertedTimestamp() + " **************** PW1 enterLocationInformation");
			test = rep.startTest("Location Information");
			String[] data = address.split(" :: ");
			click(Constants.pw1_1_location_information_accordion); // TODO: routine to open accordion
			type(Constants.pw1_1_house_number, data[0]);
			type(Constants.pw1_1_street_name,data[1]);
			select(Constants.pw1_1_borough, data[2]);
			type(Constants.pw1_1_block, data[3]);
			type(Constants.pw1_1_lot, data[4]);
			type(Constants.pw1_1_apt_suite_number, data[5]);
			click(Constants.pw1_1_location_information_accordion); // TODO: routine to close accordion
		} else {
			System.out.println(convertedTimestamp() + " **************** PW1 no enterLocationInformation");
		}
	}

	// Work on Floors
	public void workOnFloors(String work_on_floors) {	
		if(!work_on_floors.equals("")){
			test = rep.startTest("Work On Floors");
			if(work_on_floors.contains(" :: ") && count("//input[@id='txtPWLocWorkFloor']") == 0) { // JG  2018-11-27 work_on_floors changed to use ::
				String[] data = work_on_floors.split(" :: ");
				click(Constants.pw1_1_add_work_floors_button);
				if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-10-30 TEST-ENV elements changed
					select(Constants.pw1_1_work_on_floors_select_code_and_description_8085, data[0]);
					type(Constants.pw1_1_work_on_floors_floor_number_from, data[1]);
					type(Constants.pw1_1_work_on_floors_floor_number_to, data[2]);
					type(Constants.pw1_1_work_on_floors_description_of_work, convertedTimestamp());
					click(Constants.pw1_1_work_on_floors_add_button_8085);
					// JG 2018-10-30 TODO: the following 3 values are now entered in a different tab:
//						type(Constants.pw1_13_building_height_proposed, "111");
//						type(Constants.pw1_13_building_stories_proposed, "2");
//						type(Constants.pw1_13_building_dwelling_units_proposed, "51");
				} else {
					select(Constants.pw1_1_work_on_floors_select_code_and_description, data[0]);
					type(Constants.pw1_1_work_on_floors_floor_number_from, data[1]);
					type(Constants.pw1_1_work_on_floors_floor_number_to, data[2]);
					type(Constants.pw1_1_work_on_floors_description_of_work, convertedTimestamp());
					click(Constants.pw1_1_work_on_floors_add_button);
					type(Constants.pw1_13_building_height_proposed, "111");
					type(Constants.pw1_13_building_stories_proposed, "2");
					type(Constants.pw1_13_building_dwelling_units_proposed, "51");
				}					
			} else
//					type("//input[@id='txtPWLocWorkFloor']", work_on_floors); // JG  2018-11-27 work_on_floors changed to use ::
				type("//input[@id='txtPWLocWorkFloor']", "1");
		}
	}

	// Add Work on Floors (within Location Information)
	public void addWorkOnFloors(String work_on_floors) {	
		if(!work_on_floors.equals("")){
			System.out.println(convertedTimestamp() + " **************** PW1 addWorkOnFloors");
			test = rep.startTest("Work On Floors");
			String[] data = work_on_floors.split(" :: ");
			click(Constants.pw1_1_location_information_accordion); // open
			click(Constants.pw1_1_add_work_on_floors_button);
			select(Constants.pw1_1_work_on_floors_select_code_and_description_8085, data[0]);
			type(Constants.pw1_1_work_on_floors_floor_number_from, data[1]);
			type(Constants.pw1_1_work_on_floors_floor_number_to, data[2]);
			type(Constants.pw1_1_work_on_floors_description_of_work, convertedTimestamp());
			click(Constants.pw1_1_work_on_floors_add_button_8085);
			wait(1);
			click(Constants.pw1_1_location_information_accordion); // close
		}
	}

	// Work on Floors Subsequent
	public void workOnFloorsSubs(String work_type) {
		String[] data = work_type.split(" :: ");
		test = rep.startTest("Work On Floors Subs");
		if(work_type.contains("Plumbing")||work_type.contains("Sprinklers")||work_type.contains("StandPipe")) {
			waitUntilElementVisible(Constants.plumbing_work_on_floors, 30);
			type(Constants.plumbing_work_on_floors, "1");
		}
		if(work_type.contains("Antenna")||work_type.contains("SidewalkShed")||work_type.contains("SupportedScaffold")||work_type.contains("Sign")||work_type.contains("ConstructionFence")) {
			click(Constants.pw1_1_add_work_floors_button);
			select(Constants.pw1_1_work_on_floors_select_code_and_description, "Attic");
	 		type(Constants.pw1_1_work_on_floors_floor_number_from, "1");
	 		type(Constants.pw1_1_work_on_floors_floor_number_to, "1");
	 		type(Constants.pw1_1_work_on_floors_description_of_work, convertedTimestamp());
	 		click(Constants.pw1_1_work_on_floors_add_button);
		}
		if(work_type.contains("Electrical")) {
			type(Constants.el_ge1_job_description, convertedTimestamp());
			select(Constants.el_gi_building_use_type, "A One Family");
		}
	}

	// 2. Applicant Info
	public void applicantInfo(String user_info) {	
		if (!user_info.equals("")) {
			String[] data = user_info.split(" :: ");
			test = rep.startTest("Applicant Info");
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-29
				scrollTo(Constants.pw1_2_stakeholders_accordion);
				click(Constants.pw1_2_stakeholders_accordion);
				email(data[0]);
				select(Constants.license_type_list, data[1]);
				wait(1);
				if (count(Constants.business_name_list) > 0) {
					select(Constants.business_name_list, data[2]);
				}
				click(Constants.pw1_11_job_description_accordion);
				type(Constants.job_description_for_new_work, user_info);
				click(Constants.global_save_step_button);
				click(Constants.pw1_confirm_save_button_8085);
				waitInvisible(Constants.global_loading_spinner);
				waitUntilElementVisible(Constants.ok_button, 30);
				wait(1);
				assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "pw1 saved");
				wait(1);
				click(Constants.ok_button);
				waitInvisible(Constants.ok_button);
			} else {
				email(data[0]);
				select(Constants.license_type_list, data[1]);
				wait(1);
				if (count(Constants.business_name_list) > 0) {
					select(Constants.business_name_list, data[2]);
				}
				type(Constants.job_description_for_new_work, user_info);
				scrollToElement(Constants.global_save_step_button);
				click(Constants.global_save_step_button);
				click(Constants.pw1_confirm_save_button);					
				waitInvisible(Constants.global_loading_spinner);
				waitUntilElementVisible(Constants.ok_button, 30);
				assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "pw1 saved");
				clickButton("OK");
				waitInvisible(Constants.ok_button);
			}
	 	}
	}

	// 2. Enter Applicant Information (within Stakeholders accordion)
	public void enterApplicantInformation(String user_info) {
		if (!user_info.equals("")) {
			System.out.println(convertedTimestamp() + " **************** PW1 enterApplicantInformation");
			String[] data = user_info.split(" :: ");
			test = rep.startTest("Applicant Info");
			click(Constants.pw1_2_stakeholders_accordion); // open
			email(data[0]);
			select(Constants.license_type_list, data[1]);
			wait(1);
			if (count(Constants.business_name_list) > 0) {
				select(Constants.business_name_list, data[2]);
			}
			// 3. Enter Filing Representative Class I / Preparer (within Stakeholders accordion)
			email3(data[3]);
			wait(1);
			scrollAllWayUp();
			click(Constants.pw1_2_stakeholders_accordion); // close
	 	} else {
	 		System.out.println(convertedTimestamp() + " **************** PW1 no enterApplicantInformation");
	 	}
	}
	
	// 3A. Add Delegated Associate (within Stakeholders accordion)
	public void addDelegatedAssociate(String user_info) {
		if (!user_info.equals("")) {
			System.out.println(convertedTimestamp() + " **************** PW1 addDelegatedAssociate");
			String[] data = user_info.split(" :: ");
			test = rep.startTest("Applicant Info");
			scrollAllWayUp();
			click(Constants.pw1_2_stakeholders_accordion); // open
			scrollDown();
			click(Constants.pw1_3a_add_button);
			email(data[4]);
			wait(1);
			select(Constants.pw1_3a_select_license_type, data[5]);
			wait(1);
			select(Constants.pw1_3a_select_business_name, data[6]);
			click(Constants.pw1_3a_save_button);
			waitUntilElementVisible(Constants.ok_button, 30);
			wait(1);
//			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "pw1 saved");
			wait(1);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			scrollAllWayUp();
			click(Constants.pw1_2_stakeholders_accordion); // close
	 	} else {
	 		System.out.println(convertedTimestamp() + " **************** PW1 no addDelegatedAssociate");
	 	}
	}
	
	// 2. Applicant Info PL/SP/SD
	public void applicantInfoPlumbing(String user_info) {	
		if (!user_info.equals("")){
			String[] data = user_info.split(" :: ");
			test = rep.startTest("Applicant Info");
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-29
				scrollTo(Constants.pw1_2_stakeholders_accordion); //JG 2018-11-30
				click(Constants.pw1_2_stakeholders_accordion);
			}
			email(data[0]);
			select(Constants.license_type_list, data[1]);
			wait(1);
			if (count(Constants.business_name_list) > 0) {
				select(Constants.business_name_list, data[2]);
			}
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-29
				click(Constants.pw1_11_job_description_accordion);
			}
	 		type(Constants.job_description_for_new_work, user_info);
	 		// JG 2018-11-26 add the following so plumbing applicant info can be run independently, like regular applicant info (and maybe fix the null pointer exception?)  
	 		scrollToElement(Constants.global_save_step_button);
			click(Constants.global_save_step_button);
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-10-30 TEST Filing buttons changed
				click(Constants.pw1_confirm_save_button_8085);
			} else {
				click(Constants.pw1_confirm_save_button);
			}
			waitInvisible(Constants.global_loading_spinner);
			waitUntilElementVisible(Constants.ok_button, 30);
			wait(1);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "pw1 saved");
			wait(1);
//			click(Constants.ok_button);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
	 	}
	} 
		
	public void applicantInfoSubs(String user_info) {	
		if(!user_info.equals("")){
			String[] data = user_info.split(" :: ");
			test = rep.startTest("Applicant Info Subs");
			System.out.println(convertedTimestamp() + " **************** applicantInfoSubs");
			email(data[0]);
			wait(1);
			select(Constants.license_type_list, data[1]);
			wait(1);	
			if(count(Constants.business_name_list) > 0)
				select(Constants.business_name_list, data[2]);
			if(count(Constants.job_description_for_new_work) > 0)
				type(Constants.job_description_for_new_work, user_info);
	 	}
	}

	public void subsequentCurbCut16(String applicant_info) {	
		if(!applicant_info.equals("")){
			System.out.println(convertedTimestamp() + " **************** subsequentCurbCut PW1");
			filterJob(OR_PROPERTIES.getProperty("user_email"),JOB_NUMBER.getProperty("job_number"));
			test = rep.startTest("Applicant Info subseq");
			type(Constants.pw1_16_size_of_cutout, "51");
			type(Constants.pw1_16_distance_to_nearest_corner, "51");
			type(Constants.pw1_16_distance_from_nearest_property, "51");
			type(Constants.pw1_16_which_side_nearest_to_property, "West");
			type(Constants.pw1_16_to_streat, "51");
			click(Constants.pw1_16_this_curb_will_provide_access_to);
			clickElement(Constants.link_xpath_part1 + "Parking Pad" + Constants.link_xpath_part2);
			pw1_16_which_side_of_street_curb_on.sendKeys("East");
			pw1_16_on_grade_no.click();
			pw1_16_over_vault_no.click();
			pw1_16_other_structure_no.click();
			pw1_16_sidewalk_within_8ft_no.click();
			pw1_16_sidewalk_to_destroy_no.click();
			pw1_16_infront_of_ajoining_no.click();
			pw1_16_agencies_required_documents.sendKeys("MTA");
			scrollToElement(Constants.global_save_step_button);
			click(Constants.global_save_step_button);
			waitInvisible(Constants.global_loading_spinner);
			waitUntilElementVisible(Constants.ok_button, 30);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved pw1");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			waitUntilISpinnersInvisible();
	 	}
	}

// 4. Filing review Type
	public void reviewtype(String type) {
		if(!type.equals("")){
			waitInvisible(Constants.dialog_box_overlay);
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-29
				click(Constants.pw1_4_filling_review_type_accordion);
			}
			select(Constants.pw1_4_filling_review_type_list, type);	
	 	}
	}
	
// 5. Job/Project Types
	public void directive14acceptanceRequested(String type) {	
		if(!type.equals("")){
			waitInvisible(Constants.dialog_box_overlay);
			scrollToElement(Constants.pw1_5_acceptance_requested_yes);
			if(type.equals("Yes"))
				radio(Constants.pw1_5_acceptance_requested_yes);
			else
				radio(Constants.pw1_5_acceptance_requested_no);
	 	}
	}
	
	// 6. Work Types
	public void workTypes(String new_existing_both) {
		if (!new_existing_both.equals("")) {
			test = rep.startTest("workTypes");
			String[] data = new_existing_both.split(" :: ");
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-29
				click(Constants.pw1_6_work_types_accordion);
			} else {
				scrollToElement("//span[contains(text(),'Work Types')]");
			}
			wait(1);
			if (!data[0].equals("N"))
				radio("//input[@type='radio'][@name='rdNewApp'][@value='" + data[0] + "']");
			if (!data[1].equals("N"))
				radio("//input[@id='rdstructuralWorkIncluded'][@value='" + data[1] + "']");
			if (!data[2].equals("N"))
				radio("//input[@id='rdZoningExemptionsdiameter'][@value='" + data[2] + "']");
			if (!data[3].equals("N"))
				radio("//input[@id='rdZoningExemptionsSqfeet'][@value='" + data[3] + "']");
			if (!data[4].equals("N"))
				radio("//input[@id='rdZoningExemptionsBulkhead'][@value='" + data[4] + "']");
			if (!data[5].equals("N"))
				check("//input[contains(@id,'chkPWWrkTypeP')]");
			if (!data[6].equals("N"))
				check("//input[contains(@id,'chkPWWrkTypeSp')]");
			if (!data[7].equals("N"))
				check("//input[@id='chkPWWrkTypeSd1']");
			if (!data[8].equals("N"))
				radio("//input[@id='rdSDType'][@value='" + data[8] + "']");
			if (!data[9].equals("N"))
				radio("//input[@id='rdSDClass'][@value='" + data[9] + "']");
		}
	}
	
	// Enter Filing Review Type, Work Type/ Filing Includes (generic)
	public void enterWorkTypes(String new_existing_both) {
		if (!new_existing_both.equals("")) {
			System.out.println(convertedTimestamp() + " **************** PW1 enterWorkTypes");
			test = rep.startTest("enterWorkTypes");
			String[] data = new_existing_both.split(" :: ");
			click(Constants.pw1_6_work_types_accordion); // open
			if (!data[0].equals("N")) {
				radio("//input[@type='radio'][@name='rdNewApp'][@value='" + data[0] + "']"); // 1-New Work or 2-Legalization
				if (count("//input[@type='radio'][@name='radPWDirective14Accept'][@ng-value='false']") > 0) {
					radio("//input[@type='radio'][@name='radPWDirective14Accept'][@ng-value='false']");
				}
			}
			click(Constants.pw1_6_work_types_accordion); // close
		} else {
			System.out.println(convertedTimestamp() + " **************** PW1 no enterWorkTypes");
		}
	}

	// Enter Filing Review Type, Work Type/ Filing Includes (Mechanical Systems)
	public void enterWorkTypesMechanicalSystems(String new_existing_both) {
		if (!new_existing_both.equals("")) {
			System.out.println(convertedTimestamp() + " **************** PW1 enterWorkTypesMechanicalSystems");
			test = rep.startTest("enterWorkTypesMechanicalSystems");
			String[] data = new_existing_both.split(" :: ");
			click(Constants.pw1_6_work_types_accordion); // open
			if (!data[0].equals("N"))
				radio("//input[@type='radio'][@name='rdNewApp'][@value='" + data[0] + "']"); // New Work
			if (!data[1].equals("N"))
				check("//input[@ng-model='FormObj.MSHeatingSystem']"); // Heating System
			if (!data[2].equals("N"))
				check("//input[@ng-model='FormObj.MSVentilationSystem']"); // Ventilation System 
			if (!data[3].equals("N"))
				check("//input[@ng-model='FormObj.MSAirConditioningSystem']"); // Air Conditioning System
			if (!data[4].equals("N"))
				check("//input[@ng-model='FormObj.MSRefrigeration']"); // Refrigeration
			if (!data[5].equals("N"))
				check("//input[@ng-model='FormObj.MSCoolingTowers']"); // Cooling Towers
			if (!data[6].equals("N"))
				check("//input[@ng-model='FormObj.MSAssociatedductSandpiping']"); // Associated Ducts and Piping
			if (!data[7].equals("N"))
				check("//input[@ng-model='FormObj.MSGenerator']"); // Generator
			if (!data[8].equals("N"))
				check("//input[@ng-model='FormObj.MSOther']"); // Other
			click(Constants.pw1_6_work_types_accordion); // close
		}
	}
		
	// Add Boiler Equipment Device
	public void addBoilerEquipmentDevice(String new_existing_both) {
		if (!new_existing_both.equals("")) {
			System.out.println(convertedTimestamp() + " **************** PW1 addBoilerEquipmentDevice");
			test = rep.startTest("addBoilerEquipmentDevice");
			String[] data = new_existing_both.split(" :: ");
//			click(Constants.pw1_tab);
//			wait(1);
			for (int i = 1; i <= Integer.valueOf(data[1]); i++) {
				click(Constants.pw1_tab);
				wait(1);
				scrollAllWayUp();
				click(Constants.pw1_list_boiler_equipment_accordion);
				wait(1);
				click(Constants.pw1_list_boiler_equipment_add);
				wait(1);
				click(Constants.pw1_list_boiler_update_device_details_yes);
				wait(1);
				select(Constants.pw1_list_boiler_equipment_select_occupancy_type, "Commercial");
				type(Constants.pw1_list_boiler_equipment_boiler_manufacturer, "Test Boiler Manufacturer");
				type(Constants.pw1_list_boiler_equipment_boiler_model_number, "Test Boiler Model Number");
				select(Constants.pw1_list_boiler_equipment_select_agency_name, "CSA");
				type(Constants.pw1_list_boiler_equipment_certification_number, "233233");
				String equipmentLocatedIn = "Boiler equipment located in: " + Integer.toString(i);
				type(Constants.pw1_list_boiler_equipment_located_in, equipmentLocatedIn);
				type(Constants.pw1_list_boiler_equipment_efficiency, "28759");
				type(Constants.pw1_list_boiler_equipment_input_capacity, "29959");
				select(Constants.pw1_list_boiler_equipment_select_design, "Fire-tube");
				radio(Constants.pw1_list_boiler_equipment_single_only_no);
				type(Constants.pw1_list_boiler_equipment_pressure_relief, "123456789");
				select(Constants.pw1_list_boiler_equipment_select_internal_access, "Handhole");
				radio(Constants.pw1_list_boiler_equipment_associated_cogen_no);
				select(Constants.pw1_list_boiler_equipment_select_material, "Cast Iron");
				type(Constants.pw1_list_boiler_equipment_servicing_location_address, "123 Main Street");
				type(Constants.pw1_list_boiler_equipment_servicing_location_floor, "Test servicing location floor");
				type(Constants.pw1_list_boiler_equipment_comments, "Test boiler equipment comments");
				radio(Constants.pw1_list_boiler_equipment_same_work_on_fuel_burner_yes);
				radio(Constants.pw1_list_boiler_equipment_same_work_on_fuel_storage_yes);
				
				scrollAllWayUp();
				click(Constants.pw1_list_boiler_equipment_fuel_burner_details_tab);
				select(Constants.pw1_list_boiler_equipment_select_fuel_burner_type, "External");
				type(Constants.pw1_list_boiler_equipment_burner_manufacturer, "Test Burner Manufacturer");
				select(Constants.pw1_list_boiler_equipment_select_burner_agency_name, "CSA");
				type(Constants.pw1_list_boiler_equipment_burner_certification_number, "123456");
				type(Constants.pw1_list_boiler_equipment_burner_model_number, "FuelBurnerModel 123456");
				radio(Constants.pw1_list_boiler_equipment_burner_dual_burning_no);
				type(Constants.pw1_list_boiler_equipment_burner_input_capacity, "55000");
				type(Constants.pw1_list_boiler_equipment_fuel_burner_comments, "Fuel Burner comments");
				
				scrollAllWayUp();
				click(Constants.pw1_list_boiler_equipment_fuel_storage_details_tab);
				select(Constants.pw1_list_boiler_equipment_select_fuel_storage_location, "Above Ground");
				type(Constants.pw1_list_boiler_equipment_fuel_storage_floor_number, "123");
				select(Constants.pw1_list_boiler_equipment_select_fuel_storage_installed, "Enclosed");
				radio(Constants.pw1_list_boiler_equipment_tank_adjacent_to_subway_no);
				type(Constants.pw1_list_boiler_equipment_storage_fdny_permit_number, "123456789");
				select(Constants.pw1_list_boiler_equipment_select_grade_of_oil, "Bio");
				type(Constants.pw1_list_boiler_equipment_storage_total_tank_capacity, "862000");
				
				click(Constants.global_save_form_button_8085);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.ok_button);
				wait(2);
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
				wait(2);
				clickButton("OK");
				waitInvisible(Constants.ok_button);
			}
		} else {
			System.out.println(convertedTimestamp() + " **************** PW1 no addBoilerEquipmentDevice");
		}
	}
	
	// 6. Work Types Antenna (new PW1 UI) // JG 2018-10-31
	public void workTypesAntenna(String new_existing_both) {
		if (!new_existing_both.equals("")) {
			test = rep.startTest("workTypesAntenna");
			String[] data = new_existing_both.split(" :: ");
			//scrollToElement("//span[contains(text(),'Work Types')]");
			click(Constants.pw1_6_work_types_accordion); // JG 2018-11-29 
//			scrollToElement("//span[contains(text(),'Filing Review')]"); // JG 2018-10-31 scrolling here because 'Work Types' was too far down.
			wait(1);
			if (!data[0].equals("N"))
				radio("//input[@type='radio'][@name='rblAntennaTypeValue'][@value='" + data[0] + "']");
			if (!data[1].equals("N"))
				radio("//input[@id='rdPWZoningExemptions'][@value='" + data[1] + "']");
			if (data[1].equals("true")) {
				radio("//input[@id='rdPWIsStructuralWork'][@value='" + data[2] + "']");
				radio("//input[@id='rdPWoccupancytab'][@value='" + data[3] + "']");
				radio("//input[@id='rdPWIsAntennaONeMeter'][@value='" + data[4] + "']");
				radio("//input[@id='rdPWcurrentcertificate'][@value='" + data[5] + "']");
			}
		}
	}

	public void workTypesPlumbing(String new_existing_both) {
		if (!new_existing_both.equals("")) {
			test = rep.startTest("workTypes");
			String[] data = new_existing_both.split(" :: ");
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-29
				click(Constants.pw1_6_work_types_accordion);
			} else {
				scrollToElement("//span[contains(text(),'Work Types')]");
			}
			wait(1);
			if (!data[0].equals("N"))
				radio("//input[@type='radio'][@name='rdNewApp'][@value='" + data[0] + "']");
			if (!data[1].equals("N"))
				radio("//input[@id='rdstructuralWorkIncluded'][@value='" + data[1] + "']");
			if (!data[2].equals("N"))
				radio("//input[@id='rdZoningExemptionsdiameter'][@value='" + data[2] + "']");
			if (!data[3].equals("N"))
				radio("//input[@id='rdZoningExemptionsSqfeet'][@value='" + data[3] + "']");
			if (!data[4].equals("N"))
				radio("//input[@id='rdZoningExemptionsBulkhead'][@value='" + data[4] + "']");
			if (!data[5].equals("N"))
				check("//input[contains(@id,'chkPWWrkTypeP')]"); // select plumbing
			if (!data[6].equals("N"))
				check("//input[contains(@id,'chkPWWrkTypeSp')]"); // select sprinkler
			if (!data[7].equals("N"))
				check("//input[contains(@id,'chkPWWrkTypeSd')]"); // select standpipe
			if (!data[8].equals("N"))
				check("(//input[contains(@id,'chkPWWrkTypeP2')])[last()]"); 
			if (!data[9].equals("N"))
				check("//input[@id='chkPWWrkTypeSp3']"); // work type 5
			
			if (count("//input[@name='rdSDNewSdInstallation']") > 0)
				radio("//input[@name='rdSDNewSdInstallation'][@value='true']");
			
			if (!data[10].equals("N")) {
				if (count("//input[@id='rdSDType'][@value='" + data[10] + "']") > 0) { // JG 2018-12-03 old standpipe values
					radio("//input[@id='rdSDType'][@value='" + data[10] + "']"); //rdSDType
				}
			}
			if (!data[11].equals("N")) {
				if (count("//input[@id='rdSDClass'][@value='" + data[11] + "']") > 0) { // JG 2018-12-03 old standpipe values
					radio("//input[@id='rdSDClass'][@value='" + data[11] + "']");
				}
			}
		}
	}	
	// 6. Work Types workTypeScaffold
	public void workTypeScaffold(String new_existing_both) {	
		if (!new_existing_both.equals("")) {
			test = rep.startTest("workTypeScaffold");
			String[] data = new_existing_both.split(" :: ");
			scrollToElement("//span[contains(text(),'Work Types')]");
			wait(1);
			if (!data[0].equals("N"))
				radio("//input[@type='radio'][@name='rdNewApp'][@value='" + data[0] + "']");
			if (!data[1].equals("N"))
				radio("//input[@id='rdstructuralWorkIncluded'][@value='" + data[1] + "']");
			if (!data[2].equals("N"))
				radio("//input[@id='rdZoningExemptionsdiameter'][@value='" + data[2] + "']");
			if (!data[3].equals("N"))
				radio("//input[@id='rdZoningExemptionsSqfeet'][@value='" + data[3] + "']");
			if (!data[4].equals("N"))
				radio("//input[@id='rdZoningExemptionsBulkhead'][@value='" + data[4] + "']");
			if (!data[5].equals("N"))
				check("//input[contains(@id,'chkPWWrkTypeP')]");
			if (!data[6].equals("N"))
				check("//input[contains(@id,'chkPWWrkTypeAntenna')]");
			if (!data[7].equals("N"))
				check("(//input[@id='chkPWWrkTypeSp1'])[last()]");
	 	}
	}
/*	// 6. Work Types Sign
	public void XworkTypeSign(String type) {	
		if(!type.equals("")){
			if (type.contains("legalization"))
				radio(Constants.pw1_6_sign_legalization);
	 	}
	}*/
	
// 8. Additional Information	
	public void additionalInfo(String costareatype) {	
		if(!costareatype.equals("")){
			String[] data = costareatype.split(" :: ");
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-29
				click(Constants.pw1_8_additional_information_accordion);
			}
			type(Constants.pw1_8_estimated_new_work_cost, data[0]);
			type(Constants.pw1_8_total_new_work_floor_area, data[1]);			
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-10-30 TEST-ENV new PW UI
				select(Constants.pw1_8_building_type, data[2]); 
				scrollToElement(Constants.job_description_for_new_work);
				type(Constants.job_description_for_new_work, convertedTimestamp());//legalization
			} else {
				radio(Constants.pw1_8_associated_no_8085); // JG 2018-11-19 new PW UI radio button 
				radio(Constants.pw1_8_associated_bis_job_number_no); // JG 2018-11-19 new PW UI radio button
			}
		}
	}

	// 8. Enter Additional Information	
	public void enterAdditionalInformation(String additional_info) {	
		if(!additional_info.equals("")){
			System.out.println(convertedTimestamp() + " **************** PW1 enterAdditionalInformation");
			String[] data = additional_info.split(" :: ");
			click(Constants.pw1_8_additional_information_accordion); // open
			type(Constants.pw1_8_estimated_new_work_cost, data[0]);
			type(Constants.pw1_8_total_new_work_floor_area, data[1]);			
			radio(Constants.pw1_8_associated_no_8085); // JG 2018-11-19 new PW UI radio button 
			radio(Constants.pw1_8_associated_bis_job_number_no); // JG 2018-11-19 new PW UI radio button
			click(Constants.pw1_8_additional_information_accordion); // close
		}
	}

	
	
	// 8. Additional Information 2
	public void additionalInfo2(String additional_info) {
		if (!additional_info.equals("")) {
			test = rep.startTest("additionalInfo2");
			String[] data = additional_info.split(" :: ");
			if (count(Constants.pw1_8_estimated_new_work_cost) > 0) // new / both
				type(Constants.pw1_8_estimated_new_work_cost, data[0]);
			if (count(Constants.pw1_8_legalization_cost) > 0)
				type(Constants.pw1_8_legalization_cost, data[0]);
			if (count(Constants.pw1_8_total_legalization_floor_area) > 0)
				type(Constants.pw1_8_total_legalization_floor_area, data[1]);
			if (count(Constants.pw1_8_total_new_work_floor_area) > 0)
				type(Constants.pw1_8_total_new_work_floor_area, data[1]);
			select(Constants.pw1_8_building_type, data[2]);
			scrollToElement(Constants.job_description_for_new_work);
			if(count(Constants.job_description_for_new_work) > 0)
				type(Constants.job_description_for_new_work, convertedTimestamp());
			if(count(Constants.job_description_legalization) > 0)
				type(Constants.job_description_legalization, convertedTimestamp() + " legalization");
			if(count(Constants.pw1_8_height) > 0)
				type(Constants.pw1_8_height, data[3]);
			
			}
	}
	// 8. Additional Information Plumbing
	public void additionalInforPlumbing(String additional_info) {
		if (!additional_info.equals("")) {
			test = rep.startTest("additionalInforPlumbing");
			String[] data = additional_info.split(" :: ");
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-29
				click(Constants.pw1_8_additional_information_accordion);
			}
			if (count(Constants.pw1_8_estimated_new_work_cost) > 0) // new / both
				type(Constants.pw1_8_estimated_new_work_cost, data[0]);
			if (count(Constants.pw1_8_legalization_cost) > 0)
				type(Constants.pw1_8_legalization_cost, data[3]);
			if (count(Constants.pw1_8_total_legalization_floor_area) > 0)
				type(Constants.pw1_8_total_legalization_floor_area, data[1]);
			if (count(Constants.pw1_8_total_new_work_floor_area) > 0)
				type(Constants.pw1_8_total_new_work_floor_area, data[1]);
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-26
				select(Constants.pw1_8_building_type, data[2]);
			} else {
				radio(Constants.pw1_8_associated_bis_job_number_no); // JG 2018-11-28
			}
			scrollToElement(Constants.job_description_for_new_work);
			if(count(Constants.job_description_legalization) > 0)
				type(Constants.job_description_legalization, convertedTimestamp() + " legalization");		}
	}
	// 8. Additional Information Subsequent	
		public void additionalInfoSubs(String costareatype) {	
			if(!costareatype.equals("")){
				String[] newvalue = costareatype.split(" :: ");
				String estimated_cost = newvalue[0];
				String floor_area = newvalue[1];
				type(Constants.pw1_8_estimated_new_work_cost, estimated_cost);
				type(Constants.pw1_8_total_new_work_floor_area, floor_area);
				
				
				
		 	}
		}
// 9. Additional Considerations Antenna
	public void additionalConciderationsAntenna(String demolition) {
		if (!demolition.equals("")) {
			test = rep.startTest("additionalConciderationsAntenna");
			if (count("//input[@id='rdPWReviewReq1']") > 1) {
				radio("//input[@id='rdPWReviewReq1'][@value='1']");
				radio("//input[@id='rdPWLittleSite'][@value='1']");
				radio("//input[@id='rdPWRequestLegalization'][@value='1']");
				radio("//input[@id='rdPWUnmappedCCoStreet1'][@value='1']");
				radio("//input[@id='rdPWPermanentRemoval'][@value='1']");
			}
			else {
				select(Constants.pw1_9_review_requested_under_code, "2014");
				radio(Constants.pw1_9_facade_alteration_no);
				radio(Constants.pw1_9_adult_establishment_no);
				radio(Constants.pw1_9_quality_housing_no);
				radio(Constants.pw1_9_bsa_calendar_numbers_no);
				radio(Constants.pw1_9_cpc_calendar_numbers_no);
				radio(Constants.pw1_9_stability_affected_by_work_no);
				scrollToElement(Constants.pw1_9_includes_partial_demolition_yes);
				if (demolition.equals("Y"))
					radio(Constants.pw1_9_includes_partial_demolition_yes);
				if (demolition.equals("N"))
					radio(Constants.pw1_9_includes_partial_demolition_no);
				radio(Constants.pw1_9_stability_affected_by_work_no);
			}
		}
	}

	public void additionalConciderations(String additional_conciderations) {
		if (!additional_conciderations.equals("")) {
			test = rep.startTest("additionalConciderations");
			String[] data = additional_conciderations.split(" :: ");
			if (count("//span[contains(text(),'Additional Considerations')]") > 0) { // JG 2018-11-29 span replaced by accordion
				scrollTo("//span[contains(text(),'Additional Considerations')]");	
			}
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-29
				click(Constants.pw1_9_additional_considerations_accordion);
			}
			if (count(Constants.pw1_9_review_requested_under_code) > 0) { // ALL WORK TYPES
//				select(Constants.pw1_9_review_requested_under_code, data[0]); JG 2018-11-26, not working so use the below:
				send(Constants.pw1_9_review_requested_under_code, "2014");
				if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-01 TEST-ENV PW1 UI changes
					if (count(Constants.pw1_9_change_number_stories_no) > 0) { //JG 2018-11-29
						radio(Constants.pw1_9_change_number_stories_no);
					}
//					if (count(Constants.pw1_9_facade_alteration_yes) > 0) { // Antenna work type
					if (count(Constants.pw1_9_facade_alteration_yes_8085) > 0) { 
							radio("//input[@name='rdPWfacadealteration'][@value='" + data[1] + "']");
					}
					radio("//input[@name='rdPWestablishmenttab'][@value='" + data[2] + "']");
//					radio("//input[@name='rdPWQualityHousing'][@value='" + data[3] + "']"); // JG 2018-11-01 required per dd, but not present
					if (count(Constants.pw1_9_landmark_approval_number) > 0) {
						type(Constants.pw1_9_landmark_approval_number, "1");
					}
					radio("//input[@name='rdPWBSACalender'][@value='false']"); // JG 2018-11-27 data[4] has 1, but needs to be false
					radio("//input[@name='rdPWCPCCalender'][@value='false']"); // JG 2018-11-27 data[5] has 1, but needs to be false
					if (count("//input[@ng-model='FormObj.WorkIncludesPartialDemolition'][@value='true']") > 0) { // JG 2018-11-30 for cc/pl, use the below logic.
						radio("//input[@ng-model='FormObj.WorkIncludesPartialDemolition'][@value='" + data[6] + "']");
					}
					if (additional_conciderations.equals("Y")) {
						radio("//input[@ng-model='FormObj.WorkIncludesPartialDemolition'][@value='true']");
					}
					if (additional_conciderations.equals("N")) {
						radio("//input[@ng-model='FormObj.WorkIncludesPartialDemolition'][@value='false']");
					}
					if (count("//input[@ng-model='FormObj.StructuralStabilityAffected'][@value='" + data[7] + "']") > 0) { // JG 2018-11-27 only in antenna:
						radio("//input[@ng-model='FormObj.StructuralStabilityAffected'][@value='" + data[7] + "']");
					}
				} else {
					radio("//input[@name='rdPWFa�adeAlteration'][@value='" + data[1] + "']");
					radio("//input[@name='rdPWAdultEstablishment'][@value='" + data[2] + "']");
					radio("//input[@name='rdPWQualityHousing'][@value='" + data[3] + "']");
					radio("//input[@name='rdPWBSACalender'][@value='" + data[4] + "']");
					radio("//input[@name='rdPWCPCCalender'][@value='" + data[5] + "']");
					radio("//input[@name='rdPWWorkIncludes'][@value='" + data[6] + "']");
					if (additional_conciderations.equals("Y")) {
						radio(Constants.pw1_9_includes_partial_demolition_yes);
					}
					if (additional_conciderations.equals("N")) {
						radio(Constants.pw1_9_includes_partial_demolition_no);
					}
					radio("//input[@name='rdPWStructuralStab'][@value='" + data[7] + "']");
					//radio(Constants.pw1_9_stability_affected_by_work_no); // JG 2018-11-01 this is not needed
				}				
			}
			if (count("//input[@id='rdPWLMCC']") > 0) // SIGN
				radio("//input[@id='rdPWLMCC'][@value='" + data[4] + "']");	
			if(count("//input[@name='rdPWSiteSafety']") > 0) // SIGN
				radio(Constants.pw1_9_site_safety_job_no);
			if (count("//input[@id='rdPWReviewReq1']") > 0) { // BOILERS
				radio("//input[@id='rdPWReviewReq1'][@value='" + data[0] + "']");
				radio("//input[@name='rdPWLittleSite'][@value='" + data[1] + "']");
				radio("//input[@name='rdPWAdultEstablishment'][@value='" + data[2] + "']");
				radio("//input[@name='rdPWUnmappedCCoStreet1'][@value='" + data[3] + "']");
				radio("//input[@id='rdPWRequestLegalization'][@value='" + data[4] + "']");
				radio("//input[@name='rdPWPermanentRemoval'][@value='" + data[5] + "']");
				radio("//input[@name='rdPWCrfnRestrictive'][@value='" + data[6] + "']");
				radio("//input[@name='rdPWCrfnFilingToAddress'][@value='" + data[7] + "']");
				radio("//input[@name='rdPWCrfnComplyingToLocal'][@value='" + data[8] + "']");
			}
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-15 these are now required.
				if (count("//input[@ng-model='FormObj.UnmappedCCOStreet'][@value='1']") > 0) { // 2018-11-27 not in plumbing
					radio("//input[@ng-model='FormObj.UnmappedCCOStreet'][@value='1']");
				}
				radio("//input[@ng-model='FormObj.CRFNRestrictiveDeclaration'][@value='false']");
				radio("//input[@ng-model='FormObj.ComplyingToLocalLaws'][@value='false']");
				radio("//input[@ng-model='FormObj.IsFilingtoAddressViolations'][@value='false']");
				radio("//input[@ng-model='FormObj.GCModularConstnyState'][@value='false']");
				radio("//input[@ng-model='FormObj.GCModularConstunderNYC'][@value='false']");
				if (count("//input[@ng-model='FormObj.RaisingAndMovingofbuildings'][@value='false']") > 0) { // 2018-11-27 not in plumbing
					radio("//input[@ng-model='FormObj.RaisingAndMovingofbuildings'][@value='false']");
				}
				if (count("//input[@ng-model='FormObj.STWorkOnInteriorofBuilding'][@value='false']") > 0) { // 2018-11-27 not in plumbing
					radio("//input[@ng-model='FormObj.STWorkOnInteriorofBuilding'][@value='false']");
				}
				if (count("//input[@ng-model='FormObj.STWorkonExteriorofBuilding'][@value='false']") > 0) { // 2018-11-27 not in plumbing
					radio("//input[@ng-model='FormObj.STWorkonExteriorofBuilding'][@value='false']");
				}
				if (count(Constants.pw1_9_impact_water_supply_no) > 0) { // JG 2018-11-28 added for new UI plumbing
					radio(Constants.pw1_9_impact_water_supply_no);
				}
				if (count(Constants.pw1_9_otcr_approval_required_no) > 0) { // JG 2018-11-28 added for new UI plumbing
					radio(Constants.pw1_9_otcr_approval_required_no);
				}
				if (count("//input[@ng-model='FormObj.BuildingGreater'][@value='true']") > 0) { // 2018-12-06 added for Structural
					radio("//input[@ng-model='FormObj.BuildingGreater'][@value='true']");
				}
				if (count("//input[@ng-model='FormObj.StructureDesignBased'][@value='false']") > 0) { // 2018-12-06 added for Structural
					radio("//input[@ng-model='FormObj.StructureDesignBased'][@value='false']");
				}
				if (count("//input[@ng-model='FormObj.STDemolishing50orMoreoftheArea'][@value='false']") > 0) { // 2018-12-06 added for Structural
					radio("//input[@ng-model='FormObj.STDemolishing50orMoreoftheArea'][@value='false']");
				}
				if (count("//input[@ng-model='FormObj.STConcreteForFootingsFullySupported'][@value='false']") > 0) { // 2018-12-06 added for Structural
					radio("//input[@ng-model='FormObj.STConcreteForFootingsFullySupported'][@value='false']");
				}
				if (count("//input[@ng-model='FormObj.STConcretePlacementlessThan50cy'][@value='false']") > 0) { // 2018-12-06 added for Structural
					radio("//input[@ng-model='FormObj.STConcretePlacementlessThan50cy'][@value='false']");
				}
				if (count("//input[@id='txtPWNYSLicenseNumber']") > 0) { // 2018-12-06 added for Structural
					type("//input[@id='txtPWNYSLicenseNumber']", "005551");
				}
				if (count(Constants.pw1_9_more_than_5_floors_no) > 0) { // 2018-12-11 added for Sprinklers
					radio(Constants.pw1_9_more_than_5_floors_no);
				}
				if (count(Constants.pw1_9_require_standpipe_service_24hrs_no) > 0) { // 2018-12-20 added for Standpipe
					radio(Constants.pw1_9_require_standpipe_service_24hrs_no);
				}
			}
		}
	}
	
	// Enter Additional Considerations, Limitations or Restrictions
	public void enterAdditionalConsiderations(String additional_conciderations) {
		if (!additional_conciderations.equals("")) {
			System.out.println(convertedTimestamp() + " **************** PW1 enterAdditionalConsiderations");
			test = rep.startTest("enterAdditionalConsiderations");
			String[] data = additional_conciderations.split(" :: ");
			scrollAllWayUp();
			wait(1);
//			 if (count(Constants.pw1_list_boiler_equipment_accordion) > 0) { // JG 2019-01-17 List of Devices is not open, so no need to close.
//				 click(Constants.pw1_list_boiler_equipment_accordion); // 
			if (count(Constants.pw1_filing_info_accordion) > 0) { // 
				click(Constants.pw1_filing_info_accordion); // open
				if (count(Constants.pw1_filing_info_associated_job_number) > 0) {
					type(Constants.pw1_filing_info_associated_job_number,data[9]);
				}
				wait(1);
				scrollAllWayUp();
				wait(1);
				click(Constants.pw1_filing_info_accordion); // close
			}
			scrollDown();
			click(Constants.pw1_9_additional_considerations_accordion); // open
			scrollToElement(Constants.pw1_9_additional_considerations_accordion);
			wait(1);
			if (count(Constants.pw1_9_review_requested_under_code) > 0) { // ALL WORK TYPES
				send(Constants.pw1_9_review_requested_under_code, "2014");
				if (count(Constants.pw1_9_change_number_stories_no) > 0) { //JG 2018-11-29
					radio(Constants.pw1_9_change_number_stories_no);
				}
				if (count(Constants.pw1_9_facade_alteration_yes_8085) > 0) { 
						radio("//input[@name='rdPWfacadealteration'][@value='" + data[1] + "']");
				}
				if (count("//input[@ng-model='FormObj.UnmappedCCOStreet'][@value='1']") > 0) { // 2018-11-27 not in plumbing
					radio("//input[@ng-model='FormObj.UnmappedCCOStreet'][@value='1']");
				}
				scrollAllWayUp();
				wait(1);
				if (count("//input[@name='rdPWestablishmenttab'][@value='" + data[2] + "']") > 0) {
				    radio("//input[@name='rdPWestablishmenttab'][@value='" + data[2] + "']");
//					radio("//input[@name='rdPWQualityHousing'][@value='" + data[3] + "']"); // JG 2018-11-01 required per dd, but not present
				}
				if (count(Constants.pw1_9_landmark_approval_number) > 0) {
					type(Constants.pw1_9_landmark_approval_number, "1");
				}
				scrollToElement(Constants.pw1_9_review_requested_under_code);
				radio("//input[@name='rdPWBSACalender'][@value='false']"); // JG 2018-11-27 data[4] has 1, but needs to be false
				radio("//input[@name='rdPWCPCCalender'][@value='false']"); // JG 2018-11-27 data[5] has 1, but needs to be false
				if (count("//input[@ng-model='FormObj.WorkIncludesPartialDemolition'][@value='true']") > 0) { // JG 2018-11-30 for cc/pl, use the below logic.
					radio("//input[@ng-model='FormObj.WorkIncludesPartialDemolition'][@value='" + data[6] + "']");
				}
				if (additional_conciderations.equals("Y")) {
					radio("//input[@ng-model='FormObj.WorkIncludesPartialDemolition'][@value='true']");
				}
				if (additional_conciderations.equals("N")) {
					radio("//input[@ng-model='FormObj.WorkIncludesPartialDemolition'][@value='false']");
				}
				if (count("//input[@ng-model='FormObj.StructuralStabilityAffected'][@value='" + data[7] + "']") > 0) { // JG 2018-11-27 only in antenna:
					radio("//input[@ng-model='FormObj.StructuralStabilityAffected'][@value='" + data[7] + "']");
				}		
			}
			if (count("//input[@id='rdPWLMCC']") > 0) // SIGN
				radio("//input[@id='rdPWLMCC'][@value='" + data[4] + "']");	
			if(count("//input[@name='rdPWSiteSafety']") > 0) // SIGN
				radio(Constants.pw1_9_site_safety_job_no);
			if (count("//input[@id='rdPWReviewReq1']") > 0) { // BOILERS
				radio("//input[@id='rdPWReviewReq1'][@value='" + data[0] + "']");
				radio("//input[@name='rdPWLittleSite'][@value='" + data[1] + "']");
				radio("//input[@name='rdPWAdultEstablishment'][@value='" + data[2] + "']");
				radio("//input[@name='rdPWUnmappedCCoStreet1'][@value='" + data[3] + "']");
				radio("//input[@id='rdPWRequestLegalization'][@value='" + data[4] + "']");
				radio("//input[@name='rdPWPermanentRemoval'][@value='" + data[5] + "']");
				radio("//input[@name='rdPWCrfnRestrictive'][@value='" + data[6] + "']");
				radio("//input[@name='rdPWCrfnFilingToAddress'][@value='" + data[7] + "']");
				radio("//input[@name='rdPWCrfnComplyingToLocal'][@value='" + data[8] + "']");
			}
			scrollDown();
			radio("//input[@ng-model='FormObj.CRFNRestrictiveDeclaration'][@value='false']");
			radio("//input[@ng-model='FormObj.ComplyingToLocalLaws'][@value='false']");
			radio("//input[@ng-model='FormObj.IsFilingtoAddressViolations'][@value='false']");
			radio("//input[@ng-model='FormObj.GCModularConstnyState'][@value='false']");
			radio("//input[@ng-model='FormObj.GCModularConstunderNYC'][@value='false']");
			if (count("//input[@ng-model='FormObj.RaisingAndMovingofbuildings'][@value='false']") > 0) { // 2018-11-27 not in plumbing
				radio("//input[@ng-model='FormObj.RaisingAndMovingofbuildings'][@value='false']");
			}
			if (count("//input[@ng-model='FormObj.STWorkOnInteriorofBuilding'][@value='false']") > 0) { // 2018-11-27 not in plumbing
				radio("//input[@ng-model='FormObj.STWorkOnInteriorofBuilding'][@value='false']");
			}
			if (count("//input[@ng-model='FormObj.STWorkonExteriorofBuilding'][@value='false']") > 0) { // 2018-11-27 not in plumbing
				radio("//input[@ng-model='FormObj.STWorkonExteriorofBuilding'][@value='false']");
			}
			if (count(Constants.pw1_9_impact_water_supply_no) > 0) { // JG 2018-11-28 added for new UI plumbing
				radio(Constants.pw1_9_impact_water_supply_no);
			}
			if (count(Constants.pw1_9_otcr_approval_required_no) > 0) { // JG 2018-11-28 added for new UI plumbing
				radio(Constants.pw1_9_otcr_approval_required_no);
			}
			if (count("//input[@ng-model='FormObj.BuildingGreater'][@value='true']") > 0) { // 2018-12-06 added for Structural
				radio("//input[@ng-model='FormObj.BuildingGreater'][@value='true']");
			}
			if (count("//input[@ng-model='FormObj.StructureDesignBased'][@value='false']") > 0) { // 2018-12-06 added for Structural
				radio("//input[@ng-model='FormObj.StructureDesignBased'][@value='false']");
			}
			if (count("//input[@ng-model='FormObj.STDemolishing50orMoreoftheArea'][@value='false']") > 0) { // 2018-12-06 added for Structural
				radio("//input[@ng-model='FormObj.STDemolishing50orMoreoftheArea'][@value='false']");
			}
			if (count("//input[@ng-model='FormObj.STConcreteForFootingsFullySupported'][@value='false']") > 0) { // 2018-12-06 added for Structural
				radio("//input[@ng-model='FormObj.STConcreteForFootingsFullySupported'][@value='false']");
			}
			if (count("//input[@ng-model='FormObj.STConcretePlacementlessThan50cy'][@value='false']") > 0) { // 2018-12-06 added for Structural
				radio("//input[@ng-model='FormObj.STConcretePlacementlessThan50cy'][@value='false']");
			}
			if (count("//input[@id='txtPWNYSLicenseNumber']") > 0) { // 2018-12-06 added for Structural
				type("//input[@id='txtPWNYSLicenseNumber']", "005551");
			}
			if (count(Constants.pw1_9_more_than_5_floors_no) > 0) { // 2018-12-11 added for Sprinklers
				radio(Constants.pw1_9_more_than_5_floors_no);
			}
			if (count(Constants.pw1_9_require_standpipe_service_24hrs_no) > 0) { // 2018-12-20 added for Standpipe
				radio(Constants.pw1_9_require_standpipe_service_24hrs_no);
			}
			scrollAllWayUp();
			wait(1);
			click(Constants.pw1_9_additional_considerations_accordion); // close
		}
	}

	// 9. Additional Considerations Curb Cut
			public void additionalConciderationsCurb(String demolition) {	
				if(!demolition.equals("")){
					test = rep.startTest("additionalConciderationsCurb");
					if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-29
						click(Constants.pw1_9_additional_considerations_accordion);
					}
					send(Constants.pw1_9_review_requested_under_code, "2014");	
//					pw1_9_review_requested_under_code.sendKeys("2014");
	/*				pw1_9_review_requested_under_code.sendKeys("2014");
					radio(Constants.pw1_9_facade_alteration_no);
					radio(Constants.pw1_9_adult_establishment_no);
					radio(Constants.pw1_9_quality_housing_no);*/
	/*				pw1_9_facade_alteration_no.click();
					pw1_9_adult_establishment_no.click();
					pw1_9_quality_housing_no.click();*/
					if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-21
						radio(Constants.pw1_9_facade_alteration_no);
						radio(Constants.pw1_9_adult_establishment_no);
						radio(Constants.pw1_9_quality_housing_no);
					} else {
						if (count(Constants.pw1_9_landmark_approval_number) > 0) { // JG 2018-11-30 only here for certain addresses
							type(Constants.pw1_9_landmark_approval_number, "1");
						}
						radio(Constants.pw1_9_unmapped_cco_street_no_8085);
						radio(Constants.pw1_9_crfn_restrictive_declaration_easement_no_8085);
						radio(Constants.pw1_9_comply_with_local_laws_no_8085);
						radio(Constants.pw1_9_address_violations_no_8085);
						radio(Constants.pw1_9_bsa_calendar_numbers_no);
						radio(Constants.pw1_9_cpc_calendar_numbers_no);
						radio(Constants.pw1_9_modular_construct_nys_no_8085);
						radio(Constants.pw1_9_modular_construct_nyc_no_8085);
					}
				}
			}
	
// 10. NYCEEC Compliance
	public void complianceNYCECC(String nycecc) {	
		if(!nycecc.equals("")){
			String[] comp = nycecc.split(" :: ");
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-29
				if (count(Constants.pw1_10_nycecc_compliance_accordion) > 0) {
					click(Constants.pw1_10_nycecc_compliance_accordion);
					radio(Constants.pw1_10_work_in_compliance_with_nycecc_8085);
					select(Constants.pw1_10_code_compliance_path, comp[0]);
					select(Constants.pw1_10_energy_nalysis, comp[1]);
					// JG 2018-12-11 only check this to suppress TR8
					if (count(Constants.pw1_10_no_tr8_inspections_req) > 0) {
						if (comp[2].equals("N")) {
							check(Constants.pw1_10_no_tr8_inspections_req);
						}
					}
				}
			} else {
				radio(Constants.pw1_10_work_in_compliance_with_nycecc);
				select(Constants.pw1_10_code_compliance_path, comp[0]);
				select(Constants.pw1_10_energy_nalysis, comp[1]);
			}
	 	}
	}
	
	// 10. Enter NYCECC Compliance
	public void enterNYCECCCompliance(String nycecc) {	
		if(!nycecc.equals("")){
			System.out.println(convertedTimestamp() + " **************** PW1 enterNYCECCCompliance");
			String[] comp = nycecc.split(" :: ");
			if (count(Constants.pw1_10_nycecc_compliance_accordion) > 0) {
				click(Constants.pw1_10_nycecc_compliance_accordion); // open
				radio(Constants.pw1_10_work_in_compliance_with_nycecc_8085);
				select(Constants.pw1_10_code_compliance_path, comp[0]);
				select(Constants.pw1_10_energy_nalysis, comp[1]);
				// JG 2018-12-11 only check this to suppress TR8
				if (count(Constants.pw1_10_no_tr8_inspections_req) > 0) {
					if (comp[2].equals("N")) {
						check(Constants.pw1_10_no_tr8_inspections_req);
					}
				}
				click(Constants.pw1_10_nycecc_compliance_accordion); // close
			}
	 	} else {
	 		System.out.println(convertedTimestamp() + " **************** PW1 no enterNYCECCCompliance");
	 	}
	}

	// 11. Enter Job Description
	public void enterJobDescription() {	
		System.out.println(convertedTimestamp() + " **************** PW1 enterJobDescription");
		click(Constants.pw1_11_job_description_accordion); // open
		type(Constants.job_description_for_new_work, "Test job description");
		scrollAllWayUp();
		click(Constants.pw1_11_job_description_accordion); // close
	}

// 12. Zoning Characteristics
	public void zonningCharacteristics(String characteristics) {	
		if(!characteristics.equals("")){
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-01 TEST-ENV new PW1 UI - Zoning Info tab
				click(Constants.zoning_information_tab);
				scrollTo(Constants.pw1_12_district_8085); // JG 2018-11-14
				select_val(Constants.pw1_12_district_8085,"BPC"); //JG 2018-11-01 TODO: use a variable instead of "BPC"  
			} else {
				type(Constants.pw1_12_district, "1");
			}
			type(Constants.pw1_12_overlay, "2");
			type(Constants.pw1_12_special_district, "3");
			type(Constants.pw1_12_map_number, "4");
	 	}
	}

	// 12. Enter Zoning Characteristics
	public void enterZoningCharacteristics(String characteristics) {
		if(!characteristics.equals("")){
			System.out.println(convertedTimestamp() + " **************** PW1 (Zoning Information tab) enterZoningCharacteristics");
			test = rep.startTest("enterZoningCharacteristics");
			click(Constants.zoning_information_tab);
			scrollAllWayUp();
			select_val(Constants.pw1_12_district_8085,"BPC"); //JG 2018-11-01 TODO: use a variable instead of "BPC"  
			type(Constants.pw1_12_overlay, "2");
			type(Constants.pw1_12_special_district, "3");
			type(Constants.pw1_12_map_number, "4");
		} else {
			System.out.println(convertedTimestamp() + " **************** PW1 (Zoning Information tab) no enterZoningCharacteristics");
		}
	}

	// 13. Building Characteristics
		public void buildingCharacteristics(String building_charcteristics) {
			if(!building_charcteristics.equals("")){
				test = rep.startTest("buildingCharacteristics");
				if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-01 TEST-ENV new PW1 UI
					click(Constants.zoning_information_tab);  // JG 2018-11-27 cc already clicked, but not plumbing
					scrollAllWayUp();
					if (count(Constants.pw1_13_site_tidal_no) > 0) {
						radio(Constants.pw1_13_site_tidal_no);
					}
					if (count(Constants.pw1_13_occupancy_classification_existing) > 0) {
						select(Constants.pw1_13_occupancy_classification_existing, "A-High Hazard");
					}
					if (count(Constants.pw1_13_occupancy_classification_proposed) > 0) {
						select(Constants.pw1_13_occupancy_classification_proposed, "A-High Hazard");
					}
					if (count(Constants.pw1_13_2014_code_apply_no) > 0) {
						radio(Constants.pw1_13_2014_code_apply_no);
					}
					if (count(Constants.pw1_13_construction_classification_existing) > 0) {
						select(Constants.pw1_13_construction_classification_existing, "I-A 4-Hour Protected (Non-Combustible)");
					}
					if (count(Constants.pw1_13_construction_classification_proposed) > 0) {
						select(Constants.pw1_13_construction_classification_proposed, "I-A 4-Hour Protected (Non-Combustible)");
					}
					if (count(Constants.pw1_13_multiple_dwelling_classification) > 0) {
						select(Constants.pw1_13_multiple_dwelling_classification, "Class A-OL-Old Law Tenement");
					}
					select_val(Constants.pw1_13_building_type_8085, "1");
					scrollDown();
					wait(1);
					radio(Constants.pw1_13_mixed_use_type_no_8085);
					if (count(Constants.pw1_13_select_primary_structural_system) > 0) {
						select(Constants.pw1_13_select_primary_structural_system, "Concrete (CIP)");
					}
					if (count(Constants.pw1_13_select_structural_occupancy_risk_existing) > 0) {
						select(Constants.pw1_13_select_structural_occupancy_risk_existing, "I-Low Hazard to Human Life");
					}
					if (count(Constants.pw1_13_select_structural_occupancy_risk_proposed) > 0) {
						select(Constants.pw1_13_select_structural_occupancy_risk_proposed, "I-Low Hazard to Human Life");
					}
					if (count(Constants.pw1_13_select_seismic_design_existing) > 0) {
						select(Constants.pw1_13_select_seismic_design_existing, "Category A");
					}
					if (count(Constants.pw1_13_select_seismic_design_proposed) > 0) {
						select(Constants.pw1_13_select_seismic_design_proposed, "Category A");
					}
					if (count(Constants.pw1_13_dwelling_units_existing) > 0) { // Dwelling Units
						type(Constants.pw1_13_dwelling_units_existing, "41");
						type(Constants.pw1_13_dwelling_units_proposed, "42");
					}
				} else {
					radio(Constants.pw1_13_mixed_use_type_no);
					type(Constants.pw1_13_building_height_existing, "100");
					type(Constants.pw1_13_building_height_proposed, "111");
					type(Constants.pw1_13_building_dwelling_units_existing, "50");
					type(Constants.pw1_13_building_dwelling_units_proposed, "51");
				}
				if (count(Constants.pw1_13_building_stories_existing) > 0) { // Building Code: Building Stories
					type(Constants.pw1_13_building_stories_existing, "1");
					type(Constants.pw1_13_building_stories_proposed, "2");
				}
				if (count(Constants.pw1_13_building_dwelling_units_existing) > 0) { // Structural Footprint
					type(Constants.pw1_13_building_dwelling_units_existing, "51");
					type(Constants.pw1_13_building_dwelling_units_proposed, "52");
				}
		 	}
		}

	// 13. Zoning Information - Enter Building Characteristics
	public void enterBuildingCharacteristics(String building_charcteristics) {
		if(!building_charcteristics.equals("")){
			System.out.println(convertedTimestamp() + " **************** PW1 (Zoning Information tab) enterBuildingCharacteristics");
			test = rep.startTest("enterBuildingCharacteristics");
			click(Constants.zoning_information_tab);
			scrollAllWayUp();
			if (count(Constants.pw1_13_site_tidal_no) > 0) {
				radio(Constants.pw1_13_site_tidal_no);
			}
			if (count(Constants.pw1_13_occupancy_classification_existing) > 0) {
				select(Constants.pw1_13_occupancy_classification_existing, "A-High Hazard");
			}
			if (count(Constants.pw1_13_occupancy_classification_proposed) > 0) {
				select(Constants.pw1_13_occupancy_classification_proposed, "A-High Hazard");
			}
			if (count(Constants.pw1_13_2014_code_apply_no) > 0) {
				radio(Constants.pw1_13_2014_code_apply_no);
			}
			if (count(Constants.pw1_13_construction_classification_existing) > 0) {
				select(Constants.pw1_13_construction_classification_existing, "I-A 4-Hour Protected (Non-Combustible)");
			}
			if (count(Constants.pw1_13_construction_classification_proposed) > 0) {
				select(Constants.pw1_13_construction_classification_proposed, "I-A 4-Hour Protected (Non-Combustible)");
			}
			if (count(Constants.pw1_13_multiple_dwelling_classification) > 0) {
				select(Constants.pw1_13_multiple_dwelling_classification, "Class A-OL-Old Law Tenement");
			}
			select_val(Constants.pw1_13_building_type_8085, "1");
			if (!building_charcteristics.equals("X")){
				scrollDown();
			}
			wait(1);
			radio(Constants.pw1_13_mixed_use_type_no_8085);
			if (count(Constants.pw1_13_select_primary_structural_system) > 0) {
				select(Constants.pw1_13_select_primary_structural_system, "Concrete (CIP)");
			}
			if (count(Constants.pw1_13_select_structural_occupancy_risk_existing) > 0) {
				select(Constants.pw1_13_select_structural_occupancy_risk_existing, "I-Low Hazard to Human Life");
			}
			if (count(Constants.pw1_13_select_structural_occupancy_risk_proposed) > 0) {
				select(Constants.pw1_13_select_structural_occupancy_risk_proposed, "I-Low Hazard to Human Life");
			}
			if (count(Constants.pw1_13_select_seismic_design_existing) > 0) {
				select(Constants.pw1_13_select_seismic_design_existing, "Category A");
			}
			if (count(Constants.pw1_13_select_seismic_design_proposed) > 0) {
				select(Constants.pw1_13_select_seismic_design_proposed, "Category A");
			}
			if (count(Constants.pw1_13_dwelling_units_existing) > 0) { // Dwelling Units
				type(Constants.pw1_13_dwelling_units_existing, "41");
				type(Constants.pw1_13_dwelling_units_proposed, "42");
			}

			if (count(Constants.pw1_13_building_stories_existing) > 0) { // Building Code: Building Stories
				type(Constants.pw1_13_building_stories_existing, "1");
				type(Constants.pw1_13_building_stories_proposed, "2");
			}
			if (count(Constants.pw1_13_building_dwelling_units_existing) > 0) { // Structural Footprint
				type(Constants.pw1_13_building_dwelling_units_existing, "51");
				type(Constants.pw1_13_building_dwelling_units_proposed, "52");
			}
	 	} else {
			System.out.println(convertedTimestamp() + " **************** PW1 (Zoning Information tab) no enterBuildingCharacteristics");
	 	}
	}	
		
		public void buildingCharMixedSubs(String building_charcteristics) {
			if(building_charcteristics.equals("Y")){
				System.out.println(convertedTimestamp() + " **************** buildingCharMixedSubs");
				test = rep.startTest("buildingCharMixedSubs");
				radio(Constants.pw1_13_mixed_use_type_no);
				type(Constants.pw1_13_building_height_existing, "100");
				type(Constants.pw1_13_building_height_proposed, "111");
				type(Constants.pw1_13_building_stories_existing, "1");
				type(Constants.pw1_13_building_stories_proposed, "2");
				type(Constants.pw1_13_building_dwelling_units_existing, "50");
				type(Constants.pw1_13_building_dwelling_units_proposed, "51");
		 	}
		}
		
		// 15.Construction Equipment
		public void constructionEquipment(String equipment) {	
			if(!equipment.equals("")){
				System.out.println(convertedTimestamp() + " **************** PW1 constructionEquipment");
				String[] data = equipment.split(" :: ");
				if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-21
					click(Constants.pw1_15_construction_equipment_accordion); // open
				}
				if (count(Constants.construction_material_fence) > 0) {
					select(Constants.construction_material_fence, data[0]);
				}
				if (count(Constants.describe_construction_material) > 0) { // txtPWConstructionMaterial
					type(Constants.describe_construction_material, data[1]);
				}
				if (count(Constants.construction_material_sidewalk) > 0) { 
					type(Constants.construction_material_sidewalk, data[2]);
				}
//				if (count(Constants.pw1_15_sidewalk_construction_material) > 0) {
//					type(Constants.pw1_15_sidewalk_construction_material, data[2]);
//				}
				if (count(Constants.size_of_shed) > 0) {
					type(Constants.size_of_shed, data[3]);
				}
				if (count(Constants.pw1_15_sidewalk_bsa_mea_otcr_approval_number) > 0) {
					type(Constants.pw1_15_sidewalk_bsa_mea_otcr_approval_number, data[4]);
				}			
				if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-21
					click(Constants.pw1_15_construction_equipment_accordion); // close
				}
		 	} else {
		 		System.out.println(convertedTimestamp() + " **************** PW1 no constructionEquipment");
		 	}
		}
		
		
// 16. Curb Cut Description
	public void curbCutDescription(String accessto) {	
		if(!accessto.equals("")){
			test = rep.startTest("curbCutDescription");
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-21
				click(Constants.scope_of_work_step);
				waitUntilElementVisible(Constants.pw1_16_size_of_cutout_8085,30);
//				scrollTo(Constants.pw1_16_size_of_cutout_8085);
				scrollAllWayUp(); // JG 2018-11-26
				type(Constants.pw1_16_size_of_cutout_8085, "9");			
				type(Constants.pw1_16_distance_to_nearest_corner_8085, "10");			
				type(Constants.pw1_16_distance_from_nearest_property_8085, "11");
				select(Constants.pw1_16_which_side_nearest_to_property_8085, "West");
				type(Constants.pw1_16_to_streat_8085, "12");
//				type(Constants.pw1_16_size_of_cutout_8085, "11");
				click(Constants.pw1_16_this_curb_will_provide_access_to_8085);
				clickElement(Constants.link_xpath_part1 + accessto + Constants.link_xpath_part2);
				select(Constants.pw1_16_which_side_of_street_curb_on_8085, "East");
				radio(Constants.pw1_16_on_grade_no_8085);
				radio(Constants.pw1_16_over_vault_no_8085);
				radio(Constants.pw1_16_other_structure_no_8085);
				radio(Constants.pw1_16_sidewalk_within_8ft_no_8085);
				radio(Constants.pw1_16_sidewalk_to_destroy_no_8085);
				radio(Constants.pw1_16_infront_of_ajoining_no_8085);
				select(Constants.pw1_16_agencies_required_documents_8085, "MTA");
			} else {
				waitVisible("//span[text()='16. Curb Cut Description']");			
				waitUntilElementVisible(Constants.pw1_16_size_of_cutout, 30);
				type(Constants.pw1_16_size_of_cutout, "11");			
				type(Constants.pw1_16_distance_to_nearest_corner, "11");			
				type(Constants.pw1_16_distance_from_nearest_property, "11");
				select(Constants.pw1_16_which_side_nearest_to_property, "West");
				type(Constants.pw1_16_to_streat, "11");
				type(Constants.pw1_16_size_of_cutout, "11");
				click(Constants.pw1_16_this_curb_will_provide_access_to);
				clickElement(Constants.link_xpath_part1 + accessto + Constants.link_xpath_part2);
				select(Constants.pw1_16_which_side_of_street_curb_on, "East");
				
				radio(Constants.pw1_16_on_grade_no);
				radio(Constants.pw1_16_over_vault_no);
				radio(Constants.pw1_16_other_structure_no);
				radio(Constants.pw1_16_sidewalk_within_8ft_no);
				radio(Constants.pw1_16_sidewalk_to_destroy_no);
				radio(Constants.pw1_16_infront_of_ajoining_no);
				select(Constants.pw1_16_agencies_required_documents, "MTA");
			}		
/*			pw1_16_size_of_cutout.sendKeys("11");
			pw1_16_distance_to_nearest_corner.sendKeys("5");
			pw1_16_distance_from_nearest_property.sendKeys("100");
			pw1_16_which_side_nearest_to_property.sendKeys("West");
			pw1_16_to_streat.sendKeys("22");
			pw1_16_this_curb_will_provide_access_to.click();
			waitTime(1000);
			clickElement(Constants.link_xpath_part1 + accessto + Constants.link_xpath_part2);
			pw1_16_which_side_of_street_curb_on.sendKeys("East");
			pw1_16_on_grade_no.click();
			pw1_16_over_vault_no.click();
			pw1_16_other_structure_no.click();
			pw1_16_sidewalk_within_8ft_no.click();
			pw1_16_sidewalk_to_destroy_no.click();
			pw1_16_infront_of_ajoining_no.click();
			pw1_16_agencies_required_documents.sendKeys("MTA");*/
		}
	}
// 18. Fire Protection Equipment
	public void fireProtectionEquipment(String fireequipment) {	
		if(!fireequipment.equals("")){
			String[] data = fireequipment.split(" :: ");
			scrollToElement("//span[contains(text(),'Fire Protection Equipment')]");
			radio("//input[@name='rblPWExistFireAlarm'][@value='" +data[0]+ "']");
			radio("//input[@name='rblPWPropFireAlarm'][@value='" +data[1]+ "']");
			radio("//input[contains(@name,'rblPWExistFireSup')][@value='" +data[2]+ "']");
			radio("//input[contains(@name,'rblPWPropFireSup')][@value='" +data[3]+ "']");
		}
	}
	
	//18 Sign
	public void fireProtectionEquipment2(String fireequipment) {	
		if(!fireequipment.equals("")){
			radio(Constants.pw1_18_fire_alarm_existing_no);
			radio(Constants.pw1_18_fire_alarm_proposed_no);
			radio(Constants.pw1_18_sprinkler_existing_no);
			radio(Constants.pw1_18_sprinkler_proposed_no);
			radio(Constants.pw1_18_standpipe_existing_no);
			radio(Constants.pw1_18_standpipe_proposed_no);			
		}
	}	
	
// 20/20A/22/24. Site Characteristics	
	public void siteCharacteristics(String sitechar) {	
		if(!sitechar.equals("")){
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-01 TEST-ENV new PW1 UI - back to PW1 tab
				click(Constants.pw1_tab);
				click(Constants.pw1_20_site_characteristics_accordion); //JG 2018-11-29
				radio(Constants.pw1_20_tidal_wetlands_no_8085);
				radio(Constants.pw1_20_coastal_erosion_hazard_area_no);
				radio(Constants.pw1_20_fire_districs_no);
				radio(Constants.pw1_20_freshwater_wetlands_no);
				radio(Constants.pw1_20_urban_renewal_no);
				radio(Constants.pw1_20A_flood_hazard_area_no);
				click(Constants.pw1_22_asbestos_abatement_accordion); //JG 2018-11-29
				radio(Constants.pw1_22_exempt_from_asbestos);
				click(Constants.pw1_24_comments_accordion); //JG 2018-11-29
				type(Constants.pw1_24_comments, convertedTimestamp());
			} else {
				radio(Constants.pw1_20_tidal_wetlands_no);
				if(count(Constants.pw1_18_fire_alarm_proposed_no) > 0) {
					radio(Constants.pw1_18_fire_alarm_proposed_no);
				}
				radio(Constants.pw1_20_coastal_erosion_hazard_area_no);
				radio(Constants.pw1_20_fire_districs_no);
				radio(Constants.pw1_20_freshwater_wetlands_no);
				radio(Constants.pw1_20_urban_renewal_no);
				radio(Constants.pw1_20A_flood_hazard_area_no);
				radio(Constants.pw1_22_exempt_from_asbestos);
	//			type(Constants.pw1_comments_textarea, convertedTimestamp());
				type(Constants.pw1_24_comments, convertedTimestamp());
			}
		}
	}

	// 20. Enter Site Characteristics	
	public void enterSiteCharacteristics(String sitechar) {	
		if(!sitechar.equals("")){
			System.out.println(convertedTimestamp() + " **************** PW1 enterSiteCharacteristics");
			click(Constants.pw1_20_site_characteristics_accordion); // open
			
			radio(Constants.pw1_20_tidal_wetlands_no_8085);
			radio(Constants.pw1_20_coastal_erosion_hazard_area_no);
//			scrollToElement(Constants.pw1_9_additional_considerations_accordion);
//			wait(1);
			radio(Constants.pw1_20_fire_districs_no);
			radio(Constants.pw1_20_freshwater_wetlands_no);
			radio(Constants.pw1_20_urban_renewal_no);
			radio(Constants.pw1_20A_flood_hazard_area_no);
//			scrollAllWayUp();
//			wait(1);
			click(Constants.pw1_20_site_characteristics_accordion); // close
//			scrollDown();
//			click(Constants.pw1_22_asbestos_abatement_accordion); // open
//			radio(Constants.pw1_22_exempt_from_asbestos);
//			click(Constants.pw1_22_asbestos_abatement_accordion); // close
//			
//			click(Constants.pw1_24_comments_accordion); // open
//			type(Constants.pw1_24_comments, convertedTimestamp());
//			click(Constants.pw1_24_comments_accordion); // close
		}
	}

	// 22. Enter Asbestos Abatement Compliance	
	public void enterAsbestosAbatementCompliance(String sitechar) {	
		if(!sitechar.equals("")){
			System.out.println(convertedTimestamp() + " **************** PW1 enterAsbestosAbatementCompliance");
			click(Constants.pw1_22_asbestos_abatement_accordion); // open
			radio(Constants.pw1_22_exempt_from_asbestos);
			click(Constants.pw1_22_asbestos_abatement_accordion); // close
		}
	}
	
	// 24. Enter PW1 Comments	
	public void enterPw1Comments(String description) {	
		if(!description.equals("")){
			System.out.println(convertedTimestamp() + " **************** PW1 enterPw1Comments");
			click(Constants.pw1_24_comments_accordion); // open
			type(Constants.pw1_24_comments, convertedTimestamp() + " " + description);
			click(Constants.pw1_24_comments_accordion); // close
		} else {
			System.out.println(convertedTimestamp() + " **************** PW1 no enterPw1Comments");
		}
	}
	
	public void signDetails(String sign_details) {	
		if(!sign_details.equals("")){
			test = rep.startTest("signDetails");
			String[] data = sign_details.split(" :: ");
			System.out.println(convertedTimestamp() + " **************** Sign Details");
			test = rep.startTest("Sign Details");
			click(Constants.add_new_sign_button);
			email(user);
			type(Constants.sign_relationship, "Friend");			
			check(Constants.i_hereby_state);
			select(Constants.sign_purpose, data[0]);
			select(Constants.sign_material, data[1]);
			type(Constants.sign_weight, data[2]);
			type(Constants.sign_square_feet, data[3]);
			type(Constants.sign_zoning, data[4]);
			type(Constants.sign_surface, data[5]);
			type(Constants.sign_maximum_surface, data[6]);
			select(Constants.sign_type, data[7]);
			select(Constants.sign_type_of_illumination, data[8]);
			select(Constants.sign_location, data[9]);
			type(Constants.sign_height_above_curb, data[2]);
			type(Constants.sign_total_surface_area, data[3]);
			type(Constants.sign_estimated_cost, data[6]);
			type(Constants.sign_description, convertedTimestamp());
			radio(Constants.sign_changeable_copy_no);
			radio(Constants.sign_oak_have_an_interest_no);
			radio(Constants.sign_arterial_highway_no);
			radio(Constants.sign_within_view_of_park_no);
			click(Constants.save_button_sign);
			waitInvisible(Constants.save_button_sign);
			assertNotification("Sign details added successfully.", "Sign details");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			reportPass("signDetails");
		}
	}
	
/*	public void siteCharacteristicSigns(String sitechar) {	
		if(!sitechar.equals("")){
			radio(Constants.pw1_20_tidal_wetlands_no);
			radio(Constants.pw1_20_coastal_erosion_hazard_area_no);
			radio(Constants.pw1_18_fire_alarm_proposed_no);
			radio(Constants.pw1_20_fire_districs_no);
			radio(Constants.pw1_20_freshwater_wetlands_no);
			radio(Constants.pw1_20_urban_renewal_no);
			radio(Constants.pw1_20A_flood_hazard_area_no);
			radio(Constants.pw1_22_requires_asbestos_abatement_sign);
			type(Constants.pw1_comments_textarea, convertedTimestamp());
//			driver.findElement(By.xpath("//textarea[@id='txtPWComments']")).sendKeys("this is comments");			
		}
	}*/
		
// SAVE PW1	
	public void savePW1(String save) {	
		if(!save.equals("")){
			test = rep.startTest("Save PW1");
			scrollAllWayUp();
			scrollToElement(Constants.save_button);
			click(Constants.save_button);
			wait(2);
			if(count(Constants.pw1_confirm_save_button) > 0)
				click(Constants.pw1_confirm_save_button);
			waitVisible60(Constants.ok_button);
			wait(2);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "saveForm savePW1");
			wait(2);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			wait(2);
			waitClickableOr("//b[contains(text(),'Job#')]", "//strong[@class='ng-binding']");
			if (!save.equals("skip_number")) {
				if(count("//strong[@class='ng-binding']") > 0) { // ELECERICAL // JG 2018-11-01 also indicates new PW1 UI, but doesn't start with space, so go to 9. 
					addToProps("job_number", text(Constants.el_job_label).substring(0, 9).trim());
				} else {			
					addToProps("job_number", text(Constants.job_label).trim().substring(6, 15).trim());
				}
			}
	 	}
		reportPass("savePW1");
	}
		
	// Save Job
	public void saveJob(String save) {	
		if(!save.equals("")){
			System.out.println(convertedTimestamp() + " **************** PW1 saveJob");
			test = rep.startTest("saveJob");
			click(Constants.global_save_step_button);
			if (count(Constants.pw1_confirm_save_button_8085) > 0) {
				click(Constants.pw1_confirm_save_button_8085);
			}
			waitInvisible(Constants.global_loading_spinner);
			waitUntilElementVisible(Constants.ok_button, 30);
			wait(2);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "pw1 saved");
//			click(Constants.ok_button);
			wait(2);
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			wait(2);
			waitClickableOr("//b[contains(text(),'Job#')]", "//strong[@class='ng-binding']");
			if (save.equals("get_number")) {
				if(count("//strong[@class='ng-binding']") > 0) { // ELECERICAL // JG 2018-11-01 also indicates new PW1 UI, but doesn't start with space, so go to 9. 
					addToProps("job_number", text(Constants.el_job_label).substring(0, 9).trim());
				} else {			
					addToProps("job_number", text(Constants.job_label).trim().substring(6, 15).trim());
			 	}
			}
			reportPass("saveJob");
		}
	}
	
	public void savePW1_subs(String save) {	
		if(!save.equals("")){
			test = rep.startTest("Save PW1_subs");
			

			scrollAllWayUp();
			scrollToElement(Constants.save_button);
			click(Constants.save_button);
			wait(2);
			if(count(Constants.pw1_confirm_save_button) > 0)
				click(Constants.pw1_confirm_save_button);
			waitVisible60(Constants.ok_button);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "saveForm savePW1_subs");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
//			addToProps("job_number", text(Constants.job_label).trim().substring(0, 9).trim());
	 	}
	}

	public void previewToFile(String preview_to_file) {
		if(!preview_to_file.equals("")){
			System.out.println(convertedTimestamp() + " **************** " + "PreviewToFile");
			filterJob(user);
			test = rep.startTest("Preview To File");
			for (int i = 1; i <= 20; i++) {
				wait(2); // JG 2018-11-19
				click(Constants.preview_resubmit_button);
				waitUntilISpinnersInvisible();
				wait(3);
				if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-20 new PW1 UI asks to Confirm
					click(Constants.yes_button);
					waitUntilISpinnersInvisible();
					wait(2);
					break;
				}
				waitVisible(Constants.application_preview_label);
				waitVisible("//div[@class='hidden-xs col-md-2 pull-right']");
				waitVisible("//span[@class='label pull-right portal-fonts']");
				
				if (count("//*[contains(text(),'Getting Preview... 0%')]") > 0) { //	while (driver.getPageSource().contains("Getting Preview... 0%")) {
					click(Constants.return_to_filing_view);
					waitInvisible(Constants.return_to_filing_view);
					wait(1);
					click(Constants.preview_resubmit_button);
					waitUntilISpinnersInvisible();
					wait(2);
				}
				if (count(Constants.number_of_pages_label) > 0)
					break;
			}
			if (!CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-20
				for (int i = 1; i <= 50; i++) {
					click(Constants.click_go_next_button);
					wait(1);
					if (count(Constants.final_legal_contect_checkbox) > 0)
						break;
				}
				check(Constants.final_legal_contect_checkbox);
				click(Constants.file_button);
				waitInvisible(Constants.file_button);
				// JG 2018-12-16 moved the following inside the "if not 8085" statement:
	//			reportPass("previewToFile"); // JG 2018-12-16 I don't think this is needed, it's the last line of this method.
	//			waitVisible(Constants.ok_button); // JG 2018-12-04 is OK button supposed to be here for all paths? 
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("filing_message"));
				wait(1); // JG 2018-11-29 
				if (count(Constants.ok_button) > 0) {
					waitVisible(Constants.ok_button);
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}
			}
			assertFilingStatus("Pending");
			reportPass("previewToFile");
		}
	}	

	public void pAa(String paa) {	
		if(!paa.equals("")){
			System.out.println(convertedTimestamp() + " ****************  PAA PW1");
			test = rep.startTest("PAA PW1");
			type(Constants.job_description_for_new_work, convertedTimestamp());
			savePW1("Y");
//			addToProps("job_number", text(Constants.job_label).trim().substring(6, 15).trim());
		}
	}
	public void correction(String correction, String description) {	
		if(!correction.equals("")){
			test = rep.startTest("Correction");
			System.out.println(convertedTimestamp() + " **************** Correction PW1");
			waitVisible(Constants.global_save_step_button);
			waitVisible(Constants.job_description_for_new_work);
			clear(Constants.job_description_for_new_work);
			type(Constants.job_description_for_new_work, description + " "+ convertedTimestamp());
//			job_description_for_new_work.clear();
//			job_description_for_new_work.sendKeys("My Correction Test");
			waitVisible(Constants.global_save_step_button);
			scrollToElement(Constants.global_save_step_button);
			click(Constants.global_save_step_button);
//			waitVisible(Constants.global_loading_spinner);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "savePW1 correction");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			assertTextPresent(TEXT_PROPERTIES.getProperty("correction"), "correction");
			savePW1("Y");
			reportPass("correction");
		}
	}
	public void resolveObjections(String objections) {	
		if(!objections.equals("")){
			System.out.println(convertedTimestamp() + " **************** PW1 resolveObjections ");
			filterJob(OR_PROPERTIES.getProperty("user_email"));	
			test = rep.startTest("Resolve Objections");
			waitUntilElementVisible(Constants.global_save_step_button, 30);
			waitVisible(Constants.objections_view_details_button);
			click(Constants.objections_view_details_button);
			waitVisible(Constants.objections_status);
			select(Constants.objections_status, "Resolved");
			click(Constants.global_save_form_button);
			waitVisible(Constants.ok_button);
			assertNotification(TEXT_PROPERTIES.getProperty("objection_saved_successfully"), "resolve objections");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			scrollToElement(Constants.global_save_step_button);
			waitUntilElementVisible(Constants.global_save_step_button, 30);
			click(Constants.global_save_step_button);
			waitVisible(Constants.global_loading_spinner);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "savePW1 objections");
			clickButton("OK");
			waitInvisible(Constants.ok_button);
			assertTextPresent(TEXT_PROPERTIES.getProperty("objections"), "objections");
			reportPass("resolveObjections");
		}
	}
	
/*	public void assertFilingStatusPaa(String assert_filing_status_paa) {
		if(!assert_filing_status_paa.equals("")){
			waitInvisible(Constants.ok_button);
			assertFilingStatus(assert_filing_status_paa);
		}
	}*/

}
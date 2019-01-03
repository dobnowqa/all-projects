package com.pages;

import org.openqa.selenium.By;
import com.base.TestBase;
import com.util.Constants;

public class DobSOWPage extends TestBase {
/*	WebDriver driver;
	public DobSOWPage(WebDriver dr) {
		driver = dr;
	}*/
	
	public void scopeOfWork(String asw) {	
		if(!asw.equals("")){
			System.out.println(convertedTimestamp() + " **************** SOW scopeOfWork");
//			filterJob(user);		
			test = rep.startTest("ASW");
//			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-02: new PW1 UI
//				refreshPage(); //JG 2018-11-02: need to refresh for elements to be clickable
//			}
//			click(Constants.antenna_scope_of_work_step);
			click(Constants.scope_of_work_step);
			scrollAllWayUp();
			waitVisible(Constants.asw_specify_supporting_structures_for_antenna_array_rrh);
			String[] data = asw.split(" :: ");
			wait(1); // JG 2018-11-19
			if(data[0].contains("Y"))
				radio(Constants.asw_are_new_antenna_rrh_array_prposed_yes);
			else
				radio(Constants.asw_are_new_antenna_rrh_array_prposed_no);
			if(count("//button[contains(text(),'Select')]") > 0){
				click("//button[contains(text(),'Select')]");
//				click(Constants.asw_specify_supporting_structures_for_antenna_array_rrh);
				click(Constants.link_xpath_part1 + data[1] + Constants.link_xpath_part2);
			}
			if(data[2].contains("separate"))
				radio(Constants.asw_structural_work_seperate);
			if(data[3].contains("existing"))
				radio(Constants.asw_emergency_power_system_existing);	
			if(data[4].contains("N"))
				radio(Constants.asw_associated_mechanical_work_proposed_no);
			type(Constants.asw_what_floor_associated_equipment_located, "1");
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.global_notification_ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			click(Constants.global_notification_ok_button);
			waitInvisible(Constants.global_notification_ok_button);
		}
	}
	public void scopeOfWorkPlumbingNew(String sow) {
		if (!sow.equals("")) {
			String[] data = sow.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** scopeOfWorkPlumbingNew");
//			filterJob(user);
			test = rep.startTest("scopeOfWorkPlumbingNew");
			click(Constants.scope_of_work_step);
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-11-27
				// Add SOW-PL using new UI: Gas, New Installation, Regular Installation
				scrollAllWayUp();
				if (count(Constants.sow_pl_gas) > 0) {
					check(Constants.sow_pl_gas);
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					wait(2);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					wait(2);
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}
				click(Constants.sow_pl_add_sow_pl);
				select_val(Constants.sow_pl_select_scope_includes, "1");
				select(Constants.sow_pl_select_type, "Regular Installation");
				type(Constants.sow_pl_total_quantity, "1");
				click(Constants.sow_pl_work_on_floor_check);
				click(Constants.sow_pl_save_button);
				// JG 2010-01-02 per bug 20863, there is no OK pop-up, so instead click Save
				waitVisible(Constants.ok_button);
				if (count(Constants.ok_button) > 0) {
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				} else {
					click(Constants.global_save_step_button);
					waitInvisible(Constants.global_loading_spinner);
					waitUntilElementVisible(Constants.ok_button, 30);
					wait(2);
					assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "pw1 saved");
					wait(2);
					clickButton("OK");
					waitInvisible(Constants.ok_button);
					wait(2);
				}
				// JG 2018-11-29 add the following for new UI:
				wait(2);
				scrollDown();
				if (count(Constants.sow_pl_select_operating_pressure) > 0) {
					select(Constants.sow_pl_select_operating_pressure, "Low Pressure");
					check(Constants.sow_pl_riser_information_na);
					check(Constants.sow_pl_type_of_meter_individual);
					click(Constants.sow_pl_add_work_on_floors);
					select(Constants.sow_pl_select_work_on_floors_type, "Individual");
					select(Constants.sow_pl_select_work_on_floors_location, "Ground Floor");
					type(Constants.sow_pl_work_on_floors_quantity, "1");
					click(Constants.sow_pl_save_button);
					waitInvisible(Constants.sow_pl_save_button);
					scrollAllWayDown();
					check(Constants.sow_pl_gas_use_cooking_residential);
					check(Constants.sow_pl_appliances_cooking_residential);
					type(Constants.sow_pl_appliances_cook_equip_res_qty, "1");
				} else {
					scrollUp();
					check(Constants.sow_sp_type_antifreeze);
					select(Constants.sow_sp_select_primary_Water_sytem, "N/A");
					select(Constants.sow_sp_select_secondary_Water_sytem, "N/A");
					scrollTo(Constants.sow_sp_reference_standard_nfpa13);
					check(Constants.sow_sp_reference_standard_nfpa13);
					select(Constants.sow_sp_select_design_criteria, "Pipe Schedule");
					check(Constants.sow_sp_specify_pump_na);
				}
			} else {
				int b = 0, c = 1;
				for (int i = 1; i <= 5; i++) {
					waitVisible("//span[text()='Work Type']");
					multiClick(Constants.add);
					waitVisible(Constants.sow_modal);
					waitVisible(Constants.sow_detail_select_category);
					select(Constants.sow_detail_select_category, data[b + i]);
					wait(1);
					select(Constants.sow_detail_select_scope_includes, data[c + b + i]);
					if (driver.findElement(By.xpath("//input[@id='txtSDNumOfUnits']")).isDisplayed())
						type("//input[@id='txtSDNumOfUnits']", "1");
					if (driver.findElement(By.xpath("//input[@id='txtSDFloor']")).isDisplayed())
						type("//input[@id='txtSDFloor']", "1");
					if (driver.findElement(By.xpath("//input[@id='txtSDTypeOfUnit']")).isDisplayed())
						type("//input[@id='txtSDTypeOfUnit']", "1");
					click(Constants.global_save_form_button);
					waitInvisible(Constants.global_save_form_button);
					wait(3);
					if (count(Constants.trash_can_icon) == num_items)
						break;
					b = b + 1;
				}
			}
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
	}
	public void scopeOfWorkPlumbingLegalization(String sow) {
		if (!sow.equals("")) {
			String[] data = sow.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** scopeOfWorkPlumbingLegalization");
//			filterJob(user);
			test = rep.startTest("scopeOfWorkPlumbingLegalization");
			click(Constants.scope_of_work_step);
			int b = 0, c = 1;
			for (int i = 1; i <= 5; i++) {
				waitVisible("//span[text()='Work Type']");
				multiClick("(" + Constants.add + ")[2]");
				waitVisible(Constants.sow_modal);
				waitVisible(Constants.sow_detail_select_category);
				select(Constants.sow_detail_select_category, data[b + i]);
				wait(1);
				select(Constants.sow_detail_select_scope_includes, data[c + b + i]);
				if (driver.findElement(By.xpath("//input[@id='txtSDNumOfUnits']")).isDisplayed())
					type("//input[@id='txtSDNumOfUnits']", "1");
				if (driver.findElement(By.xpath("//input[@id='txtSDFloor']")).isDisplayed())
					type("//input[@id='txtSDFloor']", "1");
				if (driver.findElement(By.xpath("//input[@id='txtSDTypeOfUnit']")).isDisplayed())
					type("//input[@id='txtSDTypeOfUnit']", "1");
				click(Constants.global_save_form_button);
				waitInvisible(Constants.global_save_form_button);
				wait(3);
				if (count(Constants.trash_can_icon) >= num_items)
					break;
				b = b + 1;
			}
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
	}
	public void scopeOfWorkPlumbing(String sow) {
		if (!sow.equals("")) {
			String[] data = sow.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** scopeOfWorkPlumbing");
//			filterJob(user);
			test = rep.startTest("ASW");
			click(Constants.scope_of_work_step);
			
			if (CONFIG.getProperty("env").contains("8085")) { //JG 2018-12-03 Add SOW-SD using new UI
				scrollAllWayUp();
				click("//span[text()='Add scope of work']");
				select("//select[@id='SOWInstallationWork']", "New Installation");
				select("//select[@id='SOWInstallationType']", "Regular Installation");
				type("//input[@id='SOWTotalQuantity']", "1");
				check("//input[@type='checkbox'][@ng-model='row.entity.isSelected']");
				click("//button[@type='submit']");
				clickButton("OK");
				wait(1);
				check(Constants.sow_sd_type_automatic_sd);
				select(Constants.sow_sd_select_class, "I");
				radio(Constants.sow_sd_combined_sd_sp_no);
				select(Constants.sow_sd_select_primary_water_system, "N/A");
				select(Constants.sow_sd_select_secondary_water_system, "N/A");
				scrollTo(Constants.sow_sd_reference_standard_nfpa14);
				check(Constants.sow_sd_reference_standard_nfpa14);
				select(Constants.sow_sd_select_design_criteria, "Pipe Schedule");
				check(Constants.sow_sd_pump_na);
			} else {
				int b = 0, c = 1;
				for (int i = 1; i <= 5; i++) {
					waitVisible("//span[text()='Work Type']");
					multiClick(Constants.add);
					waitVisible(Constants.sow_modal);
					waitVisible(Constants.sow_detail_select_category);
					select(Constants.sow_detail_select_category, data[b + i]);
					wait(1);
					select(Constants.sow_detail_select_scope_includes, data[c + b + i]);
					if (driver.findElement(By.xpath("//input[@id='txtSDNumOfUnits']")).isDisplayed()) {
						type("//input[@id='txtSDNumOfUnits']", "1");}
					if (driver.findElement(By.xpath("//input[@id='txtSDFloor']")).isDisplayed()) {
						type("//input[@id='txtSDFloor']", "1");}
					if (driver.findElement(By.xpath("//input[@id='txtSDTypeOfUnit']")).isDisplayed()) {
						type("//input[@id='txtSDTypeOfUnit']", "1");}
					click(Constants.global_save_form_button);
					waitInvisible(Constants.global_save_form_button);
					wait(3);
					if (count(Constants.trash_can_icon) == num_items) {
						break;}
					b = b + 1;
				}
				if(num_items >= 2) {
					b = 0;
					c = 1;
					for (int i = 1; i <= 5; i++) {
						waitVisible("//span[text()='Work Type']");
						multiClick("(" + Constants.add + ")[2]");
						waitVisible(Constants.sow_modal);
						waitVisible(Constants.sow_detail_select_category);
						select(Constants.sow_detail_select_category, data[b + i]);
						wait(1);
						select(Constants.sow_detail_select_scope_includes, data[c + b + i]);
						if (driver.findElement(By.xpath("//input[@id='txtSDNumOfUnits']")).isDisplayed()) {
							type("//input[@id='txtSDNumOfUnits']", "1");}
						if (driver.findElement(By.xpath("//input[@id='txtSDFloor']")).isDisplayed()) {
							type("//input[@id='txtSDFloor']", "1"); }
						if (driver.findElement(By.xpath("//input[@id='txtSDTypeOfUnit']")).isDisplayed()) {
							type("//input[@id='txtSDTypeOfUnit']", "1"); }
						click(Constants.global_save_form_button);
						waitInvisible(Constants.global_save_form_button);
	//					b = b + 1;
						wait(2);
						if (count(Constants.trash_can_icon) >+ num_items) {
							break; }
						b = b + 1;
					}
				}
			}
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			clickButton("OK");
			waitInvisible(Constants.ok_button);
		}
	}
	
	public void enterScopeOfWorkStructural(String sow) {
		if (!sow.equals("")) {
			String[] data = sow.split(" :: "); // JG 2018-12-05 TODO: Use 'data' to dynamically select options.
			System.out.println(convertedTimestamp() + " **************** SOW enterScopeOfWorkStructural");
			test = rep.startTest("ASW");
			click(Constants.scope_of_work_step);
			scrollAllWayUp();
			radio(Constants.sow_st_prefab_wood_joists_no);
			radio(Constants.sow_st_cold_formed_steel_no);
			radio(Constants.sow_st_open_web_steel_posts_no);
			
			if (!data[1].equals("N"))
				check("//input[@ng-model='STScopeOfWork.STConcreteType']"); // Concrete
			if (!data[2].equals("N"))
				check("//input[@ng-model='STScopeOfWork.STAluminumType']"); // Aluminum 
			if (!data[3].equals("N"))
				check("//input[@ng-model='STScopeOfWork.STMasonryType']"); // Masonry
			if (!data[4].equals("N"))
				check("//input[@ng-model='STScopeOfWork.STSteelType']"); // Steel
			if (!data[5].equals("N"))
				check("//input[@ng-model='STScopeOfWork.STWoodType']"); // Wood
			if (!data[6].equals("N"))
				check("//input[@ng-model='STScopeOfWork.STSignStructureType']"); // Sign Structure
			if (!data[7].equals("N"))
				check("//input[@ng-model='STScopeOfWork.STTemporaryStructuralBracingType']"); // Temporary Structural Bracing
			if (!data[8].equals("N"))
				check("//input[@ng-model='STScopeOfWork.GCPartialDemolitionType']"); // Partial Demolition
			if (!data[9].equals("N"))
				check("//input[@ng-model='STScopeOfWork.RaisingAndMovingofbuildings']"); // Raising and Moving of Buildings
			if (!data[10].equals("N"))
				check("//input[@ng-model='STScopeOfWork.STOtherMiscellaneousType']"); // Other/Miscellaneous
			
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
//			clickButton("OK"); // JG 2018-12-06 not clickable, try constant instead...
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
		}
	}

	public void addScopeOfWorkMechanicalSystems(String sow) {
		if (!sow.equals("")) {
			String[] data = sow.split(" :: "); // JG 2018-12-05 TODO: Use 'data' to dynamically select options.
			System.out.println(convertedTimestamp() + " **************** SOW addScopeOfWorkMechanicalSystems");
			test = rep.startTest("ASW");
			click(Constants.scope_of_work_step);
			scrollAllWayUp();
			click(Constants.sow_ms_button_add);
			select(Constants.sow_ms_select_sub_category, "Heating Systems");
			
			type(Constants.sow_ms_item_name, "Test Item Name");
			type(Constants.sow_ms_item_description,"Test Item Description");
			type(Constants.sow_ms_item_location, "Test Item Location");
			type(Constants.sow_ms_number_of_items, "2");
			type(Constants.sow_ms_capacity_number, "3");
			select(Constants.sow_ms_select_capacity_units, "BTU");
			type(Constants.sow_ms_equipment_efficiency, "4");
			select(Constants.sow_ms_select_equipment_units, "COP");
			type(Constants.sow_ms_manufacturer_name, "Test Manufacturer Name");
			type(Constants.sow_ms_model_name, "Test Model Name");
			radio(Constants.sow_ms_certificate_of_compliance_no);
			type(Constants.sow_ms_certificate_number_for_listing, "Test Certification Number");
			click(Constants.sow_ms_mechanical_information_add);
			type(Constants.sow_ms_sum_total_heating, "1000");
			type(Constants.sow_ms_sum_total_cooling, "20000");
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
//			clickButton("OK"); // JG 2018-12-06 not clickable, try constant instead...
			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
		}
	}

	public void enterScopeOfWorkBoilerEquipment(String sow) {
		if (!sow.equals("")) {
			String[] data = sow.split(" :: "); // JG 2018-12-05 TODO: Use 'data' to dynamically select options.
			System.out.println(convertedTimestamp() + " **************** SOW enterScopeOfWorkBoilerEquipment");
			test = rep.startTest("ASW");
			click(Constants.scope_of_work_step);
			scrollAllWayUp();
			click(Constants.sow_be_boiler_specifications_accordion);
			select(Constants.sow_be_select_proposed_boiler_rating, "High Pressure");
			type(Constants.sow_be_proposed_max_allowable_wp, "1000");
			select(Constants.sow_be_select_proposed_boiler_type, "Hot Water Heating");
			select(Constants.sow_be_select_proposed_boiler_energy_source, "Electric");
			select(Constants.sow_be_select_proposed_boiler_classification, "Conventional(Standard)");
			type(Constants.sow_be_sum_total_rated_input_capacity, "2000");
			scrollAllWayUp();
			click(Constants.sow_be_boiler_specifications_accordion);
			
			click(Constants.sow_be_chimney_information_accordion);
			select(Constants.sow_be_select_connected_to_vent_or_chimney, "Chimney");
//			radio(Constants.sow_be_radio_new_installation_of_chimney_yes);
			radio(Constants.sow_be_radio_new_installation_of_chimney_no);
//			type(Constants.sow_be_job_number_of_associated_chimney_work, "???");
//			select(Constants.sow_be_select_type_of_venting_material, "Stainless Steel");
			select(Constants.sow_be_select_chimney_lining, "The chimney does not require lining");
			click(Constants.sow_be_chimney_information_accordion);
			
/* comment out until this is implemented, scheduled for 2019-01-03
			click(Constants.sow_be_oil_burner_lmp_accordion);
//			email(Constants.sow_be_select_ob_lmp_email, "boilersoil@gmail.com");
			email2("boilersoil@gmail.com");
			select(Constants.sow_be_select_license_type, "Oil Burner Installer");
//			check(Constants.sow_be_check_licensed_installer);
			click(Constants.sow_be_oil_burner_lmp_accordion);
*/
						
			click(Constants.global_save_step_button);
			waitUntilISpinnersInvisible();
			waitVisible(Constants.ok_button);
			wait(2);
			verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
			wait(2);
			clickButton("OK");
//			click(Constants.ok_button);
			waitInvisible(Constants.ok_button);
		}
	}
	
	public void scopeOfWorkScaffold(String asw) {
		if (!asw.equals("")) {
			String[] data = asw.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** scopeOfWorkScaffold");
//			filterJob(user);
			test = rep.startTest("scopeOfWorkScaffold");
			click(Constants.scope_of_work_step);
			for (int i = 1; i <= 5; i++) {
				waitVisible("//span[text()='Supported Scaffold']");
				if (!data[1].contains("N"))
					check(Constants.sidewalk_shed);
				if (!data[2].contains("N"))
					check(Constants.construction_fence);
				select(Constants.scaffold_type, data[3]);
				radio(Constants.scaffold_going_to_extend_no);
				select(Constants.how_scaffold_supported, data[5]);
				radio(Constants.scaffold_any_related_equipment_no);
				wait(1);
				if (count(Constants.completed_checkmark) > 0) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}
				scrollAllWayDown();
				if(count("//span[text()='Sidewalk Shed']") > 0) {
					select(Constants.shed_type, data[7]);
					radio(Constants.sidewalk_going_to_extend_no);
					select(Constants.how_shed_supported, data[9]);
					radio(Constants.sidewalk_any_related_equipment_no);
					if(count("//button[contains(text(),'Select')]") > 0) {
						click("//button[contains(text(),'Select')]");
						click("(//a[contains(.,'" + data[11] + "')])[last()]");
					}
					wait(1);
					if (count(Constants.completed_checkmark) > 1) {
						click(Constants.global_save_step_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
					}
				}
				scrollAllWayDown();
				if(count("//span[text()='Construction Fence']") > 0) {
					type(Constants.fence_height, data[12]);
					select(Constants.fence_location, data[13]);
					wait(1);
					if (count(Constants.completed_checkmark) > 2) {
						click(Constants.global_save_step_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
					}
				}
				if (count(Constants.completed_checkmark) == num_items) {
					reportPass("scopeOfWorkScaffold");
					break;
				}
			}
		}
	}
	public void scopeOfWorkSidewalk(String asw) {
		if (!asw.equals("")) {
			String[] data = asw.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** scopeOfWorkSidewalk");
//			filterJob(user);
			test = rep.startTest("scopeOfWorkSidewalk");
			click(Constants.scope_of_work_step);
			for (int i = 1; i <= 5; i++) {
/*				waitVisible("//span[text()='Supported Scaffold']");
				if (!data[1].contains("N"))
					check(Constants.sidewalk_shed);
				if (!data[2].contains("N"))
					check(Constants.construction_fence);
				select(Constants.scaffold_type, data[3]);
				radio(Constants.scaffold_going_to_extend_no);
				select(Constants.how_scaffold_supported, data[5]);
				radio(Constants.scaffold_any_related_equipment_no);
				wait(1);
				if (count(Constants.completed_checkmark) > 0) {
					click(Constants.global_save_step_button);
					waitUntilISpinnersInvisible();
					waitVisible(Constants.ok_button);
					verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
					clickButton("OK");
					waitInvisible(Constants.ok_button);
				}*/
				scrollAllWayDown();
				if(count("//span[text()='Sidewalk Shed']") > 0) {
					select(Constants.shed_type, data[3]);
					radio(Constants.sidewalk_going_to_extend_no);
					select(Constants.how_shed_supported, data[5]);
					radio(Constants.sidewalk_any_related_equipment_no);
					if(count("//button[contains(text(),'Select')]") > 0) {
						click("//button[contains(text(),'Select')]");
						click("(//a[contains(.,'" + data[7] + "')])[last()]");
					}
					wait(1);
					if (count(Constants.completed_checkmark) > 0) {
						click(Constants.global_save_step_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
					}
				}
/*				scrollAllWayDown();
				if(count("//span[text()='Construction Fence']") > 0) {
					type(Constants.fence_height, data[12]);
					select(Constants.fence_location, data[13]);
					wait(1);
					if (count(Constants.completed_checkmark) > 2) {
						click(Constants.global_save_step_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
					}
				}*/
				if (count(Constants.completed_checkmark) == num_items) {
					reportPass("scopeOfWorkSidewalk");
					break;
				}
			}
		}
	}
	public void scopeOfWorkFence(String asw) {
		if (!asw.equals("")) {
			String[] data = asw.split(" :: ");
			int num_items = Integer.valueOf(data[0]);
			System.out.println(convertedTimestamp() + " **************** scopeOfWorkFence");
//			filterJob(user);
			test = rep.startTest("scopeOfWorkFence");
			click(Constants.scope_of_work_step);
			for (int i = 1; i <= 5; i++) {
				scrollAllWayDown();
				if(count("//span[text()='Construction Fence']") > 0) {
					type(Constants.fence_height, data[3]);
					select(Constants.fence_location, data[4]);
					wait(1);
					if (count(Constants.completed_checkmark) > 0) {
						click(Constants.global_save_step_button);
						waitUntilISpinnersInvisible();
						waitVisible(Constants.ok_button);
						verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
						clickButton("OK");
						waitInvisible(Constants.ok_button);
					}
				}
				if (count(Constants.completed_checkmark) == num_items) {
					reportPass("scopeOfWorkFence");
					break;
				}
			}
		}
	}

}
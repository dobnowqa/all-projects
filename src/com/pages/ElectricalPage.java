package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.base.TestBase;
import com.util.Constants;

public class ElectricalPage extends TestBase {
	WebDriver driver;
	public ElectricalPage(WebDriver dr) {
		driver = dr;
	}
	
// Location Info
	@FindBy(xpath=Constants.el_gi_house_number)
	public WebElement el_gi_house_number;
	@FindBy(xpath=Constants.el_gi_street_name)
	public WebElement el_gi_street_name;
	@FindBy(xpath=Constants.el_gi_borough)
	public WebElement el_gi_borough;
	@FindBy(xpath=Constants.el_gi_block)
	public WebElement el_gi_block;
	@FindBy(xpath=Constants.el_gi_lot)
	public WebElement el_gi_lot;
	@FindBy(xpath=Constants.el_ge1_job_description)
	public WebElement el_ge1_job_description;
	@FindBy(xpath=Constants.el_gi_job_start_date_calendar)
	public WebElement el_gi_job_start_date_calendar;
	@FindBy(xpath=Constants.el_gi_calendar_active_day)
	public WebElement el_gi_calendar_active_day;	
	@FindBy(xpath=Constants.el_gi_job_completion_date_calendar)
	public WebElement el_gi_job_completion_date_calendar;
	@FindBy(xpath=Constants.el_gi_job_completion_last_day)
	public WebElement el_gi_job_completion_last_day;
	@FindBy(xpath=Constants.el_calendar_next_month_arrow)
	public WebElement el_calendar_next_month_arrow;
	@FindBy(xpath=Constants.el_gi_job_is_this_joint_venture_yes)
	public WebElement el_gi_job_is_this_joint_venture_yes;
	@FindBy(xpath=Constants.el_gi_job_is_this_joint_venture_no)
	public WebElement el_gi_job_is_this_joint_venture_no;
	@FindBy(xpath=Constants.el_gi_building_use_type)
	public WebElement el_gi_building_use_type;
	
	@FindBy(xpath=Constants.plumbing_work_on_floors)
	public WebElement plumbing_work_on_floors;
	// Work on Floor Antenna
	@FindBy(xpath=Constants.pw1_1_add_work_floors_button)
	public WebElement pw1_1_add_work_floors_button;	
	@FindBy(xpath=Constants.pw1_1_work_on_floors_select_code_and_description)
	public WebElement pw1_1_work_on_floors_select_code_and_description;
	@FindBy(xpath=Constants.pw1_1_work_on_floors_floor_number_from)
	public WebElement pw1_1_work_on_floors_floor_number_from;
	@FindBy(xpath=Constants.pw1_1_work_on_floors_floor_number_to)
	public WebElement pw1_1_work_on_floors_floor_number_to;
	@FindBy(xpath=Constants.pw1_1_work_on_floors_description_of_work)
	public WebElement pw1_1_work_on_floors_description_of_work;
	@FindBy(xpath=Constants.pw1_1_work_on_floors_add_button)
	public WebElement pw1_1_work_on_floors_add_button;
	@FindBy(xpath=Constants.el_gi_applicant_email)
	public WebElement el_gi_applicant_email;
	@FindBy(xpath=Constants.el_gi_applicant_license_type)
	public WebElement el_gi_applicant_license_type;
	@FindBy(xpath=Constants.el_gi_owner_email)
	public WebElement el_gi_owner_email;	
	@FindBy(xpath=Constants.el_gi_owner_type)
	public WebElement el_gi_owner_type;
	
	
// 1. Location Info	
	public void locationInfo(String address,String description,String calendar,String joint_venue,String use_type) {	
		if(!address.equals("")){
			test = rep.startTest("location Imformation");
			System.out.println(convertedTimestamp() + " **************** " + "General Info");
			waitUntilISpinnersInvisible();
			String[] loc = address.split("::");
			type(Constants.el_gi_house_number, loc[0]);
			type(Constants.el_gi_street_name,loc[1]);
			select(Constants.el_gi_borough, loc[2]);
			type(Constants.el_gi_block, loc[3]);
			type(Constants.el_gi_lot, loc[4]);
			type(Constants.el_ge1_job_description, description + " "+ convertedTimestamp());
	 		click(Constants.el_gi_job_start_date_calendar);
	 		click(Constants.el_gi_calendar_active_day);
	 		keyPressTab(Constants.el_gi_job_start_date_calendar);
	 		click(Constants.el_gi_job_completion_date_calendar);
			if(calendar.equals("current"))
				click(Constants.el_gi_calendar_active_day);
			if(calendar.equals("next")) {
				click(Constants.el_calendar_next_month_arrow);
				click(Constants.el_gi_job_completion_last_day);
			}
			keyPressTab(Constants.el_gi_job_completion_date_calendar);
			if(joint_venue.equals("Yes"))
				radio(Constants.el_gi_job_is_this_joint_venture_yes);
			if(joint_venue.equals("No"))
				radio(Constants.el_gi_job_is_this_joint_venture_no);
	 		select(Constants.el_gi_building_use_type, use_type);
		}
	}
	public void locationOLDImformation(String house, String street,String borough,String block,String  lot,String description, String use_type,String joint_venue,String sow) {	
		if(!house.equals("")){
			test = rep.startTest("location Imformation");
			System.out.println(convertedTimestamp() + " **************** " + "General Info");
			waitUntilISpinnersInvisible();
			type(Constants.el_gi_house_number, house);
			type(Constants.el_gi_street_name, street);
			type(Constants.el_gi_borough, borough);
			type(Constants.el_gi_block, block);
			type(Constants.el_gi_lot, lot);
			type(Constants.el_ge1_job_description, description + " "+ convertedTimestamp());
	 		click(Constants.el_gi_job_start_date_calendar);
	 		click(Constants.el_gi_calendar_active_day);
	 		click(Constants.el_gi_job_completion_date_calendar);
			if(sow.equals("NEW INSTALLATION") || sow.equals("Field Sign Inspection")) {
				click(Constants.el_calendar_next_month_arrow);
				click(Constants.el_gi_job_completion_last_day);
			}
			if(sow.equals("Minor Work"))
				click(Constants.el_gi_calendar_active_day);
			if(joint_venue.equals("Yes"))
				radio(Constants.el_gi_job_is_this_joint_venture_yes);
			if(joint_venue.equals("No"))
				radio(Constants.el_gi_job_is_this_joint_venture_no);
			select(Constants.el_gi_building_use_type, use_type);
		}
	}

	public void workOnFloors(String work_on_floors, String work_type_subs, String use_type_subs) {
		if(!work_on_floors.equals("")){
			test = rep.startTest("Work On Floors");
			if(work_type_subs.contains("Plumbing")||work_type_subs.contains("Sprinklers")||work_type_subs.contains("StandPipe")) {
				waitUntilElementVisible(Constants.plumbing_work_on_floors, 30);
				plumbing_work_on_floors.sendKeys(work_on_floors);
			}
			if(work_type_subs.contains("Antenna")||work_type_subs.contains("SidewalkShed")||work_type_subs.contains("SupportedScaffold")||work_type_subs.contains("Sign")||work_type_subs.contains("ConstructionFence")) {
				waitUntilElementVisible(Constants.pw1_1_add_work_floors_button, 30);
		 		pw1_1_add_work_floors_button.click();
		 		waitUntilElementVisible(Constants.pw1_1_work_on_floors_select_code_and_description, 30);
		 		pw1_1_work_on_floors_select_code_and_description.sendKeys("Attic");
		 		pw1_1_work_on_floors_floor_number_from.sendKeys("1");
		 		pw1_1_work_on_floors_floor_number_to.sendKeys("1");
//		 		pw1_1_work_on_floors_description_of_work.sendKeys("work_on_floors.contains(Antenna)" + " " + convertedTimestamp());
		 		waitUntilElementVisible(Constants.pw1_1_work_on_floors_add_button, 30);
		 		pw1_1_work_on_floors_add_button.click();	
			}
			if(work_type_subs.contains("Electrical")) {
				waitUntilElementVisible(Constants.el_ge1_job_description, 30);
		 		el_ge1_job_description.sendKeys(convertedTimestamp());
/*		 		el_gi_job_start_date_calendar.click();
		 		waitUntilElementVisible(Constants.el_gi_calendar_active_day, 30);
		 		el_gi_calendar_active_day.click();
				el_gi_job_completion_date_calendar.click();
				waitUntilElementVisible(Constants.el_calendar_next_month_arrow, 30);
				el_calendar_next_month_arrow.click();
				waitUntilElementVisible(Constants.el_gi_job_completion_last_day, 30);
				el_gi_job_completion_last_day.click();*/
				el_gi_job_is_this_joint_venture_no.click();
				el_gi_building_use_type.sendKeys(use_type_subs);
			}

	 	}
	}
	
// 2. Applicant Info
	public void applicantInfo(String applicant_info) {	
		if(!applicant_info.equals("")){
			test = rep.startTest("Applicant Info");
			type(Constants.el_ge1_job_description, convertedTimestamp());
	 		String emailpreview = Constants.email_xpath_part1 + OR_PROPERTIES.getProperty("electical_applicant_email") + Constants.email_xpath_part2;
 			for (int i = 1; i < 100; i++) {
			clear(Constants.el_gi_applicant_email);
			send(Constants.el_gi_applicant_email, OR_PROPERTIES.getProperty("electical_applicant_email"));
			wait(1);
			if (count(emailpreview) > 0)
				break;
		}
			clickElement(emailpreview);
			select(Constants.el_gi_applicant_license_type, OR_PROPERTIES.getProperty("applicant_lisence_type_electrical"));
	 	}
	}
	
	public void applicantInfoMixed(String applicant_info) {	
		if(!applicant_info.equals("")){
		test = rep.startTest("applicantInfoMixed");
		type(Constants.el_ge1_job_description, convertedTimestamp());
		String emailpreview = Constants.email_xpath_part1 + OR_PROPERTIES.getProperty("electical_applicant_email") + Constants.email_xpath_part2;
			for (int i = 1; i <= 20; i++) {
				clear(Constants.el_gi_owner_email);
				send(Constants.el_gi_owner_email, OR_PROPERTIES.getProperty("electical_applicant_email"));
				wait(1);
				if (count(emailpreview) > 0)
					break;
			}
			clickElement(emailpreview);
			select(Constants.el_gi_applicant_license_type, OR_PROPERTIES.getProperty("applicant_lisence_type_electrical"));
	 	}
	}
	
	public void ownerInfo(String owner_info) {	
		if(!owner_info.equals("")){
			
			test = rep.startTest("Owner Info");
			String emailpreview = Constants.email_xpath_part1 + OR_PROPERTIES.getProperty("electrical_owner_email") + Constants.email_xpath_part2;
			for (int i = 1; i <= 20; i++) {
				clear(Constants.el_gi_owner_email);
				send(Constants.el_gi_owner_email, OR_PROPERTIES.getProperty("electrical_owner_email"));
				wait(1);
				if (count(emailpreview) > 0)
					break;
			}
			click(emailpreview);
			select(Constants.el_gi_owner_type, owner_info);
			waitUntilISpinnersInvisible();
	 	}
	}
	public void ownerInfoPay(String owner_type) {	
		if(!owner_type.equals("")){
			test = rep.startTest("Owner Info");
			String emailpreview = Constants.email_xpath_part1 + OR_PROPERTIES.getProperty("electrical_owner_email") + Constants.email_xpath_part2;
			for (int i = 1; i <= 20; i++) {
				clear(Constants.el_gi_owner_email);
				send(Constants.el_gi_owner_email, OR_PROPERTIES.getProperty("electrical_owner_email"));
				wait(1);
				if (count(emailpreview) > 0)
					break;
			}
			click(emailpreview);
			select(Constants.el_gi_owner_type, owner_type);
			waitUntilISpinnersInvisible();
	 	}
	}
		public void additionalInfo(String additional_info) {
			if(!additional_info.equals("")){
				test = rep.startTest("additionalInfo");
//				scrollToElement(Constants.el_gi_is_this_build_back_job_no);
				if(additional_info.contains("1yes"))
					radio(Constants.el_gi_is_this_build_back_job_yes);
				else
					radio(Constants.el_gi_is_this_build_back_job_no);
				if(additional_info.contains("2yes"))
					radio(Constants.legalization_yes);
				else
					radio(Constants.legalization_no);
				if(additional_info.contains("3yes"))
					radio(Constants.c_o_related_yes);
				else
					radio(Constants.c_o_related_no);
		 	}
		}
		public void calendar(String calendar) {	
			if(!calendar.equals("")){
				test = rep.startTest("calendar");
				scrollAllWayUp();
		 		click(Constants.el_gi_job_start_date_calendar);				//button[contains(@ng-click,'event,0)')]
		 		click(Constants.el_gi_calendar_active_day);
		 		keyPressTab(Constants.el_gi_job_start_date_calendar);
		 		click(Constants.el_gi_job_completion_date_calendar);
				if(calendar.equals("current"))
					click(Constants.el_gi_calendar_active_day);
				if(calendar.equals("next")) {
					click(Constants.el_calendar_next_month_arrow);
					click(Constants.el_gi_job_completion_last_day);
				}
				keyPressTab(Constants.el_gi_job_completion_date_calendar);
		 	}
		}
		
		public void jobDescription(String description, String work_type_subs) {	
			if(!description.equals("")){
				test = rep.startTest("jobDescription");
				if(!work_type_subs.equals("Electrical"))
				type(Constants.job_description_for_new_work, description + " "+ convertedTimestamp());
		 	}
		}
		
		public void saveGI(String save) {	
			if(!save.equals("")){
				test = rep.startTest("Save GI");
				scrollAllWayUp();
				click(Constants.global_save_step_button);
				wait(2);
				if(count(Constants.el_gi_confirm_save_button) > 0)
					click(Constants.el_gi_confirm_save_button);
				waitUntilISpinnersInvisible();
				waitVisible(Constants.global_notification_ok_button);
				assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "saveGI");
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("job_filing_saved"));
				click(Constants.global_notification_ok_button);
				waitInvisible(Constants.global_notification_ok_button);
				wait(2);
				waitVisible(Constants.el_job_label);
/*				System.out.println(text("//span[@class='pad-left-10']"));
				System.out.println(text("//strong[@class='ng-binding'][contains(text(),'I1')]").trim());
				System.out.println(text("//strong[@class='ng-binding'][contains(text(),'I1')]").trim().substring(0, 8));
				System.out.println(text("//strong[@class='ng-binding'][contains(text(),'I1')]").trim().substring(0, 9));
				wait(22);*/
				addToProps("job_number", text(Constants.el_job_label).trim().substring(0, 9));
		 	}
		}
		
		public void saveGI_subs(String save, String work_type_subs, String assert_filing_status) {	
			if(!save.equals("")){
				test = rep.startTest("saveGI Subs");
				scrollToElement(Constants.global_save_step_button);
				waitUntilElementVisible(Constants.global_save_step_button, 30);
				click(Constants.global_save_step_button);
				if(!work_type_subs.equals("Electrical")) {
					waitUntilElementVisible(Constants.global_save_step_button, 30);
					click(Constants.pw1_confirm_save_button);
				}
				waitUntilISpinnersInvisible();
				waitUntilElementVisible(Constants.global_notification_ok_button, 60);
				assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "saveForm");
				clickButton("OK");
				waitInvisible(Constants.global_notification_ok_button);
		 	}
		}
	
		public void previewToFile(String preview_to_file) {
			if(!preview_to_file.equals("")){
				System.out.println(convertedTimestamp() + " **************** " + "Preview To File GI");
//				filterJob(OR_PROPERTIES.getProperty("electrical_user_email"),JOB_NUMBER.getProperty("job_number"));
				test = rep.startTest("Preview To File GI");
				waitUntilISpinnersInvisible();
				click(Constants.preview_to_file_button_el);
				waitTime(3000L);
				waitVisible(Constants.application_preview_label);
				waitVisible(Constants.return_to_filing_view);
				waitVisible("//div[@class='hidden-xs col-md-2 pull-right']");
				if (count("//*[contains(text(),'Getting Preview... 0%')]") > 0) {
					click(Constants.return_to_filing_view);
					waitInvisible(Constants.return_to_filing_view);
					wait(1);
					click(Constants.preview_resubmit_button);
					waitUntilISpinnersInvisible();
					wait(2);
				}
				for (int i = 1; i <= 50; i++) {
					click(Constants.click_go_next_button);
					wait(1);
					if (count(Constants.final_legal_contect_checkbox) > 0)
						break;
				}
				check(Constants.final_legal_contect_checkbox);
				click(Constants.file_button);
				waitTime(3000L);
				waitUntilElementVisible(Constants.global_notification_ok_button, 60);
				assertNotification(TEXT_PROPERTIES.getProperty("filing_message_el"), "filing_message_el");
				verifyNotification(Constants.notification, TEXT_PROPERTIES.getProperty("filing_message_el"));
				click(Constants.global_notification_ok_button);
				waitInvisible(Constants.global_notification_ok_button);
//				elementTextContains("//span[@class='portal-fonts ng-binding']", "Complete");
			}
		}	

/*		public boolean assertFilingStatus(String assert_filing_status) {
			if(!assert_filing_status.equals("")){
				waitInvisible(Constants.global_notification_ok_button, 60);
				assertFilingStatus(assert_filing_status);
			}
		}*/
		
		public void assertFilingStatusSubs(String assert_filing_status_subs) {
			if(!assert_filing_status_subs.equals("")){
				waitInvisible(Constants.global_notification_ok_button);
				assertFilingStatus(assert_filing_status_subs);
			}
		}
		
		public void assertFilingStatusPaa(String assert_filing_status_paa) {
			if(!assert_filing_status_paa.equals("")){
				waitInvisible(Constants.global_notification_ok_button);
				assertFilingStatus(assert_filing_status_paa);
			}
		}
		
		public void payNow(String pay) {
			if(!pay.equals("")){
				click(Constants.pay_now_button);
				click(Constants.pay_now_confirm_button);
				waitUntilElementVisible(Constants.pay_do_not_click_back_message, 30);	
				waitTime(5000L);
		 	}
		}
		
		public void subsequentFiling(String subsequent_filing, String description, String use_type, String joint_venue, String sow ) {
			if(!subsequent_filing.equals("")){
				System.out.println(convertedTimestamp() + " **************** " + "subsequentFiling GI");
				test = rep.startTest("Subsequent Filing");
				waitUntilElementVisible(Constants.global_save_step_button, 30);
		 		el_ge1_job_description.sendKeys(description + " "+ convertedTimestamp());
		 		el_gi_job_start_date_calendar.click();
		 		waitUntilElementVisible(Constants.el_gi_calendar_active_day, 30);
		 		el_gi_calendar_active_day.click();
				el_gi_job_completion_date_calendar.click();
				if(sow.equals("NEW INSTALLATION")) {
					click(Constants.el_calendar_next_month_arrow);
					click(Constants.el_gi_job_completion_last_day);
/*					el_calendar_next_month_arrow.click();
					waitUntilElementVisible(Constants.el_gi_job_completion_last_day, 30);
					el_gi_job_completion_last_day.click();*/
				}
				if(sow.equals("Minor Work"))
					el_gi_calendar_active_day.click();
				if(joint_venue.equals("Yes"))
					el_gi_job_is_this_joint_venture_yes.click();
				if(joint_venue.equals("No"))
					el_gi_job_is_this_joint_venture_no.click();
		 		el_gi_building_use_type.sendKeys(use_type);
			}
		}

	public void subsFiling(String owner_info_subs) {
		if (!owner_info_subs.equals("")) {
			System.out.println(convertedTimestamp() + " **************** subsFiling");
			test = rep.startTest("Subsequent Filing");
			waitVisible(Constants.global_save_step_button);
			type(Constants.el_ge1_job_description, convertedTimestamp());
			click(Constants.el_gi_job_start_date_calendar);
			click(Constants.el_gi_calendar_active_day);
			click(Constants.el_gi_job_completion_date_calendar);
			click(Constants.el_calendar_next_month_arrow);
			click(Constants.el_gi_job_completion_last_day);
			radio(Constants.el_gi_job_is_this_joint_venture_no);
			select(Constants.el_gi_building_use_type, "A One Family");
			applicantInfo("Y");
			ownerInfoPay(owner_info_subs);
			additionalInfo("Y");
			saveGI("Y");
		}
	}
		public void pAa(String paa, String description) {	
			if(!paa.equals("")){
				System.out.println(convertedTimestamp() + " **************** PAA GI");
				test = rep.startTest("PAA GI");
				waitUntilISpinnersInvisible();
				clear(Constants.el_ge1_job_description);
				type(Constants.el_ge1_job_description, description + " "+ convertedTimestamp());
				click(Constants.global_save_step_button);
				waitUntilElementVisible(Constants.global_loading_spinner_subs, 30);
				waitUntilISpinnersInvisible();
				waitUntilElementVisible(Constants.global_notification_ok_button, 30);
				assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "pAa");
				click(Constants.global_notification_ok_button);
				waitInvisible(Constants.global_notification_ok_button);
			}
		}
		
		// Work Description	
		public void workDescription(String sow) {	
			if(!sow.equals("")){
				System.out.println(convertedTimestamp() + " **************** Scope Of Work Elctrical");
//				loginToPortal(OR_PROPERTIES.getProperty("electrical_user_email"));
//				filterJob(OR_PROPERTIES.getProperty("electrical_user_email"),JOB_NUMBER.getProperty("job_number"));
				test = rep.startTest("Scope Of Work");
				waitUntilISpinnersInvisible();
				click(Constants.el_scope_of_work_tab);
				waitUntilISpinnersInvisible();
				waitUntilElementVisible(Constants.el_select_category_of_work, 30);
				if(sow.contains("Emergency Lighting")) {
					scrollAllWayUp();
					waitUntilElementVisible("//*[@id='toggle-chk1']", 30);
					check(Constants.el_sow_service_work);
					check(Constants.el_sow_general_wiring);
					check(Constants.el_sow_lighting_work);
					select(Constants.el_sow_lighting_work_type, sow);
					scrollAllWayDown();
					wait(2);
					scrollToElement(Constants.el_boiler_controls_tab);
					click(Constants.el_boiler_controls_tab);
					type(Constants.el_boiler_controls_quantity, "1");
					type(Constants.el_boiler_controls_number_size, "2");
					click(Constants.el_boiler_controls_tab);
					click(Constants.el_service_meter_equipment);
//					waitUntilElementVisible(Constants.el_number_3_wire, 30);
					type(Constants.el_number_3_wire, "11");
					type(Constants.el_number_4_wire, "12");
					type(Constants.el_number_10_points, "14");
					type(Constants.el_number_existing_meters, "15");
					type(Constants.el_number_new_meters, "16");
					type(Constants.el_number_removed_meters, "17");
					click(Constants.el_service_meter_equipment);
				}
				if(sow.contains("Minor Work")){
//					select(Constants.el_select_category_of_work, "4");
					select(Constants.el_select_category_of_work, sow);

					click(Constants.global_save_step_button);
					click(Constants.global_notification_ok_button);
					waitInvisible(Constants.global_notification_ok_button);
					waitUntilISpinnersInvisible();
					waitUntilElementVisible(Constants.el_minor_work_description_slider, 30);
					scrollToElement(Constants.el_minor_work_description_slider);
					click(Constants.el_minor_work_description_slider);
					click(Constants.el_add_minor_work_description_button);
					select(Constants.el_minor_work_options, "(E) Repair of Defective Fixtures");
					select(Constants.el_minor_work_location, "Pit");
					type(Constants.el_minor_work_quantity, "1");
					type(Constants.el_minor_work_description, "minor test description");
	/*				waitUntilElementVisible(Constants.el_minor_work_options, 30);
					el_minor_work_options.sendKeys("(E) Repair of Defective Fixtures");
					el_minor_work_location.sendKeys("Pit");
					el_minor_work_quantity.sendKeys("1");
					el_minor_work_description.sendKeys("minor test description");*/
					click(Constants.el_minor_work_save_button);
//					el_minor_work_save_button.click();
					click(Constants.global_notification_ok_button);
					waitInvisible(Constants.global_notification_ok_button);
				}
				if(sow.contains("Field Sign")){
					select(Constants.el_select_category_of_work, sow);
					if(CONFIG.getProperty("env").contains("8085"))
						type(Constants.el_job_number_field, "B00007126");
					else
						type(Constants.el_job_number_field, "B00330512");
					click(Constants.electric_sign_description_tab);
					click(Constants.global_save_step_button);
					click(Constants.global_notification_ok_button);
					waitInvisible(Constants.global_notification_ok_button);
					waitUntilISpinnersInvisible();
					click(Constants.add_sign_description_button);
					type(Constants.sign_dimentions, "111");
					type(Constants.total_sq_feet_of_sign, "222");
					type(Constants.total_circuit_in_sign, "333");
					type(Constants.total_lamps, "444");
					type(Constants.total_wats, "555");
					type(Constants.number_of_transformenrs, "777");
					type(Constants.va_of_each_transformer, "888");
					type(Constants.total_wats_of_va, "999");
					type(Constants.avg_gauge_of_wires, "789");
					type(Constants.number_of_sockets_per_circuit, "211");
					type(Constants.material_and_gauge_used, "233");
					type(Constants.make_of_sign, "244");
					type(Constants.manufacturer_of_sign, "IBM");
					type(Constants.manufacturer_address, "100 Main");
					click(Constants.el_save_modal_button);
					click(Constants.global_notification_ok_button);
					waitInvisible(Constants.global_notification_ok_button);
					waitInvisible(Constants.el_save_modal_button);
					waitUntilISpinnersInvisible();
				}
				click(Constants.global_save_step_button);
				waitVisible(Constants.global_notification_ok_button);
	// ASSERT NOTIFICATION	
				assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved");
	/*			waitUntilElementVisible(Constants.global_notification_ok_button, 30);
				if(sow.equals("NEW INSTALLATION"))
					assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved");
				if(sow.equals("Minor Work"))
					assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved");*/
				click(Constants.global_notification_ok_button);
				waitInvisible(Constants.global_notification_ok_button);
			}
		}
		
	// SIGNATURES
		public void signaturesEl(String signatures) {	
			if(!signatures.equals("")){
				System.out.println(convertedTimestamp() + " **************** signaturesEl");
//				filterJob(OR_PROPERTIES.getProperty("electrical_user_email"),JOB_NUMBER.getProperty("job_number"));
				test = rep.startTest("signaturesEl");
				waitUntilISpinnersInvisible();
				click(Constants.ss_statement_signatures_step);
				check(Constants.el_i_undersigned);
				scrollDown();
				check(Constants.el_this_electrical_permit_involves);
//				click(Constants.el_application_involve_new_or_amended_yes);
				check(Constants.el_this_electrical_permit_includes);
				click(Constants.global_save_step_button);
				waitUntilElementVisible(Constants.global_loading_spinner_subs, 30);
				waitUntilISpinnersInvisible();
				waitUntilElementVisible(Constants.global_notification_ok_button, 30);
				assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "job_filing_saved ss");
				click(Constants.global_notification_ok_button);
			}
		}
		
		public void uploadDocumentsEl(String upload_file) {
			if (!upload_file.equals("")) {
				System.out.println(convertedTimestamp() + " **************** " + "Upload Documents Electrical");
//				loginToPortal(OR_PROPERTIES.getProperty("electrical_user_email"));
//				filterJob(OR_PROPERTIES.getProperty("electrical_user_email"), JOB_NUMBER.getProperty("job_number"));
				test = rep.startTest("Upload Documents");
				waitUntilISpinnersInvisible();
				click(Constants.documents_step);
				scrollUp();
				waitUntilElementVisible(Constants.el_first_document, 30);
				waitUntilElementVisible(Constants.upload_document_icon, 30);
				int number_of_uploads = driver.findElements(By.xpath(Constants.upload_document_icon)).size();
				for (int i = 1; i <= number_of_uploads; i++) {
					String document_xpath = Constants.doc_upload_xpath_part1 + i + Constants.doc_upload_xpath_part2;
					click(document_xpath);
					send(Constants.doc_browse_button, Constants.uploadFolder + "upload.png");
					click(Constants.doc_upload_button);
					waitInvisible(Constants.doc_please_wait_message);
					click(Constants.doc_document_uploaded_ok_button);
					waitUntilISpinnersInvisible();
				}
				click(Constants.global_save_step_button);
				waitVisible(Constants.global_notification_ok_button);
				assertNotification(TEXT_PROPERTIES.getProperty("job_filing_saved"), "save form docs page");
				click(Constants.global_notification_ok_button);
				waitInvisible(Constants.global_notification_ok_button);
				waitUntilISpinnersInvisible();
//				click("//a[@ng-click='changeCurrentPage(1);']");
			}
		}
		
		
		
}
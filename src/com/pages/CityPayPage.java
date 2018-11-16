package com.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import com.base.TestBase;
import com.util.Constants;

public class CityPayPage extends TestBase {
	
	// City Pay IE
	public void cityPay(String pay_now) {
		if (!pay_now.equals("")) {
			if (count(Constants.pay_now_button_disabled) == 0) {
				System.out.println(convertedTimestamp() + " **************** PayNowTest");
				test = rep.startTest("City Pay");
				String parentWindowContact = driver.getWindowHandle();
				for (int i = 1; i < 20; i++) {
					wait(2);
					if (pay_now.contains("Elevator")) { // ELEVATOR
						// DO NOTHING
					} else
						filterJob(user);
					test = rep.startTest("City Pay");
					if (pay_now.contains("Elevator") || pay_now.contains("patpa")) { // ELEVATOR / PA TPA
						clickAndWait("//span[text()='Pay Now']", Constants.pay_now_yes_button);
//						click("//span[text()='Pay Now']");
						clickButton("Yes");
						waitInvisible(Constants.pay_now_yes_button);
					} else {
						clickAndWait(Constants.pay_now_button, Constants.pay_now_confirm_button); // REST OF WORK TYPES
//						click(Constants.pay_now_button); // REST OF WORK TYPES
						waitUntilISpinnersInvisible();
						wait(3);
						waitVisible60(Constants.pay_now_confirm_button);
						doubleclick(Constants.pay_now_confirm_button);
//						clickAndWait(Constants.pay_now_confirm_button, "//b[contains(text(),'Please do not click Back')]");
						waitInvisible(Constants.pay_now_confirm_button);
					}
					wait(5);
					if ((driver.getWindowHandles().size()) > 1) {
						// driver.close();
						wait(1);
						break;
					}
				}
				for (int i = 1; i < 20; i++) {
					Set<String> handles = driver.getWindowHandles();
					Iterator<String> itr = handles.iterator();
					String newWindow = itr.next();
					driver.switchTo().window(newWindow);
					driver.manage().window().maximize();
					if (driver.getTitle().contains("NYC CityPay") || driver.getTitle().contains("Certificate Erro"))
						break;
					Set<String> handleswindow = driver.getWindowHandles();
					for (String windowHandle : handleswindow) {
						wait(1);
						driver.switchTo().window(windowHandle);
						driver.manage().window().maximize();
					}
					if (driver.getTitle().contains("NYC CityPay") || driver.getTitle().contains("Certificate Erro"))
						break;
					if (!driver.getTitle().equals("Certificate Error: Navigation Blocked")) {
						System.out.println(" You are in the wrong window");
						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().defaultContent();
						driver.switchTo().window(tabs.get(0));
						driver.switchTo().window(tabs.get(1));
						if (driver.getTitle().contains("NYC CityPay") || driver.getTitle().contains("Certificate Erro"))
							break;
					}
					if (count("//a[@id='overridelink']") > 0)
						break;
				}
				while (count("//a[@id='overridelink']") > 0) {
					driver.navigate().to("javascript:document.getElementById('overridelink').click()");
					wait(5);
					if (count("//a[@name='overridelink']") == 0)
						break;
					refreshPage();
				}
				waitVisible60(Constants.pay_continue_button);
				if (pay_now.contains("credit")) {
//					click("//a[@title='Pay by Credit Card']"); 
					clickAndWait("//a[@title='Pay by Credit Card']", "//p[@class='intro'][contains(.,'charged a service fee')]");
//					waitInvisible("//p[@class='intro'][contains(.,'pay by electronic check')]");
					waitVisible("//p[@class='intro'][contains(.,'Credit and debit card payments')]");
					type(Constants.pay_first_name_cc, "Thomas");
					type(Constants.pay_last_name_cc, "Anders");
					type(Constants.pay_address_cc, "888 5 Ave");
					type(Constants.pay_city_cc, "New York");
					type(Constants.pay_zip_cc, "10021");
					type(Constants.pay_phone_cc, "2125558888");
					type(Constants.pay_email_cc, "jgrove@buildings.nyc.gov");
					type(Constants.pay_email_confirm_cc, "jgrove@buildings.nyc.gov");
					click(Constants.pay_continue_button_cc);
					waitInvisible60(Constants.pay_continue_button_cc);
					click(Constants.pay_next_button);
					type(Constants.pay_name_on_card, "Thomas Anders");
					type(Constants.pay_card_number, "4111111111111111");
					select(Constants.pay_exp_month, "01");
					select(Constants.pay_exp_year, "2020");
					type(Constants.pay_cvv, "333");
				} else {
					type(Constants.pay_first_name, "Thomas");
					type(Constants.pay_last_name, "Anders");
					type(Constants.pay_address, "888 5 Ave");
					type(Constants.pay_city, "New York");
					type(Constants.pay_zip, "10021");
					type(Constants.pay_phone, "2125558888");
					type(Constants.pay_email, "jgrove@buildings.nyc.gov");
					type(Constants.pay_email_confirm, "jgrove@buildings.nyc.gov");
					click(Constants.pay_continue_button_ec);
					waitInvisible60(Constants.pay_continue_button_ec);
					click(Constants.pay_next_button);
					type(Constants.pay_name_on_account, "Thomas Anders");
					type(Constants.account_number, "123456789");
					type(Constants.account_number_confirm, "123456789");
					type(Constants.aba_routing_number, "021000089");
				}
				click(Constants.pay_next_button);
				waitInvisible60(Constants.pay_next_button);
				click(Constants.pay_now_button_final);
				waitInvisible60(Constants.pay_now_button_final);
				wait(10);
				if (!CONFIG.getProperty("env").contains("8085")) {
					while (count("//a[@id='overridelink']") > 0) {
						driver.navigate().to("javascript:document.getElementById('overridelink').click()");
						wait(5);
						if (count("//a[@name='overridelink']") == 0)
							break;
						refreshPage();
					}
				}

				assertTextPresent("Receipt Details", "Receipt Details");

				wait(2);
				setConfigBrowser("Chrome");
				driver.switchTo().window(parentWindowContact);
				waitVisible(Constants.ok_button);
				clickButton("OK");
				waitInvisible(Constants.ok_button);

				try {
					Set<String> windows = driver.getWindowHandles();
					Iterator<String> iter = windows.iterator();
					String[] winNames = new String[windows.size()];
					int i = 0;
					while (iter.hasNext()) {
						winNames[i] = iter.next();
						i++;
					}

					if (winNames.length > 1) {
						for (i = winNames.length; i > 1; i--) {
							driver.switchTo().window(winNames[i - 1]);
							driver.close();
						}
					}
					driver.switchTo().window(winNames[0]);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			driver.close();
		}
		successMessage("cityPay");
	}

	// City Pay
	public void cityPayFFX(String pay_now) {
		if (!pay_now.equals("")) {
			if (count(Constants.pay_now_button_disabled) == 0) {
				System.out.println(convertedTimestamp() + " **************** PayNowTest");
				test = rep.startTest("City Pay");
				String parentWindowContact = driver.getWindowHandle();
				for (int i = 1; i < 20; i++) {
					wait(2);
					if (pay_now.contains("Elevator")) { // ELEVATOR
						// DO NOTHING
					} else
						filterJob(user);
					test = rep.startTest("City Pay");
					if (pay_now.contains("Elevator") || pay_now.contains("patpa")) { // ELEVATOR / PA TPA
						clickAndWait("//span[text()='Pay Now']", Constants.pay_now_yes_button);
//						click("//span[text()='Pay Now']");
						clickButton("Yes");
						waitInvisible(Constants.pay_now_yes_button);
					} else {
						clickAndWait(Constants.pay_now_button, Constants.pay_now_confirm_button); // REST OF WORK TYPES
//						click(Constants.pay_now_button); // REST OF WORK TYPES
						waitUntilISpinnersInvisible();
						wait(3);
						waitVisible60(Constants.pay_now_confirm_button);
						doubleclick(Constants.pay_now_confirm_button);
//						clickAndWait(Constants.pay_now_confirm_button, "//b[contains(text(),'Please do not click Back')]");
						waitInvisible(Constants.pay_now_confirm_button);
					}
					wait(5);
					if ((driver.getWindowHandles().size()) > 1) {
						// driver.close();
						wait(1);
						break;
					}
				}
				for (int i = 1; i < 20; i++) {
					Set<String> handles = driver.getWindowHandles();
					Iterator<String> itr = handles.iterator();
					String newWindow = itr.next();
					driver.switchTo().window(newWindow);
					driver.manage().window().maximize();
					if (driver.getTitle().contains("NYC CityPay") || driver.getTitle().contains("Certificate Erro"))
						break;
					Set<String> handleswindow = driver.getWindowHandles();
					for (String windowHandle : handleswindow) {
						wait(1);
						driver.switchTo().window(windowHandle);
						driver.manage().window().maximize();
					}
					if (driver.getTitle().contains("NYC CityPay") || driver.getTitle().contains("Certificate Erro"))
						break;
					if (driver.getTitle().contains("DOB NOW")) {
						System.out.println(" You are in the wrong window");
						ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
						driver.switchTo().defaultContent();
						driver.switchTo().window(tabs.get(0));
						driver.switchTo().window(tabs.get(1));
						driver.switchTo().window(tabs.get(1));
						driver.switchTo().window(tabs.get(1));
					}
					if (driver.getTitle().contains("NYC CityPay") || driver.getTitle().contains("Certificate Erro"))
						break;
				}
/*				while (count("//a[@id='overridelink']") > 0) {
					driver.navigate().to("javascript:document.getElementById('overridelink').click()");
					wait(5);
					if (count("//a[@name='overridelink']") == 0)
						break;
					refreshPage();
				}*/
				waitVisible60(Constants.pay_continue_button);
				if (pay_now.contains("credit")) {
//					click("//a[@title='Pay by Credit Card']"); 
					clickAndWait("//a[@title='Pay by Credit Card']", "//p[@class='intro'][contains(.,'charged a service fee')]");
//					waitInvisible("//p[@class='intro'][contains(.,'pay by electronic check')]");
					waitVisible("//p[@class='intro'][contains(.,'Credit and debit card payments')]");
					type(Constants.pay_first_name_cc, "Thomas");
					type(Constants.pay_last_name_cc, "Anders");
					type(Constants.pay_address_cc, "888 5 Ave");
					type(Constants.pay_city_cc, "New York");
					type(Constants.pay_zip_cc, "10021");
					type(Constants.pay_phone_cc, "2125558888");
					type(Constants.pay_email_cc, "jgrove@buildings.nyc.gov");
					type(Constants.pay_email_confirm_cc, "jgrove@buildings.nyc.gov");
					click(Constants.pay_continue_button_cc);
					waitInvisible60(Constants.pay_continue_button_cc);
					click(Constants.pay_next_button);
					type(Constants.pay_name_on_card, "Thomas Anders");
					type(Constants.pay_card_number, "4111111111111111");
					select(Constants.pay_exp_month, "01");
					select(Constants.pay_exp_year, "2020");
					type(Constants.pay_cvv, "333");
				} else {
					type(Constants.pay_first_name, "Thomas");
					type(Constants.pay_last_name, "Anders");
					type(Constants.pay_address, "888 5 Ave");
					type(Constants.pay_city, "New York");
					type(Constants.pay_zip, "10021");
					type(Constants.pay_phone, "2125558888");
					type(Constants.pay_email, "jgrove@buildings.nyc.gov");
					type(Constants.pay_email_confirm, "jgrove@buildings.nyc.gov");
					click(Constants.pay_continue_button_ec);
					waitInvisible60(Constants.pay_continue_button_ec);
					click(Constants.pay_next_button);
					type(Constants.pay_name_on_account, "Thomas Anders");
					type(Constants.account_number, "123456789");
					type(Constants.account_number_confirm, "123456789");
					type(Constants.aba_routing_number, "021000089");
				}
				click(Constants.pay_next_button);
				waitInvisible60(Constants.pay_next_button);
				click(Constants.pay_now_button_final);
				waitInvisible60(Constants.pay_now_button_final);
				wait(10);
				if (!CONFIG.getProperty("env").contains("8085")) {
					while (count("//a[@id='overridelink']") > 0) {
						driver.navigate().to("javascript:document.getElementById('overridelink').click()");
						wait(5);
						if (count("//a[@name='overridelink']") == 0)
							break;
						refreshPage();
					}
				}

				assertTextPresent("Receipt Details", "Receipt Details");

				wait(2);
				setConfigBrowser("Chrome");
				driver.switchTo().window(parentWindowContact);
				waitVisible(Constants.ok_button);
				clickButton("OK");
				waitInvisible(Constants.ok_button);

				try {
					Set<String> windows = driver.getWindowHandles();
					Iterator<String> iter = windows.iterator();
					String[] winNames = new String[windows.size()];
					int i = 0;
					while (iter.hasNext()) {
						winNames[i] = iter.next();
						i++;
					}

					if (winNames.length > 1) {
						for (i = winNames.length; i > 1; i--) {
							driver.switchTo().window(winNames[i - 1]);
							driver.close();
						}
					}
					driver.switchTo().window(winNames[0]);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			driver.close();
		}
		successMessage("cityPay");
	}
	
}
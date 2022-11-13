package com.vtiger.stepdefination;

import org.openqa.selenium.WebDriver;

import com.vtiger.pages.Homepage;
import com.vtiger.pages.Leadpage;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Leadstepdefination extends Basaestepdefination  {
//public WebDriver driver;
	
	
	
	
	@Before
	public void before(Scenario scenario) {
		this.scenario=scenario;
	}
	@After
	public void after()
	{
		extent.flush();
		driver.quit();
		
	}
	
	@When("user click on mandatory field and click on save button")
	public void user_click_on_mandatory_field_and_click_on_save_button() {
	  //System.out.println("user click on mandatory field and click on save button");
		lpp.creadlead(TestData.get(TCName).get("FirstName"), TestData.get(TCName).get("LastName"), TestData.get(TCName).get("Company"));
	}
	@When("lead should be created succesfully")
	public void lead_should_be_created_succesfully() {
	   System.out.println("lead should be created succesfully");
	}
	@When("user click on new lead link")
	public void user_click_on_new_lead_link() {
	    System.out.println("user click on new lead link");
	      hp.clickNewLead();
	      lpp =new Leadpage(driver, logger);
	}
	@Then("create lead page should be open")
	public void create_lead_page_should_be_open() {
	   System.out.println("create lead page should be open");
	}
	@When("user Salutation type ,firstname, lastname,company,leadsource,mobile,city,state and click on save button")
	public void user_salutation_type_firstname_lastname_company_leadsource_mobile_city_state_and_click_on_save_button() {
	   System.out.println("user Salutation type ,firstname, lastname,company,leadsource,mobile,city,state and click on save button");
	}
	@Then("lead created succefully")
	public void lead_created_succefully() {
	    System.out.println("lead created succefully");
	}
	
}

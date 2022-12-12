package com.vtiger.stepdefination;

import com.vtiger.pages.Accountpage;
import com.vtiger.pages.Leadpage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class Accountstepdefination extends Basaestepdefination {
	
	
	@Before
	public void before(Scenario scenario) {
		this.scenario=scenario;
		 TCName=scenario.getName();
	}
	@After
	public void after()
	{
		extent.flush();
		//driver.quit();
		
	}
	@When("user click on new account link")
	public void user_click_on_new_account_link() {
		
		System.out.println("user click on new lead link");
	      hp.clickNewAccount();
	      ac =new Accountpage(driver, logger);
	    
	}
	@Then("create account page should be open")
	public void create_account_page_should_be_open() {
		//ac.varifiedAccounttext();
		System.out.println("create account page should be openk");
		
	   
	}
	@When("user account_name  ,website, ticketsymbol,industry and click on save button")
	public void user_account_name_website_ticketsymbol_industry_and_click_on_save_button() {
		ac.AccountSave(TestData.get(TCName).get("AccountName"), TestData.get(TCName).get("website"), TestData.get(TCName).get("symbol"), TestData.get(TCName).get("indusry"));
	}
	@Then("Account created succefully")
	public void account_created_succefully() {
		ac.varifiedAccounttext();
	   
	}
	@When("user account_name {string} And  website  {string} And ticketsymbol And   {string} And industry  {string} and click on save button")
	public void user_account_name_and_website_and_ticketsymbol_and_and_industry_and_click_on_save_button(String accnumber,String website,String ticketsymbol,String industry) {
		ac.AccountSave(accnumber, website, ticketsymbol, industry);
	   
	}


}

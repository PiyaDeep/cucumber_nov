package com.vtiger.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.Homepage;
import com.vtiger.pages.Leadpage;
import com.vtiger.pages.Loginpage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Loginstepdefinations extends Basaestepdefination  {
	//public WebDriver driver;
	

	
	
	@Before
	public void before(Scenario scenario) {
		this.scenario=scenario;
	}
	@After
	public void after()
	{
		extent.flush();
		//driver.quit();
		
	}
	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		init();
		logger=extent.createTest(scenario.getName());
		 TCName=scenario.getName();
		lp=new Loginpage(driver,logger);
		hp=new Homepage(driver,logger);
		lpp=new Leadpage(driver,logger);
		
	}
	@When("user enters invalid userid and password and click on login button")
	public void user_enters_invalid_userid_and_password_and_click_on_login_button() {
		lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password")); 

	}
	@Then("user can see the error message")
	public void user_can_see_the_error_message() {
     lp.verifyErrorMsg();	   
	}

@When("user entersvalid userid and password and click on login button")
public void user_entersvalid_userid_and_password_and_click_on_login_button() {
	lp.login(TestData.get(TCName).get("Userid"), TestData.get(TCName).get("Password")); 
}
@Then("user can navigated to homepage")
public void user_can_navigated_to_homepage() {
	hp.Varifylogout();
    
}
@Then("logout link should be appear on right corner on the home page")
public void logout_link_should_be_appear_on_right_corner_on_the_home_page() {
  hp.clicklogout();

}
@When("user enter  invalid login {string} and password {string} and click on login button")
public void user_enter_invalid_login_and_password_and_click_on_login_button(String u, String p) 
{
	lp.login(u, p);
	//driver.findElement(By.name("user_name")).sendKeys(u);
	//driver.findElement(By.name("user_password")).sendKeys(p);

}

}

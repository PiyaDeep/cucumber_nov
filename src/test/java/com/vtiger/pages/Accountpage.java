package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class Accountpage extends Headerpage {

	public Accountpage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		PageFactory.initElements(driver, this);
	
	}

		
		
			@FindBy(xpath="//td[@class='moduleTitle']")
		     WebElement tex_AccounTitle;
			
			@FindBy(name="accountname")
			WebElement tb_accname;
			@FindBy(name="website")
			WebElement tb_website;
			@FindBy(name="tickersymbol")
			WebElement tb_ticketsymbol;
			@FindBy(xpath="//*[@name='account_name']")
			WebElement tb_memberof;
			
			@FindBy(xpath="//*[@name='industry']")
			WebElement tb_industry;

			@FindBy(xpath="//input[@type='submit']")
			WebElement btn_save;
			//webelement
			@FindBy(xpath="//input[@name='btn1']")
			WebElement btn_change;
			@FindBy(linkText="X-CEED INC 99")
			WebElement lnk_vtiger;
			
			@FindBy(xpath="//*[@name='account_name']")
			WebElement txt_cahngetext;
			

		
			
			
			public void AccountSave(String accnumber,String website,String ticketsymbol,String industry )//main funcation
			{   setaccountname(accnumber);
				setwebite(website);
				settickersymbol(ticketsymbol);
				
				setwindowhandle();
				setindustry(industry);
				ClicksaveAccount();
				
				
			}
			public void setaccountname(String accnumber)
			{
				
				cr.EnterValue(tb_accname, accnumber, accnumber+"Enter Account Number  field");
				
			}
			
			public void setwebite(String website)
			{
				
				cr.EnterValue(tb_website, website, website+"Enter website in that field");
				
			}
			
			public void settickersymbol(String ticketsymbol)
			{
				
				cr.EnterValue(tb_ticketsymbol, ticketsymbol, ticketsymbol+"Enter ticketsymbol field");
				
			}
			public void setwindowhandle()
			{
				cr.ClickElement(btn_change, "chnge button click");
				
	            cr.Getwindowhandle(lnk_vtiger, "click on link");
	             }
			public void setindustry(String industry)
			{
				
				cr.SelectDropdownValue(tb_industry, industry, "Enter indusry field");
				
			}
			
			public void ClicksaveAccount()
			{
				cr.ClickElement(btn_save, "Save Account Number Succesfully");
			}
			
			
			
			
			
			public void varifiedAccounttext()
			{
				//return txt_errormsg.isDisplayed();
				cr.IsElementDisplay(tex_AccounTitle,"Account:Home Text validate");
				
				
			}
			public void varifiedchangebuttonpopupwindow()
			{
				//return txt_errormsg.isDisplayed();
				cr.IsElementDisplay(txt_cahngetext,"popup window text   validate");
				
				
			}
			
			
	}


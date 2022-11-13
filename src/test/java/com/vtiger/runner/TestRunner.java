package com.vtiger.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features="src/test/resources/Features/",
glue={"com.vtiger.stepdefination"},
plugin={"pretty","html:target/cucumber-reports.html"},
monochrome=true,
tags="@leadfeature"
		
//,dryRun=true
)
public class TestRunner {

}

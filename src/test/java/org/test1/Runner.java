package org.test1;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src\\test\\resources\\Sameple1.feature", glue = {"org.test1"},monochrome=true,plugin = "usage")
	
public class Runner {


	
}

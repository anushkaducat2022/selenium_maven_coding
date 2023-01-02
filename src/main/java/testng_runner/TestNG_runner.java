package testng_runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

features = "C:\\Selenium_Coding_Ducat\\cucumberjavaselenium\\featurefile\\login.feature", 
glue = "stepdef", 
tags = "@validLogingTC1", 
dryRun = false,
monochrome = false
)
public class TestNG_runner extends AbstractTestNGCucumberTests {

}

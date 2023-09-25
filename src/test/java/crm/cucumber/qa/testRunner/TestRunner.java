package crm.cucumber.qa.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"html:target/cucumber_html_report.html","pretty"},
features="src/main/java/crm/cucumber/qa/feature",
glue={"StepDefinations"},
monochrome=true,
dryRun=false,
tags="@sanity"

)



public class TestRunner {

}

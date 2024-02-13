
package com.bdd.testrunner;


/*
 * This class is used to run all the feature files
 * Created By : Varsha  Tailor
 */

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
		import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

//@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features ={"src/test/resources/Features/UI_Features"}
		, plugin = { "pretty", "json:target/cucumber.json", "junit:target/cucumber.xml", "pretty:target/cucumber-pretty.txt" },
		tags={"@Test"}
		, glue = {
						"com.bdd.stepdefinition"}, dryRun = false, monochrome = true

)
public class TestRunner {
	
	static {
        // Example: Set browser and URL properties
        System.setProperty("browser.name", "chrome");
        System.setProperty("url", "QA");
    }

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() {

		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

	}

	@Test(dataProvider = "scenarios")
	public void scenarios(PickleEventWrapper eventwrapper, CucumberFeatureWrapper CucumberFeature) throws Throwable {

		testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());

	}


	@DataProvider
	public Object[][] scenarios() {

		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {

		testNGCucumberRunner.finish();

	}

}

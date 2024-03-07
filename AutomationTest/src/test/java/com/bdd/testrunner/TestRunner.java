
package com.bdd.testrunner;

import org.junit.runner.RunWith;
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
		features ={"src/test/resources/Features/UI_Features"},
		plugin = { "pretty", "json:target/cucumber.json", "junit:target/cucumber.xml", "pretty:target/cucumber-pretty.txt" },
		tags={"@Test"},
		glue = {"com.bdd.stepdefinition", "com.bdd.hooks" },
		dryRun = false,
		monochrome = true)

public class TestRunner {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {

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
	public void tearDownClass() throws Exception {

		testNGCucumberRunner.finish();
	}
}

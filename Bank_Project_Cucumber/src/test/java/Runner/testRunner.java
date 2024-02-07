 package Runner;

	import org.junit.runner.RunWith;

	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/resources/Features/VerifyErrorMessage.feature",glue={"stepDefinition","Hook"},
	dryRun=false,monochrome=true,plugin ={"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
	publish=true)

	public class testRunner {

	}



//com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:---extent report plugin
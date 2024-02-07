 package Runner;

	import org.junit.runner.RunWith;

	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(features="@fail/failcase3.txt",glue={"stepDefinition","Hook"},
	dryRun=false,monochrome=false)
	public class Rerunner {

	}




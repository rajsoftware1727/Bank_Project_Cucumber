package stepDefinition;

import org.openqa.selenium.WebDriver;

import Hook.Base;
import Page_Objects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class VerifyErrorMessage {
	
	WebDriver driver;
	@Given("goto home page")
	public void goto_home_page() {
		
		driver=Base.getDriver();
	     
	}

	@When("uname and pwd as empty")
	public void uname_and_pwd_as_empty() {
		
		LoginPage.getInstance().setLogin("","");
		LoginPage.getInstance().TabAndEnterKeyPress();
 
		
	     
	}

	@Then("verify error messages")
	public void verify_error_messages() {
		
		Assert.assertEquals("User-ID must not be blank",LoginPage.getInstance().getUnameFieldMessage());
		Assert.assertEquals("Password must not be blank",LoginPage.getInstance().getPwdFieldMessage());

	     
	}

}

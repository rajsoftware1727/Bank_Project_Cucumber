package stepDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Hook.Base;
import Page_Objects.LoginPage;
import Utilities.Action1;
import Utilities.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class login  {
	static WebDriver driver;


	@Given("goto website")
	public void goto_website() {

		driver=Base.getDriver();


	}
	@When("enter uname {string} and pwd {string}")
	public void enter_uname_and_pwd(String uname, String pwd) {

		/*driver.findElement(By.name("uid")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pwd);*/
		try
		{
			LoginPage.getInstance().setLogin(uname, pwd);



			Base.LOGGER.info("username and password entered");
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}





	}
	@Then("click login")
	public void click_login() throws IOException {





		//LoginPage.getInstance().getLoginButton().click();
		Action1.click(LoginPage.getInstance().getLoginButton());
		Base.LOGGER.info("login button clicked");




		//LoginPage.getInstance().getLogout().click();
		/*	Action1.click(LoginPage.getInstance().getLogout());

		Base.LOGGER.info("logout clicked");
		driver.switchTo().alert().accept();
		Base.LOGGER.info("alert opened and click ok");*/
	}






	@When("enter uname as {string} and password as {string}")
	public void enter_uname_as_and_password_as(String uname, String pwd) {

		LoginPage.getInstance().setLogin(uname, pwd);








	}
	@Then("click login button")
	public void click_login_button() {

		//LoginPage.getInstance().getLoginButton().click();
		Action1.click(LoginPage.getInstance().getLoginButton());


	}
	@Then("Verify alert is open")
	public void verify_alert_is_open() {

		boolean expResult=login.isAlertOpen();
		Assert.assertEquals(expResult,true);

	}

	public static  boolean isAlertOpen()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			e.printStackTrace();
			return false;
		}
	}


}



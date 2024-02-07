package Page_Objects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Hook.Base;
import Utilities.Constants;

public class LoginPage {
	public  WebDriver driver;
 	@FindBy(name="uid")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement pwd;
	
	@FindBy(name="btnLogin")
	private WebElement loginButton;
	
	@FindBy(css="a[href^='Log'")
	private WebElement logout;
	
	@FindBy(xpath="//ul[@class='menusubnav']/li")
	 List<WebElement> options;
	
	@FindBy(xpath="//label[@id='message18']")
	private WebElement passwordFieldMessage;
	
	@FindBy(xpath="//label[@id='message23']")
	private WebElement unameFieldMessage;
	
    //create single design pattern	for the above class
	
	private static LoginPage login;
	
	private   LoginPage()
	{
		 
	}
	 

	 public static LoginPage getInstance()
	 {
		 if(login==null)
			{
				login=new LoginPage();
			}
			return login;	 }

	 



	 






	 

	 

	 
	 

	public WebElement getUserName() {
		Constants.highLightElement(userName);
 		return userName;
	}

	public WebElement getPwd() {
		Constants.highLightElement(pwd);
 
		return pwd;
	}
	
	public WebElement getLoginButton() {
		Constants.highLightElement(loginButton);

 
		return loginButton;
	}
	
	public WebElement getLogout() {
		Constants.highLightElement(logout);

 
		return logout;
	}
	
	public List<WebElement> getOptions() {
 
		return options;
	}

	
	public void setLogin(String uname,String pwd1)
	{
		getUserName().sendKeys(uname);
		getPwd().sendKeys(pwd1);
 	}
	
	public String getUnameFieldMessage(){
		 
		return unameFieldMessage.getText();
	}
	
	public String getPwdFieldMessage(){
		 
		return passwordFieldMessage.getText();
	}
	
	public void TabAndEnterKeyPress()
	{
		pwd.sendKeys(Keys.TAB);
 	}


	 
	
	 


	 
	
	
	
	
	
	

}

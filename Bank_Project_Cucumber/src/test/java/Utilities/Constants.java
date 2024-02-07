package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Hook.Base;
import Page_Objects.LoginPage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Constants {

	public static Property_File_Reader p;

	public static String getURL()
	{
		p=new Property_File_Reader();
		return (String)p.getData("URL");
    }
	 
	public static String getbrowserName() {
		p=new Property_File_Reader();
		return (String)p.getData("browserName");
	}
	
	  public static  void initElements()
	  {
		  PageFactory.initElements(Base.getDriver(),LoginPage.getInstance());
	  }
	  
	  @AfterStep
	  public static  void takeScreenShot(Scenario scenario) throws IOException
	  {
	    byte[] screenshot = ((TakesScreenshot)Base.getDriver()).getScreenshotAs(OutputType.BYTES);
	    scenario.attach(screenshot,"image/webp","screenshot");
	    
		  
 	  }
	  
	  /*
	   * create single design pattern for constants class
	   */
	  private Constants()
	  {
		  
	  }
	  private static Constants constant;
	  public static Constants getInstance()
	  {
		  if(constant==null)
		  {
			  constant=new Constants();
		  }
		  return constant;
	  }
	  
	  public static void highLightElement(WebElement element)
	  {
		  JavascriptExecutor js=(JavascriptExecutor)Base.getDriver();
		  js.executeScript("arguments[0].style.border='3px solid aqua'",element);
	  }
	  
	  /*
	   * create generic drop down selection method
	   */
	  
	  public static void selectDropDown(WebElement element,String how,String value)
	  {
		  Select select=new Select(element);

		  switch(how)
		  {
		  case "index":
			  select.selectByIndex(Integer.parseInt(value));
		  case "visibleText":
			  select.selectByVisibleText(value);
		  case "someValue":
			  select.selectByValue(value);
		}
	  }
}

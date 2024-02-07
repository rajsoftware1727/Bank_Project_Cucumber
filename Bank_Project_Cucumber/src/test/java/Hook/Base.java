package Hook;

import java.io.IOException;

import org.apache.log4j.Logger;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Utilities.Constants;
import Utilities.Property_File_Reader;
 import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Base {
	
	public static WebDriver driver1;
	public static Logger LOGGER;
 	
    
	
	@Before
	public   void setup()
	{
		if(driver1==null)
		{
		String browserName=Constants.getbrowserName();
		
		 
 			System.out.println("started");
			switch(browserName)
			{
			
			case "chrome" :
				WebDriverManager.chromedriver().setup();
			    driver1=new ChromeDriver();
			    break;
			case "edge" :
				WebDriverManager.edgedriver().setup();
				driver1=new EdgeDriver();
				break;
			case "internetExplorer" :
				WebDriverManager.iedriver().setup();
				driver1=new InternetExplorerDriver();
				break;
			case "firefox" :
				WebDriverManager.firefoxdriver().setup();
				driver1=new FirefoxDriver();
				break;
			}
		}
			 
			driver1.manage().window().maximize();
			driver1.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
 
			driver1.get(Constants.getURL());
			LOGGER=Logger.getLogger(Base.class.getName());
			PropertyConfigurator.configure("log4j.properties");

			LOGGER.info("browser started");
			Constants.initElements();
   	 		
		}

	

  	
	
	/*@After
	public void teardown()
	{
		System.out.println("closed");
		driver1.close();;
		LOGGER.info("browser closed");
 	}*/
	public String getBase64Screenshot()
	{
	    return ((TakesScreenshot) Base.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
	@AfterStep
	public void af(Scenario scenario) throws IOException, InterruptedException
	{
	    if(scenario.isFailed())
	    {		scenario.attach(getBase64Screenshot(),"image/jpg","fail");       
 	    }
 	}
	public static WebDriver getDriver()
	{
 		return driver1;
		
	}

}

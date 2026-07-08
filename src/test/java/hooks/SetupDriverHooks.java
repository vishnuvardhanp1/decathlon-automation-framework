package hooks;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import java.net.URL;










public class SetupDriverHooks  extends Base {
	RemoteWebDriver remoteDriver;
	//	WebDriver driver;
		@Before
		public void setup()
		{
			
				try {
					String browser=this.getBrowser();
					
					System.out.println("java -jar src/test/resources/selenium-server-4.44.0.jar standalone");
					if (browser.equals("chrome")) {
				       //driver = new ChromeDriver();  
						//System.out.println("***REACHED IF");
						
						  ChromeOptions options = new ChromeOptions();
						 options.setCapability("platformName", "Windows");
						 
						  remoteDriver = new RemoteWebDriver( new URL("http://localhost:4444"),options
						  
						 );
						 
				    }
					else if( browser.equals("edge"))
					{
					//	driver = new EdgeDriver();  
						//grid setup
						 EdgeOptions options = new EdgeOptions();
						 options.setCapability("platformName", "Windows");
	
					 remoteDriver = new RemoteWebDriver(
		                    new URL("http://localhost:4444"),options
			                    
		            );
						 
					}
					//setDriver(driver);
					setDriver(remoteDriver);

			        getDriver().manage().window().maximize();

				System.out.println("GRID STARTED");
			    getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		     /*   getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		        getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(30));*/

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		
		@After
		public void tearDown(Scenario scenario)
		{
			  if (!scenario.isFailed()) { byte[] screenshot = ((TakesScreenshot)
			  getDriver()).getScreenshotAs(OutputType.BYTES);
			  
			 Allure.addAttachment( "Screenshot", new ByteArrayInputStream(screenshot) ); }
			 
		    
			getDriver().quit();
		}


}

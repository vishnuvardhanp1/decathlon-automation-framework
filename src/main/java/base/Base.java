package base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Base {
	public static void main(String[] args) throws Exception {
		Base base=new Base();
		System.out.println(base.getUrl());
		System.out.println(base.getFrameworkUrl());
		System.out.println(base.getBrowser());
	}
  // private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static WebDriver driver;
    public static WebDriver getDriver() {
    	return driver;
      //  return driver.get();
    }
    public static void setDriver(WebDriver driver1) {
    	    driver=driver1;
        //driver.set(driver1);
    }	
	public String getUrl() throws Exception
	{
		Properties prop=new Properties();
		prop.load(new FileInputStream
		("C:\\Users\\VISHNU VARDHAN\\eclipse-workspace\\decathlon-automation-framework\\"
				+ "src\\main\\java\\data.properties"));
		return prop.getProperty("url");
	}
	
	
	public String getFrameworkUrl() throws Exception
	{
		Properties prop=new Properties();
		prop.load(new FileInputStream
		("C:\\Users\\VISHNU VARDHAN\\eclipse-workspace\\decathlon-automation-framework\\"
				+ "src\\main\\java\\data.properties"));
		return prop.getProperty("frameworkUrl");
	}
	
	
	
	public String getBrowser() throws Exception
	{
		Properties prop=new Properties();
		prop.load(new FileInputStream
		("C:\\Users\\VISHNU VARDHAN\\eclipse-workspace\\decathlon-automation-framework\\"
				+ "src\\main\\java\\data.properties"));
		return prop.getProperty("browser");
	}

}

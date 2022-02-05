package APPHooks;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() throws FileNotFoundException
	{
		configReader = new ConfigReader();
		prop=configReader.init_prop();
		
	}
	
	@Before(order = 1)
	public void launchBrowser()
	{
		String browsername = prop.getProperty("browser");
		driverFactory=new DriverFactory();
		driverFactory.init_driver(browsername);
	}

	
	@After(order=0)
	public void QuitBrowser()
	{
		//driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario sc)
	{
  if (sc.isFailed())
  {
	  sc.getName().replaceAll(" ","-");
	//  byte[] sourcePath =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
  }
	}
}

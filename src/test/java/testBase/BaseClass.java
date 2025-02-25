package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class BaseClass {
    
	public Logger logger;
    public static WebDriver driver;
    public Properties p;
    

	@SuppressWarnings("deprecation")
	@BeforeClass(groups= {"Sanity", "Regression", "Master","Datadriven"})
	@Parameters ({"os", "browser"})
	public void setup(String os, String br) throws IOException {
		
		logger = LogManager.getLogger(this.getClass());
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
		if(p.getProperty("execution_environment").equalsIgnoreCase("remote"))//for grid
		{
			DesiredCapabilities capability = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows")) 
			{
				capability.setPlatform(Platform.WIN10);
			}
			else if (os.equalsIgnoreCase("MAC"))
			{
				capability.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("no match");
				return;
			}
			switch(br.toLowerCase()) {
			case "chrome":capability.setBrowserName("chrome");break;
			case "edge":capability.setBrowserName("MicrosoftEdge");break;
			default : System.out.println("no match");return;
			}
			
		driver = new RemoteWebDriver(new URL("http://192.168.1.6:4444/wd/hub"),capability);
		}
		
		if(p.getProperty("execution_environment").equalsIgnoreCase("local"))
		{
		switch(br.toLowerCase())
		{
		case "chrome" : driver= new ChromeDriver();break;
		case "edge" : driver = new EdgeDriver();break;
		case "firefox" : driver = new FirefoxDriver();break;
		default : System.out.println("invalid");return;
		}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get(p.getProperty("appurl"));     //reading rl from property file
	   
	    driver.manage().window().maximize();
	
	}
	@AfterClass(groups= {"Sanity", "Regreesion", "Master","Datadriven"})
	public void tearDown() {
		driver.quit();
		
	}
	 public String ramdomString() {
		 @SuppressWarnings("deprecation")
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		 return generatedString;
	 }
	 public String randomNumber() {
		 @SuppressWarnings("deprecation")
		String generatedNumber = RandomStringUtils.randomNumeric(7);
		 return generatedNumber;
	 }
	 public String randomAlphaNumeric() {
		 @SuppressWarnings("deprecation")
		String generatedAlhaNumeric = RandomStringUtils.randomAlphanumeric(9);
		 return generatedAlhaNumeric;
		 //or
		 // String generatedString = RandomStringUtils.randomAlphabetic(3);
		 //String generatedNumber = RandomStringUtils.randomNumeric(3);
		 //return generatedString+"@"+generatedNumber;
	 }
	 
	 public String captureScreen(String tname) throws IOException{
		 String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		 File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		 String targetFilePath = System.getProperty("user.dir")+"\\screenshotd\\"+tname+"_"+timestamp+".png";
		File targetFile = new File(targetFilePath);
		 sourceFile.renameTo(targetFile);
		 return targetFilePath;
	 }
	 
	 }


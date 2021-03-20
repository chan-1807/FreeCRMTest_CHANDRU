package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.util.TestUtil;
import com.crm.util.WebEventListener;

public class TestBase {
	
	 public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener weblistener;
	public static EventFiringWebDriver e_driver;
	public  Logger log=Logger.getLogger(this.getClass());
	public TestBase() {
		 try {
			 prop=new Properties();
			 log.info("TESTING LOGGER");
			 FileInputStream fis= new FileInputStream("C:\\Users\\Chandru\\Documents\\Programs\\SeleniumCG\\FreeCRMTest\\src\\main\\java\\com\\crm\\config\\config.properties");
			 prop.load(fis);
		 }catch(FileNotFoundException e) {
			 e.printStackTrace();
		 }catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialisation() {
		String browsername= prop.getProperty("browser");
		
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandru\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "");
			driver=new FirefoxDriver();
		}
		
		e_driver=new EventFiringWebDriver(driver);
		weblistener=new WebEventListener();
		e_driver.register(weblistener);
		driver=e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOADTIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
		
		
		
	}
	

}

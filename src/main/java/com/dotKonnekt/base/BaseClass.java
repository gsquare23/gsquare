package com.dotKonnekt.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//public static  WebDriver driver;
	public static Properties prop;
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static WebDriver getDriver() {
		return driver.get();
	}


	
	@BeforeSuite
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		File file = new File(System.getProperty("user.dir")+"\\configProperties\\config.properties");

		 prop = new Properties();
		FileInputStream fis = new FileInputStream(file);

		prop.load(fis);
		
		
	}
	
	
	
	public void launchApp()  {
		
		/*
		 * ChromeOptions chromeOptions = new ChromeOptions();
		 * chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		 * chromeOptions.setAcceptInsecureCerts(true);
		 * chromeOptions.addArguments("disable-infobars");
		 * chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 */
		
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver()); }
		
		else if(browsername.contains("MicrosoftEdge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver() );
		}
		
		else if(browsername.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		
	
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 40);
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
		//Thread.sleep(5);
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 40);
		
	}
	
	@AfterSuite
	public void flush() {
		ExtentManager.endReport();
	}
	
}

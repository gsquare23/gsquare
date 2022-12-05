package com.dotKonnekt.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.dataProviders.DataProviders;
import com.dotKonnekt.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	// public static WebDriver driver;
	public static Properties prop;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		File file = new File(System.getProperty("user.dir") + "\\configProperties\\config.properties");

		prop = new Properties();
		FileInputStream fis = new FileInputStream(file);

		prop.load(fis);

	}
	
	//@BeforeMethod(dataProvider = "getTitle", dataProviderClass = DataProviders.class,alwaysRun = true )
	public void launchApp(String browsername, String Url) {

		System.out.println(browsername);
		// String browsername = prop.getProperty("browser");

		if (browsername.contains("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}

		else if (browsername.contains("MicrosoftEdge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}

		else if (browsername.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} /*
			 * else if (browsername.contains("Mobile")) { Map<String, String>
			 * mobileEmulation = new HashMap<>(); mobileEmulation.put("deviceName",
			 * "iphone 12 pro"); ChromeOptions chromeOptions = new ChromeOptions();
			 * chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			 * driver.set(ChromeDriver(chromeOptions)); }
			 */

		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 40);

		
		getDriver().get(Url);
		/*
		 * if(Url.equalsIgnoreCase("Login")) {
		 * getDriver().get(prop.getProperty("LoginUrl"));} else
		 * if(Url.equalsIgnoreCase("Recipe")){
		 * getDriver().get(prop.getProperty("RecipeUrl")); }
		 */
		 

		getDriver().manage().window().maximize();

	//	Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 40);

	}

	@AfterSuite
	public void flush() {
		ExtentManager.endReport();
	}

}

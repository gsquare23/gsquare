package com.dotKonnekt.base;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.dotKonnekt.actionDrivers.Action;
import com.dotKonnekt.dataProviders.DataProviders;
import com.dotKonnekt.utility.ExtentManager;
import com.dotKonnekt.utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	// public static WebDriver driver;
	public static Properties prop;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static  WebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite(groups = {"LoggedIn","NotLoggedIn"})
	public void loadConfig() throws IOException {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		File file = new File(System.getProperty("user.dir") + "\\configProperties\\config.properties");

		prop = new Properties();
		FileInputStream fis = new FileInputStream(file);

		prop.load(fis);

	}
	
	//@BeforeMethod(dataProvider = "getTitle", dataProviderClass = DataProviders.class,alwaysRun = true )
	public void launchApp_V1(String browsername, String Url) {

		System.out.println(browsername);
		// String browsername = prop.getProperty("browser");

		if (browsername.contains("Chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			DesiredCapabilities cp = new DesiredCapabilities();
			cp.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			chromeOptions.merge(cp);
			driver.set(new ChromeDriver(chromeOptions));
		}

		else if (browsername.contains("MicrosoftEdge") || browsername.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}

		else if (browsername.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			Dimension d = new Dimension(1280, 587);
			getDriver().manage().window().setSize(d);

		} 
		else if (browsername.contains("Headless")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--window-size=1920,1200");
			chromeOptions.addArguments("disable-gpu");
			driver.set(new ChromeDriver(chromeOptions));
		}

		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 100);
		long s = System.currentTimeMillis();
		
		getDriver().get(Url);
		 
		long e = System.currentTimeMillis();
		long r = e - s;
		System.out.println("Page load time in milliseconds: " + r);
		getDriver().manage().window().maximize();

		Action.implicitWait(getDriver(), 10);
		
		getDriver().findElement(By.xpath("//button[normalize-space()='Accept']")).click();
		Log.info(browsername+"Browser Launch is successfully Completed");

		//Thread.sleep(5000);
	}
	
	public void launchApp_EB(String browsername, String Url) throws InterruptedException {

		System.out.println(browsername);
		// String browsername = prop.getProperty("browser");

		if (browsername.contains("Chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			DesiredCapabilities cp = new DesiredCapabilities();
			cp.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			chromeOptions.merge(cp);
			driver.set(new ChromeDriver(chromeOptions));
		}

		else if (browsername.contains("MicrosoftEdge")|| browsername.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}

		else if (browsername.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			Dimension d = new Dimension(1280, 587);
			getDriver().manage().window().setSize(d);
			Thread.sleep(2000);
		} 
		else if (browsername.contains("Headless")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--window-size=1920,1200");
			chromeOptions.addArguments("disable-gpu");
			driver.set(new ChromeDriver(chromeOptions));
		}

		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 40);
		long s = System.currentTimeMillis();
		
		getDriver().get(Url);
		 
		long e = System.currentTimeMillis();
		long r = e - s;
		System.out.println("Page load time in milliseconds: " + r);
		getDriver().manage().window().maximize();

		Action.implicitWait(getDriver(), 10);
		
		Log.info(browsername+"Browser Launch is successfully Completed");
	
	}

	@AfterSuite(groups = {"LoggedIn","NotLoggedIn"})
	public void flush() {
		ExtentManager.endReport();
	}

}

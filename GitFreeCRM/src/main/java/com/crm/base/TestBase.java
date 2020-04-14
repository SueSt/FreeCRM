package com.crm.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	
	
//1- create a class constructor	
	public TestBase() {
		
		try { 
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\souad\\eclipse-Newworkspace\\ZZZFreeCrmTest\\src\\main\\java\\com\\crm\\config\\config.properties");
			prop.load(ip);
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
			e.printStackTrace();
		}
	}
	
//2- Initialize the Browser
	public static void Initialization() {
		String browserName= prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\souad\\eclipse-Newworkspace\\ZZZFreeCrmTest\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("This step is completed1");
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	
		} else if (browserName.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();	
		}
		
		e_driver= new EventFiringWebDriver(driver);
		//Now create object of EventListenerHandler to register it with EventFiringWebDriver
		eventListener= new WebEventListener();
		e_driver.register(eventListener);
		driver= e_driver;

		
		driver.get(prop.getProperty("url"));
		System.out.println("This step is completed2");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("wait.load")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("wait.implicit")), TimeUnit.SECONDS);
		System.out.println("This step is completed3");
		//WebDriverWait Wait = new WebDriverWait(driver, Integer.parseInt(prop.getProperty("explicit.wait")));
		System.out.println("This step is completed4");
	
		
	}

	
	
	
	
	
	
	
	
	
	
	
}

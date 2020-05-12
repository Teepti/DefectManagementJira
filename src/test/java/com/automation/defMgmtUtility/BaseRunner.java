package com.automation.defMgmtUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.pageObjects.JiraPageObjects;
import com.automation.utils.ExcelConnection;
import com.automation.utils.WebDriverService;
import com.codoid.products.exception.FilloException;

public class BaseRunner {
	public static List<Map<String, String>> configData = null;
	public static WebDriver driver = null;
	static JiraPageObjects jiraPage = PageFactory.initElements(driver, JiraPageObjects.class);
	
	public static void loadConfig()
	{
		Properties prop = System.getProperties();
		String propFileName = "config.properties";
		try{
			InputStream inputStream = new FileInputStream(propFileName);
			prop.load(inputStream);
		}catch(IOException ex){
			System.out.println("property file '" + propFileName + "' not found in the classpath");
		}
	}
	
	public static void navigateURL() throws IOException, InterruptedException, FilloException {
		configData = ExcelConnection.getConfigData();
		driver= WebDriverService.initialize(configData.get(0).get("Browser"));
		System.out.println("implicitWait " + System.getProperty("implicitWait"));
		int implicitWait = Integer.parseInt(System.getProperty("implicitWait"));
		System.out.println("implicitWait " + implicitWait);
		String appURL = configData.get(0).get("URL");
		Assert.assertNotNull(appURL, "Application URL should not be null");
		driver.manage().timeouts().implicitlyWait(implicitWait,TimeUnit.SECONDS);
		driver.navigate().to(appURL);
		driver.manage().window().maximize();
		System.out.println("Navigated to the URL: " + appURL);
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		// stick it in the report
	}
	
	public static void login() throws Throwable {
		configData = ExcelConnection.getConfigData();
		String username = configData.get(0).get("Username");
		String password = configData.get(0).get("Password");
		Assert.assertNotNull(username, "Username should not be null");
		jiraPage.enteruserName(username);
		Thread.sleep(1000);
		jiraPage.clickuserNameSubmit();
		Thread.sleep(1000);
		jiraPage.enterpassWord(password);
		jiraPage.clickloginButton();
		Thread.sleep(2000);
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		// stick it in the report

	}
	
	
}

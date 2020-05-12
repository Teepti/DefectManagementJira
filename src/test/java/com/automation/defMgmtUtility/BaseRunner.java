package com.automation.defMgmtUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automation.pageObjects.JiraPageObjects;
import com.automation.utils.ExcelConnection;
import com.codoid.products.exception.FilloException;

public class BaseRunner {
	public static List<Map<String, String>> configData = null;
	WebDriver driver;
	
	public BaseRunner(WebDriver driver) {
	        this.driver = driver;
	    }
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
	
	public void navigateURL() throws IOException, InterruptedException, FilloException {
		System.out.println("implicitWait " + System.getProperty("implicitWait"));
		int implicitWait = Integer.parseInt(System.getProperty("implicitWait"));
		System.out.println("implicitWait " + implicitWait);
		configData = ExcelConnection.getConfigData();
		String appURL = configData.get(0).get("URL");
		Assert.assertNotNull(appURL, "Application URL should not be null");
		driver.navigate().to(appURL);
		System.out.println("Navigated to the URL: " + appURL);
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		// stick it in the report
	}
	
	public void login() throws Throwable {
		configData = ExcelConnection.getConfigData();
		JiraPageObjects jiraPage = PageFactory.initElements(driver, JiraPageObjects.class);
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
	
	public void navigatetoAdvanceSearch() throws Throwable {
		JiraPageObjects jiraPage = PageFactory.initElements(driver, JiraPageObjects.class);
		jiraPage.clickGenpactWorkSpace();
		driver.navigate().refresh();
		Thread.sleep(2000);
		jiraPage.clickAllIssues();
		Thread.sleep(1000);
		jiraPage.clickAdvancedSearch();
		Thread.sleep(2000);
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		// stick it in the report
	}
}

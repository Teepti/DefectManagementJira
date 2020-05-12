package com.automation.defMgmtUtility;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.defMgmtUtility.BaseRunner;
import com.automation.utils.ExcelConnection;
import com.automation.utils.WebDriverService;
import com.codoid.products.exception.FilloException;

public class DefMgmtUtilityJira {

	public static List<Map<String, String>> metaData = null;
	public static List<Map<String, String>> Data = null;
	public static List<Map<String, String>> configData = null;
	public static WebDriver driver = null;
//	@BeforeTest
//	public void getData() throws InterruptedException, FilloException
//	{
//		metaData = ExcelConnection.getAssigneeList();
//		Data = ExcelConnection.getexcelData();
//		configData = ExcelConnection.getConfigData();
//	}
	
	@Test
	public static void main(String[] args) throws Throwable {

		BaseRunner.loadConfig();
		configData = ExcelConnection.getConfigData();
		driver = WebDriverService.initialize(configData.get(0).get("Browser"));
		BaseRunner base = new BaseRunner(driver);
		base.navigateURL();
		base.login();
		Thread.sleep(10000);
		base.navigatetoAdvanceSearch();	
		Thread.sleep(10000);
	}

}

package com.automation.tests;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import com.Jira.db.*;
import com.automation.AutomationLibrary.AutomationLibrary;
import com.automation.AutomationLibrary.ui.config.IdentifyBy;
import com.automation.AutomationLibrary.ui.config.UIElement;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DefectManagementJira {

	private static Hashtable<Long, AutomationLibrary> automationLibraries = new Hashtable<Long, AutomationLibrary>();
	public static List<Map<String, String>> metaData = null;
	public static List<Map<String, String>> Data = null;
	public static List<Map<String, String>> configData = null;
	public static WebDriver driver = null;
	@BeforeTest
	public void getData() throws InterruptedException, FilloException
	{
		metaData = ExcelConnection.getAssigneeList();
		Data = ExcelConnection.getexcelData();
		configData = ExcelConnection.getConfigData();
	}
	
	public static void main(String[] args) throws InterruptedException, FilloException {

		if(configData.get(0).get("Browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver=new ChromeDriver();
		}
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
		 String url = configData.get(0).get("URL");
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("ite.03garg@gmail.com");
		driver.findElement(By.cssSelector("#login-submit > span > span > span")).click();
		driver.findElement(By.id("password")).sendKeys("Test#15jan");
		driver.findElement(By.cssSelector("#login-submit > span > span > span")).click();
		Thread.sleep(5000);

//		List<String> Assignee=new ArrayList<>();
//
//		Fillo file=new Fillo();
//		Connection connection=file.getConnection("D:\\JiraData.xlsx");		
//		String strQuery="Select Assignee from Test_Scenarios_NEW where Status='Deferred' and Label='Requirement'";
//		Recordset rs=connection.executeQuery(strQuery);
//		System.out.println("Total Row Count="+rs.getCount());
//		while(rs.next())
//		{
//			System.out.println("Assignee Name--"+rs.getField("Assignee"));
//			Assignee.add(rs.getField("Assignee"));
//		}
//		rs.close();
//		connection.close();
//		String NewAssignee=Assignee.get(0);		
//		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//		 driver.manage().deleteAllCookies();
//		 //WebDriver driver = new FirefoxDriver(capabilities);
//		driver.get("https://id.atlassian.com/login");
//		driver.manage().window().maximize();
//		driver.findElement(By.id("username")).sendKeys("ite.03garg@gmail.com");
//		driver.findElement(By.cssSelector("#login-submit > span > span > span")).click();
//		driver.findElement(By.id("password")).sendKeys("Test#15jan");
//		driver.findElement(By.cssSelector("#login-submit > span > span > span")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//h5[text()='Genpact']")).click();
//		driver.findElement(By.xpath("//span[contains(text(),'Genpact')]")).click();
//		driver.navigate().refresh();
//		Thread.sleep(10000);
//		driver.findElement(By.xpath("//div[contains(text(),'All issues')]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//span[contains(text(),'Advanced search')]")).click();
//		driver.findElement(By.xpath("//textarea[@id='advanced-search']")).clear();
//		driver.findElement(By.xpath("//textarea[@id='advanced-search']")).sendKeys("project = GEN AND labels in (UserStory, Requirement, HLD_Issue, Enhancement) AND (assignee in (EMPTY) OR assignee not in (5e8d65421008ef0b7ee4d0f5, 5eabd09da4c57d0b8be779df))");
//		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
//		driver.navigate().refresh();
//		Thread.sleep(10000);
//		for(int i=0;i<3;i++)
//		{
//			try
//			{
//			driver.findElement(By.xpath("//a[contains(text(),'Scenario 8')]")).click();
//			break;
//		}
//			catch(Exception e){
//				System.out.println(e.getMessage());
//				
//			}
//		}
//		
//		String AssigneeName=driver.findElement(By.xpath("//div[contains(text(),'Unassigned')]")).getText();
//		if(AssigneeName.equals("Unassigned"))
//		{
//			
//			String status=driver.findElement(By.xpath("//button[@class='elro8wh2 css-1iy307c']")).getText();
//			String label=driver.findElement(By.xpath("//a[@class='styled__Link-sc-17jb35i-1 iHqNYf']")).getText();
//			if(status.equalsIgnoreCase("Deferred") && label.equalsIgnoreCase("UserStory"))
//			{
//				WebElement assigneeName = driver.findElement(By.cssSelector(".SingleLineTextInput__ReadView-sc-4hfvq0-0.epXzqq"));
//				assigneeName.click();
//				String valueToSelect = "Nitu Gupta";
//				for(int i=0;i<10;i++) 
//				{
//					String textValue = driver.findElement(By.xpath("//div[contains(@id,'react-select-assignee-option-" + i + "')]/div/div[2]/div/span")).getText();
//					if(textValue.equalsIgnoreCase(valueToSelect))
//					{
//						driver.findElement(By.xpath("//div[contains(@id,'react-select-assignee-option-" + i + "')]/div/div[2]/div/span")).click();
//						break;
//					}
//				}
//				
//				Thread.sleep(2000);
//			}
//
//		}
//		Thread.sleep(1000);
	
	}

}

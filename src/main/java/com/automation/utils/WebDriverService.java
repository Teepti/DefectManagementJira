package com.automation.utils;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Value;


/**
 * @author Genpact Automation Team
 *
 */
public class WebDriverService {

	public static  WebDriver driver;
	@Value("${implicitWait}")
	private int implicitWait;

	public static WebDriver initialize(String browser) {
		String osName = System.getProperty("os.name");
		switch (browser){
		case "Firefox": 
			FirefoxProfile fProfile = new FirefoxProfile();
			fProfile.setAcceptUntrustedCertificates(true);
			fProfile.setPreference("browser.download.dir", 
                                               System.getProperty("user.dir") +
                                               System.getProperty("file.separator") + 
                                               "target" + 
                                               System.getProperty("file.separator") + 
                                               "Downloads");
			fProfile.setPreference("browser.download.folderList", 2);
			fProfile.setPreference("browser.download.manager.showWhenStarting", false);
			fProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
			fProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain");
			
			driver = new FirefoxDriver(); 
			break;
		case "InternetExplorer": 
			System.setProperty("webdriver.ie.driver","IEDriverServer.exe");		 
			driver = new InternetExplorerDriver();			
			break;
		case "Chrome":
			if ( osName.contains("Mac") || osName.contains("mac") || 
                             osName.contains("linux") || osName.contains("Linux") 
                           )
			{
				System.setProperty("webdriver.chrome.driver","chromedriver");
			}
			else
			{
				System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			}
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities = DesiredCapabilities.chrome();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1);
			chromePrefs.put("credentials_enable_service", "false");
			chromePrefs.put("profile.password_manager_enabled", "false");
			chromePrefs.put("download.prompt_for_download", "false");
			chromePrefs.put("download.default_directory", System.getProperty("user.dir")+System.getProperty("file.separator") + "target"+System.getProperty("file.separator") + "Downloads");
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("test-type", "start-maximized","no-default-browser-check");
			chromeOptions.setExperimentalOption("prefs", chromePrefs);
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			chromeOptions.addArguments("--no-sandbox");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
			break;
		case "Safari":
			driver = new SafariDriver();
			break;
		case "Phantom":
			System.setProperty("webdriver.ie.driver","headless_ie_selenium.exe");
			System.setProperty("HEADLESS_UNIQUE","1");
			driver = new InternetExplorerDriver();
			break;
		case "MicrosoftEdge": 
			System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe"); //msedgedriver.exe"
			driver = new EdgeDriver();
			break;
		default:
			driver = new FirefoxDriver(); 
		}
		return driver;
	}	
}

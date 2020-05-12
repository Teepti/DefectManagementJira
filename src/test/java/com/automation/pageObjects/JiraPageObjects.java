package com.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JiraPageObjects {

	 WebDriver driver;

	    public JiraPageObjects(WebDriver driver) {
	        this.driver = driver;
	    }

	/******* LoginPage Objects Starts **********************************/
	    @FindBy(id="username")
	    WebElement userName;
	    
	    @FindBy(id="password")
	    WebElement passWord;
	    
	    @FindBy(css="#login-submit > span > span > span")
	    WebElement usernameSubmitButton;
	    
	    @FindBy(css="#login-submit > span > span > span")
	    WebElement loginButton;

	    public void enteruserName(String username) {
	    	userName.sendKeys(username);
	    }
	    public void enterpassWord(String password) {
	    	passWord.sendKeys(password);
	    }
	    public void clickuserNameSubmit() {
	    	usernameSubmitButton.click();
	    }
	    public void clickloginButton() {
	    	loginButton.click();
	    }
	    
	    /******* LoginPage Objects Ends **********************************/
	    
	    /******* HomePage Objects Starts **********************************/
	    @FindBy(xpath="//h5[text()='Genpact']")
	    WebElement genpactWorkSpace;
	    
	    @FindBy(xpath="//span[contains(text(),'Advanced search')]")
	    WebElement advancedSearchButton;
	    
	    @FindBy(xpath="//*[@id=\"pin-filter-allissues\"]/div/div")
	    WebElement allIssuesTab;

	    public void clickGenpactWorkSpace() {
	    	genpactWorkSpace.click();
	    }
	    public void clickAllIssues() {
	    	allIssuesTab.click();
	    }
	    public void clickAdvancedSearch() {
	    	advancedSearchButton.click();
	    }
	    
	    /******* HomePage Objects Ends **********************************/
}

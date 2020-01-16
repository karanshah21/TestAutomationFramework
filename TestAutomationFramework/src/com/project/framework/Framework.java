package com.project.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Framework {
	//This class servers for adding all the method needed to access the browser

	static Properties env_prop = new Properties();
	static InputStream env_input = null;
	static Properties ele_prop = new Properties();
	static InputStream ele_input = null;	
	static  protected WebDriver driver = null;
	
	
	public static WebDriver goToHomePage(String browser)
	{
		loadProperties();
		String home_url = env_prop.getProperty("HOME_URL"); //Mention HOME_URl in EnvironmentSetup file to the testing environment page.
		openHomePage(home_url, browser); //Enter Browser manually or pass the value to this method-> "FF" or "Chrome"
		return driver;
	}
	
	public static void openHomePage(String url, String browser)
	{	
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "Untitled//Users//karan//Documents//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
		if(browser.equals("FF"))
		{
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
	}
	
	public static void loadProperties()
	{
		
		try {
			env_input = new FileInputStream("EnvironmentSetup.properties");
			ele_input = new FileInputStream("ElementLocators.properties");
			// load a properties file
			env_prop.load(env_input);
			ele_prop.load(ele_input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public static void enterValueInTextBox(String element, String text)
	{
		waitForElement(element, 20);	
		String element_locator = ele_prop.getProperty(element);
		
		if(element.contains("_id"))
		{
			driver.findElement(By.id(element_locator)).sendKeys(text);
		}
		if(element.contains("_xpath"))
		{
			driver.findElement(By.xpath(element_locator)).sendKeys(text);			
		}
		if(element.contains("_name")){
			driver.findElement(By.name(element_locator)).sendKeys(text);
		}
		if(element.contains("_css")){
			driver.findElement(By.cssSelector(element_locator)).sendKeys(text);
		}
	}
	
	public static void clickElement(String element)
	{
		waitForElement(element, 20);		
		String element_locator = ele_prop.getProperty(element);
		
		if(element.contains("_id"))
		{
			driver.findElement(By.id(element_locator)).click();
		}
		if(element.contains("_xpath"))
		{
			driver.findElement(By.xpath(element_locator)).click();			
		}
		if(element.contains("_name")){
			driver.findElement(By.name(element_locator)).click();;
		}
	}
	
	public static void waitForElement(String element, int time_to_wait)
	{
		WebDriverWait wait = new WebDriverWait(driver, time_to_wait);
		String element_locator = ele_prop.getProperty(element);
		
		if(element.contains("_id"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element_locator)));
		}
		if(element.contains("_xpath"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element_locator)));		
		}
		if(element.contains("_name")){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element_locator)));	
		}
	}
	
	public static String getText(String element)
	{
		waitForElement(element, 20);
		String element_locator = ele_prop.getProperty(element);		
		
		if(element.contains("_id"))
		{
			return driver.findElement(By.id(element_locator)).getText();
		}
		if(element.contains("_xpath"))
		{
			return driver.findElement(By.xpath(element_locator)).getText();			
		}
		if(element.contains("_name")){
			return driver.findElement(By.name(element_locator)).getText();
		}
		return "Element Not Found";
		
	}
	public static void selectFromDropdownByIndex(String element, int index){
		waitForElement(element, 20);
		String element_locator = ele_prop.getProperty(element);	
		if(element.contains("_id"))
		{
			Select dropdown= new Select(driver.findElement(By.id(element_locator))); //location included here
			  dropdown.selectByIndex(index);
		}
		if(element.contains("_xpath"))
		{
			Select dropdown= new Select(driver.findElement(By.xpath(element_locator))); //location included here
			  dropdown.selectByIndex(index);		
		}
		if(element.contains("_name")){
			Select dropdown= new Select(driver.findElement(By.name(element_locator))); //location included here
			  dropdown.selectByIndex(index);
		}
		
	}
	public static void selectFromDropdownByText(String element, String val){
		waitForElement(element, 20);
		String element_locator = ele_prop.getProperty(element);	
		String permission=val;
		if(element.contains("_id"))
		{
			Select dropdown= new Select(driver.findElement(By.id(element_locator))); 
			dropdown.selectByVisibleText(permission);
		}
		if(element.contains("_xpath"))
		{
			Select dropdown= new Select(driver.findElement(By.xpath(element_locator))); 
			dropdown.selectByVisibleText(permission);		
		}
		if(element.contains("_name")){
			Select dropdown= new Select(driver.findElement(By.name(element_locator))); 
			dropdown.selectByVisibleText(permission);
		}
		
	}
	public static void uploadImage(String element, String imgPath){
		waitForElement(element, 20);
		String element_locator = ele_prop.getProperty(element);
		String path=ele_prop.getProperty(imgPath);
		if(element.contains("_name")){
			driver.findElement(By.name(element_locator)).sendKeys(path);
		}
		if(element.contains("_id")){
			driver.findElement(By.name(element_locator)).sendKeys(path);
		}
	}
	public static void clickOkAlert(){
		driver.switchTo().alert().accept();
	}
	public static void clickCancelAlert(){
		driver.switchTo().alert().dismiss();
	}
	public static void clearText(String element){
		waitForElement(element, 20);
		String element_locator = ele_prop.getProperty(element);		
		
		if(element.contains("_id"))
		{
			driver.findElement(By.id(element_locator)).clear();;
		}
		if(element.contains("_xpath"))
		{
			driver.findElement(By.xpath(element_locator)).clear();			
		}
		if(element.contains("_name")){
			driver.findElement(By.name(element_locator)).clear();
		}
	}
	
}

package july31;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import july31.Test;

public class Listing1 extends Test
//public interface Listing1
{
	
	public void listing() throws Exception
	{
		File file = new File("E:\\workspace\\july31\\src\\july31\\listing.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		//jobalert menu
		 driver.findElement(By.xpath(prop.getProperty("jobalertmenu"))).click();
		//create jobalert
		 driver.findElement(By.xpath(prop.getProperty("createjobalert"))).click();
		log.info("Clicking Create jobalert ");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		Select Select = new Select(driver.findElement(By.xpath(prop.getProperty("profileselection"))));
		log.info("Selecting profile ");
		Select.selectByIndex(5);
	    driver.findElement(By.xpath(prop.getProperty("excludecompany"))).sendKeys(prop.getProperty("excludecompanyname"));
		log.info("Entering exclude company name");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("alertname"))).sendKeys(prop.getProperty("alertname"));
		driver.findElement(By.xpath(prop.getProperty("savebutton"))).click();
		log.info("Clicking save alert");
		// Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//back to jobalert menu
	    driver.findElement(By.xpath(prop.getProperty("menu"))).click();
		Thread.sleep(100);
		// alert list
		driver.findElement(By.xpath(prop.getProperty("alertlist"))).click();
		log.info("Clicking alertlist");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		Select select1 = new Select(driver.findElement(By.xpath(prop.getProperty("consolidatedalert"))));
		select1.selectByIndex(0);
		Select select2 = new Select(driver.findElement(By.xpath(prop.getProperty("instantalert"))));
		select2.selectByIndex(0);
		Thread.sleep(1000);
		// delete alert
		driver.findElement(By.xpath(prop.getProperty("deleteicon"))).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}

}

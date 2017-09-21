package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
	public static void main(String args[]) throws InterruptedException
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\javas\\chromedriver.exe" );
		
	 driver = new ChromeDriver(); 
	 driver.get("https://www.google.com");
	WebElement e2=driver.findElement(By.name("q"));
	e2.sendKeys("lpo");
	WebElement e=driver.findElement(By.xpath(".//*[@id='tsf']/div[2]/div[3]/center/input[1]"));
	e.click();
	Thread.sleep(5000);
	WebElement e3=driver.findElement(By.xpath(".//*[@id='gs_htif0']"));
	String s=e3.getText();
	System.out.println(s);
	
	}

}

package keyword.Toolsqa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionKeywords {

	public static WebDriver driver;

	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Javas\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void navigatewebsite() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://uat.techfetch.com");
		Thread.sleep(2000);
	}

	public static void Click_MyAccount() throws Exception {
		
		driver.findElement(By.xpath(".//*[@id='ucHeaderCtrl_divCandidate']/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='jsloginpop']")).click();	
	}

	public static void input_Username() throws Exception {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("candidatecontentframe");
		driver.findElement(By.xpath(".//*[@id='txtemailid']")).sendKeys("trainee2@tiliconveli.com");
	}

	public static void input_Password() {
		driver.findElement(By.xpath(".//*[@id='txtpwd']")).sendKeys("TV@234");
	}

	public static void click_Login() {
		 driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
	}

	public static void waitFor() throws Exception {
		Thread.sleep(5000);
	}

	public static void click_Logout() {
		driver.findElement (By.xpath(".//*[@id='drop7']/img")).click();
        driver.findElement (By.xpath(".//*[@id='mini-nav']/li/ul/li[4]/div/input")).click();
	}

	public static void closeBrowser() {
		driver.quit();
	}

}
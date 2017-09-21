package finalauto;



import java.util.concurrent.TimeUnit;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import finalauto.Final;

public class Final1 {
	
    public static void main(String[] args) throws Exception  {
        Logger log = Logger.getLogger("devpinoyLogger");
    
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\javas\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    Final g=new Final(driver);
    
 g.login();
    //g.upload();
    //g.profile();
    //g.myresume();
    //g.myjob();
    //g.features();
    //g.jobalert();
    //g.logout();
    
    }}

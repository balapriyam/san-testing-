package july31;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import july31.Listing1;
import july31.Test;

public class Listing2
{
	public void action() 
	{
	File file = new File("E:\\workspace\\july31\\src\\july31\\data.properties");
    FileInputStream fileInput;
    fileInput = new FileInputStream(file);
    Properties prop = new Properties();
    prop.load(fileInput);
    WebElement jobalert;
	jobalert.click();
	createalert.click();
	exclude.sendKeys(prop.getProperty("excludecompanyname"));
	name.sendKeys(prop.getProperty("alertname"));
	save.click();
	menu.click();
	list.click();
	delete.click();
	
}
}

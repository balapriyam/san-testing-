package techfetch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class Techfetch2 
{

	static WebDriver d;
	Logger log = Logger.getLogger("devpinoyLogger");
	public String workingDir;
	

	protected static WebElement xp(String xpath)
	{

		return d.findElement(By.xpath(xpath));
	}

	protected static WebElement id(String id)
	{

		return d.findElement(By.id(id));
	}

	protected static WebElement css(String cssSelector)
	{

		return d.findElement(By.cssSelector(cssSelector));
	}
@BeforeTest
	void browserOpen() throws InterruptedException
	{
		workingDir = System.getProperty("user.dir");
		System.out.println(workingDir);
		// BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver", workingDir + "\\Resources\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
	}

	@Test
	public void login() throws IOException, InterruptedException
	{
		// Login to techfetch candidate
		/**
		 * @author Arun Sakthi work name : login
		 */
		//File file = new File("E:\\workspace\\TechFetch.Automation\\Resources\\Base.properties");
		File file = new File(workingDir + "\\Resources\\Base.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		
		FileInputStream fsIP = new FileInputStream(
				  new File("E:\\workspace\\Final.automation\\src\\finalTest\\data.xlsx"));
				XSSFWorkbook wb = new XSSFWorkbook(fsIP);
				XSSFSheet worksheet = wb.getSheetAt(0);
				Cell cell;
				XSSFCell cell1=null;
			

				d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				Thread.sleep(10000);
	for (int i = 0; i <= 3; i++) 
    {
		
		d.get(prop.getProperty("URL"));
		log.info("Opening Techfetch webiste");
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		Thread.sleep(10000);
		xp(prop.getProperty("candidatelogin")).click();
		log.info("Opening candidate menu");
		Thread.sleep(1000);
		xp(prop.getProperty("loginbutton")).click();
		log.info("Clicking Login button");
		d.switchTo().defaultContent();
		d.switchTo().frame("candidatecontentframe");
		xp(prop.getProperty("mailid")).clear();

		xp(prop.getProperty("mailid")).sendKeys(prop.getProperty("username"));
		log.info("Entering mailid");
		xp(prop.getProperty("password1")).clear();
		xp(prop.getProperty("password1")).sendKeys(prop.getProperty("password"));
		log.info("Entering password");

		xp(prop.getProperty("submitbutton")).click();
		log.debug("Clicking submit button");

		Thread.sleep(1000);
		
		
		try 
		{
			WebElement web1 = d.findElement(By.xpath(".//*[@id='login']/div[1]/div"));
			boolean a2 = web1.isDisplayed();
			if (a2 = true) 
			{
				cell1 = worksheet.getRow(i).createCell(2);
				//cell1 = worksheet.getRow(i).getCell(2);
				cell1.setCellValue("Login fails");
				//cell1.
				fsIP.close();
			    FileOutputStream output_file1 =new FileOutputStream(new File(workingDir + "\\Resources\\data.xlsx"));  
	            wb.write(output_file1);
	                output_file1.close();
	        }

			}
		 catch (Exception e)
		{
			// XSSFCell cell1 = null;
				cell1 = worksheet.getRow(i).createCell(2);
			 cell1.setCellValue("Login pass");
		        fsIP.close();
		        FileOutputStream output_file1 =new FileOutputStream(new File(workingDir + "\\Resources\\data.xlsx"));  
		        wb.write(output_file1);
		        output_file1.close();
		        Thread.sleep(1000);
		        
		    	d.findElement(By.xpath(prop.getProperty("usersetting"))).click();
				log.info("Clicking user settings ");
				Thread.sleep(10000);
				d.findElement(By.xpath(prop.getProperty("logoutbutton"))).click();
				log.info("Clicking logout button ");
				Thread.sleep(10000);
		        
          // break;
		}
	

	}}

	@Test(dependsOnMethods =  "login" )
	public void upload() throws Exception 
	{
		// uploading a resume from external path
		/**
		 * @author karthiga balapriya work name : upload
		 */
		Properties prop;
		FileInputStream fileInput = new FileInputStream(workingDir + "\\Resources\\Upload.properties");
		prop = new Properties();
		prop.load(fileInput);
		d.switchTo().defaultContent();
		d.switchTo().frame("contentframe");

		xp(prop.getProperty("Uploadicon")).click();
		// xp(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[1]/td[4]/a/img")).click();
		log.debug("Clicking Replacedocs");

		Thread.sleep(1000);
		d.switchTo().defaultContent();
		d.switchTo().frame("replacedoccontentframe");
		Thread.sleep(1000);
		id("resumeupload").clear();
		id("resumeupload").sendKeys(workingDir + "\\Resources\\Resume.docx");
		log.debug("Uploading Resume");

		Thread.sleep(10000);

		xp(prop.getProperty("Iconsave")).click();
		// xp(".//*[@id='btnSubmit']")).click();
		log.debug("Clicking Submit button");

		Thread.sleep(3000);
		id("btnClose").click();
		log.debug("Clicking Close button");
	}

	@Test(dependsOnMethods = { "upload" })
	public void forward() throws Exception 
	{
		// Displaying profile detail and downloading the resume
		/**
		 * @author Arun Sakthi work name : profile
		 */
		File file = new File(workingDir + "\\Resources\\Profile.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		Set<String> Wi = d.getWindowHandles();
		// System.out.println("No of Windows:" + Wi.size());
		Iterator it = Wi.iterator();
		String main = (String) it.next();
		// System.out.println(it.next());
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

		d.switchTo().defaultContent();
		d.switchTo().frame("contentframe");
		xp(prop.getProperty("ProfileClick")).click();

		log.info("Clicking Profile");
		Wi = d.getWindowHandles();

		it = Wi.iterator();
		it = Wi.iterator();
		String mmm = (String) it.next();
		String nnn = (String) it.next();

		d.switchTo().window(nnn);
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		css(prop.getProperty("ProfileDownload")).click();
		log.info("Downloading Profile");

		Thread.sleep(4000);
		xp(prop.getProperty("ProfileForward")).click();

		log.info("Clicking Forward Button");
		Thread.sleep(3000);
		d.switchTo().defaultContent();
		d.switchTo().frame("jsforwardprofilecontentframe");
		xp(prop.getProperty("ProfileForwardToMail")).sendKeys(prop.getProperty("ProfileForwardID"));
		Thread.sleep(3000);

		log.info("Entering Forward Mailid");
		Thread.sleep(2000);
		xp(prop.getProperty("ProfileSendButton")).click();

		log.info("Clicking SendButton");
		Thread.sleep(2000);
		xp(prop.getProperty("ProfileClose")).click();

		log.info("Clicking CloseButton");
		d.close();
		d.switchTo().window(mmm);
		d.switchTo().defaultContent();
		Thread.sleep(1000);

	}

	@Test(dependsOnMethods = { "forward" })
	public void update() throws Exception 
	{
		// creating a profile and perform edit and update
		/**
		 * @author surya Balapriya work name : myresume
		 */
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("contentframe");
		File file = new File(workingDir + "\\Resources\\Update.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		Logger log = Logger.getLogger("devpinoyLogger");
		Thread.sleep(1000);
		xp(prop.getProperty("MyResume")).click();
		log.info("Opening MyResume");
		Thread.sleep(1000);
		xp(prop.getProperty("AddResume")).click();
		log.info("Selecting AddResume");

		d.switchTo().defaultContent();
		d.switchTo().frame("contentframe");

		Thread.sleep(1000);
		xp(prop.getProperty("Name1")).sendKeys(prop.getProperty("firstname"));
		log.info("Entering FirstName");

		xp(prop.getProperty("Name2")).sendKeys(prop.getProperty("middlename"));
		log.info("Entering MiddleName");
		xp(prop.getProperty("Name3")).sendKeys(prop.getProperty("lastname"));
		log.info("Entering LastName");
		Thread.sleep(2000);
		Select oSelect = new Select(xp(prop.getProperty("Country")));
		log.info("Selecting Country");
		oSelect.selectByIndex(12);
		xp(prop.getProperty("City")).sendKeys(prop.getProperty("city"));
		log.info("Entering City,state or zip");

		xp(prop.getProperty("MobNo")).sendKeys(prop.getProperty("phone(mobile)"));
		log.info("Entering MobilePhone");

		xp(prop.getProperty("HomeNo")).sendKeys(prop.getProperty("phone(home)"));
		log.info("Entering HomePhone");
		xp(prop.getProperty("WorkNo")).sendKeys(prop.getProperty("phone(work)"));
		log.info("Entering WorkPhone");
		xp(prop.getProperty("ExtensionNo")).sendKeys(prop.getProperty("phoneextension"));
		log.info("Entering Extension");

		Select oSelect1 = new Select(xp(prop.getProperty("PrefferedTime")));
		oSelect1.selectByIndex(2);
		log.info("Selecting PrefferedTime");

		Select oSelect2 = new Select(xp(prop.getProperty("Phone")));
		oSelect2.selectByIndex(2);
		log.info("Selecting Home");

		Select oSelect3 = new Select(xp(prop.getProperty("Citizen")));
		oSelect3.selectByIndex(2);
		log.info("Selecting Citizen");
		xp(prop.getProperty("WorkAuthorization")).click();
		log.info("Clicking WorkAuthorization");

		Select oSelect4 = new Select(xp(prop.getProperty("NeedNewH1B")));
		oSelect4.selectByIndex(2);
		log.info("Selecting NeedNewH1B");
		id(prop.getProperty("Resumeupload")).clear();
		log.info("clearing upload");
		id(prop.getProperty("Resumeupload")).sendKeys(workingDir + "\\Resources\\Resume.docx");

		log.info("Selecting Resume");
		Thread.sleep(10000);

		xp(prop.getProperty("Submitt")).click();
		log.info("Clicking Submit button");
		Thread.sleep(100);

		d.switchTo().defaultContent();
		d.switchTo().frame("contentframe");
		log.info("Switching to Professional");
		Thread.sleep(1000);
		id(prop.getProperty("Bachelor")).click();
		log.info("Selecting Bachelor button on Highest degree");
		Select oSelect5 = new Select(id(prop.getProperty("ExcpectedSalary")));
		oSelect5.selectByVisibleText("$10K");
		log.info("Selecting Expected salary per year");

		Select oSelect6 = new Select(id(prop.getProperty("ExpectedSalaryHour")));
		oSelect6.selectByVisibleText("$15");
		log.info("Selecting Expected salary per hour");

		id(prop.getProperty("JobTitle")).clear();
		id(prop.getProperty("JobTitle")).sendKeys(prop.getProperty("jobtitle"));
		log.info("Entering job title");

		Select oSelect7 = new Select(id(prop.getProperty("TotalExperience")));
		oSelect7.selectByVisibleText("17");
		log.info("Selecting total experience");

		css(prop.getProperty("ExpValue")).click();
		log.info("Clicking Value ");

		Select oSelect8 = new Select(id(prop.getProperty("USAExperience")));
		oSelect8.selectByVisibleText("15");
		log.info("Selecting USA experience");

		id(prop.getProperty("ResumeTitle")).clear();
		id(prop.getProperty("ResumeTitle")).sendKeys(prop.getProperty("resumetitle"));
		log.info("Entering resume title");

		id(prop.getProperty("Resumeupload")).clear();
		id(prop.getProperty("Resumeupload")).sendKeys(workingDir + "\\Resources\\Resume.docx");
		log.info("Uploading resume");
		Thread.sleep(10000);
		id(prop.getProperty("Professional")).click();
		log.info("Clicking save and next button");
		Thread.sleep(1000);

		// d.switchTo().defaultContent();
		// d.switchTo().frame("contentframe");

		// d.findElement(By.linkText("*Skills(Incomplete)")).click();
		Select oSelect9 = new Select(id(prop.getProperty("SpecializedArea")));
		oSelect9.selectByVisibleText("Java, J2EE");
		log.info("Selecting specialized area");
		Select oSelect10 = new Select(id(prop.getProperty("SpecializedSkill")));
		oSelect10.selectByVisibleText("Java Front End");
		log.info("Selecting specialized skills");
		id(prop.getProperty("Skill1")).clear();
		id(prop.getProperty("Skill1")).sendKeys(prop.getProperty("skill"));
		log.info("Entering skill1");
		Select oSelect11 = new Select(id(prop.getProperty("Years1")));
		oSelect11.selectByVisibleText("2");
		log.info("Selecting years for skill1 ");
		id(prop.getProperty("Skills")).click();
		log.info("Clicking save and next button");
		Thread.sleep(10000);
		// id("Skillsli")).click();

		// css("#Preferencesli > a")).click();
		id(prop.getProperty("BusinessDomain")).click();
		log.info("Clicking preferred employment ");
		id(prop.getProperty("PublishToAll")).click();
		log.info("Selecting resume publishing options ");
		id(prop.getProperty("prefjob")).click();
		log.info("Selecting domain experience");
		id(prop.getProperty("Preferences")).click();
		log.info("Clicking save and next button");
		Thread.sleep(10000);
		id(prop.getProperty("Keywords")).clear();
		id(prop.getProperty("Keywords")).sendKeys(prop.getProperty("keyword"));
		log.info("Entering keywords ");
		id(prop.getProperty("Contarctjobtype")).click();
		log.info("Clicking job type ");
		id(prop.getProperty("Contracttype")).click();
		id(prop.getProperty("Permanentjobtype")).click();
		id(prop.getProperty("Jobwithtitle")).clear();
		id(prop.getProperty("Jobwithtitle")).sendKeys(prop.getProperty("title"));
		log.info("Entering job with title ");
		Select oSelect12 = new Select(id(prop.getProperty("Years")));
		oSelect12.selectByVisibleText("2");
		log.info("Selecting years");
		css(prop.getProperty("Yearvalue")).click();

		// new
		// Select(id("lbPriorityList"))).selectByVisibleText("Florida
		// (FL)");
		// xp("//div[@onclick='javascript:
		// OptSelect();']")).click();
		// xp("//div[@onclick='javascript:
		// OptUnSelect();']")).click();
		id(prop.getProperty("AlertName")).clear();
		id(prop.getProperty("AlertName")).sendKeys(prop.getProperty("alert"));
		log.info("Entering alert name ");
		id(prop.getProperty("JobAlert")).click();
		log.info("Clicking save and next button");
		d.switchTo().defaultContent();
		Thread.sleep(1000);
		xp(prop.getProperty("Myjobsbutton")).click();
	}

	@Test(dependsOnMethods = { "update" })
	public void fetch() throws Exception
	{
		// fetching the job based on resume detail
		/**
		 * @author Durga work name : myjob
		 */
		File file = new File(workingDir + "\\Resources\\Fetch.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		d.switchTo().defaultContent();
		xp(prop.getProperty("myjobs")).click();
		d.switchTo().defaultContent();
		Thread.sleep(1000);
		// xp(".//*[@id='cssmenu']/ul/li[3]/a")).click();
		log.info("clicking the my jobs tab");

		id(prop.getProperty("fetchjobs")).click();
		log.info("clicking fetch job tab");
		Thread.sleep(1000);

		d.switchTo().defaultContent();
		d.switchTo().frame("contentframe");
		log.info("move to content frame");

		id(prop.getProperty("keyword")).clear();

		id(prop.getProperty("keyword")).sendKeys(prop.getProperty("keywords"));
		log.info("Entering the keyword");

		id(prop.getProperty("keyall")).click();
		log.info("select the type");

		new Select(id(prop.getProperty("country"))).selectByVisibleText("India");
		log.info("select the country");

		new Select(id(prop.getProperty("splzdarea"))).selectByVisibleText("Java, J2EE");
		log.info("select the specialized skills");

		id(prop.getProperty("advoption")).click();
		log.info("click the browse button");
		Thread.sleep(1000);

		id(prop.getProperty("state")).clear();
		id(prop.getProperty("state")).sendKeys(prop.getProperty("cityname"));
		log.info("select the state");
		Thread.sleep(1000);
		// Alert A3 = d.switchTo().alert();
		// A3.accept();
		// css("i.fa.fa-forward")).click();
		// css("div.btn.btn-upload")).click();
		// css("div.btn.btn-upload")).click();
		// id("chkRemote")).click();
		// css("i.fa.fa-forward")).click();
		// css("div.btn.btn-upload")).click();
		// css("i.fa.fa-backward")).click();
		id(prop.getProperty("needh1b")).click();
		log.info("Clicking prefered employment");

		id(prop.getProperty("securityclearance")).click();
		log.info("Clicking the work authorization");

		id(prop.getProperty("nedh1b")).click();
		log.info("Clicking the work authorization");

		// id("chkWorkAuthorization_5")).click();
		// log.info("Clicking the work authorization");

		id(prop.getProperty("h1bworkpermit")).click();
		log.info("Clicking the work authorization");

		id(prop.getProperty("ead")).click();
		log.info("Clicking the work authorization");

		id(prop.getProperty("greencard")).click();
		log.info("Clicking the work authorization");
		// log.info("Clicking the work authorization");
		// WebElement id("chkWorkAuthorization_1")).click();

		// id("chkRemote")).click();

		id(prop.getProperty("remote")).click();
		log.info("Clickingthe check remote option");

		// WebElement exclwrds=id("txtExcludeWords")); //.clear();

		id(prop.getProperty("excludewords")).sendKeys(prop.getProperty("excludekeyword"));
		log.info("Clicking the exclude words");

		new Select(id(prop.getProperty("jobpost"))).selectByVisibleText("2 Days");
		log.info("Selecting a job within a days/months/years");

		id(prop.getProperty("fetchjob")).click();
		log.info("Clicking a fetch job button");
		Thread.sleep(5000);

		d.switchTo().defaultContent();
		Thread.sleep(3000);
	}

	@Test(dependsOnMethods = { "fetch" })
	public void listing() throws Exception
	{
		// creating job alert and alert list.
		/**
		 * @author sans work name : jobalert
		 */
		File file = new File(workingDir + "\\Resources\\Listing.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		// jobalert menu
		xp(prop.getProperty("jobalertmenu")).click();
		// create jobalert
		xp(prop.getProperty("createjobalert")).click();
		log.info("Clicking Create jobalert ");
		d.switchTo().defaultContent();
		d.switchTo().frame("contentframe");
		Select Select = new Select(xp(prop.getProperty("profileselection")));
		log.info("Selecting profile ");
		Select.selectByIndex(5);
		// xp(prop.getProperty("excludecompany"))).sendKeys(prop.getProperty("excludecompanyname"));
		log.info("Entering exclude company name");
		Thread.sleep(1000);
		xp(prop.getProperty("alertname1")).sendKeys(prop.getProperty("alertname"));
		xp(prop.getProperty("savebutton")).click();
		log.info("Clicking save alert");
		// Thread.sleep(2000);
		d.switchTo().defaultContent();
		Thread.sleep(2000);
		// back to jobalert menu
		xp(prop.getProperty("menu")).click();
		Thread.sleep(100);
		// alert list
		xp(prop.getProperty("alertlist")).click();
		log.info("Clicking alertlist");
		Thread.sleep(2000);
		d.switchTo().defaultContent();
		d.switchTo().frame("contentframe");
		Select select1 = new Select(xp(prop.getProperty("consolidatedalert")));
		select1.selectByIndex(0);
		Select select2 = new Select(xp(prop.getProperty("instantalert")));
		select2.selectByIndex(0);
		Thread.sleep(1000);
		// delete alert
		xp(prop.getProperty("deleteicon")).click();
		d.switchTo().alert().accept();
		Thread.sleep(2000);
		d.switchTo().defaultContent();

	}

	@Test(dependsOnMethods = { "listing" })
	public void features() throws Exception
	{
		// showing the result based on resume
		/**
		 * @author Ram Sastha work name : features
		 */
		File file = new File(workingDir + "\\Resources\\Feature.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);

		xp(prop.getProperty("features_click")).click();
		Thread.sleep(1000);
		xp(prop.getProperty("demandindex")).click();
		Thread.sleep(2000);
		d.switchTo().frame("contentframe");
		Thread.sleep(2000);
		xp(prop.getProperty("profile")).click();

		Select select = new Select(xp(prop.getProperty("profile")));

		Select select1 = new Select(xp(prop.getProperty("spealized")));

		Select select2 = new Select(xp(prop.getProperty("date")));

		Select select3 = new Select(xp(prop.getProperty("state")));

		for (int i = 0; i < 1; i++) {
			select.selectByIndex(i);
			for (int i1 = 0; i1 < 1; i1++) {
				Thread.sleep(1000);
				select1.selectByIndex(i1);
				for (int i2 = 0; i2 < 1; i2++) {
					select2.selectByIndex(i2);

					for (int i3 = 0; i3 < 1; i3++) {

						select3.selectByVisibleText("CA");
						xp(prop.getProperty("seeresult")).click();
						Thread.sleep(5000);
						select3.selectByVisibleText("FL");
						xp(prop.getProperty("seeresult")).click();
						Thread.sleep(5000);
						select3.selectByVisibleText("SC");
						xp(prop.getProperty("seeresult")).click();
						Thread.sleep(2000);
					}
				}
			}
		}
		Thread.sleep(3000);

		Actions action = new Actions(d);

		xp(prop.getProperty("profile")).click();
		List<WebElement> list = select.getOptions();

		for (int i = 0; i < list.size(); i++)
		{
			action.sendKeys(Keys.ARROW_DOWN).build().perform();

			Thread.sleep(100);
		}
		for (int i1 = 0; i1 < list.size(); i1++) 
		{
			action.sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(100);
		}

		xp(prop.getProperty("spealized")).click();
		List<WebElement> list1 = select1.getOptions();
		for (int j = 0; j < list1.size(); j++) 
		{
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(100);
		}
		for (int j1 = 0; j1 < list1.size(); j1++) {
			action.sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(100);
		}

		xp(prop.getProperty("date")).click();
		List<WebElement> list2 = select2.getOptions();
		for (int k = 0; k < list2.size(); k++)
		{

			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(100);
		}
		for (int k1 = 0; k1 < list2.size(); k1++) {
			action.sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(100);
		}
		xp(prop.getProperty("state")).click();
		List<WebElement> list3 = select3.getOptions();
		for (int m = 0; m < list3.size(); m++)
		{
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(100);
		}
		for (int m1 = 0; m1 < list3.size(); m1++)
		{
			action.sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(100);
		}
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(100);
		action.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(100);
	}

	@AfterTest
	public void logout() throws Exception
	{
		// performing logout
		/**
		 * @author karthiga work name: logout
		 * 
		 */
		d.switchTo().defaultContent();

		Thread.sleep(10000);
		File file = new File(workingDir + "\\Resources\\Base.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		// Logout...
		xp(prop.getProperty("usersetting")).click();
		log.debug("Clicking user settings ");
		Thread.sleep(10000);
		xp(prop.getProperty("logoutbutton")).click();
		log.debug("Clicking logout button ");
		Thread.sleep(10000);
	}
	/*
	 * @Test public void finish() throws Exception { // performing overall action
	 * /**
	 * 
	 * @author selva venkat work name : final
	 * 
	 * login(); upload(); forward(); update(); fetch(); listing(); features();
	 * logout(); }
	 */
}

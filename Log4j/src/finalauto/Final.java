package finalauto;




import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import org.apache.log4j.Logger;

public class Final {
    //File file = new File("E:\\workspace\\TechFetch.Automation\\Locator.properties");
    WebDriver driver;
    Logger log = Logger.getLogger("devpinoyLogger");
    public  Final(WebDriver driver)
    {    
        this.driver=driver;
}
   
	public void login() throws IOException, InterruptedException
    {
       
        File file = new File("E:\\workspace\\Log4j\\src\\finalauto\\Locator.Properties");
        FileInputStream fileInput;
        fileInput = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInput);
        driver.get(prop.getProperty("url"));
        log.debug("Opening Techfetch webiste");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='ucHeaderCtrl_divCandidate']/a")).click();
        log.debug("Opening candidate menu");
        Thread.sleep(1000);
         driver.findElement(By.xpath(".//*[@id='jsloginpop']")).click();
          log.debug("Clicking Login button");
         driver.switchTo().defaultContent();
        driver.switchTo().frame("candidatecontentframe");
        driver.findElement(By.xpath("//.//*[@id='txtemailid']")).sendKeys(prop.getProperty("Username"));
           log.debug("Entering mailid");
        driver.findElement(By.xpath("//.//*[@id='txtpwd']")).sendKeys(prop.getProperty("password"));
         log.debug("Entering password");
    driver.findElement(By.xpath("//.//*[@id='btnSubmit']")).click();
    log.debug("Clicking submit button");
     Thread.sleep(1000);

 
    }
    public void upload() throws Exception
 {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("contentframe");
        driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[1]/td[4]/a/img")).click();
        log.debug("Clicking Replacedocs");
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("replacedoccontentframe");
        Thread.sleep(1000);
         driver.findElement(By.id("resumeupload")).clear();
     
        
           driver.findElement(By.id("resumeupload")).sendKeys("C:\\Users\\mag6\\Downloads\\Anusha_Sharma.docx");
           
             log.debug("Uploading Resume");
        Thread.sleep(10000);
        //WebElement Element = driver.findElement(By.xpath(".//*[@id='dupupload2']/div/div/div"));
        // Element.sendKeys("C:\\hai.doc");
        driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
          log.debug("Clicking Submit button");
        Thread.sleep(3000);
driver.findElement(By.id("btnClose")).click();
     log.debug("Clicking Close button");
    }
    public void profile() throws Exception
    {
        Set<String> Wi = driver.getWindowHandles();
        System.out.println("No of Windows:"+Wi.size());
        Iterator it=Wi.iterator();
        //String main=(String) it.next();
        System.out.println(it.next());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
            driver.switchTo().defaultContent();
            driver.switchTo().frame("contentframe");
        driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[4]/td[5]/a/img")).click();
          log.debug("Clicking Profile");
           Wi = driver.getWindowHandles();
        log.info("No of Windows:"+Wi.size());
        it=Wi.iterator();
        it=Wi.iterator();
        String mmm=(String) it.next();
        String nnn=(String) it.next();
        System.out.println(mmm);
        System.out.println(nnn);
        driver.switchTo().window(nnn);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("#download")).click();
        log.debug("Downloading Profile");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='forward']")).click();
        log.debug("Clicking Forward Button");
          driver.switchTo().defaultContent();
          driver.switchTo().frame("jsforwardprofilecontentframe");
          driver.findElement(By.xpath(".//*[@id='txtTo']")).sendKeys("trainee4@tiliconveli.com");
          log.debug("Entering Forward Mailid");
          Thread.sleep(1000);
          driver.findElement(By.xpath(".//*[@id='btnsendmail']")).click();
          log.debug("Clicking SendButton");
          Thread.sleep(1000);
          driver.findElement(By.xpath(".//*[@id='btnPnlClose']")).click();
          log.debug("Clicking CloseButton");
     driver.close();
      driver.switchTo().window(mmm);
        
    }
    public void myresume() throws Exception
    {
        //driver.switchTo().defaultContent();
        //driver.switchTo().frame("contentframe");

        driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[2]/a")).click();
        log.debug("Opening MyResume");
        driver.findElement(By.xpath(".//*[@id='addresumetab']")).click();
        log.debug("Selecting AddResume");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("contentframe");
        
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='txtFName']")).sendKeys("stephen ");
        log.debug("Entering FirstName");
        driver.findElement(By.xpath(".//*[@id='txtMName']")).sendKeys("s");
         log.debug("Entering MiddleName");
    
        driver.findElement(By.xpath(".//*[@id='txtLName']")).sendKeys("clarous");
         log.debug("Entering LastName");
        Thread.sleep(2000);
        Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='ddsCountry']")));
        log.debug("Selecting Country");
        oSelect.selectByIndex(12);
        driver.findElement(By.xpath(".//*[@id='txtCity']")).sendKeys("Yaamba, Queensland");
        log.debug("Entering City,state or zip");
        driver.findElement(By.xpath(".//*[@id='txtPhoneM']")).sendKeys("9875309123");
        log.debug("Entering MobilePhone");
        driver.findElement(By.xpath(".//*[@id='txtPhoneA']")).sendKeys("9875309124");
        log.debug("Entering HomePhone");
        driver.findElement(By.xpath(".//*[@id='txtPhoneW']")).sendKeys("9875309125");
        log.debug("Entering WorkPhone");
        driver.findElement(By.xpath(".//*[@id='txtExtn']")).sendKeys("452312");
        log.debug("Entering Extension");

        Select oSelect1 = new Select(driver.findElement(By.xpath(".//*[@id='ddlPreferredTime']")));
        
        oSelect1.selectByIndex(2);
        log.debug("Selecting PrefferedTime");
        Select oSelect2 = new Select(driver.findElement(By.xpath(".//*[@id='ddlPhone']")));
        
        oSelect2.selectByIndex(2);
        log.debug("Selecting Home");
        Select oSelect3 = new Select(driver.findElement(By.xpath(".//*[@id='ddsCitizen']")));
        oSelect3.selectByIndex(2);
        log.debug("Selecting Citizen");
        driver.findElement(By.xpath(".//*[@id='chkWorkAuthorizationTNEAD']")).click();
        log.debug("Clicking WorkAuthorization");
        Select oSelect4 = new Select(driver.findElement(By.xpath(".//*[@id='ddltneadlist']")));
        oSelect4.selectByIndex(2);
        log.debug("Selecting NeedNewH1B");
        driver.findElement(By.id("resumeupload")).clear();
        log.debug("clearing upload");
        driver.findElement(By.id("resumeupload")).sendKeys("C:\\Users\\mag6\\Downloads\\Anusha_Sharma (2).docx");
        log.debug("Selecting Resume");
        Thread.sleep(10000);
        driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
        log.debug("Clicking Submit button");
        Thread.sleep(100);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("contentframe");
        log.debug("Switching to Professional");
        Thread.sleep(1000);
        driver.findElement(By.id("rdBachelor")).click();
        log.debug("Selecting Bachelor button on Highest degree");
        new Select(driver.findElement(By.id("ddlExpectedSalaryYear"))).selectByVisibleText("$10K");
        log.debug("Selecting Expected salary per year");
        
        new Select(driver.findElement(By.id("ddlExpectedSalaryHour"))).selectByVisibleText("$15");
        log.debug("Selecting Expected salary per hour");
        driver.findElement(By.id("txtJobTitle")).clear();
      
        driver.findElement(By.id("txtJobTitle")).sendKeys("no");
        log.debug("Entering job title");
        new Select(driver.findElement(By.id("ddsTotalExperience"))).selectByVisibleText("17");
        log.debug("Selecting total experience");
        driver.findElement(By.cssSelector("option[value=\"17\"]")).click();
        log.debug("Clicking Value ");
        new Select(driver.findElement(By.id("ddsUSAExperience"))).selectByVisibleText("15");
        log.debug("Selecting USA experience");
        driver.findElement(By.id("txtResumeTitle")).clear();
       
        driver.findElement(By.id("txtResumeTitle")).sendKeys("ytry");
        log.debug("Entering resume title");
        driver.findElement(By.id("resumeupload")).clear();
        driver.findElement(By.id("resumeupload")).sendKeys("C:\\Users\\mag6\\Downloads\\Anusha_Sharma.docx");
        log.debug("Uploading resume");
        Thread.sleep(10000);
        driver.findElement(By.id("btnProfessional")).click();
        log.debug("Clicking save and next button");
        Thread.sleep(1000);
    
      //  driver.switchTo().defaultContent();
      //  driver.switchTo().frame("contentframe");
       
        //driver.findElement(By.linkText("*Skills(Incomplete)")).click();
        
        new Select(driver.findElement(By.id("ddlSpecializedArea"))).selectByVisibleText("Java, J2EE");
        log.debug("Selecting specialized area");
        new Select(driver.findElement(By.id("ddlSpecializedSkill"))).selectByVisibleText("Java Front End");
        log.debug("Selecting specialized skills");
        driver.findElement(By.id("txtSkill1")).clear();
        driver.findElement(By.id("txtSkill1")).sendKeys("infosys");
        log.debug("Entering skill1");
        new Select(driver.findElement(By.id("ddlYears1"))).selectByVisibleText("2");
        log.debug("Selecting years for skill1 ");
        driver.findElement(By.id("btnSkills")).click();
        log.debug("Clicking save and next button");
        Thread.sleep(10000);
       // driver.findElement(By.id("Skillsli")).click();
    
      //  driver.findElement(By.cssSelector("#Preferencesli > a")).click();
        driver.findElement(By.id("chkBusinessDomaintelecom")).click();
        log.debug("Clicking preferred employment ");
        driver.findElement(By.id("radPublishToAll")).click();
        log.debug("Selecting resume publishing options ");
        driver.findElement(By.id("chkprefjobyes")).click();
        log.debug("Selecting domain experience");
        driver.findElement(By.id("btnPreferences")).click();
          log.debug("Clicking save and next button");
        Thread.sleep(10000);
        driver.findElement(By.id("txtKeywords")).clear();
        driver.findElement(By.id("txtKeywords")).sendKeys("java");
        log.debug("Entering keywords ");
        driver.findElement(By.id("chkcontarctjobtype")).click();
        log.debug("Clicking job type ");
        driver.findElement(By.id("contracttype")).click();
        driver.findElement(By.id("chkpermanentjobtype")).click();
        driver.findElement(By.id("txtJobwithtitle")).clear();
        driver.findElement(By.id("txtJobwithtitle")).sendKeys("java");
        log.debug("Entering job with title ");
        new Select(driver.findElement(By.id("ddlYears"))).selectByVisibleText("2");
        log.debug("Selecting years");
        driver.findElement(By.cssSelector("#ddlYears > option[value=\"2\"]")).click();
       // new Select(driver.findElement(By.id("lbPriorityList"))).selectByVisibleText("Florida (FL)");
       // driver.findElement(By.xpath("//div[@onclick='javascript: OptSelect();']")).click();
        //driver.findElement(By.xpath("//div[@onclick='javascript: OptUnSelect();']")).click();
        driver.findElement(By.id("txtAlertName")).clear();
        driver.findElement(By.id("txtAlertName")).sendKeys("newjobbsss");
        log.debug("Entering alert name ");
        driver.findElement(By.id("btnJobAlert")).click();
        log.debug("Clicking save and next button");
        
      }
    public void myjob() throws Exception
    {
        driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[3]/a")).click();
        log.debug("clicking the my jobs tab");
         driver.findElement(By.id("fetchjobstab")).click();
        log.debug("clicking fetch job tab");
         Thread.sleep(1000);
         driver.switchTo().defaultContent();
           driver.switchTo().frame("contentframe");
           log.debug("move to content frame");
            driver.findElement(By.id("txtKeyword")).clear();
             driver.findElement(By.id("txtKeyword")).sendKeys("java");
             log.debug("Entering the keyword");
            driver.findElement(By.id("rbKeywordsAll")).click();
            log.debug("select the type");
            new Select(driver.findElement(By.id("ddlCountry"))).selectByVisibleText("India");
            log.debug("select the country");
            
            new Select(driver.findElement(By.id("ddlSpecializedArea"))).selectByVisibleText("Java, J2EE");
            log.debug("select the specialized skills");
            driver.findElement(By.id("li1")).click();
            log.debug("click the browse button");
             Thread.sleep(1000);
            driver.findElement(By.id("txtcity")).clear();
           
            driver.findElement(By.id("txtcity")).sendKeys("Machhiwara, Punjab");
            log.debug("select the state");
           // Alert A3 = driver.switchTo().alert();
            //A3.accept();
           // driver.findElement(By.cssSelector("i.fa.fa-forward")).click();
            //driver.findElement(By.cssSelector("div.btn.btn-upload")).click();
            //driver.findElement(By.cssSelector("div.btn.btn-upload")).click();
           // driver.findElement(By.id("chkRemote")).click();
           // driver.findElement(By.cssSelector("i.fa.fa-forward")).click();
           // driver.findElement(By.cssSelector("div.btn.btn-upload")).click();
          //  driver.findElement(By.cssSelector("i.fa.fa-backward")).click();
            driver.findElement(By.id("chkPreferredEmployment_5")).click();
            log.debug("select the prefered employment");
            driver.findElement(By.id("chkWorkAuthorization_1")).click();
            log.debug("select the work authorization");
            driver.findElement(By.id("chkWorkAuthorization_5")).click();
            log.debug("select the work authorization");
            driver.findElement(By.id("chkWorkAuthorization_5")).click();
            log.debug("select the work authorization");
            driver.findElement(By.id("chkWorkAuthorization_4")).click();
            log.debug("select the work authorization");
            driver.findElement(By.id("chkWorkAuthorization_3")).click();
            log.debug("select the work authorization");
            driver.findElement(By.id("chkWorkAuthorization_2")).click();
            log.debug("select the work authorization");
            driver.findElement(By.id("chkWorkAuthorization_1")).click();
            log.debug("select the work authorization");
            driver.findElement(By.id("chkRemote")).click();
            log.debug("select the check remote option");
            driver.findElement(By.id("txtExcludeWords")).clear();
            driver.findElement(By.id("txtExcludeWords")).sendKeys("unix");
            log.debug("select the exclude words");
            new Select(driver.findElement(By.id("ddlJobPost"))).selectByVisibleText("2 Days");
            log.debug("select a job within a days/months/years");
            driver.findElement(By.id("btnFetchJobs")).click();
            log.debug("select a fetch job button");
    }
    public void features() throws Exception
    {
        driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[6]/a")).click();
          log.debug("Clicking features menu ");
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='demandindextab']")).click();
          log.debug("Clicking demand index ");
        
Thread.sleep(2000);
driver.switchTo().frame("contentframe");
driver.findElement(By.xpath(".//*[@id='ddlprofile']")).click();

Select select = new Select(driver.findElement(By.id("ddlprofile")));
List<WebElement> l = select.getOptions();

Select select1=new Select(driver.findElement(By.xpath(".//*[@id='ddlspecializedarea']")));
List<WebElement> l1 = select1.getOptions();

Select select2=new Select(driver.findElement(By.xpath(".//*[@id='ddlmonthyear']")));
List<WebElement> l2 = select2.getOptions();

Select select3=new Select(driver.findElement(By.xpath(".//*[@id='ddlstate']")));
List<WebElement> l3 = select3.getOptions();


for (int i=0;i<l.size();i++)
{
select.selectByIndex(i);
for(int i1=0;i1<l1.size();i1++)
{
select1.selectByIndex(i1);
for(int i2=0;i2<l2.size();i2++)
{
    select2.selectByIndex(i2);
    for(int i3=0;i3<l3.size();i3++)
    {
        select3.selectByIndex(i3);
driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
Thread.sleep(5000);
}
}
}
}

    }
    public void jobalert() throws Exception
    {
        driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[4]/a[1]")).click();
        log.debug("Clicking JobAlert menu ");
        //create job alert
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='createjobalerttab']")).click();
        log.debug("Clicking Create jobalert ");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("contentframe");
        Select oSelect = new Select(driver.findElement(By.xpath(".//*[@id='ddlProfile']")));
        log.debug("Selecting profile ");
        oSelect.selectByIndex(5);
        driver.findElement(By.xpath(".//*[@id='txtExclucompname']")).sendKeys("techebuzz");
        log.debug("Entering exclude company name");
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='btnSaveAlert']")).click();
        log.debug("Clicking save alert");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        //alert list
        driver.findElement(By.xpath(".//*[@id='alertlist']")).click();
        log.debug("Clicking alertlist");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("contentframe");
        Select oselect = new Select(driver.findElement(By.xpath(".//*[@id='consstatus-filter']")));
   
        oselect.selectByIndex(0);
        log.debug("Selecting Consolidate alert ");
        Select oselect1 = new Select(driver.findElement(By.xpath(".//*[@id='insstatus-filter']")));
        oselect1.selectByIndex(0);
        log.debug("Selecting instant alert ");
        Thread.sleep(1000);
        //delete alert
        driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/tbody/tr[2]/td[7]/a/img")).click();
        log.debug("Clicking delete button");
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        // back to alert for matched jobs
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath(".//*[@id='alertlist']")).click();
        log.debug("Clicking alertlist");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("contentframe");
        Select oselect2 = new Select(driver.findElement(By.xpath(".//*[@id='consstatus-filter']")));
        oselect2.selectByIndex(0);
        log.debug("Selecting Consolidate alert ");
        Select oselect3 = new Select(driver.findElement(By.xpath(".//*[@id='insstatus-filter']")));
        oselect3.selectByIndex(0);
        log.debug("Selecting instant alert ");
        //matched jobs
        driver.findElement(By.xpath(".//*[@id='tblouterdiv']/table/tbody/tr[2]/td[6]/a")).click();
        log.debug("Clicking matched jobs ");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("contentframe");
        Thread.sleep(2000);
        /*driver.findElement(By.xpath(".//*[@id='ctl06_lnkLogin']")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("applyemailframe");
        // driver.findElement(By.xpath(".//*[@id='txtCC']")).sendKeys("trainee6@tiliconveli.com");
        // driver.findElement(By.xpath(".//*[@id='fileCL']"));
        driver.findElement(By.xpath(".//*[@id='fileCL']")).click();
*/
    }
    public void logout () throws Exception
    {
        driver.switchTo().defaultContent();
    
        Thread.sleep(10000);

        //Logout...
        driver.findElement(By.xpath(".//*[@id='drop7']/img")).click();
        log.debug("Clicking user settings ");
        Thread.sleep(10000);
        driver.findElement(By.xpath(".//*[@id='mini-nav']/li/ul/li[4]/div/input")).click();
        log.debug("Clicking logout button ");
        Thread.sleep(10000);
    }
    }
      
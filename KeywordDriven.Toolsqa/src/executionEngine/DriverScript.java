package executionEngine;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import keyword.Toolsqa.ActionKeywords;
import utility.ExcelUtils;
 
public class DriverScript {
	 public static void main(String[] args) throws Exception {
	    	// Declaring the path of the Excel file with the name of the Excel file
	    	String nPath = "E:\\workspace\\KeywordDriven.Toolsqa\\src\\dataEngine\\toolsqa.xlsx";
	       String s="Test Steps";
	    	// Here we are passing the Excel path and SheetName as arguments to connect with Excel file 
	    	ExcelUtils.setExcelFile(nPath, s);
	 
	    	//Hard coded values are used for Excel row & columns for now
	    	//In later chapters we will replace these hard coded values with varibales
	    	//This is the loop for reading the values of the column 3 (Action Keyword) row by row
	    
	    	for (int i=1;i<=9;i++){
			    //Storing the value of excel cell in sActionKeyword string variable
	    		String sActionKeyword = ExcelUtils.getCellData(i, 3);
	 
	    		//Comparing the value of Excel cell with all the project keywords
	    		if(sActionKeyword.equals("openbrowser")){
	                        //This will execute if the excel cell value is 'openBrowser'
	    			//Action Keyword is called here to perform action
	    			ActionKeywords.openBrowser();}
	    		else if(sActionKeyword.equals("navigatewebsite")){
	    			ActionKeywords.navigatewebsite();}
	    		else if(sActionKeyword.equals("Click_MyAccount")){
	    			ActionKeywords.Click_MyAccount();
	    			}
	    		else if(sActionKeyword.equals("input_Username")){
	    			ActionKeywords.input_Username();}
	    		
	    		
	    		else if(sActionKeyword.equals("input_Password")){
	    			ActionKeywords.input_Password();}
	    		else if(sActionKeyword.equals("click_Login")){
	    			ActionKeywords.click_Login();}
	    		else if(sActionKeyword.equals("waitFor")){
	    			ActionKeywords.waitFor();}
	    		else if(sActionKeyword.equals("click_Logout")){
	    			ActionKeywords.click_Logout();}
	    		else if(sActionKeyword.equals("closeBrowser")){
	    			ActionKeywords.closeBrowser();}
	 
	    		}
	    	}
	 }
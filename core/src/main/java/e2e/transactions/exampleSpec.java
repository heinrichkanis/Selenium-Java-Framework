package e2e.transactions;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import elements.example;
import support.commands;
import support.driverHelper;
import support.reportManager;
import variables.transactions.example_var;

public class exampleSpec {

public static ExtentTest report;
	
	
	@BeforeSuite
	public void reportSetup() {
		
		reportManager.reportSetup("DemoReport.html", "report-config.json" ,example_var.websiteURL ,example_var.browserName);		
		
		report = reportManager.createReport("Test Case 1", "Testing Swag Labs demo website","Heinrich","Regression");
				
	}	
	
	@Test (priority = 1)
    public void demoSiteLogin() throws InterruptedException, IOException{
		
		try {			

			driverHelper.getDriver("WebDriver", example_var.browserName, null , null);
	        report.info(MarkupHelper.createLabel("Driver loaded", ExtentColor.BLUE));

	        driverHelper.openWebsite(example_var.websiteURL);
	        report.info(MarkupHelper.createLabel("Website opened", ExtentColor.BLUE));
	        
	        commands.enterFieldValue(example.txtUserId, example_var.userId);
	        report.info(MarkupHelper.createLabel(example.txtUserId +  example_var.userId +  "Field Value entered", ExtentColor.BLUE));

	        commands.enterFieldValue(example.txtPassword, example_var.password);
	        report.info(MarkupHelper.createLabel("Field Value entered", ExtentColor.BLUE));

	        commands.clickElement(example.btnLogin);
	        report.info(MarkupHelper.createLabel("Login button clicked", ExtentColor.BLUE));
   
	        report.pass(MarkupHelper.createLabel("Testing Swag Labs demo website", ExtentColor.GREEN));
			
	    } catch(IOException ie)
		{
	         ie.printStackTrace();
	         report.fail(MarkupHelper.createLabel("Test Case 1 Failed", ExtentColor.RED));

	    }
		
	}
	
	@AfterSuite
	public void closeTest () {
        reportManager.extentReports.flush();

        driverHelper.closeDriver();
	}
}

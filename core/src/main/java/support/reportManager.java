package support;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class reportManager {

	
    public static final ExtentReports extentReports = new ExtentReports();
    public static ExtentReports reportSetup(String reportFileName , String reportConfigFile , String URL , String BrowserName) {    	
    	
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFileName);        
        final File CONF = new File(reportConfigFile);
        try {
			sparkReporter.loadJSONConfig(CONF);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        sparkReporter.viewConfigurer().viewOrder().as(new ViewName[] {
	    		 ViewName.DASHBOARD,
	    		 ViewName.TEST,
	    		 ViewName.CATEGORY,
	    		 ViewName.DEVICE,
	    		 ViewName.AUTHOR		    		 
	     }).apply();
        
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Application URL", URL);
        extentReports.setSystemInfo("Browser Name", BrowserName);
        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReports.setSystemInfo("Username", System.getProperty("user.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));  
        
        return extentReports;
    }
    
	public static ExtentTest createReport(String testName, String testDescription,String author, String testType) {
		return extentReports.createTest(testName , testDescription).assignAuthor(author).assignCategory(testType);
	}
}

package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentReportManager implements ITestListener {	    
	    private static ExtentReports extent;
	    private static ExtentTest test;
	    private static ExtentSparkReporter sparkReporter;
	    String repName;

	    // Initialize the ExtentReports object
	    public  void onStart(ITestContext testContext) {//testcontext hold which test method currently is executing
	        // Date Format to append current date/time to the report file name
	    	/*SimpleDateFormat df =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	    	Date dt = new Date();
	    	String timeStamp = df.format(dt);*/ // this code can be wrriten in simgle line as below
	    	
	        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // getting timestamp as year month day hour minute sec
	        repName = "Test - Report-" + timeStamp + ".html"; // add timestamp in the middle of report name i.e Test-Report-2025.02.21.01.10.22.html
	        sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName);// providing the location of report
	        
	        
	        sparkReporter.config().setDocumentTitle("opencart Automation test case"); // title for report
	        sparkReporter.config().setReportName("opencart functional testing");// name of report
	        sparkReporter.config().setTheme(Theme.DARK);
	        
	        
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	        extent.setSystemInfo("Application", "opencart");
	        extent.setSystemInfo("Module","Admin");
	        extent.setSystemInfo("Sub Module","Customer");
	        extent.setSystemInfo("Username",System.getProperty("user.name"));
	        extent.setSystemInfo("Environment","QA");
	        String os = testContext.getCurrentXmlTest().getParameter("os");
	        extent.setSystemInfo("Operating System" , os);
	        String browser = testContext.getCurrentXmlTest().getParameter("os");
	        extent.setSystemInfo("Browser" , browser);
	        
	        List<String > includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
	        if(!includedGroups.isEmpty()) {
	        	extent.setSystemInfo("Groups", includedGroups.toString());
	        }
	    }

	    
	    public  void onTestSuccess(ITestResult result) {
	        test = extent.createTest(result.getTestClass().getName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.PASS, result.getName()+"got successfully executed");
	    }

	  
	    public void onTestFailure(ITestResult result) {
	        test=extent.createTest(result.getTestClass().getName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.FAIL, result.getName()+"got failed");
	        test.log(Status.INFO, result.getThrowable().getMessage());
	        try {
	        	String impPath = new BaseClass().captureScreen(result.getName());  
	        	//invokes baseclass's captureScreen method and store the returned value which is llocation of ss
	        	test.addScreenCaptureFromPath(impPath);  //will attach the ss to report
	        }
	        catch(IOException e1) {
	        	// if ss not available just in case we put in try catch block
	        	e1.printStackTrace();// print warning message
	        }
	    }

	    public void onTestSkipped(ITestResult result) {
	        test=extent.createTest(result.getTestClass().getName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.SKIP, result.getName()+"got Skipped");
	        test.log(Status.INFO, result.getThrowable().getMessage());
	        
	    }
	    
	    public void onFinish(ITestResult result) {
	    	extent.flush(); // this is enough for finish task
	    	//to open the report automaticallly after completing the test we use below code
	    	
	    	String pathOfExtentReport = System.getProperty("user.dir")+".\\reports\\"+repName;
	    	File extentReport = new File(pathOfExtentReport);
	    	try {
	    		Desktop.getDesktop().browse(extentReport.toURI());
	    		
	    	}
	    	catch(IOException e) {
	    		e.printStackTrace();
	    		
	    	}
	    
	    
	    }
	}



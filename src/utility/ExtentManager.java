package utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;


public class ExtentManager {
	
	
	    private static ExtentReports extent;
	    // private final String filePath = "/home/muthu/work/Selenium/SeleniumUQ/Reports/UQReport.html";
	    
	    public synchronized static ExtentReports getReporter(String reportPath) {
	    	
	    //	String reportPath = "/home/muthu/work/Selenium/SeleniumUQ/Reports/UQNewReport.html";
	        if (extent == null) {
	            extent = new ExtentReports(reportPath, true,NetworkMode.ONLINE);
	            
	            
	          // 	extent.startReporter(ReporterType.DB, (new File(reportPath)).getParent() + File.separator + "extent.db");
	            // optional
	            extent.config()
                .documentTitle("Automation Report")
                .reportName("Regression")
                .reportHeadline("");
	            extent
	              .addSystemInfo("Host Name", "Muhtu")
	              .addSystemInfo("Environment", "QA");
	             
	        }
	        
	        return extent;
	    }
	    public synchronized static ExtentReports getReporter() {
	        return extent;
	    }
	}
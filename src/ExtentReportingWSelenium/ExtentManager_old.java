package ExtentReportingWSelenium;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtentManager_old {
	
	
	    private static ExtentReports extent;
	    
	    public synchronized static ExtentReports getReporter(String filePath) {
	        if (extent == null) {
	            extent = new ExtentReports(filePath, false, NetworkMode.ONLINE);
	            
	            extent
	              .addSystemInfo("Host Name", "Muhtu")
	              .addSystemInfo("Environment", "QA");
	             
	        }
	        
	        return extent;
	    }
	}



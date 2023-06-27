package com.qa.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreports/extent-report.html");
		
		reporter.config().setReportName(" Extent Report");
		extentReports.attachReporter(reporter);//attaching spark report to extent report
		extentReports.setSystemInfo("company Name", "Service Management");
		extentReports.setSystemInfo("Author", "Nanda");
		return extentReports;
	}

}

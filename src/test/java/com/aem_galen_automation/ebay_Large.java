package com.aem_galen_automation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;


public class ebay_Large extends galenTest
{

//	Testing general web element attributes
    String testUrl = "https://ebay.com.au";
    String specFilePath = "galen_spec_gspec/ebay_sizes.gspec";
    int browserSizeLargeW = 1500;
    int browserSizeLargeH = 1200;
    int browserSizeMediumW = 1152;
    int browserSizeMediumH = 864;
    int browserSizeSmallW = 950;
    int browserSizeSmallH = 600;
    private WebDriver driver = null;
    
    @Test
    public void homePageLayoutTest() throws IOException {
    	System.setProperty("webdriver.chrome.driver", "./Resources/BrowserDriver/chromedriver.exe"); 
    	driver = new ChromeDriver();
    	System.out.println("Browser is set as Chrome");
        driver.get(testUrl);
        // testing done at specific browser size which can be customized per user needs
        driver.manage().window().setSize(new Dimension(browserSizeLargeW, browserSizeLargeH));
        System.out.println("I am in Large Test ");
        //Create a layoutReport object
        //CheckLayout function checks the layout and returns a LayoutReport object
        LayoutReport objLayoutReport =
                Galen.checkLayout(driver, specFilePath, Arrays.asList("Desktop_Large"));

        //Create a GalenTestInfo object
        GalenTestInfo objSingleGalenTest = GalenTestInfo.fromString("ebay Large");
        //Get layoutReport and assign to test object
        objSingleGalenTest.getReport().layout(objLayoutReport, "ebay size test large");
        //Add test object to the tests list
        objGalentestsList.add(objSingleGalenTest);

        //If layoutReport has errors Assert Fail
        if (objLayoutReport.errors() > 0){
            System.out.println("Layout test failed for ebay size test large");
            AssertJUnit.fail();
        }
        System.out.println("Layout test PASSED for ebay size test large");
    }



//    @BeforeTest
//    public void setUp()
//    {
//		System.setProperty("webdriver.chrome.driver", "./Resources/BrowserDriver/chromedriver.exe");
////		WebDriverManager.chromedriver().setup(); 				// for latest 
//		driver = new ChromeDriver();
//		System.out.println("Browser is set as Chrome");
//        driver.get(galenSampleUrl);
//    }
//
    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}
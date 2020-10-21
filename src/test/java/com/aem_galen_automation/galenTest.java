package com.aem_galen_automation;

import com.galenframework.browser.Browser;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class galenTest {

    public static List<GalenTestInfo> objGalentestsList;
    public static HtmlReportBuilder htmlReportBuilder;
    galenTest(){
         objGalentestsList= new LinkedList<GalenTestInfo>();
    }

    @AfterSuite
    public void buildReport() throws IOException {
        htmlReportBuilder = new HtmlReportBuilder();
        htmlReportBuilder.build(objGalentestsList, "GalenReportFolders");
    }
}

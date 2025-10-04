package com.Automation.ex01_Selenium_Basics.TakesScreenShots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakeFullPageScreenShots {

    @Test
    public  void test_Screenshot_fullPage()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        TakesScreenshot ts = (TakesScreenshot) driver;

        File sourcefile = ts.getScreenshotAs(OutputType.FILE);
        // this will take page screenshot and saves file somewhere in the memery to get this screenshot we can copy to our own path

        //will create the file in given location
        File targetfile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "TargetFiles" + File.separator + "test.png");

        //will copy the original file to the project location
        System.out.println(sourcefile.getName());
        System.out.println(sourcefile.getPath());
        try {
            FileUtils.copyFile(sourcefile, targetfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        WebElement table = driver.findElement(By.xpath("//table[@class='section-columns columns-2']"));
        File sourceFile = table.getScreenshotAs(OutputType.FILE);
        String targetPath = System.getProperty("user.dir")+"src/test/resources/TargetFiles/test1.png";
        File targetFile = new File(targetPath);
        System.out.println(sourceFile.getName());
       System.out.println(sourceFile.getPath());

        try {
            FileUtils.copyFile(sourceFile, targetFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

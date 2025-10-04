package com.Automation.ex01_Selenium_Basics.UplaodFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadSingleFiles {

    @Test
    public void test_SingleFilesUpload()
    {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement fileUpload = driver.findElement(By.xpath("//input[@id='singleFileInput']"));
        String filePath = "C:\\Users\\mrunaln\\OneDrive - AMDOCS\\Desktop\\personal documnets\\Automation testing docs and learning\\LearningSeleniumATB13x\\src\\test\\resources\\Testfile.pdf";
        fileUpload.sendKeys(filePath);
    }
}

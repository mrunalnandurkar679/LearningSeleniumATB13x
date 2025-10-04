package com.Automation.ex01_Selenium_Basics.Iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandlingiFrames {

    @Test
    public void test_iFrames()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

        //get the iFrame path
        WebElement iFrame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(iFrame1);
        WebElement text = driver.findElement(By.xpath("//input[@name='mytext1']"));
        text.sendKeys("Welcome");

        // coming out from the iFrame to main Frame
        driver.switchTo().defaultContent();

        WebElement iFrame2 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(iFrame2);
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//div[@id='i6']")).click();
        driver.switchTo().defaultContent();

        WebElement iFrame3 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
        driver.switchTo().frame(iFrame3);
        WebElement innerlink = driver.findElement(By.xpath("//a[text()='https://a9t9.com']"));
        innerlink.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span[text()='2. Install XModules']")));

        link.click();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());



            }
}

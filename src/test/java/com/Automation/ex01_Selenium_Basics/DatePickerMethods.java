package com.Automation.ex01_Selenium_Basics;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DatePickerMethods extends BaseClassMethods {

    @Test
    public void test_datePicker()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement datepicker = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(datepicker);
        driver.findElement(By.id("datepicker")).click();



        getPastDate(driver, "July", "2020", "24");



        }


    }



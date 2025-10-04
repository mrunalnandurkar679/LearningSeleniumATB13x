package com.Automation.ex01_Selenium_Basics.WebTable;

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

public class DynamicWebTables extends BaseClassMethods  {


    @Test
    public void testDynamicWebTable() throws InterruptedException{

        getURL(driver, "https://awesomeqa.com/hr/web/index.php/pim/viewEmployeeList");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        try {
//            Thread.sleep(3000);
//        }catch (InterruptedException e)
//        {
//            throw new RuntimeException(e);
//        }
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Hacker@4321");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']"))).click();
        //driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();


    }

}

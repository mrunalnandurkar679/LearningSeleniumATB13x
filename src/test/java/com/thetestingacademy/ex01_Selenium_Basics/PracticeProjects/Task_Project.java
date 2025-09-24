package com.thetestingacademy.ex01_Selenium_Basics.PracticeProjects;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task_Project extends BaseClassMethods {

    @Test
    public void test_Start_Free_Trial()
    {
        WebDriver driver = new ChromeDriver();
        getURL(driver, "https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage");
        driver.findElement(By.xpath("//a[text()='Start a free trial']")).click();
        Assert.assertTrue((driver.getCurrentUrl().contains("free-trial")));

        free_trial_login(driver, "Mrunal");

        WebElement button = driver.findElement(By.xpath("//button[text()='Create a Free Trial Account']"));
        Assert.assertFalse(button.isEnabled());// button is disable

        WebElement checkBox = driver.findElement(By.xpath("//input[@id='page-free-trial-step1-cu-gdpr-consent-checkbox']"));
        checkBox.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(),'The email address you entered is incorrect.')]")
        ));
        System.out.println(errorMsg.getText());
        Assert.assertEquals(errorMsg.getText(), "The email address you entered is incorrect.");
        button.click();
        Assert.assertTrue(button.isEnabled());
        // button is enabled
        driver.quit();
    }

}

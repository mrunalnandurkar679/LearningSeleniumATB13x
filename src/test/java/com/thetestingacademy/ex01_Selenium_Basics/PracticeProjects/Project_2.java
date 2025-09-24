package com.thetestingacademy.ex01_Selenium_Basics.PracticeProjects;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Project_2 extends  BaseClassMethods {
    @Description ("TC#1 _ test invalid login , verify error message")
    @Owner("Mrunal")
    @Test
    public void test_VWO_Login_Invalid_credentials()
    {

        WebDriver driver = new ChromeDriver();

        getURL(driver, "https://app.vwo.com/#/login");
        //enter login details and click on button

        vwologin(driver, "mrunal", "abd");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification-box-description")));
        System.out.println(error_message.getText());
        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");
        try
        {
            Thread.sleep(3000);
        }catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
        driver.quit();
    }
}

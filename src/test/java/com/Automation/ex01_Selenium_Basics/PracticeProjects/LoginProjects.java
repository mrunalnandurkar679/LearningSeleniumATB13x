package com.Automation.ex01_Selenium_Basics.PracticeProjects;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginProjects extends BaseClassMethods {


    @Test
    public void testLogin()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        logincredentials("tomsmith", "SuperSecretPassword!");
        try
        {
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='flash']")));
            String text = message.getText().trim();
            System.out.println(text);
            Assert.assertTrue(text.contains("You logged into a secure area!"), "login successfully!");
        }
        catch (Exception e)
        {
            Assert.fail("login test faild" +e.getMessage());
        }

        wait.until(ExpectedConditions.urlContains("/secure"));
        System.out.println(driver.getCurrentUrl());
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='content']/div/a/i")));
        logout.click();
        try
        {
            WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='flash']")));
            String message = text.getText();
            System.out.println(message);
            Assert.assertTrue(message.contains( "You logged out of the secure area!"), " Logged out successfully");
        }
        catch (Exception e)
        {
            Assert.fail("logoout unsuccessfull+r"+e.getMessage());
        }


    }

    @Test
    public void testInvalidLogin()
    {
        logincredentials("invaliduser", "invalid password");
        WebElement message = driver.findElement(By.xpath("//div[@id='flash']"));
        String text = message.getText();
        System.out.println(text);
        Assert.assertTrue(text.contains("Your username is invalid!"), "login with invalid cred tested");
    }

    public void logincredentials(String username, String userPassword)
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        getURL(driver, "http://the-internet.herokuapp.com/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement login = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        login.sendKeys(username);
        password.sendKeys(userPassword);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();


    }
}

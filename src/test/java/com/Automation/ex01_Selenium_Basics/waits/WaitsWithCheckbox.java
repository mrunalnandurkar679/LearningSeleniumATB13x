package com.Automation.ex01_Selenium_Basics.waits;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WaitsWithCheckbox extends BaseClassMethods {

    @Test
    public void testCheckbox() {
        getURL(driver, "https://awesomeqa.com/practice.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='firstname']"))).sendKeys("Mrunal");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='lastname']"))).sendKeys("Nandurkar");
        driver.findElement(By.xpath("//input[@value='Female']")).click();
        driver.findElement(By.xpath("//input[@id='exp-6']")).click();
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("2025/09/05");
        driver.findElement(By.xpath("//input[@value='Automation Tester']")).click();
        WebElement continenets = driver.findElement(By.xpath("//select[@id='continents']"));
        Select select = new Select(continenets);
        select.selectByVisibleText("Africa");
        WebElement Selenium_commands = driver.findElement(By.xpath("//select[@id='selenium_commands']"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Select select1 = new Select(Selenium_commands);
        select1.selectByVisibleText("Switch Commands");
        //Upload file
        WebElement fileupload = driver.findElement(By.xpath("//input[@id='photo']"));
        String user_dir = System.getProperty("user.dir");
        System.out.println("User directory "+user_dir);
        String path = user_dir+"/src/test/java/com/thetestingacademy/ex01_Selenium_Basics";
        fileupload.sendKeys(path);
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Button')]"));
        WebElement file = driver.findElement(By.xpath("//a[contains(text(),'Click here to Download File')]"));
        file.click();
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        Assert.assertTrue(URL.contains("github.com/stanfy/behave-rest/blob/master/features/conf.yaml"), "navid=gate to download file ");
        driver.navigate().back();
        Assert.assertTrue(button.isDisplayed(), "button should be clicked");
        button.click();
    }

}
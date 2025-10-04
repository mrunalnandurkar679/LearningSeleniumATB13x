package com.Automation.ex01_Selenium_Basics.Alerts;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.Scanner;

public class HandleAlerts extends BaseClassMethods {

    @Test
    public void testAlerts() {

        getURL(driver, "https://the-internet.herokuapp.com/javascript_alerts");


        WebElement JS_alert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        JS_alert.click();

        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        myAlert.accept();
        WebElement message = driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']"));
        Assert.assertTrue(message.isDisplayed());
        System.out.println(message.isDisplayed());
        Assert.assertEquals(message.getText(), "You successfully clicked an alert");


//        Alert alert = driver.switchTo().alert();
//
//
//
//        alert.accept();
//        WebElement alert_message = driver.findElement(By.xpath("//p[@id='result']"));
//        String alert_text = alert_message.getText();
//        System.out.println(alert_text);
//        Assert.assertEquals(alert_text, "You successfully clicked an alert" );
//
//        WebElement js_confirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
//        js_confirm.click();
//        alert.dismiss();
//        WebElement dismis_message = driver.findElement(By.xpath("//p[@id='result']"));
//        String dismis_text = dismis_message.getText();
//        Assert.assertEquals(dismis_text, "You clicked: Cancel");
//
//        WebElement prompt = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
//        prompt.click();
//        Random random= new Random();
//        String name = random.toString();
//        alert.sendKeys(name);
//        alert.accept();
//        WebElement message = driver.findElement(By.xpath("//p[@id='result']"));
//        String prompt_message = message.getText();
//        System.out.println(prompt_message);
//        Assert.assertEquals(prompt_message, "You entered: "+name);

    }


}

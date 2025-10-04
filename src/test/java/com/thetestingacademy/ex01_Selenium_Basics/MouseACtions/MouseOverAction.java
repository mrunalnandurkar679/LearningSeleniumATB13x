package com.thetestingacademy.ex01_Selenium_Basics.MouseACtions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class MouseOverAction {

    @Test
    public static void test_MouseActions()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement pointme = driver.findElement(By.xpath("//button[contains(text(),'Point Me')]"));
        Actions act = new Actions(driver);
        System.out.println(pointme.getText());
        WebElement laptop = driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
        System.out.println(laptop.getText());
        WebElement mobile = driver.findElement(By.xpath("//a[contains(text(),'Laptops')]"));
        System.out.println(mobile.getText());
        act.moveToElement(pointme).moveToElement(laptop).build().perform();
        act.moveToElement(pointme).moveToElement(mobile).build().perform();
        WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
        field1.clear();
        field1.sendKeys("welcome to copy");
        String text = field1.getAttribute("value");
        System.out.println(text);
        act.doubleClick(field1).doubleClick().build().perform();
        WebElement copy = driver.findElement(By.xpath("//button[contains(text(),'Copy Text')]"));
        WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
        field2.click();
        act.doubleClick(copy).build().perform();
        String text2 = field1.getAttribute("value");
        if(text2.equals("welcome to copy"))
        {
            System.out.println("text copied successfully");

        }else {
            System.out.println("copy failed");
        }


    }
}

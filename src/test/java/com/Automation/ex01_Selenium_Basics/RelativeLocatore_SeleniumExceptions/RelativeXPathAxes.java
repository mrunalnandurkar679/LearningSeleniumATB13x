package com.Automation.ex01_Selenium_Basics.RelativeLocatore_SeleniumExceptions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class RelativeXPathAxes  {


    @Test
    public void testLogin()
    {
        WebDriver driver = new ChromeDriver();
        driver.get(" https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "JS Form Validation");
        driver.switchTo().frame("result");
        WebElement button = driver.findElement(By.xpath("//button[text()='Submit']"));
        button.click();
        WebElement password = driver.findElement(with(By.xpath("//small[text()='Password2 is required']")).above(button));
        System.out.println(password.getText());
        WebElement username_message = driver.findElement(with(By.xpath("//small[text()='Username must be at least 3 characters']")).above(button));
        System.out.println(username_message.getText());
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("AB");
        driver.findElement(with(By.tagName("small")).below(username)).getText();
        Assert.assertEquals(username_message.getText(), "Username must be at least 3 characters");
        WebElement email = driver.findElement(with(By.id("email")).below(username_message));
        WebElement email_message = driver.findElement(with(By.tagName("small")).below(email));
        Assert.assertEquals(email_message.getText(),"Email is not invalid");
        WebElement password1 = driver.findElement(with(By.id("password")).below(email_message));
        Random random = new Random();
        String pass ="mruna" ;

        if(pass.length()<6)
        {
            password1.sendKeys(pass);
            System.out.println(driver.findElement(with(By.tagName("small")).below(password1)).getText());
            }

        }






        }
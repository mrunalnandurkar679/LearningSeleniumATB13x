package com.thetestingacademy.ex01_Selenium_Basics.ExceptionHandling;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StaleElementException extends BaseClassMethods {


    @Test
    public void testStaleElement()
    {
        getURL(driver, "https://www.google.com/");
        WebElement search = driver.findElement(By.name("q"));
        driver.navigate().refresh();

        try
        {
        search.sendKeys("Youtube"+ Keys.ENTER);
    }
        catch(StaleElementReferenceException e)
        {
            String message = e.getMessage();
            System.out.println(message);

            WebElement search1 = driver.findElement(By.name("q"));
            search1.sendKeys("Youtube"+ Keys.ENTER);

        }
    }
}

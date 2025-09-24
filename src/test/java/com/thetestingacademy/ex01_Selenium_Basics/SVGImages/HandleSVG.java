package com.thetestingacademy.ex01_Selenium_Basics.SVGImages;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class HandleSVG extends BaseClassMethods {


    @Test
    public  void testSearchItemsBySVG()

    {
        getURL(driver, "https://www.flipkart.com/");
        WebElement serachItems = driver.findElement(By.xpath("//input[@name='q']"));
        serachItems.sendKeys("MacMini");
        List<WebElement> svgIcon = driver.findElements(By.xpath("//*[name()='svg']"));
        svgIcon.get(0).click();
        List<WebElement> titles = driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MPC')]/div/a[2]"));
        System.out.println(titles.size());
        WebElement page = driver.findElement(By.xpath("//span[text()='Next']"));
        new WebDriverWait(driver, Duration.ofSeconds(5));
        while (page.isEnabled()) {
            for (WebElement title : titles) {
                    if(title.getText().contains("Longan Core™ i7-9700 Processor [12M Cache, Up to 4.70 G..."))
                    {
                        WebElement price = driver.findElement(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MPC')]/div/a[3]/div/div"));
                        System.out.println("the price of the given laptop is "+price.getText());

                    }
                System.out.println(title.getText());

            }
            break;


        }


    }
}

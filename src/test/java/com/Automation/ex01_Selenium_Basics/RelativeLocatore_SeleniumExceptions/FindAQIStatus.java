package com.Automation.ex01_Selenium_Basics.RelativeLocatore_SeleniumExceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class FindAQIStatus {

    @Test
    public void testAQIOfCities()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='glb-popup']/div/div/div/*[name()='svg']")));
        popup.click();
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        //search.sendKeys("India" + Keys.ENTER);
        List<WebElement> cities = driver.findElements(By.xpath("//div[contains(@class,\"location-name\")]/p"));
        for (WebElement city : cities)
        {
            WebElement mostpolluted = wait.until(ExpectedConditions.visibilityOfElementLocated(with(By.xpath("//p[contains(@class,\"location-rank\") and (text()=\"1\")]")).toLeftOf(city)));
            System.out.println("the most polluted city : " +city.getText());
            WebElement status = driver.findElement(with(By.xpath("//div[contains(@class,'aqi-status')]")).toRightOf(city));
            System.out.println(status.getText());
            Assert.assertTrue(status.getText().equals("Unhealthy"));
            break;

        }

    }
}

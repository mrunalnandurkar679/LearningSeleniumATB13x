package com.thetestingacademy.ex01_Selenium_Basics.HandelingBrokenLinks;

//import com.thetestingacademy.ex01_Selenium_Basics.ExceptionHandling.StaleElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class HandleBrokenURL {

    @Test
    public void test_brokenLinks() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        Actions act = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        List<WebElement> brokenLinks = driver.findElements(By.xpath("//div[@id='broken-links']/a"));
        for (WebElement link : brokenLinks) {
            String href_value = link.getDomAttribute("href");
            if (href_value == null || href_value.isEmpty()) {
                System.out.println("link is not valid because of no href value");
                continue;
            }
            //converting String href value into URL for connection
            try {
                URL url = new URL(href_value);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();  // this method helps to connect URL to server

                if (urlConnection.getResponseCode() >= 400) {
                    System.out.println("it is a broken links");
                } else {
                    System.out.println("it is not broken link");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

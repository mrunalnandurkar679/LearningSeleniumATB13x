package com.thetestingacademy.ex01_Selenium_Basics.WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;

public class TestTableProject {


    @Test
    public void testFlightBooking()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://blazedemo.com/");
        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
        WebElement source = driver.findElement(By.name("fromPort"));
        source.click();
        Select sourceStation = new Select(source);
        sourceStation.selectByVisibleText("Portland");
        WebElement destination = driver.findElement(By.name("toPort"));
        Select destinationStation = new Select(destination);
        destinationStation.selectByVisibleText("New York");
        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("reserve"));
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "BlazeDemo - reserve");
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        List<WebElement> cols = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
        ArrayList<Double> prices = new ArrayList<>();
        for (int i =1; i<= rows.size(); i++) {
            WebElement flightPrice = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[6]"));
            String priceText = flightPrice.getText().replace("$", "").trim();
            System.out.println(priceText);
//            Double amount = Double.parseDouble(priceText);
//            System.out.println(amount);
            double price = Double.parseDouble(priceText);
            prices.add(price);

            }
        double smallestPrice = Collections.min(prices);
        System.out.println("SmallestPrice of teh flight booking:    $"+smallestPrice);
        Assert.assertTrue(smallestPrice>0, "minimum price of the flight must be greated than 0");

        for(int i =1; i< rows.size(); i++)
        {

            WebElement flightPrice = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[6]"));
            double price = Double.parseDouble(flightPrice.getText().replace("$", "").trim());
            if(price == smallestPrice)
            {
                driver.findElement(By.xpath("//table/tbody/tr[\" + i + \"]/td[1]/input[@value='Choose This Flight']")).click();
                System.out.println("Selected flight with price: $" + smallestPrice);
                break;

            }

        }

        Assert.assertTrue(driver.getCurrentUrl().contains("purchase"), " Should navigate to purchase");
        String text = driver.findElement(By.xpath("//div[@class='container']/h2[text()='Your flight from TLV to SFO has been reserved.']")).getText();
        Assert.assertEquals(text, "Your flight from TLV to SFO has been reserved.");

        WebElement remeberme = driver.findElement(By.name("rememberMe"));
        remeberme.click();

        if(remeberme.isSelected())
        {
            WebElement bookflight = driver.findElement(By.xpath("//input[@value='Purchase Flight']"));
            bookflight.click();
            WebElement confimMessage = driver.findElement(By.xpath("//div[@class='container']/div/h1[text()='Thank you for your purchase today!']"));
            Assert.assertEquals(confimMessage.getText(), "Thank you for your purchase today!", "confirmation message does not displayed");
            Assert.assertTrue(driver.getCurrentUrl().contains("confirmation"));
        }
    }
}

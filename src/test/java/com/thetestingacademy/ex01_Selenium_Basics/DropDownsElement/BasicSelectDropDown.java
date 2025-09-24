package com.thetestingacademy.ex01_Selenium_Basics.DropDownsElement;

import org.apache.commons.math3.optim.nonlinear.scalar.LineSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BasicSelectDropDown {

    @Test
    public void test_DropDown()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.navigate().to("https://testautomationpractice.blogspot.com/");

        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        Select countryDrp = new Select(country);
        countryDrp.selectByVisibleText("France");

        //get all the options list of Countries
        List<WebElement> countries = countryDrp.getOptions();
        System.out.println(countries.size());
//        for (WebElement contrey : countries)
//        {
//            System.out.println("Name of countries   : "+contrey.getText() );
//        }

        for(int i =0; i<=countries.size(); i++)
        {

            System.out.println(countries.get(i).getText());
        }




    }
}

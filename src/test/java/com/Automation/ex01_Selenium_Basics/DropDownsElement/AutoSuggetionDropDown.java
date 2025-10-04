package com.Automation.ex01_Selenium_Basics.DropDownsElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class AutoSuggetionDropDown {

    @Test
    public void testAutoSuggetionDropDown()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("Selenium");
        List<WebElement> autoSuggestion = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
        System.out.println(autoSuggestion.size());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for ( WebElement search : autoSuggestion)
        {
            System.out.println( search.getText());
            if(search.getText().equals("selenium reach foods"));
            {
                search.click();
            }
        }
    }
}

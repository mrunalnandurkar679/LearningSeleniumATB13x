package com.thetestingacademy.ex01_Selenium_Basics.MouseACtions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SlidersActions {

    @Test
    public static void testSliderActions()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        Actions act = new Actions(driver);
        WebElement min_slider = driver.findElement(By.xpath("//div[@id='slider-range']/span[1]"));
        min_slider.click();
        System.out.println(min_slider.getLocation());
        act.dragAndDropBy(min_slider, 50, 249).perform();
        System.out.println(min_slider.getLocation().getX());
        WebElement max_slider = driver.findElement(By.xpath("//div[@id='slider-range']/span[2]"));
        act.dragAndDropBy(max_slider, -49, 249).perform();
        System.out.println("New position" +max_slider.getLocation());
        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://testautomationpractice.blogspot.com/");
        List<String> windowsid  = new ArrayList(driver.getWindowHandles());

        for(String id : windowsid)
        {
            System.out.println(id);
        }

        driver.switchTo().window(windowsid.get(1));

        System.out.println(driver.getTitle());
        WebElement slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
        act.dragAndDropBy(slider, 100, 0).perform();


    }
}

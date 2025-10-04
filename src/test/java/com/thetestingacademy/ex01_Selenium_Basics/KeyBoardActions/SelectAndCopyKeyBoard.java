package com.thetestingacademy.ex01_Selenium_Basics.KeyBoardActions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SelectAndCopyKeyBoard {

    @Test
    public void testSelect_Copy_KeyBoard()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);

        WebElement text1 = driver.findElement(By.id("inputText1"));
        text1.sendKeys("Welcome");

        //ctrl+A
        act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

        //ctrl+C

        act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

        //Tab
        act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

        //ctrl+V
        act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://google.com");

        List<String> ids = new ArrayList(driver.getWindowHandles());
        System.out.println(ids.get(1));
        String title = driver.switchTo().window(ids.get(1)).getTitle();
        System.out.println("title : " +title);
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Youtube"+Keys.ENTER);


    }
}

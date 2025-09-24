package com.thetestingacademy.ex01_Selenium_Basics.Automation_Testing_Practice;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import io.qameta.allure.Owner;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.security.Key;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

public class Widget_PageList extends BaseClassMethods {

    //Test all the content pages are getting open successfully
    //site : https://testautomationpractice.blogspot.com/
        @Test
    public void test_Widget_Pages()
    {
        getURL(driver, "https://testautomationpractice.blogspot.com/");
        String parentwindow= driver.getWindowHandle();
        List<WebElement> pages = driver.findElements(By.xpath("//div[@id='PageList2']/div/ul/li/a"));

        for (int i =0 ; i<pages.size(); i++){
            try {
                pages = driver.findElements(By.xpath("//div[@id='PageList2']/div/ul/li/a"));
                WebElement page = wait.until(ExpectedConditions.elementToBeClickable(pages.get(i)));
                String pagename = page.getText();
                String expectedURL = page.getAttribute("href");
                System.out.println("Processing link " + pagename + "  :  " + expectedURL);
                page.click();

                for (String windowHendle : driver.getWindowHandles()) {
                    if (!windowHendle.equals(parentwindow)) {
                        driver.switchTo().window(windowHendle);
                        System.out.println("Switched to new WIndow : " + windowHendle);
                        String title = driver.getTitle();
                        break;
                    }
                }
                //validate pageTitle
                String pageTitle = driver.getTitle();
                Assert.assertFalse(pageTitle.isEmpty(), " page title us empty " + pagename);
                System.out.println("page title : " + pageTitle);


            }



                 catch (StaleElementReferenceException e)
            {
                System.out.println("StaleElementReferenceException at link index " + i + ": " + e.getMessage());                List<WebElement> pages1 = driver.findElements(By.xpath("//div[@id='PageList2']/div/ul/li/a"));
                i--;

          }
            }
               // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(with(By.tagName("a")).below(page)))).click();

            }



            @Test(priority = 2)
            @Owner("Mrunal")
            public void test_registration()
            {
                getURL(driver, "https://testautomationpractice.blogspot.com/");
                WebElement userName = driver.findElement(By.id("name"));
                userName.sendKeys("mrunal"+ Keys.ENTER);
                WebElement email = driver.findElement(By.id("email"));
                email.sendKeys("mrunal@gmail.com"+ Keys.ENTER);
                WebElement phone = driver.findElement(By.id("phone"));
//                String maxLenght = phone.getAttribute('maxlength');
//                System.out.println(maxLenght);
//                String validMoboile = "1234567890";
//                phone.sendKeys(validMoboile);
//                //Assert.assertEquals(maxLenght.length(), validMoboile, "Mobile number length should be exactly 10 digits.");
//                Pattern numericPattern = Pattern.compile("\\d{10}");
//                //Assert.assertTrue(numericPattern.matcher(maxLenght).matches(), "Mobile number should be contained only digits no alphabates");






            }

    }


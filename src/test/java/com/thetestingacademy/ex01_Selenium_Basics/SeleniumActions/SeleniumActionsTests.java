package com.thetestingacademy.ex01_Selenium_Basics.SeleniumActions;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumActionsTests extends BaseClassMethods {


    @Test
    public void testActions()
    {
        getURL(driver, "https://www.spicejet.com/");
        WebElement fromCity = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("BLR").build().perform();
        try
        {
            WebElement toCity = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/div/div/input"));

        actions.moveToElement(toCity).sendKeys("NGP").click().build().perform();
        WebElement error_msg = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-destination\"]/div[2]/div[2]/div"));
        String message = error_msg.getText();
        System.out.println(message);
                Assert.assertTrue(message.contains("No destinations found"), "Unable to search location ");
        }
        catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        }




    }
}

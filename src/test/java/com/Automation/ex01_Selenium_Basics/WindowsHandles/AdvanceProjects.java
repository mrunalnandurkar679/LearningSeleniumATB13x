package com.Automation.ex01_Selenium_Basics.WindowsHandles;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Set;

public class AdvanceProjects extends BaseClassMethods {


    @Test
    public void testiFrame()
    {
        getURL(driver, "https://app.vwo.com/#/analyze/heatmap/3/reports?token=eyJhY2NvdW50X2lkIjoxMTM0NTkxLCJleHBlcmltZW50X2lkIjozLCJjcmVhdGVkX29uIjoxNzU2MDA4MDkyLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiZTlmNmY0ZGZlMGJhMGIxNmQxMjZmMGJlOTUyMDQ3MmEiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&accountId=1134591");
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("Parent --->" +parentWindowHandle);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement GetURL = driver.findElement(By.xpath("//input[@name='primaryUrl']"));
        GetURL.clear();

        GetURL.sendKeys("https://thetestingacademy.com");
        WebElement viewMap = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='View Heatmap']")));
        viewMap.click();


        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allHandles = driver.getWindowHandles();
        System.out.println(allHandles);

        for(String handle : allHandles)
        {
            if(!handle.equals(parentWindowHandle))
            {
                driver.switchTo().window(handle);
                driver.switchTo().frame("heatmap-iframe");
                WebElement device = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Device']")));
                Actions actions = new Actions(driver);
                actions.moveToElement(device).click().build().perform();
            }
        }
    }
}

package com.thetestingacademy.ex01_Selenium_Basics.SeleniumActions;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class MakeMyTripSeleniumACtions extends BaseClassMethods
{

    @Test
    public void testMouseActions()
    {

        //get into the makeMyTrip Browser
        getURL(driver, "https://www.makemytrip.com/");

        //close the Modal popup
        WebElement modal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-cy='closeModal']")));
        modal.click();

        //define reference object for the ACtion class
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//input[@data-cy='fromCity']"));
        source.click();


        //Setting up the Source City
        List<WebElement> states = driver.findElements(By.xpath("//div[@id='react-autowhatever-1']/div/ul/li"));
        for (WebElement state : states)
        {
            System.out.println("list all the states :" +state.getText());
            if (state.getText().contains("GOI"))
            {
                wait.until(ExpectedConditions.elementToBeClickable(state));
                state.click();
                break;
            }
        }


        //setting up the Destination City
        WebElement destination = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-cy='toCity']")));
        actions.moveToElement(destination).click().sendKeys("BOM").build().perform();

        List<WebElement> sourceCity = driver.findElements(By.xpath("//div[@id='react-autowhatever-1']/div/ul/li"));

        for (WebElement City: sourceCity)
        {
            System.out.println("Source city lists "+City.getText());
            if (City.getText().contains("BOM"))
            {
                wait.until(ExpectedConditions.elementToBeClickable(City));
                City.click();
                break;
            }
        }

        //pick the Departure date

        WebElement departure = driver.findElement(By.xpath("//span[text()='Departure']"));
        departure.click();
        List<WebElement> departureDate = driver.findElements(By.xpath("//div[@class='DayPicker-Month'][1]/div[3]/div"));
        for(WebElement date : departureDate)
        {
            if(date.getText().contains("17"))
            {
                wait.until(ExpectedConditions.visibilityOfAllElements(date));
                date.click();
            }

        }

        //selecting the number of travelleres
        WebElement travller_class = driver.findElement(By.xpath("//div[@data-cy='flightTraveller']"));
        travller_class.click();
        WebElement twoAdults = driver.findElement(By.xpath("//li[@data-cy='adults-2']"));
        twoAdults.click();

        //Selecting the traveller class Range
        List<WebElement> classRanges = driver.findElements(By.xpath("//ul[@class='guestCounter classSelect font12 darkText']/li"));
        for (WebElement classRange : classRanges)
        {
            if(classRange.getText().contains("Business"))
            {
                actions.moveToElement(classRange).click().build().perform();
            }

        }

    }

    public void commonMethod()
    {
        List<WebElement> states = driver.findElements(By.xpath("//div[@id='react-autowhatever-1']/div/ul/li"));
        for (WebElement state : states)
        {
            System.out.println("Print all the states" +state.getText());
        }

    }

    @Test
    public void testFooter()
    {
        getURL(driver, "https://www.makemytrip.com/");
        WebElement modal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-cy='closeModal']")));
        modal.click();
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println(parentWindowHandle);
        List<WebElement> footers = driver.findElements(By.xpath("//ul[@data-cy=\"tertiaryRowItemsContainer\"]/li/div/p/span"));
        for (WebElement footer : footers)
        {
            if ( footer.getText().contains("How2Go"))
            {
                Actions action = new Actions(driver);
                wait.until(ExpectedConditions.elementToBeClickable(footer));
                action.moveToElement(footer).click().build().perform();
            }
        }
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles )
        {
            if (!windowHandle.equals(parentWindowHandle))
            {
                try{
                driver.switchTo().window(windowHandle);
                System.out.println(driver.getCurrentUrl());
                Assert.assertTrue(driver.getCurrentUrl().contains("how2go"), "window doesnot 4 Switch successfully");
                driver.switchTo().window(parentWindowHandle);
            }
                catch (Exception e)
                {
                    throw new RuntimeException(e.getMessage());

                }
        }
    }
}
    }

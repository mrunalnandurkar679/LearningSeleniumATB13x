package com.thetestingacademy.ex01_Selenium_Basics.SeleniumActions;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class ImpovedTest extends BaseClassMethods {


    @Test
    public void testbooking()
    {

// ... (inside your test method)

        getURL(driver, "https://www.makemytrip.com/flights");  // Assuming this navigates and maximizes window

// Close Modal Popup
        WebElement modal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-cy='closeModal']")));
        modal.click();

// Source City Setup
        WebElement source = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-cy='fromCity']")));
        source.clear();  // Clear any default value
        source.sendKeys("GOI");  // Better: Send keys first, then wait for suggestions
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-autowhatever-1-section-0']")));  // Wait for autocomplete dropdown

// Improved: Use text-based selection (more robust than fixed ID)
        List<WebElement> sourceSuggestions = driver.findElements(By.xpath("//div[contains(@id, 'react-autowhatever')]/ul/li//p[contains(text(), 'GOI')]"));
        boolean found = false;
        for (WebElement suggestion : sourceSuggestions) {
            System.out.println("Source suggestion: " + suggestion.getText());
            if (suggestion.getText().contains("GOI")) {
                wait.until(ExpectedConditions.elementToBeClickable(suggestion));
                suggestion.click();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new RuntimeException("Source city GOI not found");
        }

// Destination City Setup
        WebElement destination = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-cy='toCity']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(destination).click().sendKeys("BOM").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id, 'react-autowhatever')]/ul/li")));  // Wait for dropdown

        List<WebElement> destSuggestions = driver.findElements(By.xpath("//div[contains(@id, 'react-autowhatever')]/ul/li//p[contains(text(), 'BOM')]"));
        found = false;
        for (WebElement city : destSuggestions) {
            System.out.println("Destination suggestion: " + city.getText());
            if (city.getText().contains("BOM")) {
                wait.until(ExpectedConditions.elementToBeClickable(city));
                city.click();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new RuntimeException("Destination city BOM not found");
        }

// Pick Departure Date: September 17, 2025
// First, click to open calendar
        WebElement depInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@data-cy='departureDate'] | //input[contains(@placeholder, 'Departure')]")));  // Flexible selector
        depInput.click();

// Wait for calendar to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'DayPicker')]")));

// Navigate to September 2025 (from current Sept 13, 2025 - may already be visible, but loop for safety)
        String targetMonthYear = "September 2025";
        WebElement monthCaption;
        do {
            monthCaption = driver.findElement(By.xpath("//div[contains(@class, 'DayPicker-Caption')]//div[contains(text(), '" + targetMonthYear + "')]"));
            if (!monthCaption.isDisplayed()) {
                // Click next month button (right arrow)
                WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'DayPicker-NavButton--next') or @aria-label='Next Month']")));
                nextBtn.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'DayPicker-Transition')]")));  // Wait for animation
            }
        } while (!driver.findElements(By.xpath("//div[contains(@class, 'DayPicker-Caption') and contains(text(), '" + targetMonthYear + "')]")).isEmpty());

// Now select date 17 (enabled day elements)
        List<WebElement> allDays = driver.findElements(By.xpath("//div[contains(@class, 'DayPicker-Month')]//div[@aria-disabled='false' and (contains(@class, 'DayPicker-Day') or contains(@aria-label, '17'))]"));
        found = false;
        for (WebElement date : allDays) {
            String dateText = date.getText().trim();
            System.out.println("Available date: " + dateText);
            if (dateText.equals("17")) {  // Exact match, not contains (avoids 17x)
                wait.until(ExpectedConditions.elementToBeClickable(date));
                date.click();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new RuntimeException("Date 17 not found in September 2025");
        }

// Traveler Selection
        WebElement travelerBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-cy='flightTraveller']")));
        travelerBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-cy='Adult']")));  // Wait for dropdown

// Select 2 Adults
        WebElement twoAdults = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-cy='Adult']//li[@data-cy='adults-2']")));
        twoAdults.click();

// Select Class: Business (loop through options)
        List<WebElement> classOptions = driver.findElements(By.xpath("//div[@data-cy='AircraftClass']//ul/li"));
        found = false;
        for (WebElement cls : classOptions) {
            System.out.println("Class option: " + cls.getText());
            if (cls.getText().contains("Business")) {
                wait.until(ExpectedConditions.elementToBeClickable(cls));
                cls.click();
                found = true;
                break;
            }
        }
        if (!found) {
            throw new RuntimeException("Business class not found");
        }

// **Critical: Click Done to apply**
        WebElement doneBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-cy='done'] | //div[contains(text(), 'Done')]")));
        doneBtn.click();

// Optional: Click Search to submit
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-cy='searchBtn'] | //button[contains(text(), 'Search')]")));
        searchBtn.click();

// Add at end: Handle any popups or waits as needed
    }
}

package com.Automation.ex01_Selenium_Basics.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseClassMethods {
    public static WebDriver driver = new ChromeDriver();
    public static  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    public void getURL(WebDriver driver, String URL)
    {
        driver.manage().window().maximize();
        driver.get(URL);

    }

    public  void vwologin (WebDriver driver, String username, String password)
    {
        WebElement enter_loginID = driver.findElement(By.name("username"));
        enter_loginID.sendKeys(username);
        WebElement loginpassword = driver.findElement(By.xpath("//input[@type='password']"));
        loginpassword.sendKeys(password);
        WebElement login_button = driver.findElement(By.xpath("//button[@type='submit']"));
        login_button.click();

    }

    public void free_trial_login(WebDriver driver, String userid)
    {
       WebElement username =  driver.findElement(By.xpath("//input[@name='email']"));
               username.sendKeys(userid);


    }

    public static void staticWebTable()
    {

        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
    }

    public  static void explicitWait()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void getFutureDate(WebDriver driver, String month, String year, String date)
    {

        while(true) {
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (actualYear.equals(year) && actualMonth.equals(month)) {
                break;
            }

            driver.findElement(By.xpath("//span[text()='Next']")).click();

        }

        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td/a"));
        for(WebElement calendardate : dates)
        {
            String actualdate = calendardate.getText();
            if(actualdate.equals(date))
            {
                wait.until(ExpectedConditions.elementToBeClickable(calendardate));
                calendardate.click();
                String finaledate = driver.findElement(By.xpath("//input[@id='datepicker']")).getText();
                System.out.println("Will move to my new home on this date :" +finaledate);
            }
        }

    }


    public static void getPastDate(WebDriver driver, String month, String year, String date)
    {
        while(true) {
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (actualYear.equals(year) && actualMonth.equals(month)) {
                break;
            }

            driver.findElement(By.xpath("//span[text()='Prev']")).click();

        }

        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td/a"));
        for(WebElement calendardate : dates)
        {
            String actualdate = calendardate.getText();
            if(actualdate.equals(date))
            {
                wait.until(ExpectedConditions.elementToBeClickable(calendardate));
                calendardate.click();
                String finaledate = driver.findElement(By.xpath("//input[@id='datepicker']")).getText();
                System.out.println("Will move to my new home on this date :" +finaledate);
            }
        }

    }
}

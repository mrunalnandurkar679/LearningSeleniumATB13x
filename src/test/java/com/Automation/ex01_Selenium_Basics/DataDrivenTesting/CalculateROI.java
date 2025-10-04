package com.Automation.ex01_Selenium_Basics.DataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class CalculateROI extends ExcelUtils{

    @BeforeMethod
    @Test
    public void test_ROI() throws IOException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
        String file_name = System.getProperty("user.dir") + "\\src\\test\\resources\\PrincipleIntrest-SBI.xlsx";
        int rows = ExcelUtils.getRowCounts(file_name, "data");

        // 1. Read the data from Excel
        for (int i = 1; i <= rows; i++) {
            String PrincipleAmount = ExcelUtils.getCellData(file_name, "data", i, 0);
            System.out.println(PrincipleAmount);
            String ROI = ExcelUtils.getCellData(file_name, "data", i, 1);
            String periodNum = ExcelUtils.getCellData(file_name, "data", i, 2);
            String PeriodYears = ExcelUtils.getCellData(file_name, "data", i, 3);
            String Frequency = ExcelUtils.getCellData(file_name, "data", i, 4);
            String MaturityValue = ExcelUtils.getCellData(file_name, "data", i, 5);


            //2. search teh element and pass teh excel values


            WebElement principle = driver.findElement(By.xpath("//input[@id='principal']"));
            principle.sendKeys("40000");
            WebElement interest = driver.findElement(By.xpath("//input[@id='interest']"));
            interest.sendKeys(ROI);
            WebElement years = driver.findElement(By.xpath("//input[@id='tenure']"));
            years.sendKeys("9");

            Select selectYears = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
            selectYears.selectByVisibleText(PeriodYears);
            Select selectIntrest = new Select(driver.findElement(By.id("frequency")));
            selectIntrest.selectByVisibleText(Frequency);
            WebElement calc = driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
            calc.click();

        }
    }

}


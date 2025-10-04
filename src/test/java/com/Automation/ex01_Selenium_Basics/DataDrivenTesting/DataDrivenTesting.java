package com.Automation.ex01_Selenium_Basics.DataDrivenTesting;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;

public class DataDrivenTesting extends BaseClassMethods {


    @Test(dataProvider="Data")
    public void test_VWO_Login(String username, String Password)
    {
        getURL(driver, "https://app.vwo.com");
        Assert.assertEquals(driver.getTitle(), "Login - VWO");
                vwologin(driver, username, Password);

        WebElement error_message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='notification-box-description']")));
        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");

    }

    @DataProvider
    public Object[][] Data()
    {
        return UtiExcel.get_DataFrom_Excel("Testdata");
        };
    }




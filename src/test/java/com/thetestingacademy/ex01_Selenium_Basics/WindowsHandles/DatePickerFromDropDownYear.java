package com.thetestingacademy.ex01_Selenium_Basics.WindowsHandles;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;

public class DatePickerFromDropDownYear extends BaseClassMethods {

    @Test
    public  void test_datePicker()
    {
        getURL(driver, "https://testautomationpractice.blogspot.com/");
    }
}

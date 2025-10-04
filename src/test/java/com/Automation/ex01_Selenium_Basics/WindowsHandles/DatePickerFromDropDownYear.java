package com.Automation.ex01_Selenium_Basics.WindowsHandles;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.testng.annotations.Test;

public class DatePickerFromDropDownYear extends BaseClassMethods {

    @Test
    public  void test_datePicker()
    {
        getURL(driver, "https://testautomationpractice.blogspot.com/");
    }
}

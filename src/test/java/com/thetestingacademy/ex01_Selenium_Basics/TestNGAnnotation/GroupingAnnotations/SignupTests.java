package com.thetestingacademy.ex01_Selenium_Basics.TestNGAnnotation.GroupingAnnotations;

import org.testng.annotations.Test;

public class SignupTests {

    @Test(priority = 1, groups = {"regression"})
    void openURL()
    {

        System.out.println("app is open");
    }

    @Test(priority = 2, groups = {"regression"})
    void register()
    {

        System.out.println("registered done successfully");
    }

    @Test(priority = 3, groups = {"regression"})
    void result()
    {
        System.out.println("passed");

    }
}

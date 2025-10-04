package com.thetestingacademy.ex01_Selenium_Basics.TestNGAnnotation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependingMethods {

    @Test(priority = '1')
    public void opneApp()
    {
        Assert.assertTrue(true);
    }

    @Test (priority = 2, dependsOnMethods = {"opneApp"})
    public void login()
    {
        Assert.assertTrue(false);
    }

    @Test(priority = 3, dependsOnMethods = {"login"})
    void serach()
    {
     Assert.assertTrue(true);
    }

    @Test(priority = 4, dependsOnMethods = {"login"})
    void advanceSearch()
    {
        Assert.assertTrue(true);

    }

    @Test(priority =5, dependsOnMethods = {"opneApp"})
    void logout()
    {
        Assert.assertTrue(true);
    }
}

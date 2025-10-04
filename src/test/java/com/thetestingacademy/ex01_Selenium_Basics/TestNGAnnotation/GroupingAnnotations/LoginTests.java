package com.thetestingacademy.ex01_Selenium_Basics.TestNGAnnotation.GroupingAnnotations;

import org.testng.annotations.Test;

public class LoginTests {

    @Test(priority = 1, groups = {"sanity"})
    void openApp()
    {
        System.out.println("openApp");

    }
    @Test(priority = 3, groups = {"sanity"})
    void login()
    {
        System.out.println("login");

    }

    @Test(priority = 2, groups = {"regression"})
    void search()
    {

        System.out.println("search");
    }

    @Test(priority = 3, groups = {"sanity"})
    void logout()
    {

        System.out.println("logout");
    }
}

package com.thetestingacademy.ex01_Selenium_Basics.TestNGAnnotation.GroupingAnnotations;

import org.testng.annotations.Test;

public class PaymentTests {

    @Test(priority = 1, groups = {"regression", "sanity", "functional"})
    void openPayment()
    {
        System.out.println("Done Payment");

    }

    @Test(priority = 2, groups = {"regression", "sanity", "functional"})
    void paymentSuccessful()
    {

        System.out.println("Successful payment");
    }

    @Test(priority = 3, groups = {"regression", "sanity", "functional"})
    void paymentFailed()
    {
        System.out.println("failure payment");

    }
}

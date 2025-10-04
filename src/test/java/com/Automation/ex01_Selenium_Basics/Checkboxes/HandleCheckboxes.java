package com.Automation.ex01_Selenium_Basics.Checkboxes;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.util.List;

public class HandleCheckboxes extends BaseClassMethods {


    @Test
    public void textCheckboxes() {
        getURL(driver, "https://testautomationpractice.blogspot.com/");
//        //get the list of locators
//        List<WebElement> days = driver.findElements(By.xpath("//input[contains(@class,\"form-check-input\") and @type=\"checkbox\"]"));
//        for (WebElement day : days)
//        {
//            String name = day.getAttribute("id");
//            WebElement label = driver.findElement(By.xpath("//label[@for='"+name+"']"));
//            String labelText = label.getText();
//            if(labelText.contains("Monday"))
//            {
//                day.click();
//            }
//
//        }

//
//        //check the last index checkboxes
//        for (int i =4; i<days.size(); i++)
//        {
//            days.get(i).click();
//
//        }
//
//        //check the 1st 3 index checkboxes
//        for (int i =0; i<3; i++)
//        {
//            days.get(i).click();
//        }
//
//        //        uncheck the 1st 3 index checkboxes
//
//        for (int i =0; i<2; i++)
//        {
//            if (days.get(i).isSelected())
//            {
//                days.get(i).click();
//            }
//        }
//
//        //Uncheck all the checkboxes
//        for (WebElement day : days) {
//            if (day.isSelected()) {
//                day.click();
//            }
//        }

        //Get the list of pages

        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        System.out.println(pages.size());
        for (WebElement page : pages) {
            page.click();

        //Handle Table checkbox

        String first_path = "//table[@id='productTable']/tbody/tr[";
        String second_path = "]/td[4";
        String third_part = "]/input";
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
        //List<WebElement> col = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr[1]/td"));

            for (int i = 1; i <= rows.size(); i++) {

                String dynamic_path = first_path + i + second_path + third_part;
                System.out.println(dynamic_path);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                wait.until(ExpectedConditions.elementToBeClickable((By.xpath(dynamic_path)))).click();


            }
        }

    }
}




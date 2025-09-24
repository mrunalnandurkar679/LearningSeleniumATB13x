package com.thetestingacademy.ex01_Selenium_Basics.WebTable;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StaticWebTables extends BaseClassMethods {

    @Test
    public void getTableDetails()
    {
        BaseClassMethods.staticWebTable();
        String first_part = "//table[@class='table table-striped mt-3']/tbody/tr[";
        String seond_part = "]/td[";
        String third_part = "]";
        int row = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr[1]/td")).size();

        System.out.println(driver.findElement(By.xpath("//table[@class='table table-striped mt-3']/thead")).getText());

        for (int i = 1; i <=row; i++)
        {
            for (int j = 1; j<=col; j++)
            {

                String dynamic_path = first_part+i+seond_part+j+third_part;
                String data = driver.findElement(By.xpath(dynamic_path)).getText();
                System.out.print(data+"        ");
                if (data.contains("Vega"))
                {
                    String age_path =  dynamic_path+"/following-sibling::td";
                    String age_data= driver.findElement(By.xpath(age_path)).getText();
                    System.out.println("_______________________________");
                    System.out.println("get teh age of Vega ----" +age_data);
                    String  email_path = dynamic_path+"/following-sibling::td[2]";
                    String email_data = driver.findElement(By.xpath(email_path)).getText();
                    System.out.println("vega email address : ------"+email_data);
                                    }
                if (data.contains("kierra@example.com"))
                {
                    String department_path = dynamic_path+("/following-sibling::td[2]");
                    String depatment_data = driver.findElement(By.xpath(department_path)).getText();
                    Assert.assertTrue(depatment_data.contains("Legal"));
                    System.out.println("Department details : "+ depatment_data);
                }
            }
            System.out.println();
        }
        System.out.println(driver.findElement(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr[5]/td[1]")).getText());

    }

}

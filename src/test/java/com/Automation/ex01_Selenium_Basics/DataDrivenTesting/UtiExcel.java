package com.Automation.ex01_Selenium_Basics.DataDrivenTesting;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtiExcel extends BaseClassMethods {



    public static String file_Path = System.getProperty("user.dir")+"\\src\\test\\resources\\Testdata.xlsx";
    public static Workbook workbook;
    public static Sheet sheet;
    public static Object[][] get_DataFrom_Excel(String sheetName)
    {
        System.out.println(file_Path);

        //APache POI
        //Read The File
        //WorkBook Create
        //Sheet
        //Row and Cell
        //2D Object - getData()

        FileInputStream fileInputStream = null;
        try
        {
            fileInputStream = new FileInputStream(file_Path);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        }
        catch (IOException e)
        {
            System.out.println("File not found");
        }

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i =1; i< sheet.getLastRowNum(); i++)
        {
            for (int j =0; j<sheet.getRow(0).getLastCellNum(); j++)
            {
                data[i][j] = sheet.getRow(+1).getCell(j).toString();


            }
        }
        return data;
    }
}

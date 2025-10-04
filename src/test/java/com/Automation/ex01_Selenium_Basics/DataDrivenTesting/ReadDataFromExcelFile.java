package com.Automation.ex01_Selenium_Basics.DataDrivenTesting;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ReadDataFromExcelFile  {


//File - Workbook - sheet - Row - for value (cell)

public static void main(String[] args) throws IOException {


    String File_path = System.getProperty("user.dir") + "/src/test/resources/MOCK_DATA.xlsx";
    FileInputStream file = new FileInputStream(File_path);  // open file in read mode
    XSSFWorkbook workbook = new XSSFWorkbook(file);  //extracted workbook from file
    XSSFSheet sheet = workbook.getSheet("data"); //extracted sheet from file // provide teh name of thet sheet
    int totalrows = sheet.getLastRowNum();
    System.out.println("number of rows "+totalrows);
    int totalcells = sheet.getRow(1).getLastCellNum();
    System.out.println("total number of col : "+totalcells);

    for(int i =1; i<=totalrows ; i++)
    {
        XSSFRow currenntRows = sheet.getRow(i);
        for (int j =0; j<totalcells; j++)
        {
            String data = currenntRows.getCell(j).toString();
            System.out.print(data+"      ");

        }
        System.out.println("");
    }
    workbook.close();
    file.close();




}

}

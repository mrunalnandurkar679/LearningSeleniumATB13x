package com.Automation.ex01_Selenium_Basics.DataDrivenTesting;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    public static FileInputStream file;
    public  static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public  static XSSFRow row;
    public static XSSFCell cell;
    public  static CellStyle style;
    public static FileOutputStream fo;
    //public static String file_name = System.getProperty("user.dir")+("user.dir") + "/src/test/resources/MOCK_DATA.xlsx";

    public static int getRowCounts(String file_name, String sheet_name) throws IOException {
        file = new FileInputStream(file_name);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheet_name);
        int numofrow = sheet.getLastRowNum();
        System.out.println(numofrow);
        workbook.close();
        file.close();
        return numofrow;

    }

    public static int getCellCounts(String file_name, String sheet_name, int rowNum) throws IOException {

        file = new FileInputStream(file_name);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheet_name);
        int row = sheet.getLastRowNum();
        int numofcol = sheet.getRow(rowNum).getLastCellNum();
        workbook.close();
        file.close();
        return numofcol;
    }


    public static String getCellData(String file_name, String sheet_name, int rowNum, int cellNum) throws IOException {
        file = new FileInputStream(file_name);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheet_name);
        int rowCounts = sheet.getLastRowNum();
        int cellCounts = sheet.getRow(rowNum).getLastCellNum();
        String data ;
        try
        {
            data = sheet.getRow(rowNum).getCell(cellNum).toString();

        }catch (Exception e)
        {
            data =" ";

        }

        workbook.close();
        file.close();
        return data;

    }

    public static void setCellData(String file_name, String sheet_name, int rowNum, int cellNum, String data) throws IOException {

        file = new FileInputStream(file_name);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheet_name);
        row = sheet.getRow(rowNum);

        cell = row.createCell(cellNum);
        cell.setCellValue(data);
        fo = new FileOutputStream(file_name);

        workbook.close();
        file.close();
        fo.close();

    }
}

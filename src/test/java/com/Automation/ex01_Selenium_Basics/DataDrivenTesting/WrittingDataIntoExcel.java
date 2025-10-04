package com.Automation.ex01_Selenium_Basics.DataDrivenTesting;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WrittingDataIntoExcel {

    private static XSSFRow row2;

    public static void main(String[] args) throws IOException {

        String file_path = System.getProperty("user.dir")+"/src/test/resources/created_File.xlsx";
        FileOutputStream file = new FileOutputStream(file_path);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("data");  // for creating data

        XSSFRow row0 = sheet.createRow(1);
        row0.createCell(0).setCellValue("Name");
        row0.createCell(1).setCellValue("lastName");
        row0.createCell(2).setCellValue("age");



        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("Mrunal");
        row1.createCell(1).setCellValue("Nandurkar");
        row1.createCell(2).setCellValue(33.5);

        XSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("abc");
        row2.createCell(1).setCellValue("xyz");
        row2.createCell(2).setCellValue(34.09);

        XSSFRow row3 = sheet.createRow(3);
        row3.createCell(0).setCellValue("asd");
        row3.createCell(1).setCellValue("qwe");
        row3.createCell(2).setCellValue(234);

        workbook.write(file);
        workbook.close();
        file.close();


    }
}

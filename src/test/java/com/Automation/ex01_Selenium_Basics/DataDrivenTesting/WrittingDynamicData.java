package com.Automation.ex01_Selenium_Basics.DataDrivenTesting;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WrittingDynamicData {

    public static void main(String[] args) throws IOException {

        String file_name = System.getProperty("user.dir")+"/src/test/resources/createdTest.xlsx";
        FileOutputStream file = new FileOutputStream(file_name);
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("data");
        XSSFRow row = sheet.createRow(0);

        Scanner scan = new Scanner(System.in);

        System.out.println("enter the number of rows");
        int rows = scan.nextInt();
        System.out.println("enter the number of cells");
        int col = scan.nextInt();

        for (int r =0 ; r<= rows; r++)
        {
            XSSFRow currentrow= sheet.createRow(r);

            for (int c = 0; c<col; c++)
            {
                XSSFCell cell = currentrow.createCell(c);
                System.out.println("entered the data");
                cell.setCellValue(scan.next());

            }

        }
//        workbook.close();
//        file.close();



    }
}

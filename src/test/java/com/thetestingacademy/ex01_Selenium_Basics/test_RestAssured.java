package com.thetestingacademy.ex01_Selenium_Basics;

import com.Automation.ex01_Selenium_Basics.DriverUploadRequest;
import io.restassured.RestAssured;

import java.io.File;

public class test_RestAssured {
    public static void main(String[] args) {

        File profilePhoto = new File("src/test/java/com/thetestingacademy/ex01_Selenium_Basics/qjobfit.png");
        File licensePhoto = new File("src/test/java/com/thetestingacademy/ex01_Selenium_Basics/qjobfit.png");
        File aadharPhoto = new File("src/test/java/com/thetestingacademy/ex01_Selenium_Basics/qjobfit.png");


        DriverUploadRequest driverUploadRequest = new DriverUploadRequest(
               "1","abc",profilePhoto,licensePhoto,"abc123",aadharPhoto);


        RestAssured.given().baseUri("").basePath("")
                .multiPart("id",driverUploadRequest.getId())
                .multiPart("licenseNo",driverUploadRequest.getLicenseNo());


    }
}

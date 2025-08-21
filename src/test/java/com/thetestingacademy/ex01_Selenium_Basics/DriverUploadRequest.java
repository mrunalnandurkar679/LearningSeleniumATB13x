package com.thetestingacademy.ex01_Selenium_Basics;

import java.io.File;

public class DriverUploadRequest {
    // text fields
    private String id;
    private String licenseNo;
    private String aadhaarNo; // optional

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(String aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public File getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(File profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public File getLicensePhoto() {
        return licensePhoto;
    }

    public void setLicensePhoto(File licensePhoto) {
        this.licensePhoto = licensePhoto;
    }

    public File getAadhaarPhoto() {
        return aadhaarPhoto;
    }

    public void setAadhaarPhoto(File aadhaarPhoto) {
        this.aadhaarPhoto = aadhaarPhoto;
    }

    // file fields
    private File profilePhoto;
    private File licensePhoto;
    private File aadhaarPhoto;


    public DriverUploadRequest(String id,
                               String licenseNo,
                               File profilePhoto,
                               File licensePhoto,
                               String aadhaarNo,
                               File aadhaarPhoto) {
        this.id = id;
        this.licenseNo = licenseNo;
        this.profilePhoto = profilePhoto;
        this.licensePhoto = licensePhoto;
        this.aadhaarNo = aadhaarNo;
        this.aadhaarPhoto = aadhaarPhoto;
    }



}

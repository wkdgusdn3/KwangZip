package com.doubleline.kwangzip.kwangzip.model;

import java.io.Serializable;

/**
 * Created by HyunWoo on 2015-08-29.
 */
public class TastyHouse implements Serializable{
    String number;
    String name;
    String category;
    String distance;
    String latitude;
    String longitude;
    String grade;
    String phoneNumber;
    String operationTime;
    String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(String operationTime) {
        this.operationTime = operationTime;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public TastyHouse(String number, String name, String category, String distance, String grade) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.distance = distance;
        this.grade = grade;
    }

    public TastyHouse(String number, String name, String category, String distance, String latitude, String longitude, String grade, String phoneNumber, String operationTime, String location) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.distance = distance;
        this.latitude = latitude;
        this.longitude = longitude;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
        this.operationTime = operationTime;
        this.location = location;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

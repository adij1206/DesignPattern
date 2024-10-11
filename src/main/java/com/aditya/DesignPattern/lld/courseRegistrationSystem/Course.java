package com.aditya.DesignPattern.lld.courseRegistrationSystem;

import lombok.Data;

@Data
public class Course {

    private String courseCode;
    private String courseName;
    private String instructor;
    private int maximumCapacity;
    private int currentCapacity;

    public Course(String courseCode, String courseName, String instructor, int maximumCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
        this.maximumCapacity = maximumCapacity;
        this.currentCapacity = 0;
    }
}

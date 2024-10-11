package com.aditya.DesignPattern.lld.courseRegistrationSystem;

import java.util.HashMap;
import java.util.Map;

public class CourseService {

    private Map<String, Course> courseMap;

    public CourseService() {
        this.courseMap = new HashMap<>();
    }

    public void addCourse(Course course) {
        this.courseMap.put(course.getCourseCode(), course);
    }

    public Course getCourse(String courseCode) {
        return this.courseMap.get(courseCode);
    }

    public Course getCourseByName(String courseName) {
        for (Course course : courseMap.values()) {
            if (course.getCourseName().equals(courseName)) {
                return course;
            }
        }

        return null;
    }

    public void updateEnrolledStudentCount(String courseCode) {
        Course course = getCourse(courseCode);

        if (course.getMaximumCapacity() <= course.getCurrentCapacity()) {
            System.out.println("Bo Seats are available to enrolled");
            return;
        }

        course.setCurrentCapacity(course.getCurrentCapacity() + 1);
    }

    public boolean isSeatAvailable(String courseCode) {
        Course course = getCourse(courseCode);

        return course.getMaximumCapacity() > course.getCurrentCapacity();
    }
}

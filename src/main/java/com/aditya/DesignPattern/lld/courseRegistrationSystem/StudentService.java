package com.aditya.DesignPattern.lld.courseRegistrationSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentService {

    private Map<String, Student> studentMap;

    public StudentService() {
        studentMap = new HashMap<>();
    }

    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    public Student getStudent(String id) {
        return studentMap.get(id);
    }
}

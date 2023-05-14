package com.aditya.DesignPattern.pattern.structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
* FlyWeight Design Pattern is used when we have to create many objects of a class.
* They will have same intrinsic property : to fix issue or to test issue
* But they will have different skills , so instead of creating different object , we can create a object
* and they will work based on their different property;
*/

interface Employee {
    void assignTask(String skill);
    void executeTask();
}

class Developer implements Employee {
    private final String JOB;
    private String skill;

    public Developer() {
        JOB = "Fix Issue";
    }

    @Override
    public void assignTask(String skill) {
        this.skill = skill;
    }

    @Override
    public void executeTask() {
        System.out.println("Developer with skill : " + skill + " will do the job of : " + JOB);
    }
}

class Tester implements Employee {
    private final String JOB;
    private String skill;

    public Tester() {
        JOB = "Test Issue";
    }

    @Override
    public void assignTask(String skill) {
        this.skill = skill;
    }

    @Override
    public void executeTask() {
        System.out.println("Tester with skill : " + skill + " will do the job of : " + JOB);
    }
}

class EmployeeFactory {
    private static final Map<String, Employee> employeeMap = new HashMap<>();

    public static Employee getEmployee(String type) {
        Employee employee = null;

        if (employeeMap.get(type) != null) {
            return employeeMap.get(type);
        } else {
            switch (type) {
                case "Developer" -> {
                    System.out.println("Creating Developer");
                    employee = new Developer();
                }
                case "Tester" -> {
                    System.out.println("Creating Tester");
                    employee = new Tester();
                }
            }
            return employee;
        }
    }
}

public class FlyWeightDesignPattern {

    private static String[] employeeRole = {"Developer", "Tester"};
    private static String[] skills = {"Java", "C++", "Python", "Node.js"};

    public static void main(String[] args) {

        for (int i=0; i<10; i++) {
            Employee e = EmployeeFactory.getEmployee(getRandomEmployeeRole());

            e.assignTask(getRandomSkill());
            e.executeTask();
        }
    }

    private static String getRandomEmployeeRole() {
        Random r = new Random();
        int randomInt = r.nextInt(employeeRole.length);

        return employeeRole[randomInt];
    }

    private static String getRandomSkill() {
        Random r = new Random();
        int randomInt = r.nextInt(skills.length);

        return skills[randomInt];
    }

}

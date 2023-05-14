package com.aditya.DesignPattern.pattern.creation;

import java.util.ArrayList;
import java.util.List;

class Person implements Cloneable {
    private List<String> personList;

    public Person() {
        this.personList = new ArrayList<>();
    }

    public Person(List<String> personList) {
        this.personList = personList;
    }

    public List<String> getPersonList() {
        return this.personList;
    }

    public void insertData() {
        personList.add("Aditya");
        personList.add("Abhigyan");
        personList.add("Sourabh");
        personList.add("Satyam");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<>();

        for (String person : this.getPersonList()) {
            tempList.add(person);
        }

        return new Person(tempList);
    }
}

public class PrototypeDesignPattern {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.insertData();

        Person person1 = (Person) person.clone();
        List<String> a = person1.getPersonList();
        a.add("Kumar Aditya");

        System.out.println(person.getPersonList());
        System.out.println(a);

        person1.getPersonList().remove("Satyam");
        System.out.println(person.getPersonList());
        System.out.println(a);
    }
}

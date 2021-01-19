package Laboratories.Class_12;

import Laboratories.Class_11.Employee;
import Laboratories.Class_11.Specialist;

import java.util.ArrayList;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person called " + name + ". ";
    }

    public void print() {
        System.out.println(this.toString());
    }
}

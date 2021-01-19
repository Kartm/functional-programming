package Laboratories.Class_12;

public class Task2 {
    public static void main(String[] args) {
        Developer[] developers = new Developer[]{null, null, null};

        fill(developers);
    }

    private static void fill(Object[] objectArray) {
        Person humanA = new Person("Alex Austin");
        Employee humanB = new Employee("Ben Bella", "Recruiter");
        Developer humanC = new Developer("Daniel Dylan", "Senior Architect", "Coffee");

        humanA.print();
        humanB.print();
        humanC.print();

        // runtime type of objectArray is Developer[], it's ok to set it here
        objectArray[2] = humanC;

        // objectArray expects a type Developer or one inheriting from it, throws an ArrayStoreException
        objectArray[0] = humanA;

        // same here
        objectArray[1] = humanB;
    }
}

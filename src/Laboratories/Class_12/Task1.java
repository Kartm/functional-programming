package Laboratories.Class_12;

public class Task1 {
    public static void main(String[] args) {
        Person[] employees = new Person[]{null, null, null};

        fill(employees);
    }

    private static void fill(Object[] objectArray) {
        Person humanA = new Person("Anna Ankowich");
        Employee humanB = new Employee("Brian Break", "Manager");
        Developer humanC = new Developer("Drake Dart", "Junior Developer", "Java");

        humanA.print();
        humanB.print();
        humanC.print();

        // runtime type of array is Person[] and humanA is Person, it's ok to put it here
        objectArray[0] = humanA;

        // sets successfully, since Employee inherits from Person
        objectArray[1] = humanB;

        // sets successfully, since Developer inherits from Employee which inherits from Person
        objectArray[2] = humanC;
    }
}

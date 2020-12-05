package Exercises.List_8.Task_1;

import java.util.Random;

public class Dog {
    // state
    private int id; // identity
    private String name;

    private static Random rn = new Random();

    public Dog(String name) {
        this.id = rn.nextInt(10000);
        this.name = name;
    }

    // getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    // behavior
    private void barkAt(Dog other) {
        String message = String.format(
            "Dog %s (id %s) barks at dog %s (id %s)",
            getName(),
            getId(),
            other.getName(),
            other.getId()
        );

        System.out.println(message);
    }

    public static void main(String[] args) {
        Dog dogA = new Dog("DogA");
        Dog dogB = new Dog("DogB");

        dogA.barkAt(dogB);
    }
}

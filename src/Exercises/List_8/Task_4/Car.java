package Exercises.List_8.Task_4;

public class Car extends BaseCar {
    private final String type = "Car";

    public Car(String color, String model, int makeYear, FuelType fuelType) {
        super(color, model, makeYear, fuelType);
    }

    @Override
    public void drive() {
        System.out.println("Drives decently.");
    }

    @Override
    public String toString() {
        return String.format("%s %s", type, this.getFormattedData());
    }
}

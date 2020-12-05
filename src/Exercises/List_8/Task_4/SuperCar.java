package Exercises.List_8.Task_4;

public class SuperCar extends BaseCar {
    private final String type = "SuperCar";

    public SuperCar(String color, String model, int makeYear, FuelType fuelType) {
        super(color, model, makeYear, fuelType);
    }

    @Override
    public void drive() {
        System.out.println("Drives smoothly and semi-autonomously.");
    }

    @Override
    public String toString() {
        return String.format("%s %s", type, this.getFormattedData());
    }
}

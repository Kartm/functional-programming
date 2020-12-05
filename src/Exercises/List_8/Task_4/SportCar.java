package Exercises.List_8.Task_4;

public class SportCar extends BaseCar {
    private final String type = "SportCar";

    public SportCar(String color, String model, int makeYear, FuelType fuelType) {
        super(color, model, makeYear, fuelType);
    }

    @Override
    public void drive() {
        System.out.println("Drives fast.");
    }

    @Override
    public String toString() {
        return String.format("%s %s", type, this.getFormattedData());
    }
}

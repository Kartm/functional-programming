package Exercises.List_8.Task_4;

public abstract class BaseCar {
    private String color;
    private String model;
    private int makeYear;
    private FuelType fuelType;

    public BaseCar(String color, String model, int makeYear, FuelType fuelType) {
        this.color = color;
        this.model = model;
        this.makeYear = makeYear;
        this.fuelType = fuelType;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public int getMakeYear() {
        return makeYear;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType newFuelType) {
        fuelType = newFuelType;
    }

    public abstract void drive();

    public String getFormattedData() {
        return String.format("%s %s, manufactured in %d, running on %s", this.getColor(), this.getModel(), this.getMakeYear(), this.getFuelType());
    }
}

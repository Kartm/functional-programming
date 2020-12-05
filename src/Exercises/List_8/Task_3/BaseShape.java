package Exercises.List_8.Task_3;

import Exercises.List_8.Task_2.IShape;

public abstract class BaseShape implements IShape {
    private String name;

    public BaseShape(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getFormattedData() {
        return String.format("Area of shape \"%s\": %f", this.getName(), this.getArea());
    }
}

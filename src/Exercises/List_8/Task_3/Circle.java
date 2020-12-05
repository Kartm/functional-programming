package Exercises.List_8.Task_3;

public class Circle extends BaseShape {
    private double radiusLength;

    public Circle(String name, double radiusLength) {
        super(name);

        this.radiusLength = radiusLength;
    }

    @Override
    public double getArea() {
        return Math.PI * radiusLength * radiusLength; // PI * R^2
    }

    public static void main(String[] args) {
        Circle circle = new Circle("Circle A", 2);
        System.out.println(circle.getFormattedData());
    }
}

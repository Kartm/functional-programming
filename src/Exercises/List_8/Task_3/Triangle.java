package Exercises.List_8.Task_3;

public class Triangle extends BaseShape {
    private double baseLength;
    private double heightLength;

    public Triangle(String name, double baseLength, double heightLength) {
        super(name);

        this.baseLength = baseLength;
        this.heightLength = heightLength;
    }

    @Override
    public double getArea() {
        return baseLength * heightLength * 0.5;
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle("Triangle A", 4, 3);
        System.out.println(triangle.getFormattedData());
    }
}

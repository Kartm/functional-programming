package Exercises.List_8.Task_3;

public class Square extends BaseShape {
    private double sideLength;

    public Square(String name, double sideLength) {
        super(name);

        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    public static void main(String[] args) {
        Square square = new Square("Square A", 1.5);
        System.out.println(square.getFormattedData());
    }
}

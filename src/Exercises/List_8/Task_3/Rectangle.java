package Exercises.List_8.Task_3;

public class Rectangle extends BaseShape {
    private double sideALength;
    private double sideBLength;

    public Rectangle(String name, double sideALength, double sideBLength) {
        super(name);

        this.sideALength = sideALength;
        this.sideBLength = sideBLength;
    }

    @Override
    public double getArea() {
        return sideALength * sideBLength;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("Rectangle A", 4, 2);
        System.out.println(rectangle.getFormattedData());
    }
}

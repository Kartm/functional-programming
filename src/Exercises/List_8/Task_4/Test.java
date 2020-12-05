package Exercises.List_8.Task_4;

public class Test  {
    public static void main(String[] args) {
        Car car = new Car("Green", "Ford", 2001, FuelType.DIESEL);
        System.out.println(car);
        car.drive();
        System.out.println();

        SuperCar superCar = new SuperCar("Black", "Tesla", 2018, FuelType.ELECTRIC);
        System.out.println(superCar);
        superCar.drive();
        System.out.println();

        SportCar sportCar = new SportCar("Red", "Ferrari", 2017, FuelType.GASOLINE);
        System.out.println(sportCar);
        sportCar.drive();
    }
}

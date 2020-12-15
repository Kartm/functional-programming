package Laboratories.Class_11;

public class Employee {
    protected String firstName;
    protected String surname;
    protected double pay;

    public Employee(String firstName, String surname, double pay) {
        this.firstName = firstName;
        this.surname = surname;
        this.pay = pay;
    }

    public double getPay() {
        return this.pay;
    }

    // assume percentage is a ratio
    public void setPercentagePayIncrease(double percentage) {
        this.pay *= percentage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", pay=" + pay +
                '}';
    }
}

package Laboratories.Class_11;

public class Specialist extends Employee {
    private double bonus = 0.0;

    public Specialist(String firstName, String surname, double pay, double bonus) {
        super(firstName, surname, pay);

        this.bonus = bonus;
    }

    @Override
    public double getPay() {
        return super.getPay() + this.bonus;
    }

    public double getBonus() {
        return this.bonus;
    }

    public void increaseBonus(double increase) {
        this.bonus += bonus;
    }

    @Override
    public String toString() {
        return "Specialist{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", pay=" + pay +
                ", bonus=" + bonus +
                '}';
    }
}

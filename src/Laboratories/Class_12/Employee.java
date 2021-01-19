package Laboratories.Class_12;

public class Employee extends Person {
    private String role;

    public Employee(String name, String role) {
        super(name);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return super.toString() + "Is working as " + role + ". ";
    }

    public void print() {
        System.out.println(this.toString());
    }
}

package Laboratories.Class_12;

public class Developer extends Employee {
    private String stack;

    public Developer(String name, String role, String stack) {
        super(name, role);
        this.stack = stack;
    }

    public String getStack() {
        return stack;
    }

    @Override
    public String toString() {
        return super.toString() + "Development stack is " + stack + ". ";
    }

    public void print() {
        System.out.println(this.toString());
    }
}

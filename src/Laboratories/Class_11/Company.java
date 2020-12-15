package Laboratories.Class_11;

import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Employee> employeeList = new ArrayList();

    public Company(String name) {
        this.name = name;
    }

    public void addEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
    }

    public void increaseGeneralPay(double percentage) {
        for (Employee employee: employeeList) {
            employee.setPercentagePayIncrease(percentage);
        }
    }

    public void increaseSpecialistBonuses(double increase) {
        for (Employee employee: employeeList) {
            if(employee instanceof Specialist) {
                Specialist specialist = (Specialist)employee;
                specialist.increaseBonus(increase);
            }
        }
    }

    public ArrayList<Employee> getEmployeeList() {
        return this.employeeList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", employeeList=" + employeeList.toString() +
                '}';
    }

    public static void main(String[] args) {
        Company appleInc = new Company("Apple");

        Employee somePerson = new Employee("Some", "Person", 1000);
        System.out.println(somePerson);
        assert(somePerson.getPay() == 1000);

        Specialist someOtherPerson = new Specialist("Steve", "Wozniak", 5000, 250);
        System.out.println(someOtherPerson);
        assert(someOtherPerson.getPay() == 5250);
        assert(someOtherPerson.getBonus() == 250);

        appleInc.addEmployee(somePerson);
        appleInc.addEmployee(someOtherPerson);
        System.out.println(appleInc);

        assert(appleInc.getEmployeeList().size() == 2);

        appleInc.increaseGeneralPay(1.1);
        assert(somePerson.getPay() == 1100);
        assert(someOtherPerson.getPay() == 5750);

        appleInc.increaseSpecialistBonuses(250);
        assert(somePerson.getPay() == 1100);
        assert(someOtherPerson.getPay() == 6000);

        System.out.println("After increases: ");
        System.out.println(appleInc);
    }
}

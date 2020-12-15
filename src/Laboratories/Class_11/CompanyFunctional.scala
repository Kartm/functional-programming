package Laboratories.Class_11

class CompanyFunctional(private val name: String) {
  private var employeeList = List[EmployeeFunctional]();

  def addEmployee(newEmployee: EmployeeFunctional): Unit = {
    employeeList = employeeList :+ newEmployee;
  }

  def increaseGeneralPay(percentage: Double): Unit = {
    employeeList = employeeList.map((employee) => employee.setPercentagePayIncrease(percentage));
  }

  def increaseSpecialistBonuses(increase: Double): Unit = {
    employeeList = employeeList.map((employee) => if (employee.isInstanceOf[SpecialistFunctional]) (employee.asInstanceOf[SpecialistFunctional]).increaseBonus(increase) else employee);
  }

  override def toString: String = {
    return s"Company ${name}, employees: " + employeeList.map(employee => employee.toString() + "\n")
  }
}

object Testing extends App {
  val appleInc = new CompanyFunctional("Apple")

  val somePerson = new EmployeeFunctional("Some", "Person", 1000)
  println(somePerson)
  assert(somePerson.getPay == 1000)

  val someOtherPerson = new SpecialistFunctional("Steve", "Wozniak", 5000, 250)
  println(someOtherPerson)
  assert(someOtherPerson.getPay == 5250)
  assert(someOtherPerson.getBonus == 250)

  appleInc.addEmployee(somePerson)
  appleInc.addEmployee(someOtherPerson)
  println(appleInc)

  appleInc.increaseGeneralPay(1.1)
  assert(somePerson.getPay == 1100)
  assert(someOtherPerson.getPay == 5750)

  appleInc.increaseSpecialistBonuses(250)
  assert(somePerson.getPay == 1100)
  assert(someOtherPerson.getPay == 6000)

  println("After increases: ")
  println(appleInc)
}

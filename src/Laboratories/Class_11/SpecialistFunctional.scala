package Laboratories.Class_11

class SpecialistFunctional(private val firstName: String, private val surname: String, private val initialPay: Double, val initialBonus: Double) extends EmployeeFunctional(firstName, surname, initialPay) {
  protected var bonus: Double = initialBonus;

  override def getPay(): Double = super.getPay() + bonus;

  def getBonus(): Double = bonus;

  def increaseBonus(increase: Double): SpecialistFunctional = {
    bonus = bonus + increase;
    return this
  }

  override def toString: String = super.toString + s", specialist with bonus ${bonus}"
}

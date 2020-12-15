package Laboratories.Class_11

class EmployeeFunctional(private val firstName: String, private val surname: String, private val initialPay: Double) {
  protected var pay: Double = initialPay;

  def setPercentagePayIncrease(percentage: Double): EmployeeFunctional = {
    pay = pay * percentage;
    return this;
  }

  def getPay(): Double = pay;

  override def toString: String = s"Employee ${firstName} ${surname} ${pay}"
}

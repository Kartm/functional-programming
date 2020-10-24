package Exercises.List_3_3

object CurriedConvert extends App {
  // Input:	pressure	in	atm	(atmosphere)
  //Outputs:	PSI,	bar,	torr
  //1	atm =	14.6956	psi	=	760	torr	=	101325	Pa	=	1.01325	bar

  def convertTo(atmToPsi: Double)(atmToTorr: Double)(atmToPa: Double)(atmToBar: Double): Double = {
    return atmToPsi * 14.6956 + atmToTorr * 760 + atmToPa * 101325 + atmToBar * 1.01325
  }

  val atmToPsi = convertTo(_: Double)(0)(0)(0)
  val atmToTorr = convertTo(0)(_: Double)(0)(0)
  val atmToPa = convertTo(0)(0)(_: Double)(0)
  val atmToBar = convertTo(0)(0)(0)(_: Double)

  println(s"10 Atm to psi: ${atmToPsi(10)}")
  println(s"10 Atm to torr: ${atmToTorr(10)}")
  println(s"10 Atm to pa: ${atmToPa(10)}")
  println(s"10 Atm to bar: ${atmToBar(10)}")
}

class Equation(val params: Array[Double]) {

  def evaluate(): List[Double] =
    val degree = params.length - leadingZeros(params.toList) - 1

    degree match
      case 1 => eval1()
      case 2 => eval2()
      case _ => throw new Exception("Error, can't evaluate")

  private def eval1():List[Double] =
    val b = params(params.length - 1)
    val a = params(params.length - 2)

    List( (-b) / a )

  private def eval2(): List[Double] =
    val c = params(params.length - 1)
    val b = params(params.length - 2)
    val a = params(params.length - 3)

    val delta = Math.pow(b,2) - 4*a*c

    if delta < 0 then
      throw new Exception("No solutions")
    else if delta == 0 then
      List( (-b) / (2*a) )
    else
      List( ((-b) + Math.sqrt(delta) )/(2*a) , ((-b) - Math.sqrt(delta) )/(2*a) )

  private def leadingZeros(list: List[Double]): Int =
    list match
      case Nil => 0
      case h :: t =>
        if h == 0 then
          1 + leadingZeros(t)
        else
          0
}

val eq1 = new Equation(Array(2, 4)) // 2x + 4 = 0
eq1.evaluate()

val eq2 = new Equation(Array(0, 3, 6)) // 3x + 6 = 0
eq2.evaluate()

val eq3 = new Equation(Array(1, -3, 2)) // x^2 - 3x + 2 = 0
eq3.evaluate()

val eq4 = new Equation(Array(1, -2, 1)) // x^2 - 2x + 1 = 0 (delta = 0)
eq4.evaluate()

val eq5 = new Equation(Array(1, 0, 1)) // x^2 + 1 = 0 (delta < 0)
eq5.evaluate()

val eq6 = new Equation(Array(0, 0, 0)) // Równanie zerowe
eq6.evaluate()

val eq7 = new Equation(Array(0, 0, 0, 1)) // Stopień równania > 2
eq7.evaluate()
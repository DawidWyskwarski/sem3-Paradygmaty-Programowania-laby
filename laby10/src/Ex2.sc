class Rownanie(val params: Array[Double]) {

  def rozwiaz(): Array[Double] =
    if params.length == 0 then
      throw new Exception("Vector of parameters is empty!")
    
    val degree = params.length - leadingZeros(params.toList) - 1

    degree match
      case 1 => eval1()
      case 2 => eval2()
      case -1 => throw new Exception("Infinite number of solutions")
      case 0 => throw new Exception("Contradiction")
      case _ => throw new Exception("Error, can't evaluate an equation with a degree higher than 2")

  private def eval1():Array[Double] =
    val b = params(params.length - 1)
    val a = params(params.length - 2)

    Array( (-b) / a )

  private def eval2(): Array[Double] =
    val c = params(params.length - 1)
    val b = params(params.length - 2)
    val a = params(params.length - 3)

    val delta = Math.pow(b,2) - 4*a*c

    if delta < 0 then
      throw new Exception("No solutions")
    else if delta == 0 then
      Array( (-b) / (2*a) )
    else
      Array( ((-b) + Math.sqrt(delta) )/(2*a) , ((-b) - Math.sqrt(delta) )/(2*a) )

  private def leadingZeros(list: List[Double]): Int =
    list match
      case Nil => 0
      case h :: t =>
        if h == 0 then
          1 + leadingZeros(t)
        else
          0
}

println("Empty -> Error")
val t1 = new Rownanie(Array())
t1.rozwiaz()

println("0=0 -> inf")
val t2 = new Rownanie(Array(0,0,0,0))
t2.rozwiaz()

println("4x+3=0 -> -3/4")
val t3 = new Rownanie(Array(4,3))
t3.rozwiaz()

println("4x+3=0 -> -3/4")
val t4 = new Rownanie(Array(0,0,4,3))
t4.rozwiaz()

println("x^2+2x+1=0 -> -1")
val t5 = new Rownanie(Array(1,2,1))
t5.rozwiaz()

println("x^2+2x+1=0 -> -1")
val t6 = new Rownanie(Array(0,0,0,1,2,1))
t6.rozwiaz()

println("x^3 = 0 -> Error")
val t7 = new Rownanie(Array(1,0,0,0))
t7.rozwiaz()

println("3x^2 + 6x + 9 = 0 -> No Real Solutions")
val t8 = new Rownanie(Array(3,6,9))
t8.rozwiaz()

println("3x^2 - 9 = 0 -> +-sqrt(3)")
val t9 = new Rownanie(Array(3,0,-9))
t9.rozwiaz()


println("2 = 0 -> Error")
val t10 = new Rownanie(Array(0,0,2))
t10.rozwiaz()
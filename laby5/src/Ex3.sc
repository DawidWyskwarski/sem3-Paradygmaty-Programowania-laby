val dx = 0.0000001

def derComp(f:Double=>Double,g:Double=>Double): Double=>Double =
  val der = (fun:Double=>Double) => (x:Double) =>
    (fun(x + dx) - fun(x))/dx

  val derF = der(f)
  val derG = der(g)

  derG.compose(derF)

val f = (x:Double) => math.cos(x)
val g = (x:Double) => math.sin(x)

derComp(f,g)(0)
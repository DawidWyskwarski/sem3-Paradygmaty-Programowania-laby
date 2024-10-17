def triArea(a:Double, b:Double, c:Double): Double =

  if a<=0 || b<=0 || c<=0 then
    throw new Exception("a,b or c is <= 0")
  else
    if math.abs(b-c) < a && b+c > a then
      val p = (a + b + c) / 2
      math.sqrt(p * (p - a) * (p - b) * (p - c))

    else
      throw new Exception("nie mozna utwozyc trojkata")


triArea(3, 4, 5)
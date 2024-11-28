import scala.annotation.tailrec

def calcConstEul(epsilon:Double): Double =
  if epsilon <= 0 then
    throw new Exception("Illegal value")
  else
    @tailrec
    def calcRec(prev:Double, cur:Double, i:Int):Double =
      if ((cur - Math.log(i)) - (prev - Math.log(i-1))).abs <= epsilon then
        cur - Math.log(i)
      else
        calcRec(cur,cur + (1.0/(i+1)) ,i+1)

    calcRec(0,1,1)


calcConstEul(0.00000001)
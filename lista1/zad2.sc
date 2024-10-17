import scala.annotation.tailrec

def sum(n:Int, x:Double): Double=
  @tailrec
  def sum1(n:Int, x:Double, i:Int, nominator:Double, denominator:Double, s:Double): Double=
    if i <= n then 
      sum1(n,x,i+1,(-1)*nominator * x,denominator*(i+1),s+(nominator/denominator))
    else 
      s
  
  sum1(n,x,1,-1*x,1,0)

sum(5,3)
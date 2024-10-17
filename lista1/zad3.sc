import scala.annotation.tailrec

def moreThanR(r:Double): Int=
  @tailrec
  def more1(r:Double, i:Int): Int = 
    if r>=0 then 
      more1(r - (1/i.asInstanceOf[Double]), i+1)
    else 
      i-1
  
  more1(r,1)

moreThanR(10)
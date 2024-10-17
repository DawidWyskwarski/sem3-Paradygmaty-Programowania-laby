import scala.annotation.tailrec

def min(a:List[Double]): Double =
  if a.isEmpty then
    throw new Exception("List is Empty")
  else
    @tailrec
    def min1(a:List[Double], minVal:Double): Double =
      if a.isEmpty then
        minVal
      else if a.head < minVal then
        min1(a.tail,a.head)
      else 
        min1(a.tail,minVal)
    min1(a.tail,a.head)    
        
min(List(1,2,3,4,0,-9))
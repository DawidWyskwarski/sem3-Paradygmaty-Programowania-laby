import scala.annotation.tailrec

def power(x:Double, n:Int): Double =
  if n==0 then
    1
  else
    x*power(x,n-1)

def f(a:Double, x:Double, n:Int): Double =
    a - power(x,n)

def nthRoot(a:Double, n:Int, epsilon:Double):Double=
    if n<=0 then
        throw new Exception("illegal value of n")
    else
        @tailrec
        def binarySearch(left:Double, right:Double, epsilon:Double, a:Double, n:Int):Double=
            val middle = (left+right)/2

            if f(a,middle,n) == 0 then
                middle
            else if ( f(a,right,n) - f(a,left,n) ).abs < epsilon then
                middle
            else if( f(a,middle,n) > 0 ) then
                binarySearch(middle,right,epsilon,a,n)
            else
                binarySearch(left,middle,epsilon,a,n)

        if(a == 1) then
            1
        else if a < 1 then
            binarySearch(0,1,epsilon,a,n)
        else
            binarySearch(1,a,epsilon,a,n)


nthRoot(4,3,0.0000001)
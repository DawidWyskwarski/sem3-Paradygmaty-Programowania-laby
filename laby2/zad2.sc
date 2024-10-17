import scala.annotation.tailrec

def ex2(a:List[Int]): Boolean =
  if a == List() then
    throw new Exception("Pusta lista")
  else
    @tailrec
    def check(prev:Int, a:List[Int]): Boolean=
      if a == List() then true
      else if (prev < a.head) then false
      else check(a.head,a.tail)

    check(a.head,a.tail)

ex2(List(3,2,1))
ex2(List(3,4,1))
ex2(List(3,3,3))
ex2(List(1))


import scala.annotation.tailrec

def listSplit(a: List[Int]): List[List[Int]] =
  @tailrec
  def listSplit1(a: List[Int], negative: List[Int], positive: List[Int]): List[List[Int]] =
    if a.isEmpty then
      List(negative, positive)
    else
      if a.head < 0 then
        listSplit1(a.tail, negative.appended(a.head), positive)
      else
        listSplit1(a.tail, negative, positive.appended(a.head))

  listSplit1(a, List(), List())


listSplit( List(1,2,3,5,-9,-7,-34,0,0,0) )

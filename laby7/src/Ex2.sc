import scala.annotation.tailrec

def compMany(functions:List[Double=>Double]): Double=>Double =
  @tailrec
  def compRec(list:List[Double=>Double], result: Double=>Double): Double=>Double =
    list match
      case Nil => result
      case h::t => compRec(t,h.compose(result))

  functions match
    case Nil => throw new Exception("Empty List")
    case h::t => compRec(t,h)

def compManyFold(functions:List[Double=>Double]): Double=>Double =
  functions match
    case Nil => throw new Exception("Empty List")
    case h::t => t.foldLeft(h)((acc,f) => f.compose(acc))

val f1 = (x:Double) => 2*x
val f2 = (x:Double) => x*x
val f3 = (x:Double) => x+1

compMany(List(f1,f2,f3))(5)
compManyFold(List(f1,f2,f3))(5)
import scala.annotation.tailrec

def multiplyList[A](list: List[A]): List[A]=
  if list.isEmpty then
    List()
  else
    @tailrec
    def doTheThing[Any](resultList:List[A], list:List[A], multiply:Int, index:Int): List[A]=
      if list.isEmpty then
        resultList.reverse
      else if multiply > 0 then
        doTheThing(list.head :: resultList, list, multiply-1, index)
      else
        doTheThing(resultList, list.tail, index+1, index+1)

    doTheThing(List(),list,1,1)

def multiplyListMatchCase[A](list: List[A]): List[A]= list match {
    case Nil => List()
    case _ =>
        def doTheThing1[Any](resultList:List[A], list:List[A], multiply:Int, index:Int): List[A]= list match {
            case Nil => resultList.reverse
            case head :: tail if multiply > 0 => doTheThing1(head :: resultList, list, multiply - 1, index)
            case head :: tail => doTheThing1(resultList, tail, index + 1, index + 1)
        }
        doTheThing1(List(),list,1,1)
}




multiplyList(List(1,2,3,4))
multiplyListMatchCase(List(1,2,3,4))
multiplyList(List())
multiplyListMatchCase(List())
multiplyList(List("a","b","c","d"))
multiplyListMatchCase(List("a","b","c","d"))

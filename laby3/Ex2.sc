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

multiplyList(List(1,2,3,4))
multiplyList(List())
multiplyList(List("a","b","c","d"))

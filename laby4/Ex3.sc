import scala.annotation.tailrec

def listCutter(list:List[Int], n:Int): List[Int] = (list,n) match{
  case (Nil,_) => List()
  case (_,x) if x < 0 || x > (list.length/2) => throw new Exception("illegal value of n")
  case (_,x) if x == (list.length+1/2) => List()
  case (_,_) =>
    @tailrec
    def cut(resultList:List[Int], list:List[Int], startCut:Int, endCut:Int): List[Int] = (list,startCut,endCut) match{
      case (head::tail,x,_) if x>0 => cut(resultList,tail,startCut - 1, endCut-1)
      case (head::tail,_,y) if y>0 => cut(head :: resultList, tail, startCut,endCut-1)
      case (_,_,_) => resultList.reverse
    }

    cut(List(),list,n,list.length-n)
}

listCutter(List(1,2,3,4,5,6,7,8,9,10,11),3)
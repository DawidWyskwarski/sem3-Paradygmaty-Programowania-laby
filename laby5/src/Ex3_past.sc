def insert(list:List[Int], newEl:Int): List[Int] =
  def insRec(list:List[Int], newEl:Int, result:List[Int]): List[Int] =
    list match
      case Nil => (newEl :: result).reverse
      case head::tail => if head > newEl then (head::newEl::result).reverse ++ tail else insRec(tail,newEl,head :: result)
  insRec(list,newEl,List())


insert(List(1,2,3,5,6,7), 2)


def insertSort(list:List[Int]):List[Int]=
  def insSorRec(list:List[Int], result:List[Int]):List[Int]=
    list match
      case Nil => result
      case head::tail => insSorRec(tail,insert(result,head))
  insSorRec(list,List())
  
insertSort(List(9,8,7,6,5,4,7,6,5,8,7,1,2,3,5,4,0))  
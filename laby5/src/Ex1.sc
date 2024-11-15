import scala.annotation.tailrec

def findMinMaxes(xs:List[List[Int]]): List[Tuple] =
  @tailrec
  def goThrough(xs:List[List[Int]], result:List[Tuple]): List[Tuple] = xs match
    case Nil => result
    case head::tail =>
      @tailrec
      def findIt(xs:List[Int], min:Int, max:Int):Tuple = xs match
        case Nil => (min,max)
        case head::tail => findIt(tail,head.min(min),head.max(max))
        
      goThrough(xs.tail,findIt(head.tail,head.head,head.head)::result)
    goThrough(xs,List()).reverse   
    
findMinMaxes(List(List(-2,-10,4,5),List(12,5,46,2),List(-125,5,2)))

def minMaxFunctional(listOfLists: List[List[Int]]): List[(Int, Int)] = {
  listOfLists.map { lst =>
    lst.foldLeft (Int.MaxValue, Int.MinValue) {
      case ((min, max), elem) => (math.min(min, elem), math.max(max, elem))
    }
  }
}

minMaxFunctional(List(List(-111,2,3,4,5,-9), List(7,8,9,10,11),List(11,12,12,13,0)))

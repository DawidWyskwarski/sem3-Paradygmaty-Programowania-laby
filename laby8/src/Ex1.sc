sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[A](value:A,left:BT[A],right:BT[A]) extends BT[A]

def transformTree(tree:BT[ List[Double] ]):BT[Double] =
  tree match
    case Empty => Empty
    case Node(value,left,right) => Node(value.sum,transformTree(left), transformTree(right))
    
val tree:BT[List[Double]] = Node(List(1,2,3,4,5),Node(List(5,6,7,8),Empty,Empty),Node(List(),Empty,Node(List(6,5,19,42),Empty,Empty)))

transformTree(tree)
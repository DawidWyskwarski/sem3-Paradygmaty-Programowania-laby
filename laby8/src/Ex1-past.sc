sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[A](value:A, left:BT[A], right:BT[A]) extends BT[A]

def transformSum(tree:BT[ List[Double] ]): BT[Double] =
  tree match
    case Empty => Empty
    case Node(value,left,right) => Node(value.sum, transformSum(left), transformSum(right))

val tree:BT[List[Double]] = Node(List(1,2,3,4,5),Empty,Node(List(1,6,21),Empty,Node(List(412,43),Empty,Empty)))

transformSum(tree)
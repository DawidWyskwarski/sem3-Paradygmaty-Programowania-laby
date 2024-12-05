case class Node[A](value: A, children: List[Node[A]])

sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Kid[A](value:A,left:BT[A],right:BT[A]) extends BT[A]

def graphToBinary[A](graph:Node[A]):BT[A] =
  graph match
    case Node(value, Nil) => Kid(value,Empty,Empty)
    case Node(value, x::y::_) => Kid(value,graphToBinary(x), graphToBinary(y))
    case Node(value, x::_) => Kid(value, graphToBinary(x),Empty)


val graph:Node[Int] = Node(1, List(Node(2,List(Node(1,Nil),Node(3,Nil),Node(4,Nil))),Node(4,Nil),Node(52132,Nil)))

graphToBinary(graph)


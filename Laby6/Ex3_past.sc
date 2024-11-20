sealed trait BT[+A]
case class Value[+A](elem:A) extends BT[A]
case class Node[+A](left:BT[A],right:BT[A]) extends BT[A]
case object Empty extends BT[Nothing]

val tree: BT[Int] = Node(
                      Node(
                        Node(Value(2),Value(1)),
                        Node(Empty,Value(4))
                      ),
                      Value(3)
                    )


def exists[A](tree:BT[A], condition:A=>Boolean): Boolean =
  tree match
    case Empty => false
    case Value(elem) => condition(elem)
    case Node(left,right) => exists(left,condition) || exists(right,condition)

exists(tree, _>3)
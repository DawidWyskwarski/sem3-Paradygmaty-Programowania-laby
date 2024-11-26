sealed trait Tree[+A]
case class Value[+A](elem:A) extends Tree[A]
case class NodeLR[+A](left:Tree[A], right:Tree[A]) extends Tree[A]
case class NodeC[+A](center:Tree[A]) extends Tree[A]

sealed trait SP[+A]
case class P[+A](data:(String,A) ) extends SP[A]
case class S(data:String) extends SP

def TreeToListPost(tree:Tree[Any]): List[SP[Any]] =
  tree match
    case Value(elem) => List( P("Dana",elem) )
    case NodeLR(left,right) =>
      val data = (left,right) match
        case (Value(_),Value(_)) => "Wezel (element,element)"
        case (_,Value(_)) => "Wezel (lewo,element)"
        case (Value(_),_) => "Wezel (element,prwao)"
        case _ => "Wezel (lewo,prawo)"
      TreeToListPost(left) ++ TreeToListPost(right) ++ List(S(data))
    case NodeC(center) =>
      val data = center match
        case Value(_) => "Wezel (element)"
        case _ => "Wezel (center)"
      TreeToListPost(center) ++ List(S(data))

val tree: Tree[Int] = NodeLR(NodeLR(NodeLR(Value(2),Value(1)), NodeC(Value(4)) ), Value(3) )

TreeToListPost(tree)
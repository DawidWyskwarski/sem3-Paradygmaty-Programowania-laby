sealed trait Tree[+A]
case class Value[+A](elem:A) extends Tree[A]
case class Node2[+A](left:Tree[A],right:Tree[A]) extends Tree[A]
case class Node1[+A](center:Tree[A]) extends Tree[A]
case object Empty extends Tree[Nothing]


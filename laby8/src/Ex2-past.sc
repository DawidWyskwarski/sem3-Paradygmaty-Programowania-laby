import scala.collection.mutable

case class Node[T](value: T, children: List[Node[T]])

def hasDuplicateValues[T](root: Node[T]): Boolean =

  val seen:mutable.Set[T] = mutable.Set()

  def dfs(node: Node[T]): Boolean =
    if seen(node.value) then
      true
    else
      seen.add(node.value)
      node.children.exists(child => dfs(child))

  dfs(root)

val tree = Node(1,
  List(
    Node(3,
      List(
        Node(2, Nil),
        Node(4, Nil))),
    Node(5,
      List(
        Node(6, Nil))),
    Node(2, Nil)
))

hasDuplicateValues(tree)
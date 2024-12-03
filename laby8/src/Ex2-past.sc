//Doesn't work and don't know why

case class Node[T](value: T, children: List[Node[T]])

def hasDuplicateValues[T](root: Node[T]): Boolean =
  def dfs(node: Node[T], seen: Set[T]): Boolean =
    if seen.contains(node.value) then
      true
    else {
      val newSeen = seen + node.value
      node.children.exists(child => dfs(child, newSeen))
    }
  dfs(root, Set())

val tree = Node(1, List(
  Node(3, List(Node(2, Nil), Node(1, Nil))),
  Node(5, List(Node(6, Nil))),
  Node(13, Nil)
))

hasDuplicateValues(tree)
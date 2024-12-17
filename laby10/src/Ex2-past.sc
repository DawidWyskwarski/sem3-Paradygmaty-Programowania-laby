import scala.annotation.tailrec

def transArrayF(array:Array[Array[Int]]):Array[Int] =
  @tailrec
  def transRec(result:List[Int], index:Int):Array[Int] =
    if index < array.length then
      transRec( array(index).sum :: result, index+1)
    else
      result.reverse.toArray()

  transRec(List(),0)

def transArrayI(array:Array[Array[Int]]):Array[Int] =
  var i = 0
  val result = new Array[Int](array.length)

  while i < array.length do
    result(i) = array(i).sum
    i = i + 1
  
  result
  
  
    

transArrayF(Array(Array(1,2,3,4,5),Array(1,2,3,4,5),Array(1,2,3,3,1,4),Array(1,2,331,23,1) ))
transArrayI(Array(Array(1,2,3,4,5),Array(1,2,3,4,5),Array(1,2,3,3,1,4),Array(1,2,331,23,1) ))
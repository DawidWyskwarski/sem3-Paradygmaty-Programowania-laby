import scala.annotation.tailrec

def transArrayF(array:Array[Array[Int]]):Array[Int] =
  @tailrec
  def transRec(result:List[Int], index:Int):Array[Int] =
    if index < array.length then
      transRec( array(index).min :: result, index+1)
    else
      result.reverse.toArray()

  transRec(List(),0)

def transArrayI(array:Array[Array[Int]]):Array[Int] =
  val result = new Array[Int](array.length)

  for i<-0 until array.length do
    result(i) = array(i)(0)
    for j<-1 until array(i).length do
      if result(i) > array(i)(j) then
        result(i) = array(i)(j)

  result


transArrayF(Array(Array(1,2,3,5),Array(2,0,1,-5),Array(23,11,51,63) ))
transArrayI(Array(Array(1,2,3,5),Array(2,0,1,-5),Array(23,11,51,63) ))

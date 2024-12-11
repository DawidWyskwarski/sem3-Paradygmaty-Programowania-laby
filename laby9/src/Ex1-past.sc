def lRepeat(list:LazyList[Int]):LazyList[Int] =
  def lRep(list:LazyList[Int],index:Int):LazyList[Int] =

    if list.isEmpty then
      LazyList()
    else
      def repeat(elem:Int,count:Int):LazyList[Int] =
        if count < index then
          elem #:: repeat(list.head*elem,count+1)
        else
          LazyList()

      repeat(list.head,0) #::: lRep(list.tail,index+1)

  lRep(list,1)

lRepeat(LazyList.from(1)).take(14).toList

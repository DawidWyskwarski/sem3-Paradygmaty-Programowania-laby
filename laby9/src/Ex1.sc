def repF[A](list:LazyList[A], f: Int => Int): LazyList[A] =
  def repf(list:LazyList[A],index:Int):LazyList[A] =
    def repeat(elem:A,count:Int):LazyList[A] =
      if count < f(index) then
        elem #:: repeat(elem,count+1)
      else 
        LazyList()
        
    list match
      case LazyList() => LazyList()
      case lHead #:: lTail => repeat(lHead,0) #::: repf(lTail,index+1)
  
  repf(list,1)
  
val f = (x:Int) => 2*x-5

repF(LazyList.from(1),f).take(18).toList
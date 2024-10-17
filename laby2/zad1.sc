def exA(p:(Int, Int)): (Int,Int) =
  val x1 = p._1 + p._2
  val y1 = p._1 - p._2
  (x1,y1)

exA(1,1)

def exB(p:(Float, Float)): Boolean =
  val result = p._1 - p._2
  if result >=0 then
    true
  else false

exB(3.0f,2.9f)
exB(3.0f,3.1f)

def exC[A](p:(List[A],Int)): List[A]=
  if  p._2==0 && p._1 == List() then
    p._1
  else p._1

exC(List("a","b","c"),0)
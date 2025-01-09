object Ptak {
  private var curId = -1

  def generateId():Int =
    curId += 1
    curId
}
abstract class Ptak(val id:Int, val name:String) {
  println("I come from the Dinosaurs!")
}

trait Plywa {
  def plywanieInfo:String = "Plywam"
}
trait Nurkuje {
  def nukrowanieInfo:String = "Nurkuje"
}
trait Lata {
  def poziom:String
  def latanieInfo:String = "Latam " + poziom
}
trait Biega {
  def poziom:String
  def bieganieInfo:String = "Biegam " + poziom
}

class Pingwin extends Ptak(Ptak.generateId(), "Pingwin") with Plywa with Nurkuje
class Golab extends Ptak(Ptak.generateId(), "Goląb") with Lata with Plywa{
  override def poziom: String = "dobrze"
}
class Strus extends Ptak(Ptak.generateId(), "Struś") with Biega{
  override def poziom: String = "świetnie"
}
class Sokol extends Ptak(Ptak.generateId(), "Sokól") with Lata{
  override def poziom: String = "znakomicie"
}
class Kura extends Ptak(Ptak.generateId(), "Kura") with Lata with Biega{
  override def poziom: String = "Slabo"
}

val ptaki = List(new Pingwin, new Golab, new Strus, new Sokol, new Kura, new Pingwin, new Golab, new Strus)

val latajace = ptaki.collect {case x:Lata => x}
val nurkuje = ptaki.collect {case x:Nurkuje => x}
val plywajace = ptaki.collect {case x:Plywa => x}
val biegajace = ptaki.collect {case x:Biega => x}

def wyswietlPtaki(p:List[Ptak]): Unit =
  p.foreach(ptak =>
    println(s"Ptak nr ${ptak.id} - ${ptak.name}")

    ptak match
      case x:Lata => println(x.latanieInfo)
      case x:Nurkuje => println(x.nukrowanieInfo)
      case x:Plywa => println(x.plywanieInfo)
      case x:Biega => println(x.bieganieInfo)
  )

println("Latajace")
wyswietlPtaki(latajace)

println("Nurkujace")
wyswietlPtaki(nurkuje)

println("Plywajace")
wyswietlPtaki(plywajace)

println("Biegajace")
wyswietlPtaki(biegajace)

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
/*
* trait Ptak {
  val id: Int
  val gatunek: String
  println("Pochodzę od dinozaurów!!!")
}

trait Pływanie {
  def pływam(): String = "Pływam"
}

trait Latanie {
  val stopieńLatania: String
  def latam(): String = s"Latam $stopieńLatania"
}

trait Nurkowanie {
  def nurkuję(): String = "Nurkuję"
}

trait Bieganie {
  val stopieńBiegania: String
  def biegam(): String = s"Biegam $stopieńBiegania"
}

// Klasy ptaków
class Pingwin(val id: Int) extends Ptak with Pływanie with Nurkowanie {
  val gatunek: String = "Pingwin"
}

class Gołąb(val id: Int) extends Ptak with Pływanie with Latanie with Bieganie {
  val gatunek: String = "Gołąb"
  val stopieńLatania: String = "dobrze"
  val stopieńBiegania: String = "słabo"
}

class Struś(val id: Int) extends Ptak with Bieganie {
  val gatunek: String = "Struś"
  val stopieńBiegania: String = "świetnie"
}

class Sokół(val id: Int) extends Ptak with Latanie {
  val gatunek: String = "Sokół"
  val stopieńLatania: String = "znakomicie"
}

class Kura(val id: Int) extends Ptak with Latanie with Bieganie {
  val gatunek: String = "Kura"
  val stopieńLatania: String = "słabo"
  val stopieńBiegania: String = "dobrze"
}

// Tworzenie ptaków
val ptaki = List(
  new Pingwin(1),
  new Gołąb(2),
  new Struś(3),
  new Sokół(4),
  new Kura(5),
  new Pingwin(6),
  new Gołąb(7),
  new Struś(8)
)

// Tworzenie list na podstawie cech
val ptakiPływające = ptaki.collect { case p: Pływanie => p }
val ptakiLatające = ptaki.collect { case p: Latanie => p }
val ptakiNurkujące = ptaki.collect { case p: Nurkowanie => p }
val ptakiBiegające = ptaki.collect { case p: Bieganie => p }

// Wyświetlanie danych
println("Ptaki pływające:")
ptakiPływające.foreach(p => println(s"Ptak nr ${p.id} - ${p.gatunek}\n${p.pływam()}"))

println("\nPtaki latające:")
ptakiLatające.foreach(p => println(s"Ptak nr ${p.id} - ${p.gatunek}\n${p.latam()}"))

println("\nPtaki nurkujące:")
ptakiNurkujące.foreach(p => println(s"Ptak nr ${p.id} - ${p.gatunek}\n${p.nurkuję()}"))

println("\nPtaki biegające:")
ptakiBiegające.foreach(p => println(s"Ptak nr ${p.id} - ${p.gatunek}\n${p.biegam()}"))
* */
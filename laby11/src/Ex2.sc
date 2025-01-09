object Ptak {
  var id:Int = 0

  def wygenerujId():Int =
    id+=1
    id
}
abstract class Ptak(val gatunek:String) {
  val id:Int = Ptak.wygenerujId()
  println("Pochodzę od dinozaurów!!")
}

trait Plywanie {
  def plywam():String = "Plywam"
}

trait Nurkowanie {
  def nurkowanie():String = "Nurkuje"
}

trait Latanie(val poziomLatania:String) {
  def latanie():String = s"Latam ${poziomLatania}"
}

trait Bieganie(val poziomBiegania:String) {
  def bieganie():String = s"Biegam ${poziomBiegania}"
}

class Pingwin extends Ptak("Pingwin") with Plywanie with Nurkowanie
class Golab extends Ptak("Goląb") with Latanie("dobrze") with Plywanie with Bieganie("slabo")
class Strus extends Ptak("Struś") with Bieganie("świetnie")
class Sokol extends Ptak("Sokól") with Latanie("znakomicie")
class Kura extends Ptak("Kura") with Latanie("slabo") with Bieganie("dobrze")

val ptaki = List(new Pingwin, new Golab, new Strus, new Sokol, new Kura, new Pingwin, new Golab, new Strus)

val latajace = ptaki.collect{case x:Latanie => x}

val plywajace = ptaki.collect{case x:Plywanie => x}

val nurkujace = ptaki.collect{case x:Nurkowanie => x}

val biegajace = ptaki.collect{case x:Bieganie => x}

latajace.foreach(x => println(s"Ptak nr ${x.id} - ${x.gatunek}\n ${x.latanie()}"))

plywajace.foreach(x => println(s"Ptak nr ${x.id} - ${x.gatunek}\n ${x.plywam()}"))

nurkujace.foreach(x => println(s"Ptak nr ${x.id} - ${x.gatunek}\n ${x.nurkowanie()}"))

biegajace.foreach(x => println(s"Ptak nr ${x.id} - ${x.gatunek}\n ${x.bieganie()}"))
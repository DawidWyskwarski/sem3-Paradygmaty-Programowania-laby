object Obora {
  var id:Int = 0
  
  def generateId():Int =
    id+=1
    id
}

class Zwierzak(val gatunek:String, val imie:String, val rokUrodzenia:Int) {
  override def toString:String = s"Gatunek: $gatunek, imie: $imie, rokUrodzenia: $rokUrodzenia"
}

class Obora(val wlasciciel:String, val liczbaBoxow:Int) {
  val id:Int = Obora.generateId()
  var listaZwierzat:List[Zwierzak] = Nil
  
  def kwaterowanie(zwierz:Zwierzak):Unit =
    if listaZwierzat.length == liczbaBoxow then
      throw new Exception("Obora jest pelna!")
    
    listaZwierzat = listaZwierzat.appended(zwierz)
    
  def wykwaterowanie(zwierzImie:String):Zwierzak =
    if !listaZwierzat.exists(x => x.imie == zwierzImie) then
      throw new Exception("Nie ma takiego zwierzaka w oborze!")

    val zwierz: Zwierzak = listaZwierzat.find(x => x.imie == zwierzImie).get
    listaZwierzat = listaZwierzat.filter(x => x.imie != zwierzImie)
    zwierz
  
  def wyswietleZwierzeta():Unit =
    listaZwierzat.foreach(x => println(x))
    
  def przenies(obora: Obora, imieZierzaka:String):Unit =
    if listaZwierzat.length == liczbaBoxow then
      throw new Exception("Obora jest pelna!")
    
    kwaterowanie(obora.wykwaterowanie(imieZierzaka))
}

var obora1 = new Obora("Ja",3)
var obora2 = new Obora("Ty",1)

obora1.kwaterowanie(new Zwierzak("Koń","BoJack",1970))
obora1.kwaterowanie(new Zwierzak("Świnia","Piglet",1920))
obora1.kwaterowanie(new Zwierzak("Kaczka","Donald",1960))

obora1.kwaterowanie(new Zwierzak("Pies","Peter",1999))

//obora2.kwaterowanie(new Zwierzak("Kot","kot",2022))

obora1.wyswietleZwierzeta()

obora1.wykwaterowanie("Piglet")

obora1.wyswietleZwierzeta()

obora2.przenies(obora1,"BoJack")
obora1.wyswietleZwierzeta()

obora2.wyswietleZwierzeta()


sealed trait Plec
case object Kobieta extends Plec
case object Mezczyzna extends Plec


type Osoba = (String,String)

def okreslPlec(osoba :Osoba): Plec =
  osoba match
    case ("",_) => throw new Exception()
    case (imie,_) => if imie.toLowerCase.last == 'a' then Kobieta else Mezczyzna

okreslPlec(("alicja","kolega"))
object Ptak:
  private var ostatniNr = -1

abstract class Ptak(latanie: Int, plywanie: Int, nurkowanie: Int, bieganie: Int):
  import Ptak.ostatniNr

  println("Pochodze od dinozaurow!")

  val nrEwidencyjny =
    ostatniNr += 1
    ostatniNr

  private def OkreslStopienZnajomosci(stopien: Int): String=
    if stopien >= 8 then
      "Znakomicie"
    else if stopien >= 6 then
      "Dobrze"
    else if stopien >= 4 then
      "Przecietnie"
    else if stopien >= 2 then
      "Slabo"
    else
      "Bardzo slabo"

  def Dane(): String=
    var output = "Ptak nr " + nrEwidencyjny + " - " + this.getClass.getSimpleName()

    if plywanie > 0 then
      output += "\nPlywanie: " + OkreslStopienZnajomosci(plywanie)
    if latanie > 0 then
      output += "\nLatanie: " + OkreslStopienZnajomosci(latanie)
    if nurkowanie > 0 then
      output += "\nNurkowanie: " + OkreslStopienZnajomosci(nurkowanie)
    if bieganie > 0 then
      output += "\nBieganie: " + OkreslStopienZnajomosci(bieganie)
    output += '\n'
    output

class Pingwin extends Ptak(-1, 8, 8, 3)

class Sowa extends Ptak(6, -1, -1, 2)

class Sokol extends  Ptak(9, 1, -1, 4)


val lst = List(Pingwin(), Sowa(), Sokol())

for(pt <- lst)
  println(pt.Dane())

object Cowshed {
  private var currId: Int = 0;

  def generateId():Int =
    currId += 1
    currId
}

class Animal(val breed:String, val name:String,val birthYear:Int) {

  override def equals(obj: Any): Boolean = obj match {
    case animal: Animal =>
      animal.breed == breed &&
      animal.name == name &&
      animal.birthYear == birthYear
    case _ => false
  }

  override def toString:String =
    "Breed: " + breed + " Name: " + name + " Birth Year: " + birthYear
}

class Cowshed(val owner:String, boxesNumber:Int) {

  var animalList: List[Animal] = Nil
  val id: Int = Cowshed.generateId()

  def addAnimal(animal: Animal): Unit =
    if animalList.length == boxesNumber then
      throw new Exception("The Cowshed is full, sorry!")

    animalList = animalList.appended(animal)

  def removeAnimal(animal: Animal): Unit =
    if animalList.isEmpty then
      throw new Exception("The Cowshed is empty!")
    else if !animalList.contains(animal) then
      throw new Exception("This animal isn't in this cowshed!")

    animalList = animalList.filter(x => !x.equals(animal) )

  def animals(): String =
    if animalList == Nil then
      throw new Exception("The cowshed is empty!")
    else animalList.foldLeft("")((x,animal) => x + animal.toString + "\n")
}

var cowshed1 = new Cowshed("JA",3)
cowshed1.addAnimal(new Animal("Horse","BoJack",1970))
cowshed1.addAnimal(new Animal("Pig","Piglet",1920))
cowshed1.addAnimal(new Animal("Duck","Donald",1960))

println( cowshed1.animals() )

cowshed1.removeAnimal(new Animal("Horse","BoJack",1970))

cowshed1.animals()
cowshed1.id
var cowshed2 = new Cowshed("TY",4)

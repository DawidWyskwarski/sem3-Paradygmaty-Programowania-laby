type Samochod = (String,String,Int)

type Samochody = List[Samochod]

val samochody:Samochody = List(
  ("Opel", "astra", 1999),
  ("Renault", "megane", 2004),
  ("Opel", "corsa", 2009),
  ("Nissan", "micra", 2004),
  ("Nissan", "micra", 2004),
  ("Nissan", "micra", 2004),
  ("Nissan", "micra", 2004),
  ("Nissan", "micra", 2004),
  ("Nissan", "micra", 2004),
  ("Nissan", "micra", 2004)
)

def countElem(cars:Samochody): List[(String,Int)] =
  cars.foldLeft( Map.empty[String,Int] ){ (acc, car)=>
    val marka = car._1
    
    acc.updated(marka, acc.getOrElse(marka,0)+1)
  }.toList
  
countElem(samochody)  
val workiNaBochenek: Double = 0.25

class Piekarnia() {
  var workiMaki: Double = 1
  var liczbaChlebow: Int = 0

  var sumachlebow: Int = 0

  def dostawaMaki(liczbaWorkow: Int): Unit = synchronized {
    while (workiMaki > 0) {
      if stop() then
        return;
      wait()
    }

    workiMaki += liczbaWorkow
    println(s"Dostarczono ${liczbaWorkow} worki\nObecny stan magazynu to ${workiMaki} worków")
    notifyAll()
  }

  def wypiekanie(): Unit = synchronized {
    while (workiMaki < workiNaBochenek) {
      println("Niewystarczająca ilość mąki")
      wait()
    }

    liczbaChlebow += 1

    sumachlebow+=1

    workiMaki -= workiNaBochenek
    println(s"Wypieczono chleb, stan magazynu: ${liczbaChlebow} chlebów, mąka: ${workiMaki}")
    Thread.sleep(100)

    if(workiMaki < workiNaBochenek){
      notifyAll()
    }
  }

  def odbior(): Unit = synchronized {
    while (workiMaki > 0) {
      if stop() then
        return;

      wait()
    }

    if(liczbaChlebow > 0){
      println(s"Odebrano ${liczbaChlebow} chlebów")
      liczbaChlebow = 0
      notifyAll()
    }
  }

  def stop():Boolean = synchronized {
    sumachlebow > 30
  }
}

class Piekarz(piekarnia: Piekarnia) extends Thread {
  override def run(): Unit = {
    while ( !piekarnia.stop() ) {
      piekarnia.wypiekanie()
      Thread.sleep(100)
    }

    println("Piekarnia kończy pracę")
  }
}

class Odbiorca(piekarnia: Piekarnia) extends Thread {
  override def run(): Unit = {
    while ( !piekarnia.stop() ) {
      piekarnia.odbior()
      Thread.sleep(10)
    }
  }
}

class Dostawca(piekarnia: Piekarnia) extends Thread {
  override def run(): Unit = {
    while ( !piekarnia.stop() ) {
      piekarnia.dostawaMaki(3)
      Thread.sleep(10000)
    }
  }
}

object Transakcje {
  def main(args: Array[String]): Unit = {
    val piekarnia = new Piekarnia
    val piekarz = new Piekarz(piekarnia)
    val dostawca = new Dostawca(piekarnia)
    val odbiorca = new Odbiorca(piekarnia)

    piekarz.start()
    dostawca.start()
    odbiorca.start()
  }
}

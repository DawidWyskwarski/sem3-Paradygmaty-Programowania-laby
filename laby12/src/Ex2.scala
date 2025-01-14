class Bufferer {
  private var isNew = false
  private var element = 0.0
  @volatile private var _stop = false

  def put(elem: Double): Unit = synchronized {
    while(isNew && !_stop) wait()

    isNew = true
    element = elem
    notifyAll()
  }

  def take():Double = synchronized {
    while(!isNew) wait()

    isNew = false
    notifyAll()
    element
  }

  def stop = _stop
  def break = synchronized {
    _stop = true
    notifyAll()
  }

}

class SingleElement(buffer: Bufferer) extends Thread {
  override def run(): Unit = {
    var n = 1.0

    while (!buffer.stop) {
      buffer.put( ((2*n)*(2*n)) / ((2*n-1)*(2*n+1)) )
      n+=1.0
    }
  }
}

class PiEstimate(buffer: Bufferer, epsilon:Double = 0.0000001) extends Thread{
  override def run(): Unit = {
    var previous = buffer.take()
    var current = buffer.take() * previous

    while( 2*Math.abs(current - previous) > epsilon ){
      previous = current
      current = buffer.take() * previous
    }

    buffer.break
    println(current*2)
  }
}

object Pi {
  def main(args: Array[String]): Unit = {
    val buffer = new Bufferer()
    val producer = new SingleElement(buffer)
    val consumer = new PiEstimate(buffer)

    producer.start()
    consumer.start()

    producer.join()
    consumer.join()
  }
}

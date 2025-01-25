import scala.util.Random

class ATM(val max: Int = 4000) {
  private var currentMoney = max
  private val operationsLimit = 90
  private var operations = 0

  def fill(fillAmount:Int): Unit = synchronized {
    if (currentMoney < max) {
      currentMoney += fillAmount
      println(s"Buffer filled: $currentMoney zł")

      notifyAll()
    }
  }

  def withdraw(money: Int): Unit = synchronized {
    while (currentMoney < money) {
      println(s"Not enough money for ${Thread.currentThread().getName}. Waiting...")
      wait()
    }
    if operations < operationsLimit then
      operations+=1

      currentMoney -= money
      println(Thread.currentThread().getName + " withdrew: " + money + " zł. Remaining: " + currentMoney + " zł")

      notifyAll()
    else
      println(s"Dear ${Thread.currentThread().getName}, ATM isn't working anymore, please come back tomorrow!")
  }
}

class Bank(buffer: ATM) extends Thread {
  @volatile private var running = true

  def stopBank(): Unit = {
    running = false
  }

  override def run(): Unit = {
    while (running) {
      Thread.sleep(2500)
      if running then
        buffer.fill(1000)
    }
  }
}

class Client(moneyToWithdraw: Int, buffer: ATM) extends Thread {
  override def run(): Unit = {
    buffer.withdraw(moneyToWithdraw)
  }

  override def toString: String = s"$moneyToWithdraw zł"
}

object BankClientApp {
  def main(args: Array[String]): Unit = {
    val buffer = new ATM(5000)
    val bank = new Bank(buffer)
    bank.start()

    val rand = new Random()
    val clients = for (i <- 1 to 20) yield {
      val client = new Client(rand.nextInt(950) + 50, buffer)
      println(s"Client $i wants to withdraw: $client")
      client
    }

    clients.foreach(_.start())
    clients.foreach(_.join())

    bank.stopBank()
    bank.join()
  }
}

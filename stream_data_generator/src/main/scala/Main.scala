import ulities.ReadTopic
import ulities.configuration.ConfigLoader

object Main extends App{
  println("Performing main operation : New Versions")

  private val readOrder = ReadTopic
  readOrder.processIncoming()

}
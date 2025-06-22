import org.slf4j.helpers.NOP_FallbackServiceProvider
import ulities.{ReadTopic, WriteTopic}
import ulities.configuration.ConfigLoader

object Main extends App{
  println("Performing main operation : New Versions")

  private val performRead = false

  if (performRead) {
    println("Reading from Kafka topic...")
    ReadTopic.processIncoming()

  } else {

    println("Writing to Kafka topic...")
    WriteTopic.processIncoming()
  }

}
package ulities.kafka

import org.apache.kafka.clients.consumer.KafkaConsumer
import org.slf4j.LoggerFactory

import scala.collection.JavaConverters.asScalaSetConverter

object KafkaCommon {

  private val logger = LoggerFactory.getLogger(this.getClass)

  val consumer: KafkaConsumer[String, String] = KafkaConsumer.consumer

  def listTopic(): Unit = {

    try {
      val listTopics = consumer.listTopics() // triggers metadata fetch
      // Printing the list of topics
      logger.info(s"Available topics: ${listTopics.keySet().asScala.mkString(", ")}")

      logger.info("Kafka is reachable from consumer")
    } catch {
      case e: Exception =>
        logger.info(s"Kafka Consumer failed to connect: ${e.getMessage}")
        System.exit(1)
    }

  }
}

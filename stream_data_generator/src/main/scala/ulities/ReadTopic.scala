package ulities

import org.slf4j.LoggerFactory
import models.KafkaConf
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import ulities.ReadTopic.consumer

import java.time.Duration
import java.util.{Collections, Properties}
import scala.collection.JavaConverters.iterableAsScalaIterableConverter

object ReadTopic {

  private val logger = LoggerFactory.getLogger(this.getClass)

  logger.info("Kafka consumer started...")

  val config: KafkaConf = ConfigLoader.getConfig
  val props: Properties = KafkaProperty.getProperty()

  // Create Kafka Consumer
  val consumer = new KafkaConsumer[String, String](props)

  private def listTopic(): Unit = {

    try {
      consumer.listTopics() // triggers metadata fetch
      logger.info("Kafka is reachable from consumer")
    } catch {
      case e: Exception =>
        logger.info(s"Kafka Consumer failed to connect: ${e.getMessage}")
        System.exit(1)
    }

  }

  private def getMessage(): Unit = {

    logger.info(s"Config: $config")

    // Subscribe to topic
    consumer.subscribe(Collections.singletonList(config.readTopic))

    logger.info("Starting Kafka Consumer...")

    // Poll loop
    while (true) {
      val records = consumer.poll(Duration.ofMillis(500))
      for (record <- records.asScala) {
        logger.info(s"Received: key=${record.key()}, value=${record.value()}, partition=${record.partition()}, offset=${record.offset()}")
      }
    }

  }

  def processIncoming(): Unit = {
    listTopic()
    getMessage()
  }

}

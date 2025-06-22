package ulities

import models.KafkaConf
import org.slf4j.LoggerFactory
import ulities.configuration.ConfigLoader
import kafka.{KafkaCommon, KafkaConsume}
import org.apache.kafka.clients.consumer
import org.apache.kafka.clients.consumer.KafkaConsumer

import java.time.Duration
import java.util.Collections
import scala.collection.JavaConverters.iterableAsScalaIterableConverter

object ReadTopic {

  private val logger = LoggerFactory.getLogger(this.getClass)
  logger.info("Kafka consumer started...")

  val config: KafkaConf = ConfigLoader.getConfig
  val consumer: KafkaConsumer[String, String] = KafkaConsume.consumer

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
    val kafkaCommon = KafkaCommon
    kafkaCommon.listTopic()
    getMessage()
  }

}

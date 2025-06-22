package ulities

import org.slf4j.LoggerFactory
import models.KafkaConf
import ulities.configuration.ConfigLoader
import kafka.{KafkaCommon, KafkaProduce}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import scala.util.Random
object WriteTopic {

  private val logger = LoggerFactory.getLogger(this.getClass)
  logger.info("Kafka consumer started...")

  val config: KafkaConf = ConfigLoader.getConfig
  val producer: KafkaProducer[String, String] = KafkaProduce.producer

  private def pushMessage(): Unit = {

    logger.info(s"Config: $config")

    val random = new Random()
    val users = Seq("alice", "bob", "charlie", "david", "eva")

    println("Sending 5 random key-value messages...")

    for (name <- 1 to 5) {
      val key = users(random.nextInt(users.length)) // random user
      val value = s"order-${1000 + random.nextInt(9000)} for user : ${users(name - 1)}" // random order number

      val record = new ProducerRecord[String, String](config.writeTopic, key, value)

      producer.send(record)
      println(s"Sent -> Key: $key, Value: $value")
    }

    producer.close()
  }

  def processIncoming(): Unit = {
    val kafkaCommon = KafkaCommon
    kafkaCommon.listTopic()
    pushMessage()
  }
}

package ulities

import models.KafkaConf
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import ulities.ReadTopic.consumer

import java.time.Duration
import java.util.{Collections, Properties}
import scala.collection.JavaConverters.iterableAsScalaIterableConverter

object ReadTopic {

  val config: KafkaConf = ConfigLoader.getConfig
  val props: Properties = KafkaProperty.getProperty()

  // Create Kafka Consumer
  val consumer = new KafkaConsumer[String, String](props)

  def listTopic(): Unit = {

    try {
      consumer.listTopics() // triggers metadata fetch
      println("Kafka is reachable from consumer")
    } catch {
      case e: Exception =>
        println(s"Kafka Consumer failed to connect: ${e.getMessage}")
        System.exit(1)
    }

  }

  def getMessage(): Unit = {

    println(s"Config: $config")

    // Subscribe to topic
    consumer.subscribe(Collections.singletonList(config.readTopic))

    println("Starting Kafka Consumer...")

    // Poll loop
    while (true) {
      val records = consumer.poll(Duration.ofMillis(500))
      for (record <- records.asScala) {
        println(s"Received: key=${record.key()}, value=${record.value()}, partition=${record.partition()}, offset=${record.offset()}")
      }
    }

  }

  def processIncoming(): Unit = {
    listTopic()
    getMessage()
  }

}

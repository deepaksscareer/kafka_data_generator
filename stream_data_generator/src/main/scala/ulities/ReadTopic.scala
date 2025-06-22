package ulities

import org.apache.kafka.clients.consumer.KafkaConsumer

import java.util.Collections

object ReadTopic {

  val config = ConfigLoader.getConfig
  val props = KafkaProperty.getProperty()

  // Create Kafka Consumer
  val consumer = new KafkaConsumer[String, String](props)

  // Subscribe to topic
  consumer.subscribe(Collections.singletonList(config.readTopic))

  println("Starting Kafka Consumer...")
}

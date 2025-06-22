package ulities.kafka

import org.apache.kafka.clients.consumer.KafkaConsumer

import java.util.Properties

object KafkaConsume {

  private val props: Properties = KafkaProperty.getReadProperty()

  // Create Kafka Consumer
  val consumer = new KafkaConsumer[String, String](props)

}

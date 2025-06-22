package ulities.kafka

import org.apache.kafka.clients.producer.KafkaProducer

import java.util.Properties

object KafkaProducer {

  private val props: Properties = KafkaProperty.getWriteProperty()

  // Create Kafka Consumer
  val producer = new KafkaProducer[String, String](props)

}

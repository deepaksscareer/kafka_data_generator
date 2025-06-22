package ulities.kafka

import models.KafkaConf
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.{StringDeserializer, StringSerializer}
import ulities.configuration.ConfigLoader

import java.util.Properties

object KafkaProperty {

  def getWriteProperty(): Properties = {

    val config: KafkaConf = ConfigLoader.getConfig

    val props = new Properties()

    // Add the necessary properties
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.bootstrapServers)
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getName)
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer].getName)
    props.put(ProducerConfig.ACKS_CONFIG, config.acknowledgement)
    props.put(ProducerConfig.RETRIES_CONFIG, config.retries)

    props

  }

  def getReadProperty(): Properties = {

    val config: KafkaConf = ConfigLoader.getConfig

    val props = new Properties()

    // Add the necessary properties
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, config.bootstrapServers)
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName)
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName)
    props.put(ConsumerConfig.GROUP_ID_CONFIG, config.consumerGroup)
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, config.autoOffsetReset)

    props

  }
}

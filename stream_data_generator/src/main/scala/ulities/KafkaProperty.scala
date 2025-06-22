package ulities

import models.KafkaConf
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.{StringDeserializer}

import java.util.Properties

object KafkaProperty {

  def getProperty(): Properties = {

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

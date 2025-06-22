package ulities

import com.typesafe.config.ConfigFactory
import models.KafkaConfig

object ConfigLoader {
  def getConfig: KafkaConfig = {

    // Load application conf
    val config = ConfigFactory.load()

    val root_location = "app.kafka"

    // Get the values
    val bootstrapServer = config.getString(s"$root_location.bootstrapServers")
    val topic = config.getString(s"$root_location.topic")
    val retries = config.getInt(s"$root_location.retries")
    val consumerGroup = config.getString(s"$root_location.consumerGroup")
    val autoOffsetReset = config.getString(s"$root_location.autoOffsetReset")
    val readTopic = config.getString(s"$root_location.readTopic")

    println(
      s"""
         |The kafka setup
         |bootstrap_server = $bootstrapServer
         |topic = $topic
         |retries = $retries
         |consumerGroup = $consumerGroup
         |autoOffsetReset: $autoOffsetReset
         |readTopic: $readTopic
         |""".stripMargin)

    KafkaConfig(bootstrapServers = bootstrapServer, topic = topic, retries = retries,
      consumerGroup = consumerGroup, readTopic = readTopic, autoOffsetReset = autoOffsetReset)
  }

}

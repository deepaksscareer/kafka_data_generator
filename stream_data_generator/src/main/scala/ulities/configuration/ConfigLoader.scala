package ulities.configuration

import com.typesafe.config.ConfigFactory
import models.KafkaConf
import org.slf4j.LoggerFactory

object ConfigLoader {

  private val logger = LoggerFactory.getLogger(this.getClass)

  def getConfig: KafkaConf = {

    // Load application conf
    val config = ConfigFactory.load()

    val root_location = "app.kafka"

    // Get the values
    val bootstrapServer = config.getString(s"$root_location.bootstrapServers")

    val retries = config.getInt(s"$root_location.retries")

    // Consumer Group
    val consumerGroup = config.getString(s"$root_location.consumerGroup")

    // Other params
    val autoOffsetReset = config.getString(s"$root_location.autoOffsetReset")
    val acknowledgement = config.getString(s"$root_location.acknowledgement")

    // Topic details
    val writeTopic = config.getString(s"$root_location.writeTopic")
    val readTopic = config.getString(s"$root_location.readTopic")

    logger.info(
      s"""
         | Printing kafka configurations
         |The kafka setup
         |bootstrap_server = $bootstrapServer
         |writeTopic = $writeTopic
         |readTopic: $readTopic
         |retries = $retries
         |consumerGroup = $consumerGroup
         |autoOffsetReset: $autoOffsetReset
         |acknowledgement: $acknowledgement
         |""".stripMargin)

    KafkaConf(bootstrapServers = bootstrapServer,
      retries = retries,
      consumerGroup = consumerGroup,
      autoOffsetReset = autoOffsetReset,
      readTopic = readTopic,
      writeTopic = writeTopic,
      acknowledgement = acknowledgement)
  }

}

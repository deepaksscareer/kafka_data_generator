package models

case class KafkaConf(bootstrapServers: String,
                     writeTopic: String,
                     readTopic: String,
                     consumerGroup: String,
                     acknowledgement: String,
                     autoOffsetReset: String,
                     retries: Int) {
}

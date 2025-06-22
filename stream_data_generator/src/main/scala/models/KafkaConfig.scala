package models

case class KafkaConf(bootstrapServers: String, topic: String, consumerGroup: String,
                       autoOffsetReset: String, readTopic: String, retries: Int) {
}

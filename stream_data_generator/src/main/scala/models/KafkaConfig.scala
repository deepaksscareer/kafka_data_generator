package models

case class KafkaConfig(bootstrapServers: String, topic: String, consumerGroup: String,
                       autoOffsetReset: String, readTopic: String, retries: Int) {

}

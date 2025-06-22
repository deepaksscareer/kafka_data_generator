# kafka_data_generator
Generate random data using kafka

### Documentation link
https://developer.confluent.io/confluent-tutorials/kafka-on-docker/



### Create the kafka container
```bash
docker-compose up
```

### Logging to kafka container
```bash
# Use the docker deskto to login to the kafka server

```

### Create the kafka topic and list the topics:
```bash
code_dir="/opt/kafka/bin/"
topic_name="customer-orders"
bootstrap_server="localhost:9092"

cd ${code_dir}

echo "Creating the topics"
./kafka-topics.sh --create --topic ${topic_name} --bootstrap-server ${bootstrap_server}

echo "Printing the list of topics"
./kafka-topics.sh --list --bootstrap-server localhost:9092

```

### Adding messages to kafka topic using command line in key value format:
```bash
code_dir="/opt/kafka/bin/"
bootstrap_server="localhost:9092"

cd ${code_dir}

echo "Adding messages to kafka topic using command line in key value format"

# Enter message is key value pairs
./kafka-console-producer.sh --topic sales-order --bootstrap-server ${bootstrap_server} --property "parse.key=true" --property "key.separator=:"

```

### Deletion of topics in Kafka
```bash

code_dir="/opt/kafka/bin/"
bootstrap_server="localhost:9092"

cd ${code_dir}

echo "Deleting topics in kafka"

# Enter message is key value pairs
./kafka-topics.sh --delete --topic sales-orders --bootstrap-server ${bootstrap_server}

```
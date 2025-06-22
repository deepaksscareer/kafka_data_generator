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

```bash
## Create the kafka container using command:
code_dir="/opt/kafka/bin/"
topic_name="customer-orders"
bootstrap_server="localhost:9092"

cd ${code_dir}

echo "Creating the topics"
./kafka-topics.sh --create --topic ${topic_name} --bootstrap-server ${bootstrap_server}

echo "Printing the list of topics"
./kafka-topics.sh --list --bootstrap-server localhost:9092

```

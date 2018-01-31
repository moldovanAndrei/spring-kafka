# spring-kafka
Small playground for spring boot and apache kafka. Showcase for implemening two basic kafka producers and consumers. Messages are introduces via command line.

The custom producer and consumer user enhanced jackson object mapper to allow the serialization/deserialization for Java 8 types (LocalDateTime).

# Setup

Download and extract kafka and zookeeper:
https://kafka.apache.org/downloads

Edit (if necessary) the zookeeper properties and start the zookeeper:
> bin/zookeeper-server-start.sh config/zookeeper.properties

Start the kafka server:
> bin/kafka-server-start.sh config/server.properties

Run the produces spring boot application.

Run the consumer spring boot application.

# Configuration info
Zookeeper address: localhost:2128

Kafka bootstrap server address: localhost:9092

NOTE: example provided using .sh scrips will work on linux machines. For windows there are .bat scripts in the windows directory of kafka.
For more details visit: https://kafka.apache.org/quickstart

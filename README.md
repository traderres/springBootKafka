# springBootKafka

Sample java consumer and producers

The producer gets the database date/time string and pushes-it to the kafka topic every N seconds
The consumer reads it from the kafka topic


### How to Build the Package
```
unix> mvn clean package
```
<br>



### How to Run the Package
```
# Run the kafka producer (that sends a message with the current date every second)
unix> java -jar ./producer/target/producer-1.0-SNAPSHOT.jar


# Run the kafka consumer  (that prints out the message)
unix> java -jar ./consumer/target/consumer-1.0-SNAPSHOT.jar
```
<br>


### How to Debug the Package
See the nodes in docs/howToDebugLocally.txt



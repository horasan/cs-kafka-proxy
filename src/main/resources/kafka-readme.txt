docker-compose up -d
docker ps

# create a topic 
docker exec resources_kafka1_1 kafka-topics --create --bootstrap-server localhost:9091 --replication-factor 1 --partitions 1 --topic customer-create-requests

# list topics
docker exec resources_kafka1_1 kafka-topics --list --bootstrap-server localhost:9091

# create producer

# create consumer

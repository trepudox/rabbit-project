# comando pro docker recriar as imagens e subir novos containeres (só das APIs)

docker compose up --force-recreate --build bff message-producer pessoa-service cargo-service

# buildar o bff (quarkus nativo)

mvn package -Pnative -Dquarkus.native.container-build=true

# buildar os outros microsserviços em spring

mvn clean package spring-boot:repackage

# declaracao do rabbitmq

rabbitmqadmin -u guest -p guest -V / declare exchange name=rabbit-project-exchange type=direct

rabbitmqadmin -u guest -p guest -V / declare queue name=cargo-queue durable=true
rabbitmqadmin -u guest -p guest -V / declare queue name=cargo-queue-dlq durable=true
rabbitmqadmin -u guest -p guest -V / declare queue name=pessoa-queue durable=true
rabbitmqadmin -u guest -p guest -V / declare queue name=pessoa-queue-dlq durable=true

rabbitmqadmin -u guest -p guest -V / declare binding source=rabbit-project-exchange destination=cargo-queue routing_key=cargo-queue
rabbitmqadmin -u guest -p guest -V / declare binding source=rabbit-project-exchange destination=cargo-queue-dlq routing_key=cargo-queue-dlq
rabbitmqadmin -u guest -p guest -V / declare binding source=rabbit-project-exchange destination=pessoa-queue routing_key=pessoa-queue
rabbitmqadmin -u guest -p guest -V / declare binding source=rabbit-project-exchange destination=pessoa-queue-dlq routing_key=pessoa-queue-dlq

# buildar o bff (quarkus nativo)  
mvn package -Pnative -Dquarkus.native.container-build=true

# buildar os outros microsserviços em spring  
mvn clean package spring-boot:repackage
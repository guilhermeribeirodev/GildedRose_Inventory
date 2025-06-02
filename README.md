docker build --build-arg JAR_FILE=build/libs/\*.jar -t springio/gs-spring-boot-docker .

docker run -p 8080:8080 springio/gs-spring-boot-docker

curl -X POST -H "Content-Type: application/json" -d @itemsInput.json http://localhost:8080/items
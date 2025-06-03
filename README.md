
# Gilded Rose Inventory API
==================================

#### This API runs a Spring Boot MVC application and it can be built and ran using Docker

* Building the Docker image

```
$ docker build --build-arg JAR_FILE=build/libs/\*.jar -t inventory-api .
```

* Running the Docker container

```
$ docker run -p 8080:8080 inventory-api 
```

* Testing the API resource with curl

```
$ curl -X POST -H "Content-Type: application/json" -d @itemsInput.json http://localhost:8080/items
```
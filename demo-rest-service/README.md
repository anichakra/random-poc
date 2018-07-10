# Introduction
This project shows how to create a microservice using [spring-boot](https://projects.spring.io/spring-boot/). This microservice has ReST based controllers that provides basic CRUD operations and persists data into postgres. This project also shows how to write unit test cases and generate code coverage report.

# Prerequisite
Following are the softwares to be installed to run the project:
* Require JDK1.8 or higher
* Maven 3.5.3 or higher
* Postgresql 9.5 or higher

# Instructions
To test and run change directory inside the project.
## Test
```
mvn clean test
```

## Build
```
mvn install
```

## Run
```
mvn spring-boot:run 
```

or

```
java -jar demo-rest-service-0.0.1-SNAPSHOT.jar
```

## Override configuration
If your postgres is not running in localhost, and is running in a different location. Create a directory called config where the spring-boot uber jar is kept. Keep the application.yml in the config and update it accordingly.

## Different port
To run the application in a different HTTP port, say 9090 instead of default 8080:

``` 
java -jar demo-rest-service-0.0.1-SNAPSHOT.jar --PORT=9090
```

## Remote database host

``` 
java -jar demo-rest-service-0.0.1-SNAPSHOT.jar --POSTGRES_HOST=<remote-host/ip>
```


# Service Version
Context path version strategy is taken. The service version will be part of the context-path. The version of the service is directly mapped from the project artifact version as defined in the pom.xml. 

The automation is done by porting the version from pom.xml to application.yml against the @project.version@ placeholder into a custom configuration property. This is done by spring maven build plugin at build time. Check WebserverCustomizer.java for more details. This component extracts only the major and minor version eliminating anything after that and set the same to context-path of the webserver during application startup. 

E.g.

```
	<groupId>me.anichakra.poc.random</groupId>
	<artifactId>demo-rest-service</artifactId>
	<version>1.2.3-RELEASE</version>
	<packaging>jar</packaging>
```

Will make the service version as 1.2 and will be translated as context-path automatically. Hence to run any method of the service the version should be part of the endpoint as given below:

POST Method to create a vehicle:

```
 curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"manufacturer": "nissan", "year": 2017, "model": "micra"}' \
  http://localhost:8080/demo-rest-service/1.2/vehicle
 
```

GET Method to search vehicles

```
curl -i -H "Accept: application/json" -H "Content-Type: application/json" \ http://localhost:8080/demo-rest-service/1.2/vehicle/search?manufacturer=nissan
```

GET Method to retrieve a vehicle

```
 curl -i -H "Accept: application/json" -H "Content-Type: application/json" http://localhost:8080/demo-rest-service/1.2/vehicle/10
```

DELETE Method to delete a vehicle

```
curl -X DELETE -H "Accept: application/json" -H "Content-Type: application/json" \ http://localhost:8080/demo-rest-service/1.2/vehicle?id=10

```





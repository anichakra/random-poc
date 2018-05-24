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
<code>mvn clean test</code>

## Build
<code> mvn install </code>

## Run
<code> mvn spring-boot:run </code>

or

<code> java -jar demo-rest-service-0.0.1-SNAPSHOT.jar </code>

## Override configuration
If your postgres is not running in localhost, and is running in a different location. Create a directory called config where the spring-boot uber jar is kept. Keep the application.yml in the config and update it accordingly.

## Different port
To run the application in a different HTTP port, say 9090 instead of default 8080:

<code> java -jar demo-rest-service-0.0.1-SNAPSHOT.jar --PORT=9090 </code>




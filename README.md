# Spring Boot CRUD Application

This is a simple Spring Boot application created for practice

## Features

- RESTful API for managing todos
- CRUD operations on todos entities
- Integration with H2 database
- Swagger UI for API documentation and testing

## Technologies

- Java 11
- Spring Boot 2.5.4
- Spring Data JPA
- H2 Database
- Swagger UI

## Getting Started

### Prerequisites

1. Clone the repository:
~~~bash
git clone https://github.com/radioactive1337/springboot.git
~~~
2. Navigate to the project directory:
~~~bash
cd springboot
~~~
3. Configure the database connection in `src/main/resources/application.properties`

### Running the Application

1. Build the project:
~~~bash
./gradlew clean build
~~~
2. Run the application:
~~~bash
./gradlew bootRun
~~~

### Building jar

1. Build jar
~~~bash
./gradlew bootJar
~~~
2. Run jar
~~~bash
java -jar build/libs/springboot-1.0-SNAPSHOT.jar
~~~
or
~~~bash
java -jar build/libs/springboot-1.0-SNAPSHOT.jar --server.port=<your port>
~~~

The swagger doc for application will start on `http://localhost:8080`.

## API Documentation

Once the application is running, you can access the Swagger UI at: http://localhost:8080/swagger-ui.html


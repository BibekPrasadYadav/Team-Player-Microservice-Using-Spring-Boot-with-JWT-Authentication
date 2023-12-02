# Project Title
**TeamPlayerMicroservice**
 
# Features
* Used RestTemplate to communicate between services
* Used Eureka Server for Service Registry
* Implemented Circuit Breaker, Resilience4j Retry and Resilience4j ratelimiter to handle fallback of Services

# Technologies
* Spring Boot 3.0
* Microservices
* API Gateway
* Circuit Breaker
* Resilience4j Retry
* Resilience4j ratelimiter
* Eureka Server
* Maven

# Getting Started
**To get started with this project, you will need to have the following installed on your local machine:** 
* JDK 17+
* Maven 3+

**To build and run the project, follow these steps:**

* Clone the repository: git clone https://github.com/BibekPrasadYadav/TeamPlayerMicroservice.git
* Build the project: mvn clean install
* Run the project: mvn spring-boot:run
-> The application will be available at http://localhost:8080.


# Steps to Use API
## To run the Eureka Server for Service Registry
### GET Method : http://localhost:8761

## To run the API Gateway(Port=9003 used to run all other services)
### GET Method : http://localhost:9003

## To run the Player Service
### For Get All Player:
#### GET Method : http://localhost:9001/player/all OR http://localhost:9003/player/all
### For Get Player By Id:
#### GET Method : http://localhost:9001/player/{id} OR http://localhost:9003/player/{id}
#### To save the Player Details
#### POST Method : http://localhost:9001/player/save OR http://localhost:9003/player/save
* Provide the json data in BODY
###### {
###### "playerName" : "",
###### "playerJersey" : "" ,
###### "playerTeam" : "",
###### "teamId" : ""
###### }

## To run the Team Service
### For Get All Team:
#### GET Method : http://localhost:9000/team/all OR http://localhost:9003/team/all
### For Get Team By Id:
#### GET Method : http://localhost:9000/team/{id} OR http://localhost:9003/team/{id}
#### To save the Team Details
#### POST Method : http://localhost:9000/team/save OR http://localhost:9003/team/save
* Provide the json data in BODY
###### {
###### "teamName" : "",
###### "teamCaptain" : "" ,
###### "teamCoach" : ""
###### }









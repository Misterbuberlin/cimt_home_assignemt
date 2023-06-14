# Solution to a home assignment for CIMT AG.

## Specification

This is an implementation of a REST application service with two endpoints:

one that returns a fibonnaci number, given its position.
Example of how to query the fibonacci endpoint:
curl -H "Content-Type: application/json" -X GET http://localhost:8080/values/fibonacci/7

The other one returns the greatest common denominator, given two integer values.
Example of how to query the endpoint:
curl -H "Content-Type: application/json" -X POST -d '{"val1": -12, "val2": 18}' http://localhost:8080/values/gcd

## How to clone the spring-boot project

To clone this project to your local computer, run  
'git clone https://github.com/Misterbuberlin/cimt_home_assignemt.git'

## How to run the service on your local computer
To run the application, run ./gradlew bootRun and check if application is up and running
at http://localhost:8080/actuator/health
Please note you can use the application.yaml to configure another server port, in case 8080 is already in use.

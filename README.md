#Implements a REST application with two endpoints:

one that returns a fibonnaci number, given its position. Example of how to query the fibonacci endpoint: curl -H "Content-Type: application/json" -X GET http://localhost:8080/values/fibonacci/7

The other one returns the greatest common denominator, given two values. Example of how to test the endpoint: curl -H "Content-Type: application/json" -X POST -d '{"val1": -12, "val2": 18}' http://localhost:8080/values/gcd


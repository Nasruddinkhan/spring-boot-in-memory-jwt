# Spring Boot 3 with Java 17 and implementing Spring Security with JWT authentication, all without the need for a database.

1. clone the project `git clone https://github.com/Nasruddinkhan/spring-boot-in-memory-jwt`
2. run open the swagger url `http://localhost:8111/swagger-ui/index.html`. login curl command for postman `curl -X 'POST' \
   'http://localhost:8111/auth/v1/login' \
   -H 'accept: */*' \
   -H 'Content-Type: application/json' \
   -d '{
   "userName": "admin",
   "password": "admin"
   }'`
3. copy the jwt token & add into authorization header with Bearer token type. test api curl command for psotman to test api `curl -X 'GET' \
   'http://localhost:8111/msg/v1/Nasruddin%20khan' \
   -H 'accept: */*' \
   -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJzdWIiOiJhZG1pbiIsImlhdCI6MTY5MDMxNDYyMiwiZXhwIjoyMDA1OTMzODIyfQ.7j2yhBtvMMFifc5-JSKz98x2P1L9sctJ1Mulmtji9m8'`

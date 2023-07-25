# spring-boot-in-memory-jwt
Spring boot 3 with java 17 and spring security with jwt without db.

1. clone the project `git clone https://github.com/Nasruddinkhan/spring-boot-in-memory-jwt`
2. open the swagger url `http://localhost:8111/swagger-ui/index.html`. curl command for login `curl -X 'POST' \
   'http://localhost:8111/auth/v1/login' \
   -H 'accept: */*' \
   -H 'Content-Type: application/json' \
   -d '{
   "userName": "admin",
   "password": "admin"
   }'`
3. copy the jwt token & add into authorization header with Bearer token type. curl command for secure api `curl -X 'GET' \
   'http://localhost:8111/msg/v1/Nasruddin%20khan' \
   -H 'accept: */*' \
   -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjpbeyJhdXRob3JpdHkiOiJST0xFX0FETUlOIn1dLCJzdWIiOiJhZG1pbiIsImlhdCI6MTY5MDMxNDYyMiwiZXhwIjoyMDA1OTMzODIyfQ.7j2yhBtvMMFifc5-JSKz98x2P1L9sctJ1Mulmtji9m8'`

# 0fferC1t1_API

1. Run the application using the command ./mvnw spring-boot:run

2. Open your browse and past the url http://localhost:8080/swagger-ui.html gives the UI for sending requests to APIs

3. Authenticate as below curl -i -H "Content-Type: application/json" -X POST -d '{"userName":"test@gmail.com123","password":"test"}' http://localhost:8080/offerciti/authentication/login , with valid credentials the the api will return a response with a JWT token as below 
{"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImNyZWF0ZWQiOjE0NzM2NzUzMzg2MTUsImV4cCI6MTQ3NDE3NTMzOH0.GQNhl1ESD0SXpK3d"}

4. With the token the API's can be accessed as below 
curl -i -H "Content-Type: application/json" -H "X-Auth-Token:eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QGdtYWlsLmNvbSIsImNyZWF0ZWQiOjE0NzM2NzUzMzg2MTUsImV4cCI6MTQ3NDE3NTMzOH0.GQNhl1ESD0SXpK3d" -X GET http://localhost:8080/offerticiti/user/29

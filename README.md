# rc-rest-service
Develop a RESTful web service that implement the following 2 APIs in Java 
HTTP POST /items , request body { item:{ id: 123, timestamp: 2016-01-01T23:01:01.000Z } }  should return 201 created  

HTTP GET /items  should return the list of items POSTed in the last 2 seconds or the list of last 100 POSTed items, whichever greater.   [ {item: {id: 123, timestamp: 2016-01-01T23:01:01.000Z} },  {item: {id: 124, timestamp: 2016-01-01T23:01:01.001Z} },…]



Instructions to run - 

1. Checkout the project 
2. Go to the Terminal - run "/gradlew bootRun"
3. Use POSTMAN for Post calls

POST : http://localhost:8080/items  
GET : http://localhost:8080/items
# rc-rest-service
Develop a RESTful web service that implement the following 2 APIs in Kotlin, Java or Clojure     HTTP POST /items , request body { item:{ id: 123, timestamp: 2016-01-01T23:01:01.000Z } }  should return 201 created  HTTP GET /items  should return the list of items POSTed in the last 2 seconds or the list of last 100 POSTed items, whichever greater.   [ {item: {id: 123, timestamp: 2016-01-01T23:01:01.000Z} },  {item: {id: 124, timestamp: 2016-01-01T23:01:01.001Z} },…]
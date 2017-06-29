# CustomerServiceNg2Boot

Customer Manager
Goal Develop a simple Java application
to expose REST APIs for "customer" management.
Tools/Frameworks Spring Boot
Spring Security
Maven
Angular2
Business objects Customer [id, name, phone, address]
Business logic User must have ability to:
- get list of all customers;
- create new customer;
- get customer by id;
- get customer by name;
- update specific customer attribute:
specify dynamically in request parameter called "fields"
e.g. fields=name,phone request body: {"name":"John","phone":"555-55-55"}

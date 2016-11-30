# COMP 344: Web Services Programming Project

##Lake Shore Market Project
======
Lake Shore Market is a project for COMP 388: Web Services Programming at Loyola University Chicago. The project requires the creation of a RESTful API using Jax-RS and Apache CXF. The API is meant to be used by a developer developing a website using Lake Shore's MySQL database. 

The project can be broken down into a few major layers inside of the domain layer of the web service architecture:
* Model
* DAO
* Service
* Workflow

##Using the API
=====
After opening the project in Eclipse, run the project in Apache Tomcat. 

All commands will follow a similar URI pattern: http://localhost:8081/API/{Object}/{attribute}

The following classes may be used:
-* Customers
-* Partners
-* Products
- *Orders

###Class Attributes
Each class has the following attributes:
Customers
* id
* FirstName
* LastName
* Address
* PhoneNumber
* City
* State
* Zip

Orders
* id
* Status
*CustomerID

OrderItem
* OrderID
* PartnerID
* CustomerID
* ProductID
* Price
* Quantity

Product
* Name
* Description
* PartnerID
* Quantity
* Inventory

###Examples
Getting all objects of a class:
@GET
>http://localhost:8081/API/{Class(plural)}

Looking up a specific class with an id:
@GET
>http://localhost:8081/API/Partners/2

Modifying a class's attribute:
@POST
HeaderParameter: New Attribute Value. All first letters of each word capital, no spaces.
>http://localhost:8081/API/{Class(plural)}/{Attribute}/id

Deleting a class:
@DELETE
>http://localhost:8081/API/{Class(plural})/id


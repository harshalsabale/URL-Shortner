# Sprout - URL Shortner
Sprout is a service that reduces lengthy URLs to shorter, more manageable links. These shorter URLs are easier to distribute, particularly in situations when character count is limited, such as on social networking sites like Twitter.

## Getting Started

### Prerequisites
* [Install PG admin](https://www.pgadmin.org/download/)
* Set up a server in your local
* Java IDE of your choice (preferably [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/?section=windows))
* [Install Postman](https://www.postman.com/downloads/)

## Installation
1. Clone the Repository in your Local
```sh
git clone https://github.com/harshalsabale/URL-Shortner.git
```
2. Build project using below commands.
```sh
mvn clean install
```
3. In newly created server, create database named "Sprout" (case sensetive)
4. In public schema, create a table using the script in [schema-postgres.sql](src/main/resources/schema-postgres.sql)
5. Deploy/Run the project in you local.
6. You are all setup.

## How to use the Service
Below are the three APIs to exposed in this service.

### 1. Health check API
This API is responsible for checking the status of the service (Whether is it Up or not).

**Method :** GET <br>
**End Point :**
```
/api/health.check
```

### 2. Create a Short URL from the URL provided
This API is responsible for creating a short URL from the provided URL.

**Method :** Post <br>
**End point :** 
```
/short.it?url=<provide a link you want to shorten>
```

### 3. Redirecting short URL to Original URL
This API is responsible for redirecting user having short URL to Original URL.

**Method :** GET <br>
**End Point :** 
```
/sprout/<short URL>
```

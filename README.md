# Sprout - URL Shortner
Sprout is a service that reduces lengthy URLs to shorter, more manageable links. These shorter URLs are easier to distribute, particularly in situations when character count is limited, such as on social networking sites like Twitter.

## System Design
While creating URL Shortening Service, there are at least 3 questions which must be answered.
1. How many create request are we going to get per second?
2. What are the characters are allowed in Short URL?
3. What will be the size of Short URL?

For the First Question, Let's assume that we are going to get 100 create request per second. 
This will give us, yearly request count as `100 x 60 x 60 x 24 x 365 = 3,15,36,00,000` (3.15 Billion). In 20 years, 63.07 Billion request.
If we want to run this service for at least 20 years, we need same number of Unique short URLs.

Now comes to Second Question, There are 73 characters `i.e. Alphanumeric [0-9a-zA-Z], special characters $-_.+!*'().` which are safe to use in URL (without Encoding).
But for the simplicity of the implementation, let us drop all the special characters and focus on the Alphanumeric characters `[A-Z][a-z][0-9]`. 
So, we are allowed to use 62 characters.

The Last Question can not be answered alone without answering the first two questions. 
From the first question, it is clear that we will be needing at least 63.07 Billion URLs for running the service for 20 years and from second question we understood that we can use 62 characters to generate the short URLs.

So, What is the least number of character, we will be needing to create 63.07 Billion short URLs from 62 characters? Let's calculate: 

62<sup>1</sup> = 62 <br>
62<sup>2</sup> = 3844 <br>
62<sup>3</sup> = 238328 (238 Thousand)<br>
62<sup>4</sup> = 14776336 (14 Million)<br>
62<sup>5</sup> = 916132832 (916 Million)<br>
62<sup>6</sup> = 56800235584 (56 Billion)<br>
62<sup>7</sup> = 3521614606208 (3.5 Trillion) <br>

This Calculation tells that we will need at least 7 characters in the short URL to uniquely represent 63.07 Billion requests.

So, we have answer to all the important questions to proceed with Design & Development.

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

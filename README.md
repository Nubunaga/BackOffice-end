# BackOffice-end

## Info
This is the server side implementation of the backoffice client microservice that handles the call to the database, orderflow and user information to be used by the frontend application of the backoffice.

## Endpoints
###  **/advert/add**

<b>POST</b> a json object in body
Json structure:
```
"orderID": <UUID>,
"video":[{"interest":<interest>,
"length":<Integer>,"url":<URL>}],
"Startdate: <ISO>,
"Enddate: <ISO>
```
Respons:
  * Status **201** and List of video ID to the user
  * Status **400** if Json format is incorrect or no video is added
  * tatus **500** if something went wrong inside the server

###  **/advert/delete**

**GET** parameter id that deletes the video
Params:
``` id: <videoId> ```
Respons:
 * Status **204** and video is deleted.
 * Status **500** if error is internal server error.
 ###  **/order/add** 

**POST** a json object in body
Json structure: 
```
{
"user":<email>,
"credits":<Integer>,
"video":[{"interest":<interest>,
"length":<Integer>,"url":<URL>}],
 "Startdate":<Date ISO>,
 "Enddate":<Date ISO>
}
```
Responds:
  * Status **201** and an order id if done!
  * Status **400** if Json format is incorrect or no video is added
  * Status **401** if your token is expired or not autherized for the application. See response message!
  * Status **500** if something went wrong inside the server

### **/order/history**

**GET** parameter id that 
  request parameter :
  ``` username: <userName>```
  Rsponds:
  * Status **200** if a history is found and returns a list of orders.
  * Status **400** if the userName is null.
  * Status **404** if no user is found
  * Status **500** if something went wrong inside the server

###  **/order/intrests**

**GET** No param
Responds
* Status **200** if a history is found and returns a list of orders.
* Status **404** if no user is found

## Enviroment
This code is written in java with the framework <b><em> Spring </em></b> to create a connection to the database and structuring the program. The website enviroment we use to deploy the API is on heruko.

## Test
Is done each time the spring program is compiled since the command <code> mvn package </code> follows pom.xml file when compiled and thus tests all the files in the test directory before creating the jar
The test files can be found inside <i> src/test/java/com/example/demos </i>

![Java testing CI with maven](https://github.com/Projektgrupp17/BackOffice-backend/workflows/Java%20testing%20CI%20with%20maven/badge.svg)

## Structure
The code structure follows the <em> MVC </em> architecture thus allowing for better structuring and truly seperate the classes.
See [Architecture](https://github.com/Projektgrupp17/BackOffice-backend/wiki/2-Architecture) for structure and design

## Pom.xml 
Is the file that the mvn project is built uppon and list all the dependencies, project information, artifacts after compilations and maven declarations that is needed to compile this java program using maven.

## Dependencies
In order to run the program as i have, download [Maven 3.2](https://maven.apache.org/download.cgi) (or above).

You also need JDK 8 or later.


## Compile and run

To compile the program, run the following maven command <code> mvn package </code>.
To then be able to run the program, be in the directory you placed your code in <code>cd %Path_to_Program%\BackOffice-end </code>.
Then run the program, run <code> java -jar target/demos-0.0.1-SNAPSHOT.jar </code> (you have to change the "target/demos-0.0.1-SNAPSHOT.jar" depending on where it is and if there is another artifact name

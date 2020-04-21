# BackOffice-end

## Info
This is the server side implementation of the backoffice client microservice that handles the call to the database, orderflow and user information to be used by the frontend application of the backoffice.

## Enviroment
This code is written in java with the framework <b><em> Spring </em></b> to create a connection to the database and structuring the program. The website enviroment we use to deploy the API is on heruko.

## Test
Is done each time the spring program is compiled since the command <code> mvn package </code> follows pom.xml file when compiled and thus tests all the files in the test directory before creating the jar
The test files can be found inside <i> src/test/java/com/example/demos </i>

![Java testing CI with maven](https://github.com/Projektgrupp17/BackOffice-backend/workflows/Java%20testing%20CI%20with%20maven/badge.svg)

## Structure
The code structure follows the <em> MVC </em> architecture thus allowing for better structuring and truly seperate the classes.
The structure goes as followed:

<b>Controller:</b>

Contaning the Main controller for the <em> /user </em> API calls to the backend.

<b>Model:</b>

contains the buissness logic of the server with the following files that the server uses:

<b>repository:</b>

Contains the DB-class <b>UserRepository.java</b> that extends <b>CrudRepository</b> to allow fot the db calls to the server.
It also contains the DB-class <b> Users </b> that is the "table-class" that spring @hibernate will autowire into the database.

<b>target: </b>

is the module that contains the jar file after the <code> mvn package </code> have compiled. It contains all the compiled classes.

<b> .settings </b> 

contains the filés for some of the drivers to work for java 8 but are not important for the project.

<b>DTO:</b>
contains all the api's data tranferable objects.

## Pom.xml 
Is the file that the mvn project is built uppon and list all the dependencies, project information, artifacts after compilations and maven declarations that is needed to compile this java program using maven.

## Dependencies
In order to run the program as i have, download [Maven 3.2](https://maven.apache.org/download.cgi) (or above).

You also need JDK 8 or later.


## Compile and run

To compile the program, run the following maven command <code> mvn package </code>.
To then be able to run the program, be in the directory you placed your code in <code>cd %Path_to_Program%\BackOffice-end </code>.
Then run the program, run <code> java -jar target/demos-0.0.1-SNAPSHOT.jar </code> (you have to change the "target/demos-0.0.1-SNAPSHOT.jar" depending on where it is and if there is another artifact name

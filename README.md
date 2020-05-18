# BackOffice-end![Java testing CI with maven](https://github.com/Projektgrupp17/BackOffice-backend/workflows/Java%20testing%20CI%20with%20maven/badge.svg)

## Info
This is the server side implementation of the backoffice client microservice that handles the call to the database, orderflow and user information to be used by the frontend application of the backoffice.

## Endpoints
see [Endpoints](https://github.com/Projektgrupp17/BackOffice-backend/wiki/7-Endpoint)

## Enviroment
This code is written in java with the framework <b><em> Spring </em></b> to create a connection to the database and structuring the program. The website enviroment we use to deploy the API is on heruko.

## Test
Is done each time the spring program is compiled since the command <code> mvn package </code> follows pom.xml file when compiled and thus tests all the files in the test directory before creating the jar
The test files can be found inside <i> src/test/java/com/example/demos </i>

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

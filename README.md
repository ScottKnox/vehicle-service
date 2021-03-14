# IQ Scroll Backend
This backend provides the IQ Scroll mobile app lists of facts to display to users.

## Running Locally
In the iq-scroll-backend directory, simply run:

`docker-compose up`

Then, navigate to http://localhost:8080/facts

## Running Test Suites

## Staging

## Prod

#Building 
Run the following command to build and run locally:

`mvn package && java -jar target/iq-scroll-0.0.1-SNAPSHOT.jar`

To prepare for new docker image:

`mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)`

When ready for new app version:

`docker build -t 417digital/iq-scroll-backend:latest .`

## Endpoints 
`/facts` - Returns a list of facts

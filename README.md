# Vehicle Service
Vehicle Service provides vehicle data to our various front end applications, and shared services. 

## Running Locally
In the vehicle-service directory, simply run:

`docker-compose up`

Then, navigate to http://localhost:8080/vehicles

## Running Test Suites

## Staging

## Prod

#Building 
Run the following command to build and run locally:

`mvn package && java -jar target/vehicle-service-0.0.1-SNAPSHOT.jar`

To prepare for new docker image:

`mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)`

When ready for new app version:

`docker build -t 417digital/vehicle-service:latest .`

## Endpoints 
`/vehicles` - Returns a list of vehicles

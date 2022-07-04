# Vehicle Service
Vehicle Service provides vehicle data to our various front end applications, and shared services. 

## Running Locally
### Prerequisites 
**Amazon AWS CLI**: https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html

Follow the instructions for your OS, then open a terminal / command prompt and type "aws configure"

You can enter a real Access Key combo or just put in junk credentials, and "us-west-2" for the region. 
Type aws --version after these steps to ensure you installed correctly. 

**Docker Desktop**: https://docs.docker.com/desktop/

Follow the instructions to install Docker desktop for your OS.

**Java Dependencies**: Ensure you have both Java and Maven installed and callable from a terminal / command prompt.

**Database Scripts**: For the service to function, you'll need to run the database script to populate your local DynamoDB instance.

`powershell .\setupDatabase.ps1`

### Local Instructions
**DyanmoDB** - To bring up DynamoDB on port 8000:

In the vehicle-service directory, simply run:

`docker-compose up`

**Vehicle Service** - To run Vehicle Service on port 8080:

`mvn spring-boot:run`

Then, navigate to http://localhost:8080/vehicles

## Running Test Suites
**Unit Tests** `mvn test`

## Endpoints 
`/vehicles` - Returns a list of vehicles

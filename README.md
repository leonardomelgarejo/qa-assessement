# API Test Automation Project qa-assessment.svc.hostfully.com

## Description

This is an assessment project on automating testing of Rest APIs using Rest Assured and JUnit5 tools with Java from the URL https://qa-assessment.svc.hostfully.com  

## Required software

* [Java JDK 22+](https://www.oracle.com/pt/java/technologies/javase/jdk11-archive-downloads.html)

* [Apache Maven 3.6+](https://maven.apache.org/docs/3.6.0/release-notes.html)

* Clone the repository: ```git clone https://github.com/leonardomelgarejo/hostfully-qa.git```

## How to run the tests

* You can manually run each test in ```src/test/java/com/svc/com/hostfully/svc/qa_assessment/tests```
* You can manually run the test suite in ```src/test/java/com/svc/com/hostfully/svc/suite```
* You can run the tests via the command line with ```mvn clean test```
  * Complement: The execution of the above command is configured in the project's POM.xml to execute the test suite `src/test/java/com/svc/com/hostfully/svc/suite/AllTestsSuite.java`.

## Test report

* The test report is generated by the Allure Reports framework, in two ways:
    * Locally, running the commands below:
        * mvn allure:serve : It will open the HTML report in the browser
        * mvn allure:report : It will generate the HTML in the target/site/allure-maven-plugin folder
    * The location where the reference file for the report is defined in the src/test/resources/allure.properties
    * Remotely, accessing:
        * https://leonardomelgarejo.github.io/qa-assessement/
        * Or in the Gitlab Pages link in deployments, on the right side of the project home screen

## Project structure

```plaintext
├── .github
│   ├── workflows
│   │   ├── gha-ci.yml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── hostfully
│   │   │           └── svc
│   │   │               └── qa_assessment
│   │   │                   ├── client
│   │   │                   │    ├── ApiClient.java
│   │   │                   │    ├── BookingClient.java
│   │   │                   │    └── PropertyClient.java
│   │   │                   ├── config
│   │   │                   │   ├── Configuration.java
│   │   │                   │   └── ConfigurationManager.java
│   │   │                   ├── enums
│   │   │                   │   ├── CountryCode.java
│   │   │                   │   └── Status.java
│   │   │                   ├── factory
│   │   │                   │   ├── BookingDataFactory.java
│   │   │                   │   ├── GuestDataDataFactory.java
│   │   │                   │   └── PropertyDataFactory.java
│   │   │                   ├── model
│   │   │                   │   ├── Booking.java
│   │   │                   │   ├── Guest.java
│   │   │                   │   └── Property.java
│   │   │                   ├── specs
│   │   │                   │   └── InitialStateSpecs.java
│   │   │                   └── utils
│   │   │                       ├── DataRequests.java
│   │   │                       └── StringFaker.java
│   │   └────────────────── resources
│   │                       └── log4j2.properties                   
│   └── test
│       ├── java
│       │   └── com
│       │       └── hostfully
│       │           └── svc
│       │               └── qa_assessment 
│       │                   ├── suite
│       │                   │   └── AllTestsSuite.java
│       │                   ├── tests
│       │                   │   ├── BookingE2ETests.java
│       │                   │   ├── ContractTests.java
│       │                   │   ├── HealthCheckTests.java
│       │                   │   ├── PropertyE2ETests.java
│       │                   └── BaseAPI.java
│       │
│       └────────────────── resources
│                           ├── schemas
│                           │   ├── bookings.json
│                           │   └── properties.json
│                           ├── allure.properties
│                           └── api.properties
├── .gitignore
├── README.md
└── pom.xml
```

## About project structure

### src/main/java

#### client

Classes that interact with endpoints. They are called in the test method steps.

#### config

Configuration classes are the connections between the api.properties properties file located at src/test/resources/.

@Config.Sources loads the properties file and combines the attributes with the @Key, so you get the value automatically. You can see two sources. The first will get the values ​​of system properties (such as environment or command line variables) in case you want to change it, for example, in a pipeline. The second will load the api.properties file from the classpath.

```
@Config.Sources({
        "system:properties",
        "classpath:api.properties"})
```

The environment variable is read from the ConfiguratorManager. This class reduces the amount of code required to obtain any information in the properties file.

This strategy uses the Owner library.

#### enums

Facilitates data management.

#### factory

It applies the factory pattern to generate generic instances, facilitating the management of the data necessary for object inclusions.

#### model

Model and Builder class (internal to Model) to map objects through serialization and deserialization in use with Rest-Assured.

#### specs

Request and response specifications used by clients and tests. The InitialStepsSpec class defines the basePath, baseURI, and port for the custom specifications. The RestrictionsSpecs and SimulationsSpecs classes contain the implementation of request and response specifications.

### src/main/java

#### suite

It contains a class with data related to test groups, it is also where the order of execution of the test classes is configured, that is, in the order of HealthCheckTests, ContractTests, PropertyE2ETests and BookingE2ETests.

#### tests

Contains test classes divided by HealthCheckTests, ContractTests, PropertyE2ETests and BookingE2ETests.

#### BaseAPI

Test class that contains the initial settings for running all tests.

## Applied standards
* Test Data Factory
* Data Provider
* Builder
* Request and Response Specification
* Base Test

## Pipeline

This project uses [GitHub Actions](https://docs.github.com/en/actions/about-github-actions/about-continuous-integration-with-github-actions) to run the all the tests in a pipeline.

You can find this setting at https://github.com/leonardomelgarejo/qa-assessement/blob/main/.github/workflows/gha-ci.yml

We have the following steps:
```
build -> test -> report -> deploy 
```

## Dependencies 
* [JUnit Jupiter API 5.11.0+](https://testng.org/)
* [REST Assured 5.5.0+](https://www.selenium.dev/)
* [Owner](https://matteobaccan.github.io/owner/)
* [Log4J2](https://logging.apache.org/log4j/2.x/)
* [Allure Report](https://docs.qameta.io/allure/)

## Test Plan

```
- Objective
	* Automate endpoints from the URI base https://qa-assessment.svc.hostfully.com

- Scope
	To do:
		* Automate api get and post tests of the /properties resource
		* Automate get and post api tests for the /bookings resource
	Don'ts:
		* Automate patch api testing of the /bookings/{bookingId}/rebook resource
		* Automate /bookings/{bookingId}/guest resource patch api testing
		* Automate patch api testing of /bookings/{bookingId}/cancel feature
		* Automate patch api testing of /bookings/{bookingId}/cancel feature
		
- Team
	* Leonardo Melgarejo - QA Engineer

- Risks
	* Project: Short term;
	* Product: Search for additional information if documentation is missing on Swagger.

- Testing Strategy
	* Perform functional tests applying validation of positive and negative scenarios.

- Activities
	* Mapped functional test coverage;
	* Created automation project using Java 22 + Maven 3.6 + Junit5 + Rest Assured 5.5.0 + Allure Report;
	* Created project on github;
	* Applied github actions ci;	
	* Found inconsistency in the swagger documentation, for the post of /properties and /bookings resources, the status code is wrong, it should be 201, but it is 200;
	* The remaining bugs are marked as ignore + description, which can be checked as skipped in the allure test report.
```

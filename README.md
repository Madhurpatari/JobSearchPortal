# Job Search Portal
<p>This is a Spring Boot application for a job search portal that allows users to create, read, update, and delete job postings.</p>

## Getting Started
<p>To run this application, you'll need:</p>

* Java 8 or higher
* Maven 3 or higher
* An IDE of your choice (e.g., IntelliJ, Eclipse)

## Installing
* Clone this repository to your local machine.
* Import the project into your IDE as a Maven project.
* Run the JobSearchPortalApplication.java file to start the Spring Boot application.

## Usage
<p>Once the application is running, you can interact with it using the following endpoints</p>

## CRUD Operations
#### POST `/Jobs`
<p>Create a new job posting.</p>

#### GET `/jobs`
Get a list of all job postings.

#### PUT `/jobs/{id}`
Update an existing job posting by ID.

#### DELETE `/jobs/{id}`
Delete a job posting by ID.

## Custom Get Methods
#### GET `/jobs/jobType`
get job on basis of job type.

#### GET `/jobs/companyName`
get job on basis of company Name.

## Custom Queries
#### PUT `/jobs/id/salary/{id}/{salary}`
update salary on basis of Id

#### PUT `/jobs/id/title/{id}/{title}`
update title on basis of Id

#### DELETE `/jobs/comapanyName/{companyName}`
delete job based on companyName

## Built With
* Spring Boot
* H2 Database
* Maven

# Validation
 The Job entity is validated using Spring Boot validation. The following validation rules are in place:

* title: Required, maximum length of 100 characters
* description: Required
* location: Required, maximum length of 50 characters
* salary: Required, must be a positive number
* companyName: Required, maximum length of 100 characters
* employerName: Required, maximum length of 30 characters
* jobType: Required

## Contributing
Contributions to this project are welcome! If you find a bug or have a suggestion for a new feature, please open an issue or submit a pull request.




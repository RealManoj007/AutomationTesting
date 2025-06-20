TDD - Test Driven Development (f/w Junit, TestNG, etc.) focus on functionality 
=> Technical approach to writing tests before the code is written,
=> how the code will behave as per developer's requirement
EX:
Tester
Developer


BDD - Behavior Driven Development (f/w Cucumber etc.) 
=> focus on user acceptance testcase or NON-TECHNICAL testcase,
=> how application will behave as per customer requirement
EX
stackholders/ customer
product manager
project manager
screum master

BDD emphahsizes collabration b/w technical and non-technical stakeholders throught the use of common language to describe the behavious of a system.
It focus on writing tests in a human-readable format, typically using a "given - when -  then" structure, which helps clarify requirements and expectations.
Cucumber is a tool that supports BDD by allowing teams to write tests in a natural language format, which can be understood by both technical and non-technical stakeholders. It uses Gherkin syntax to define features and scenarios, making it easier to bridge the gap between business requirements and technical implementation.

Cucumber
---------
Cucumber internally follows JUnit or TestNG framework to execute the test cases.
Cucumber is a tool that supports BDD by allowing teams to write tests in a natural language format, which can be understood by both technical and non-technical stakeholders. It uses Gherkin syntax to define features and scenarios, making it easier to bridge the gap between business requirements and technical implementation.

Cucumber supports three main components:
1. **Feature Files**: These files contain the Gherkin syntax that describes the features and scenarios of the application. Each feature file typically corresponds to a specific functionality or user story.
2. **Step Definitions**: These are Java methods that implement the steps defined in the Gherkin scenarios. They link the Gherkin steps to the actual code that performs the actions described in the scenarios.
3. **Test Runner**: This is a class that uses JUnit or TestNG to run the Cucumber tests. It specifies the location of the feature files and step definitions, and it can also include configuration options for the test execution.

Gherkin
-------
Gherkin is a domain-specific language used to write test cases in Cucumber. It uses a simple syntax that is easy to read and understand, allowing both technical and non-technical stakeholders to collaborate effectively. 
Gherkin syntax typically includes keywords like "Feature", "Scenario", "Given", "When", "And", "Then" to describe the behavior of the system.

Example of Gherkin syntax:
Pre-condition - Given      If multiple pre-conditions are required, then use with "And" or "But".
Actions - When
Validations - Then

Feature: User Login                       //first line should be with "Feature" keyword
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    And the user navigate to login page
    When the user enters valid credentials
    And the user clicks on the login button
    Then the user should be redirected to the dashboard

  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters invalid credentials
    Then an error message should be displayed
  
Step Definitions file contains method whihc are represet to steps in feature file.

testRunner class --> feature file, steps, report etc.....
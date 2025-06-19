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


Gherkin
-------
Gherkin is a domain-specific language used to write test cases in Cucumber. It uses a simple syntax that is easy to read and understand, allowing both technical and non-technical stakeholders to collaborate effectively. Gherkin syntax typically includes keywords like "Feature", "Scenario", "Given", "When", and "Then" to describe the behavior of the system.

TestNG : TEST NEW GENERATION

Java based testing framework inspired by JUnit and NUnit.

TestNG is designed to cover a wider range of test categories: unit, functional, end-to-end, integration, etc.

Advantages of TestNG:
1) Test cases & test suites
2) Grouping of test cases.
3) Prioritize
4) Parameterization
5) parallel testing
6) Reports

In TestNG, there will be no main method. Instead, we will have a testng.xml file which will contain the configuration of the test cases and test suites.

TestNG executes based on alphbatical order of the test cases. If you want to change the order of execution, you can use the @Test annotation with the priority attribute.
@Test(priority = 1) to that method, which u want to execute first.

We can also give random number like @Test(priority = 1000  ) to that method, which u want to execute last.

1) TestNG execute test methods based on alphabetical order.
2) @Test(priority=num) controls the order of execution.
3) Once you provide priorty to the test methods, then order of methods is not considered.
4) priorities can be random numbers( no need to have consecutive numbers)
5) If you dont provide priority then default value is Zero (0).
6) If the priorities are same then again execute methods in alphabetical order.
7) Negitive values are allowed in priority.
8) TestNG execute test methods only if they are having @Test annotation.

testing.xml file is used to configure the test cases and test suites.
<suite> it will start with suite, suite contians no of test 
<test> tags, each test tag contains no of classes, each class tag contains no of methods. <test> tags have "thread-count" attribute which is optional and used in case of parallel testing.

Annotations in TestNG
---------------------
The sequence in which TestNG annotations are executed is as follows:

@BeforeSuite: This method runs before the execution of all the test methods in the suite.
@BeforeTest: This method runs before the execution of all the test methods in the test.
@BeforeClass: This method runs before the first method of the current class is invoked.
@BeforeMethod: This method runs before each test method.
@Test: This is the actual test method where the main business logic resides.
@AfterMethod: This method runs after each test method.
@AfterClass: This method runs after all the test methods of the current class have been executed.
@AfterTest: This method runs after the execution of all the test methods in the test.
@AfterSuite: This method runs after the execution of all the test methods in the suite.
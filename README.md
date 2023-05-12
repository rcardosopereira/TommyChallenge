# Tommy Challenge
This is a repository for the Tommy Challenge project. It uses Java, Selenium, Cucumber, JUnit and Maven as a build automation tool.

## Setup
To run the project, you will need to have the following installed on your computer:<br/>
-Java (Version 17.0.2);<br/>
-Selenium (Version 4.9.0);<br/>
-Cucumber (Version 7.12.0);<br/>
-JUnit (Version 5.9.3);<br/>
-Maven (build automation tool);<br/>

## Running the project (Installation)
To run the project, follow the steps below.

***Clone the repository: <br/>*** 
git clone <https://github.com/rcardosopereira/TommyChallenge.git> <br/>
***Navigate to the project directory (root of the project) in your terminal or command prompt: <br />***
cd TommyChallenge <br/>
***Run the following command to install dependencies:<br />***
"mvn clean install" or "mvn clean test" to execute the tests. <br/>
***Optionally, run the command: <br/>***
"mvn verify -DskipTests" to generate the test report.<br />

### Reports
Open the report located at:<br />
**${project.build.directory}\TommyChallenge\target\cucumber-report-html\cucumber-html-reports\overview-features.html.<br />**

### Testing(features) and WebDriver
To run the tests, follow the instructions above for running the project. <br />
The tests use Cucumber and are located in the **src/test/resources/features** directory.<br />
The Webdriver is located in the **src/test/resources/driver** directory.<br />

## Design decisions
The project was designed to follow the page object model, separating the packages (pages, runner and steps) and pages of the application into individual classes, and using them to interact with the application. The tests themselves use the Cucumber BDD style, allowing for clear, human-readable tests.

## Limitations and simplifications
The project is currently limited in its scope, covering only a few test cases for a single application. Additional work would need to be done to expand the project to cover more applications or test cases.

## Further adjustments
In its current state, the project should be stable and working. However, additional adjustments could be made to improve the code, such as refactoring or adding additional tests for edge cases.

## Possibilities for improvements
There are several possibilities for improvements to the project, including:<br />
-Adding more test cases;<br />
-Integrating with a CI/CD tool;<br />
-Adding more logging to aid in debugging;<br />
-Adding support for more browsers;<br />
-Adding support for parallel testing;<br />

## Conclusion
The Tommy Challenge project is a simple but functional test suite using Cucumber and Selenium. By following the instructions above, you should be able to run the tests and view the results. If you have any questions or concerns, please feel free to reach out me.

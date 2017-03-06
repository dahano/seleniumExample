# Selenium Example using both Firefox Webdriver and Chrome Webdriver

 - This Selenium test-suite uses the Page Object Model (POM) pattern. 
 - Both Gecko Driver and Chrome Driver can be located in the `./src/main/resources`
 - To run this project from the command line, use `mvn test` (note: you may have to use `mvn clean test` if you're making changes)
 
 ## Basic Structure
 1. BaseTestSetup
    - Classes unique to the project as a whole 
 2. Pages
    - Classes that relate to specific pages. This is where the page objects will be defined along with their respective methods
 3. Tests
    - Test Classes where our tests will be created and Pages Objects will be instatiated 
 
 ## TestNG and SureFire plugin
 1. Test Results can be found `./target/surefire-reports/index.html`
 2. Open the report in a browser after running all the test cases
 3. To modify which classes get run, check out the `./testNG.xml` file

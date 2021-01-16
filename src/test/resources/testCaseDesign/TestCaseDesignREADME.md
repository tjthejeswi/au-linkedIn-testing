## Assumptions

- This is an e2e application with 
- UI created using Javascript
- Webservice is created using Java
- Webservices connect to a database
- Application is hosted on Cloud

## Technology Options
### UI
- Codecept with Protractor / WebdriverIO - for easier integration to device farms and multi tab testing
- Cypress - unique dom manipulation, interactive test runner and testing network requests  

### Webservices
- Cucumber Selenium with Java (with mocking services integrated) - best test&result readability, good for security tests 

## Automation Test Suite
Scenarios for automation will be decided as a team weighing in the ROI
- Regression Suite for UI - e2e test containing business case scenarios
- Regression Suite for Webservice - e2e tests mimicking e2e UI flows
- tests within each repo - unit & integration tests
- Assertion at every step of the scenarios
- Scenarios to validate acceptance criteria (agreed by scrum team and PO) of a given Business story(scenario)/epic(feature)
- user throw catch block to deal with timeouts & use appropriate waits (cypress comes in handy here)

### Test Data
- can be stored in a seperate util file
- tests data can be generated @before running a scenario or feature and can be deleted @after the test is over

## CI/CD
- code repo in cloud
- Automated builds
- Regression tests will run on a scheduled time in scheduled intervals (or on upon every merge into master)
- tests within the repo will run on every commit

## Test Reporting
- Automated test reporting
- Test failures are notified to the developer responsible for the commit


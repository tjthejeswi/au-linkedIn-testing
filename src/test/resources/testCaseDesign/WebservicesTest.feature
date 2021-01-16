Feature User Login Backend
  Only users with valid credentials should be able to login to the application in the UI

  @smokeTest
  Scenario: Verify if the environment is up and running
    Given the user hits the webservice
    Then the user must get a "200 OK" response

    #Assumption: The UI hits the webservice endpoint /login for authentication
  Scenario Outline: Verify if the user
    Given the user hits the endpoint with "<Username Validity>" and "<Password Validity>"
    Then the user must get a "<Response>" response
    And the response object must contain "<Response Object>"
    And the backend database is updated with the timestamp of the login attempt

    Examples:
      | Username Validity | Password Validity | Response         | Response Object     |
      | Valid             | Valid             | 200 OK           | Valid Session Token |
      | Invalid           | Valid             | 401 Unauthorized | error message       |
      | Valid             | Invalid           | 401 Unauthorized | error message       |
      | Invalid           | Invalid           | 401 Unauthorized | error message       |

  @securityTesting
  Scenario: Verify if the user
    Given the user hits the endpoint with "Valid" and "Valid"
    Then the user must get a "200 OK" response
    And the response must have security headers set

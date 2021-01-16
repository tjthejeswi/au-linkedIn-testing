Feature User Login front end
  Only users with valid credentials should be able to login to the application in the UI

  @smokeTest
  Scenario: Verify if the environment is up and running
    Given the user is on the login page
    When the user must see User Name and Password fields

  Scenario Outline: Verify if the user with valid credentials is able to login successfully with any acceptable characters in either of the field
    Given the user is on the login page
    When the user enters a username "<Username>"
    And the user enters a password "<Password>"
    When the user clicks Login button
    Then the user must land on page with message "Welcome {username}"

    Examples:
      | Username  | Password    |
      | username1 | Password123 |


  Scenario Outline: Verify if the user with invalid credentials is  not able to login
    Given the user is on the login page
    When the user enters a "<Username Validity>" username
    And the user enters a "<Password Validity>" Password
    When the user clicks Login button
    Then the user must see "<Error Message>" on Login page

    Examples:
      | Username Validity | Password Validity | Error Message           |
      | Invalid           | Invalid           | Incorrect Login Details |
      | Valid             | Invalid           | Incorrect Login Details |
      | Invalid           | Valid             | Incorrect Login Details |
      | Valid             | Expired           | Password Expired        |
      | Valid             | Locked            | User account locked     |

  Scenario Outline: Verify if the user with valid credentials is  not able to login when password case is incorrect
    Given the user is on the login page
    When the user enters a "Valid" username
    And the user enters a valid password in "<Password Case>" characters
    When the user clicks Login button
    Then the user must see "Incorrect Login Details" on Login page

    Examples:
      | Password Case        |
      | all uppercase        |
      | all lowercase        |
      | incorrect mixed case |

  #Assumption: username is case insensitive
  Scenario Outline: Verify if the user with valid credentials is able to login irrespective of the username case
    Given the user is on the login page
    When the user enters a valid username in "<Username Case>" characters
    And the user enters a valid password
    When the user clicks Login button
    Then the user must land on page with message "Welcome {username}"

    Examples:
      | Username Case |
      | all uppercase |
      | all lowercase |
      | mixed case    |

    #Assumption: username is case insensitive
  Scenario Outline: Verify if the user can enter all acceptable characters in either of the field
    Given the user is on the login page
    When the user enters a username "<Username>"
    And the user enters a password "<Password>"
    When the user clicks Login button
    Then the user must land on page with message "Welcome {username}"

    Examples:
      | Username   | Password     |
      | UserName1  | PassWord$123 |
      | username-1 | Password@123 |

@sampleTest
Feature: LinkedIn Private Messaging
  As a user with valid credentials, I want to be able to login and send a private message to "Profectus Kamaljeet"

  @smokeTest
  Scenario: Verify if the user is able to login with valid credentials
    Given the user is on linkedin login page
    When the user logs in with valid credentials
    Then the linkedIn user lands on their account home page
    When the user creates a new message
    And the user selects the contact "Profectus Kamaljeet" to send message to
    And the user sends the message "Hello, kamaljeet. This is the auto message from {profile name} to Kamljeet"
    Then the user logs out
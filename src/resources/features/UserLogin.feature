Feature: User Login from Sign in page
  As a user
  I want to be able to login into my account
  To access my data

  Scenario: Successful login
    When the user enters a valid email "user1@gmail.com"
    And the user enters a valid password "password123"
    And the user clicks the login button
    Then the user is redirected to the homepage
    And the welcome message "Welcome, user1!" is displayed

  Scenario: Unsuccessful login due to invalid credentials
    When the user enters an invalid email "invalidUser@gmail.com"
    And the user enters an invalid password "wrongPassword"
    And the user clicks the login button
    Then an error message " Invalid User Name or PassWord " is displayed

  Scenario: Unsuccessful login due to empty credentials
    When the user enters an empty email
    And the user enters an empty password
    And the user clicks the login button
    Then an error message " Invalid User Name or PassWord " is displayed
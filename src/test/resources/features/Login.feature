Feature: Login

  Scenario Outline: User can login with valid data
    Given the user is on the login page
    When the user enters the email <email>
    And the user enters the password <password>
    And click in the login button
    Then the user should be logged in
    Examples:
     | email               | password     |
     | "rafael@teste.com"  | "Rafael1982" |

  @smoke
  Scenario Outline: User can login with invalid data
    Given the user is on the login page
    When the user enters the email <email>
    And the user enters the password <password>
    And click in the login button
    Then the user should see an error message
    Examples:
      | email             | password  |
      | "john@tommy.abc"  | "qwerty"  |

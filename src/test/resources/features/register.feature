@All
Feature: Register

  @Register
  Scenario Outline: Register with BDD
    Given when user is in the page
    When user click register link
    And user fill name <name>
    And user fill age <age>
    And user fill email <email>
    And user fill phone <phone>
    And user fill pass <pass>
    And user click register button
    Then user got message <result>

  Examples:
    | name | age | email | phone | pass | result |
    | maximan | 17 | maximan@gmail.com | 0815555411 | Password#123 | Your age should be at least around 18 - 45! |
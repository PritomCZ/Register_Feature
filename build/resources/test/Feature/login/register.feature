Feature: Register

  @smoke
  Scenario Outline: user can register from the valid data
    Given user base url
    When user enter '<fristName>' and '<lastName>' and '<Email>'
    And also enter '<Password>' and '<repeatPassword>'
    And enter the register button
    Then user find the home page

    Examples:
    | fristName | lastName | Email | Password | repeatPassword |
    | Pritom | Cruze | cruzepritom@gmail.com | pritom | pritom |
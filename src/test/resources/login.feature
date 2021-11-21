Feature: login to Amazon app

  Background:
    Given user enters the URL "https://www.amazon.com/" and amazon page pops up with title "Amazon.com. Spend less. Smile more."
    When user hovers over Account Lists
    And  clicks on sign in button
    Then sign in page with title "Amazon Sign-In" pops up

  Scenario: login with valid credentials
    Then user enters username "mohammedullah27@yahoo.com"
    And clicks on continue button
    Then user enters password "Jackbox223"
    And clicks on login button
    Then user name "Mohammed" should appear on the menu

  Scenario Outline: login with invalid credentials
    Then user enters username "<username>"
    And clicks on continue button
    Then error message with "We cannot find an account with that" is displayed

  Examples:
    |username|
    |md@gmail.com|
    |9178562653  |



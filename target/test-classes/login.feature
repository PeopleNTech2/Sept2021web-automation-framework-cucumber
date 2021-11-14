Feature: login to Geico app

  Scenario: login with valid credentials
    Given Enter the URL "https://www.geico.com/"
    When User clicks on ACCOUNT button
    Then User clicks on LOG IN button
    Then User enters valid User ID
    Then User enters valid Password
    Then User click on LOGIN button

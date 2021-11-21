Feature: feature name

  Background:
    Given step1 "variable0"
    When step2

  Scenario: scenario 1
    Then step3
    And step4

  Scenario Outline:
    Then step3 "<variable1>"
    And step4 "<variable2>"

    Examples:
    |variable1|variable2|
    |value1|value2      |
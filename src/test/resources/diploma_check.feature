Feature: Diploma check

  Scenario: Create new diploma
    Given new diploma
    Then diploma should be empty

  Scenario: Add one subject
    Given new diploma
    Given subjects
      | name | credits | grade |
      | java | 3       | 90    |
    Then diploma should have 1 subjects
    And average grade should be equal to 90.0

  Scenario: Add several subjects
    Given new diploma
    Given subjects
      | name      | credits | grade  |
      | java      | 3       | 100    |
      | spring    | 4       | 95     |
      | databases | 3       | 90     |
    Then diploma should have 3 subjects
    And average grade should be equal to 95.0

  Scenario: Clear subjects
    Given new diploma
    Given subjects
      | name      | credits | grade  |
      | java      | 3       | 100    |
      | spring    | 4       | 95     |
    When I clear diploma
    Then diploma should have 0 subjects
    And diploma should be empty
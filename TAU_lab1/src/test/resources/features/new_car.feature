# new feature
# Tags: optional
    
Feature: New Car
  Create new Car
    
  Scenario: Create new Car
    Given Create New Car
    When Car has been created
    Then Car has been add to database

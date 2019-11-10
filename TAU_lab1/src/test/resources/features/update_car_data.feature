Feature: Update Car
  Update Car
    
  Scenario: Update Car data
    Given prepare cars list
    When add cars to database
    When car is registered in Olsztyn
    And cars id is 5
    Then update data of this Car by new Car

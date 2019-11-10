Feature: Update Car
  Update Car
    
  Scenario: Update Car data
    Given Create Cars list
    When Cars added to database
    When Cars id is 5
    But car is not registrated in Gdańsk
    Then update data of this Car by new Car

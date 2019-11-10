Feature: Remove Car
  Remove Car
    
  Scenario: Remove car which is registrated in Gdańsk but not Mazda
    Given create cars list
    When cars added to database
    When car is registered in Gdańsk
    But car name is not Mazda
    Then remove this car

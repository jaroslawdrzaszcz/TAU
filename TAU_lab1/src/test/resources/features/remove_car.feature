Feature: Remove Car
  Remove Car
    
  Scenario: Remove car for car registrates in Gdańsk and car_owner id 100
    Given create cars list
    When cars added to database
    When car is registered in Gdańsk
    But car name is not Mazda
    Then remove this car

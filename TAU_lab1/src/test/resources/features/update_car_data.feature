Feature: Update Car
  Update Car
    
  Scenario Outline: Update Car data
    Given prepare cars list
    When add cars to database
    When car is registered in Olsztyn
    And cars id is "<id>"
    Then update data of this Car by new Car "<response>"

    Examples:
      | id | response   |
      | 1  | NotUpdates |
      | 2  | Updated    |
      | 3  | NotUpdates |
      | 4  | Updated    |
      | 5  | NotUpdates |
      | 6  | Updated    |
      | 7  | NotUpdates |
      | 8  | Updated    |
      | 9  | NotUpdates |
      | 10 | Updated    |

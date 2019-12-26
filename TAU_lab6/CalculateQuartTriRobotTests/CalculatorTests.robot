*** Settings ***
Documentation     Simple example using SeleniumLibrary.
Library           CalculatorLibrary
Force Tags        MyTag


*** Variables ***
${CALCULATOR}   test_calculate_triangle_quadrangle.py

*** Test Cases ***
First Test
    Python  ${CALCULATOR}

#Foo Test Case
#    [tags]              FooTag
#    [Documentation]     Created by John Doe
#    Do An Action        Argument
#    Do Another Action   ${robotVar}

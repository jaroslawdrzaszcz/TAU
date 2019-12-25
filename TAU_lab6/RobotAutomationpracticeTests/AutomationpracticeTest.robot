*** Settings ***
Documentation     Simple example using SeleniumLibrary.
Library           SeleniumLibrary
Resource          automationparacticeResource.robot

*** Test Cases ***
Navigation
    Open Browser To Main Page
    Got To Contact Us Page
    Contact Us Page Should Be Open
    [Teardown]    Close Browser

Valid Login
    Open Browser To Main Page
    Log In
    Input Email    ${VALID EMAIL}
    Input Password    ${VALID PASSWORD}
    Submit Credentials
    My Account Page Should Be Open
    [Teardown]    Close Browser

Invalid Login
    Open Browser To Main Page
    Log In
    Input Email    ${INVALID EMAIL}
    Input Password    ${INVALID PASSWORD}
    Submit Credentials
    Alert Danger Is Displayd
    [Teardown]    Close Browser

Invalid Registration
    Open Browser To Main Page
    Log In
    Input Create Email    test1234@wp.pl
    Create Account
    Submit Account
    Alert Error Is Displayd
    [Teardown]    Close Browser
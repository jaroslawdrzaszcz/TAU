*** Settings ***
Documentation     Simple example using SeleniumLibrary.
Library           SeleniumLibrary
Resource          mantisRresource.robot

*** Test Cases ***
Get Url
    Open Browser To Login Page
    My Login Page Should Be Open
    [Teardown]    Close Browser

Navigation
    Open Browser To Login Page
    New User
    Signin Page Should Be Open
    [Teardown]    Close Browser

Valid Login
    Open Browser To Login Page
    Input Username    ${VALID USER}
    Input Password    ${VALID PASSWORD}
    Submit Credentials
    My View Page Should Be Open
    [Teardown]    Close Browser

Invalid Login
    Open Browser To Login Page
    Input Username    ${INVALID USER}
    Input Password    ${INVALID PASSWORD}
    Submit Credentials
    Alert Page Should Be Open
    [Teardown]    Close Browser

Check Box
    Open Browser To Login Page
    Checkbox Should Not Be Selected     xpath=//*[@id="remember-login"]
    Remember Password Checkbox
    Checkbox Should Be Selected     xpath=//*[@id="remember-login"]
    [Teardown]    Close Browser

*** Settings ***
Documentation     A resource file with reusable keywords and variables.
...
...               The system specific keywords created here form our own
...               domain specific language. They utilize keywords provided
...               by the imported SeleniumLibrary.
Library           SeleniumLibrary

*** Variables ***
${SERVER}       mantis.testpro.pl
${BROWSER}      Chrome
${DELAY}        0
${VALID USER}   testowe
${INVALID USER}     test
${VALID PASSWORD}   seleniumtest
${INVALID PASSWORD}     test
${LOGIN URL}    http://${SERVER}/login_page.php
${WELCOME URL}  http://${SERVER}/my_view_page.php
${ALERT URL}    http://${SERVER}/login_page.php?error=1&username=${INVALID USER}&return=index.php&secure_session=1
${SIGNIN URL}    http://${SERVER}/signup_page.php

*** Keywords ***
Open Browser To Login Page
    Open Browser    ${LOGIN URL}    ${BROWSER}
    Title Should Be    MantisBT

Input Username
    [Arguments]    ${username}
    Input Text    username    ${username}

Input Password
    [Arguments]    ${password}
    Input Text    password    ${password}

Submit Credentials
    Click Button    xpath=//*[@id="login-form"]/fieldset/input[2]

My Login Page Should Be Open
    Location Should Be  ${LOGIN URL}

My View Page Should Be Open
    Title Should Be    Mój widok - MantisBT

Alert Page Should Be Open
    Location Should Be  ${ALERT URL}

New User
    Click Element    xpath=//*[@id="login-box"]/div/div[2]/a

Signin Page Should Be Open
    Location Should Be  ${SIGNIN URL}

Remember Password Checkbox
    Click Element    xpath=//*[@id="login-form"]/fieldset/div[1]/label/span

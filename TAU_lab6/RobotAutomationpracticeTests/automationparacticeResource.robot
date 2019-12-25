*** Settings ***
Documentation     A resource file with reusable keywords and variables.
...
...               The system specific keywords created here form our own
...               domain specific language. They utilize keywords provided
...               by the imported SeleniumLibrary.
Library           SeleniumLibrary

*** Variables ***
${SERVER}       automationpractice.com
${BROWSER}      Chrome
${DELAY}        0
${VALID EMAIL}   testowy@pjwstk.edu.pl
${INVALID EMAIL}     test@wp.pl
${VALID PASSWORD}   testowy123
${INVALID PASSWORD}     test
${MAIN URL}    http://${SERVER}/index.php
${SIGNIN URL}    http://${SERVER}/index.php?controller=authentication&back=my-account
${CONTACT US URL}  http://${SERVER}/index.php?controller=contact
#${ALERT URL}    http://${SERVER}/login_page.php?error=1&username=${INVALID USER}&return=index.php&secure_session=1

*** Keywords ***
Open Browser To Main Page
    Open Browser    ${MAIN URL}    ${BROWSER}
    Title Should Be    My Store

Got To Contact Us Page
    Click Element      xpath=//*[@id="contact-link"]/a

Contact Us Page Should Be Open
    Location Should Be  ${CONTACT US URL}

Input Email
    [Arguments]    ${email}
    Input Text    email    ${email}

Input Password
    [Arguments]    ${passwd}
    Input Text    passwd    ${passwd}

Log In
    Click Element   class=login

Submit Credentials
    Click Button    SubmitLogin

My Account Page Should Be Open
    Title Should Be    My account - My Store

Alert Danger Is Displayd
    Alert Should Be Present   Invalid password

Input Create Email
    Input Text    email_create    ${passwd}

Create Account
    Click Button    SubmitCreate

Submit Account
    Click Button    SubmitAccount

Alert Error Is Displayd
    Alert Should Be Present   There are 8 errors

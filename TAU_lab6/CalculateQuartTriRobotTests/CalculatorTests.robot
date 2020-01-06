*** Settings ***
Documentation     Simple example using CalculatorLibrary.
Library           CalculatorLibrary


*** Variables ***
${APPLICATION_PATH} =    D:\\informa\\Semestr 7\\TestowanieAutomtyczne\\cw\\TAU\\TAU_lab6\\CalculatorLibrary\\src\\Tau6\\TAULab6\\bin\\Debug\\netcoreapp3.0\\TAULab6.exe

*** Test Cases ***
Run Program
    Start App   ${APPLICATION_PATH}